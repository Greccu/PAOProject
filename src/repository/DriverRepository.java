package repository;

import config.DatabaseConnection;
import model.accounts.Driver;
import model.accounts.User;
import model.others.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverRepository {

    private static DriverRepository instance = null;
    private DriverRepository(){}

    public static DriverRepository getInstance() {
        if(instance == null){
            instance = new DriverRepository();
        }
        return instance;
    }

    private final UserRepository userRepository = UserRepository.getInstance();

    public void addDriver(Driver driver){

        String sql = "insert into drivers values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, driver.getId());
            statement.setString(2, driver.getCar().getId());
            statement.setString(3, driver.getCar().getBrand());
            statement.setString(4, driver.getCar().getModel());
            statement.setString(5, driver.getCar().getNumberPlate());
            statement.setInt(6, driver.getCar().getFabricationYear());
            statement.setInt(7, driver.getCar().getHorsePower());

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Driver> getDrivers(){
        List<Driver> drivers = new ArrayList<>();
        String sql = "select * from drivers";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                User user = userRepository.getUser(id);
                Car car = new Car(
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getInt(7),
                        result.getString(2)

                );

                drivers.add(new Driver(user,car));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  drivers;
    }

    public void updateDriver(Driver driver){
        String sql = "update drivers " +
                "set carid = ?," +
                "brand = ?," +
                "model = ?," +
                "numberplate = ?," +
                "fabricationyear = ?," +
                "horsepower = ?," +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(7, driver.getId());
            statement.setString(1, driver.getCar().getId());
            statement.setString(2, driver.getCar().getBrand());
            statement.setString(3, driver.getCar().getModel());
            statement.setString(4, driver.getCar().getNumberPlate());
            statement.setInt(5, driver.getCar().getFabricationYear());
            statement.setInt(6, driver.getCar().getHorsePower());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteDriver(String id){
        String sql = "delete from drivers " +
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
