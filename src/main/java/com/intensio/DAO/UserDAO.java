package com.intensio.DAO;

import com.intensio.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User getUserByUsername(String name);
    User getUserByLogin(String email);
    User getUserById(int id);
    void deleteAllById(int id);
}
