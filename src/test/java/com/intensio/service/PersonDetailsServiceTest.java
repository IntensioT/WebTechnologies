package com.intensio.service;

import com.intensio.DAO.UserDAO;
import com.intensio.beans.User;
import com.intensio.service.impl.PersonDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonDetailsServiceTest {
    @Mock
    UserDAO userDAO;

    @InjectMocks
    PersonDetailsService personDetailsService;

    @Test
    void loadUserByUsernameTest(){
        String testLogin = "mail@gmail.com";
        User user = User.builder().login(testLogin).username("Username").build();
        when(userDAO.getUserByLogin(testLogin)).thenReturn(user);
        Assertions.assertEquals(personDetailsService.loadUserByUsername(testLogin).getUsername(), testLogin);
        verify(userDAO).getUserByLogin(anyString());
    }
}
