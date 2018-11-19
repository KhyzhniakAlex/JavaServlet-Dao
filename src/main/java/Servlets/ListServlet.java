package Servlets;

import Entities.Interfaces.ICarDao;
import Entities.Models.CarModel;
import Realisation.DaoFactoryRealisation;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {

    //public static  list;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoFactoryRealisation daoFactory = new DaoFactoryRealisation();
        ICarDao dao = daoFactory.getCarDao();

        List<CarModel> list = dao.readAll();

        req.setAttribute("list", list);

        dao.close();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/ListOfCars.jsp");
        requestDispatcher.forward(req, resp);
    }
}
