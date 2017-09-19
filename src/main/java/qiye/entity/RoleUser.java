package qiye.entity;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class RoleUser {
    private Integer id;
    private Role role;
    private User user;

    @Override
    public String toString() {
        return "RoleUser{" +
                "id=" + id +
                ", role=" + role +
                ", user=" + user +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleUser() {
    }

    public RoleUser(Integer id, Role role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }
}
