package Servlets;

import Entities.Interfaces.ICarDao;
import Entities.Models.CarModel;
import Realisation.DaoFactoryRealisation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class AddServlet extends HttpServlet {

    public static CarModel car;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/AddCar.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        String color = req.getParameter("color");

        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();
        ICarDao dao = daoFactory.getCarDao();

        try
        {
            List<CarModel> list = dao.readAll();
            int id = list.get(list.size() - 1).getId();
            car = new CarModel(++id, brand, model, Integer.parseInt(price), color);

            dao.create(car);

            dao.close();

            req.setAttribute("add", car);
            doGet(req, resp);
        }
        catch(Exception ex)
        {
            req.setAttribute("add", "error");
            doGet(req, resp);
        }
    }
}
