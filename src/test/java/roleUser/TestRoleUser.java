package roleUser;

import base.TestBase;
import org.junit.Test;
import qiye.entity.User;
import qiye.service.RoleUserService;

import javax.inject.Inject;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class TestRoleUser extends TestBase {

    @Inject
    private RoleUserService roleUserService;

    @Test
    public void queryRoleUser() {
        System.out.println(roleUserService.queryByUserNameAndPassword(new User("admin", "1234")));
    }
}
