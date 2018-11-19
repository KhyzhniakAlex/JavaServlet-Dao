package Entities.Interfaces;

import Realisation.DaoFactoryRealisation;

public abstract class DaoFactory {

    public abstract ICarDao getCarDao();

    public static DaoFactory getFactory()
    {
        return new DaoFactoryRealisation();
    }
}
