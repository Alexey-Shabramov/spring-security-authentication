package spring.security.authentication.service.serviceImpl;


import org.springframework.stereotype.Service;
import spring.security.authentication.dao.daoImpl.ClientDaoImpl;
import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.DaoException;
import spring.security.authentication.exception.ServiceException;
import spring.security.authentication.service.ClientService;

@Service("clientService")
public class ClientServiceImpl extends GenericServiceImpl<Client, ClientDaoImpl> implements ClientService {

    @Override
    public Client getByLogin(String login) throws ServiceException {
        try {
            return dao.getByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("Can't get client by login.");
        }
    }
}
