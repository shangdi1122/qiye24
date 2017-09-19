package roleMenu;

import base.TestBase;
import org.junit.Test;
import qiye.entity.Menu;
import qiye.service.RoleMenuService;

import javax.inject.Inject;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class TestRoleMenu extends TestBase {

    @Inject
    private RoleMenuService roleMenuService;

    @Test
    public void queryMenu() {
        for (Menu menu : roleMenuService.queryMenuByRoleId(1, 0)) {
            System.out.println(menu);
        }
    }

}
