package qiye.service.impl;

import org.springframework.stereotype.Service;
import qiye.dao.UserDao;
import qiye.entity.User;
import qiye.service.UserService;

import javax.inject.Inject;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
