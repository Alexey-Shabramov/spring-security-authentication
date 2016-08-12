package spring.security.authentication.dao;


import spring.security.authentication.entity.Identifier;
import spring.security.authentication.exception.DaoException;

import java.util.List;

public interface GenericDao<T extends Identifier> {

    T get(Long id) throws DaoException;

    boolean isExists(Long id) throws DaoException;

    void save(T obj) throws DaoException;

    void delete(T obj) throws DaoException;

    List<T> listAll() throws DaoException;

    Class getEntityClass();
}
