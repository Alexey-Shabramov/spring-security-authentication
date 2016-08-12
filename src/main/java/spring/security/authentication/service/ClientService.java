package spring.security.authentication.service;


import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.ServiceException;

public interface ClientService extends GenericService<Client> {
    Client getByLogin(String login) throws ServiceException;
}
