package qiye.dao;

import org.apache.ibatis.annotations.Param;
import qiye.entity.Menu;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface RoleMenuDao {
    List<Menu> queryMenuByRoleId(@Param("roleId") Integer roleId, @Param("parentId") Integer parentId);
}
