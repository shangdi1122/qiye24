package qiye.entity;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class RoleMenu {
    private  Integer id;
    private  Role role;
    private  Menu menu;

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", role=" + role +
                ", menu=" + menu +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public RoleMenu() {
    }

    public RoleMenu(Integer id, Role role, Menu menu) {
        this.id = id;
        this.role = role;
        this.menu = menu;
    }
}
