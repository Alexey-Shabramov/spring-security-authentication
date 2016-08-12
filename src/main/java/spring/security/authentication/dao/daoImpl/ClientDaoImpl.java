package spring.security.authentication.dao.daoImpl;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.security.authentication.dao.ClientDao;
import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.DaoException;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {
    @Override
    public Class getEntityClass() {
        return Client.class;
    }

    @Override
    @Transactional
    public Client getByLogin(String login) throws DaoException {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("login", login))
                .setMaxResults(1)
                .uniqueResult();
    }
}
