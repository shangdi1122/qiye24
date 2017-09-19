package qiye.service;

import qiye.entity.Menu;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface RoleMenuService {
    List<Menu> queryMenuByRoleId( Integer roleId, Integer parentId);

}
