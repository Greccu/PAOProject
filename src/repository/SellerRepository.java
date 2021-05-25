package repository;

import config.DatabaseConnection;
import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.others.Car;
import model.restaurant.Restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellerRepository {


    private static SellerRepository instance = null;
    private SellerRepository(){}

    public static SellerRepository getInstance() {
        if(instance == null){
            instance = new SellerRepository();
        }
        return instance;
    }

    private final UserRepository userRepository = UserRepository.getInstance();
    private final ProductRepository productRepository = ProductRepository.getInstance();

    public void addSeller(Seller seller){

        String sql = "insert into sellers values (?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, seller.getId());
            statement.setString(2, seller.getRestaurant().getId());
            statement.setString(3, seller.getRestaurant().getName());
            statement.setString(4, seller.getRestaurant().getAdress());

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Seller> getSellers(){
        List<Seller> sellers = new ArrayList<>();
        String sql = "select * from sellers";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                User user = userRepository.getUser(id);
                Restaurant restaurant = new Restaurant(
                        result.getString(3),
                        result.getString(4),
                        result.getString(2)
                );
                restaurant.setMenu(productRepository.getProducts(restaurant.getId()));
                sellers.add(new Seller(user,restaurant));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  sellers;
    }

    public void updateSeller(Seller seller){
        String sql = "update sellers " +
                "set restaurantid = ?," +
                "name = ?," +
                "address = ?," +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(4, seller.getId());
            statement.setString(1, seller.getRestaurant().getId());
            statement.setString(2, seller.getRestaurant().getName());
            statement.setString(3, seller.getRestaurant().getAdress());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteSeller(String id){
        String sql = "delete from sellers " +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1, id);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
