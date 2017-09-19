package user;

import base.TestBase;
import org.junit.Test;
import qiye.entity.User;
import qiye.service.UserService;

import javax.inject.Inject;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class TestUser extends TestBase {

    @Inject
    private UserService userService;

    @Test
    public void login() {
        System.out.println(userService.login(new User("admin", "1234")));
    }
}
