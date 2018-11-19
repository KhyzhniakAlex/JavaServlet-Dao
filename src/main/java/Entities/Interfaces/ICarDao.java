package Entities.Interfaces;

import Entities.Models.CarModel;

import java.sql.SQLException;
import java.util.List;

public interface ICarDao {

    int create(CarModel car);

    CarModel read(int key) throws SQLException;

    int update(CarModel car);

    int delete(Integer Id);

    List<CarModel> readAll();

    void close();
}
