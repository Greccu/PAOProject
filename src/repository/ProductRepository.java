package repository;

import config.DatabaseConnection;
import model.accounts.Seller;
import model.accounts.User;
import model.products.Product;
import model.restaurant.Restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {


    private static ProductRepository instance = null;
    private ProductRepository(){}

    public static ProductRepository getInstance() {
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public void addProduct(Product product, String restaurantId){

        String sql = "insert into products values (?, ?, ?, ?,?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            String ingredients = "";
            if(product.getIngredients().size()>0){
                for (String ingredient : product.getIngredients()) {
                    ingredients += ingredient + ";";
                }
                ingredients = ingredients.substring(0, ingredients.length() - 1);
            }

            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, ingredients);
            statement.setString(5, restaurantId);

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Product> getProducts(String restaurantId){
        List<Product> products = new ArrayList<>();
        String sql = "select * from products where restaurantid = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1,restaurantId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);

                List<String> ingredients = new ArrayList<String>(Arrays.asList(result.getString(4).split(";")));
                products.add(new Product(
                        result.getString(2),
                        ingredients,
                        result.getDouble(3),
                        result.getString(5)
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from products";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);

                List<String> ingredients = new ArrayList<String>(Arrays.asList(result.getString(4).split(";")));
                products.add(new Product(
                        result.getString(2),
                        ingredients,
                        result.getInt(3),
                        result.getString(5)
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }

    public void updateProduct(Product product, String restaurantId){

        String sql = "update sellers " +
                "set name = ?," +
                "price = ?," +
                "ingredients = ?," +
                "restaurantid = ?," +
                "where id = ?";

        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            String ingredients = "";
            if(product.getIngredients().size()>0){
                for (String ingredient : product.getIngredients()) {
                    ingredients += ingredient + ";";
                }
                ingredients = ingredients.substring(0, ingredients.length() - 1);
            }

            statement.setString(5, product.getId());
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, ingredients);
            statement.setString(4, restaurantId);

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(String id){
        String sql = "delete from products " +
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
