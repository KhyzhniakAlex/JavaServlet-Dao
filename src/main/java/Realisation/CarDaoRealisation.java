package Realisation;

import Entities.Interfaces.ICarDao;
import Entities.Models.CarModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoRealisation implements ICarDao {

    private Connection connection;

    public CarDaoRealisation(Connection connection){
        this.connection = connection;
    }

    @Override
    public int create(CarModel car) {
        String query = "insert into `cars` (brand, model, prise, color) values (?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getPrise());
            statement.setString(4, car.getColor());
            return statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public CarModel read(int key) {
        String query = "select * from `cars` where id = ?";
        //CarModel car = null;
        ResultSet rs;

        try(PreparedStatement stm = connection.prepareStatement(query))
        {
            stm.setInt(1, key);
            rs = stm.executeQuery();

            rs.next();
            CarModel c = new CarModel();
            c.setId(rs.getInt("Id"));
            c.setBrand(rs.getString("brand"));
            c.setModel(rs.getString("model"));
            c.setPrise(rs.getInt("prise"));
            c.setColor(rs.getString("color"));
            return c;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(CarModel car) {
        String query = "update `cars` set brand = ?, model = ?, prise = ?, color = ? where id = ?";
        int result = 0;

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getPrise());
            statement.setString(4, car.getColor());
            statement.setInt(5, car.getId());

            result = statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        String query = "delete from `cars` where id = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CarModel> readAll(){
        String query = "select * from `cars`";
        ResultSet rs;
        List<CarModel> list = new ArrayList<>();

        try(PreparedStatement stm = connection.prepareStatement(query))
        {
            rs = stm.executeQuery();

            while (rs.next()) {
                CarModel c = new CarModel();
                c.setId(rs.getInt("id"));
                c.setBrand(rs.getString("brand"));
                c.setModel(rs.getString("model"));
                c.setPrise(rs.getInt("prise"));
                c.setColor(rs.getString("color"));
                list.add(c);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void close()
    {
        try {
            connection.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
