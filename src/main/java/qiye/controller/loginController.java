package qiye.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiye.entity.Menu;
import qiye.entity.RoleUser;
import qiye.entity.User;
import qiye.service.RoleMenuService;
import qiye.service.RoleUserService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Controller
@RequestMapping(value = "login",produces = "application/json;charset=utf-8")
public class loginController {

    @Inject
    private RoleUserService roleUserService;

    @Inject
    private RoleMenuService roleMenuService;

    @PostMapping(value = "login")
    public String login(User user, HttpSession session, Model model) {
        RoleUser roleUser = roleUserService.queryByUserNameAndPassword(user);
        if (roleUser != null) {
            session.setAttribute("roleUser", roleUser);
            return "main/main";
        } else {
            model.addAttribute("msg", "对不起，用户名或密码输入错误！");
            return "../login";
        }
    }

    @GetMapping(value = "queryMenuByRoleId")
    @ResponseBody
    public String queryMenuByRoleId(Integer parentId, HttpSession session) {
        RoleUser roleUser = (RoleUser) session.getAttribute("roleUser");
        List<Menu> menus = roleMenuService.queryMenuByRoleId(roleUser.getRole().getId(), parentId);
        return JSON.toJSONString(menus);
    }
}
