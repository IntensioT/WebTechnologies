package org.intensio.service.impl;

import org.intensio.DAO.UserDAO;
import org.intensio.DAO.exception.DatabaseQueryException;
import org.intensio.beans.User;
import org.intensio.beans.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final UserDAO userDAO;

    public PersonDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<User> user = userDAO.getUserByEmail(username);
            if(user.isEmpty()){
                throw new UsernameNotFoundException("User not found");
            }
            return new PersonDetails(user.get());
        } catch (DatabaseQueryException e) {
            throw new RuntimeException(e);
        }
    }
}
