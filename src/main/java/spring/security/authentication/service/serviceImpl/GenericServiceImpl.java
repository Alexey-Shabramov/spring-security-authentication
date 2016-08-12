package spring.security.authentication.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import spring.security.authentication.dao.GenericDao;
import spring.security.authentication.entity.Identifier;
import spring.security.authentication.exception.DaoException;
import spring.security.authentication.exception.ServiceException;
import spring.security.authentication.service.GenericService;

import java.util.List;

public class GenericServiceImpl<T extends Identifier, D extends GenericDao> implements GenericService<T> {
    @Autowired
    protected D dao;

    @Override
    @Transactional
    public T get(long id) throws ServiceException {
        try {
            return (T) dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when trying to get the entity by id.");
        }
    }

    @Override
    @Transactional
    public boolean isExists(long id) throws ServiceException {
        try {
            return dao.isExists(id);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when checking entity is existed.");
        }
    }

    @Override
    @Transactional
    public void save(T obj) throws ServiceException {
        try {
            dao.save(obj);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when saving the entity.");
        }
    }

    @Override
    @Transactional
    public void delete(T obj) throws ServiceException {
        try {
            dao.delete(obj);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when trying to delete the entity.");
        }
    }

    @Override
    @Transactional
    public List<T> listAll() throws ServiceException {
        try {
            return dao.listAll();
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when getting all entity list by id.");
        }
    }
}

