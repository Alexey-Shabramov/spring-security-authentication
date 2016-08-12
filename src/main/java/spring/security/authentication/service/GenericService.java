package spring.security.authentication.service;


import spring.security.authentication.entity.Identifier;
import spring.security.authentication.exception.ServiceException;

import java.util.List;

public interface GenericService<T extends Identifier> {

    T get(long id) throws ServiceException;

    boolean isExists(long id) throws ServiceException;

    void save(T obj) throws ServiceException;

    void delete(T obj) throws ServiceException;

    List<T> listAll() throws ServiceException;
}
