package spring.security.authentication.dao.daoImpl;


import org.hibernate.criterion.Restrictions;
import spring.security.authentication.dao.GenericDao;
import spring.security.authentication.entity.Identifier;
import spring.security.authentication.exception.DaoException;

import java.util.List;


public abstract class GenericDaoImpl<T extends Identifier> extends AbstractDao implements GenericDao {

    @Override
    public T get(Long id) throws DaoException {
        return (T) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("id", id))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public boolean isExists(Long id) throws DaoException {
        return false;
    }

    @Override
    public void save(Identifier entity) throws DaoException {
        if (entity.isNew()) {
            getSession().save(entity);
        } else {
            getSession().merge(entity);
        }
    }

    @Override
    public void delete(Identifier entity) throws DaoException {
        getSession().delete(entity);
    }

    @Override
    public List<T> listAll() throws DaoException {
        return (List<T>) getSession().createCriteria(getEntityClass()).list();
    }
}
