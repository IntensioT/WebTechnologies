package org.intensio.service;

import org.intensio.beans.User;
import org.intensio.beans.UserPrincipal;
import org.intensio.service.exception.AlreadyExistException;
import org.intensio.service.exception.ServiceException;
import org.intensio.service.exception.UnknownUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     *
     * @return
     * @throws ServiceException
     */
    List<User> getUsers() throws ServiceException;

    /**
     *
     * @param name
     * @return
     * @throws ServiceException
     */
    Optional<User> getUserByUsername(String name) throws ServiceException;

    /**
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Optional<User> getUserById(int id) throws ServiceException;

    /**
     *
     * @param email
     * @param password
     * @param username
     * @return
     * @throws ServiceException
     * @throws AlreadyExistException
     */
    UserPrincipal newUser(String email, String password, String username) throws ServiceException, AlreadyExistException;

    /**
     *
     * @param login
     * @param password
     * @return
     * @throws ServiceException
     * @throws UnknownUserException
     */
    UserPrincipal authenticate(String login, String password) throws ServiceException, UnknownUserException;

    /**
     *
     * @throws ServiceException
     */
    void updateRate() throws ServiceException;

    /**
     *
     * @param id
     * @throws ServiceException
     */
    void deleteUser(int id) throws ServiceException;

    /**
     *
     * @param id
     * @throws ServiceException
     */
    void changeStatus(int id) throws ServiceException;
}
