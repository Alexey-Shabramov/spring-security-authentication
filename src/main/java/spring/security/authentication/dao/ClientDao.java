package spring.security.authentication.dao;


import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.DaoException;

public interface ClientDao extends GenericDao {
    Client getByLogin(String login) throws DaoException;
}
