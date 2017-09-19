package qiye.service.impl;

import org.springframework.stereotype.Service;
import qiye.dao.RoleMenuDao;
import qiye.entity.Menu;
import qiye.service.RoleMenuService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Inject
    private RoleMenuDao roleMenuDao;

    @Override
    public List<Menu> queryMenuByRoleId(Integer roleId, Integer parentId) {

        return roleMenuDao.queryMenuByRoleId(roleId, parentId);
    }
}
