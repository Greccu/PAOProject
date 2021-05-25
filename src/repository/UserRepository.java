package repository;

import config.DatabaseConnection;
import model.accounts.User;
import model.order.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance = null;
    private UserRepository(){}

    public static UserRepository getInstance() {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user){

        String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPhoneNumber());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCardNumber());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public User getUser(String userId){
        String sql = "select * from users where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1,userId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                String username = result.getString(2);
                String fullName = result.getString(3);
                String email = result.getString(4);
                String password = result.getString(5);
                String phoneNumber = result.getString(6);
                String address = result.getString(7);
                String cardNumber = result.getString(8);
                User user = new User(username,fullName,email,password,phoneNumber,address,cardNumber,id);
                return user;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                String username = result.getString(2);
                String fullName = result.getString(3);
                String email = result.getString(4);
                String password = result.getString(5);
                String phoneNumber = result.getString(6);
                String address = result.getString(7);
                String cardNumber = result.getString(8);
                users.add(new User(username,fullName,email,password,phoneNumber,address,cardNumber,id));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  users;
    }

    public void updateUser(User user){
        String sql = "update users " +
                "set username = ?," +
                "fullname = ?," +
                "email = ?," +
                "password = ?," +
                "phonenumber = ?," +
                "address = ?," +
                "cardnumber = ?" +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(8, user.getId());
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getCardNumber());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteUser(String id){
        String sql = "delete from users " +
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
