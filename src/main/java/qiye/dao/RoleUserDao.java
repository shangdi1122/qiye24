package qiye.dao;

import qiye.entity.RoleUser;
import qiye.entity.User;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface RoleUserDao {
    RoleUser queryByUserNameAndPassword(User user);
}
