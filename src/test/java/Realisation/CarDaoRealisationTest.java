package Realisation;

import Entities.Interfaces.ICarDao;
import Entities.Models.CarModel;

import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class CarDaoRealisationTest {

    private CarModel toyota = new CarModel(1, "Toyota", "Civic", 10000, "white");

    @org.junit.Test
    public void CreateAndDeleteTest() throws SQLException {
        CarModel car = new CarModel(5, "Porsche", "Panamera", 5000, "violet");
        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();

        ICarDao dao = daoFactory.getCarDao();

        int result = dao.create(car);

        Assert.assertNotEquals(0, result);

        List<CarModel> list = dao.readAll();
        int rowDel = dao.delete(list.get(list.size() - 1).getId());

        Assert.assertNotEquals(0, rowDel);

        dao.close();
    }

    /*@org.junit.Test
    public void Delete() throws SQLException {
        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();

        ICarDao dao = daoFactory.getCarDao();

        List<CarModel> list = dao.readAll();
        dao.delete(list.get(list.size() - 1).getId());
        dao.delete(list.get(list.size() - 2).getId());

        dao.close();
    }*/

    @org.junit.Test
    public void ReadTest() throws SQLException {
        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();
        ICarDao dao = daoFactory.getCarDao();

        CarModel car = dao.read(toyota.getId());

        Assert.assertEquals(toyota.getBrand(), car.getBrand());
        Assert.assertEquals(toyota.getModel(), car.getModel());
        Assert.assertEquals(toyota.getPrise(), car.getPrise());
        Assert.assertEquals(toyota.getColor(), car.getColor());

        dao.close();
    }

    @org.junit.Test
    public void UpdateTest() throws SQLException {
        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();
        ICarDao dao = daoFactory.getCarDao();

        List<CarModel> list = dao.readAll();
        int id = list.get(list.size() - 1).getId();

        CarModel car = dao.read(id);
        String firstBrand = car.getBrand();
        car.setBrand("Ford");
        dao.update(car);
        Assert.assertEquals("Ford", car.getBrand());

        car = dao.read(id);
        car.setBrand(firstBrand);
        dao.update(car);

        dao.close();
    }

    @org.junit.Test
    public void ReadAllTest() {
        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();
        ICarDao dao = daoFactory.getCarDao();

        List<CarModel> list = dao.readAll();

        int expectedSize = 5;

        Assert.assertEquals(expectedSize, list.size());

        dao.close();
    }
}