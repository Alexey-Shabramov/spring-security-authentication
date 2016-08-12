package spring.security.authentication.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.ServiceException;
import spring.security.authentication.service.ClientService;
import spring.security.authentication.util.Constants;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private ClientService clientService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = null;
        try {
            client = clientService.getByLogin(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (client == null) {
            throw new UsernameNotFoundException(Constants.CLIENT_DOES_NOT_EXIST);
        }
        return client.prepareSecurityClient(client);
    }
}
