package qiye.service.impl;

import org.springframework.stereotype.Service;
import qiye.dao.RoleUserDao;
import qiye.entity.RoleUser;
import qiye.entity.User;
import qiye.service.RoleUserService;

import javax.inject.Inject;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Inject
    private RoleUserDao roleUserDao;

    @Override
    public RoleUser queryByUserNameAndPassword(User user) {
        return roleUserDao.queryByUserNameAndPassword(user);
    }
}
