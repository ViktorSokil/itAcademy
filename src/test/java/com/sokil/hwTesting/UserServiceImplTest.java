package com.sokil.hwTesting;

import com.sokil.hwTesting.DAO.IUserDAO;
import com.sokil.hwTesting.DAO.impl.UserDAOImpl;
import com.sokil.hwTesting.entity.User;
import com.sokil.hwTesting.service.IUserService;
import com.sokil.hwTesting.service.SecurityService;
import com.sokil.hwTesting.service.SecurityServiceImpl;
import com.sokil.hwTesting.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private IUserDAO userDAO = new UserDAOImpl();
    @Mock
    private SecurityService securityService = new SecurityServiceImpl();
    private User user;

    @InjectMocks
    private IUserService userService = new UserServiceImpl(userDAO, securityService);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId(1L);
        user.setPassword("12345");
        user.setName("Viktor");
    }

    @Test
    public void testIsUserSetPassword(){
        when(securityService.md5(user.getPassword())).thenReturn("54321");
        userService.assignPassword(user);
        assertEquals("54321", user.getPassword());
    }

    @Test
    public void testIsUpdateUserCalled(){
        userService.assignPassword(user);
        verify(userDAO).updateUser(user);
    }
}
