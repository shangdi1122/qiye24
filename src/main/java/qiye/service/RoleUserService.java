package qiye.service;

import qiye.entity.RoleUser;
import qiye.entity.User;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface RoleUserService {
    RoleUser queryByUserNameAndPassword(User user);
}
