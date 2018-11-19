package Realisation;

import Entities.Interfaces.ICarDao;
import Entities.Interfaces.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoFactoryRealisation extends DaoFactory {

    private static final String user = "root";
    private static final String password = "khyzhniak";
    private static final String url = "jdbc:mysql://localhost:3306/javalabs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //  ?autoReconnect=true&useSSL=false";
    private static Connection connection;

    public DaoFactoryRealisation()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public ICarDao getCarDao(){
        return new CarDaoRealisation(connection);
    }
}
