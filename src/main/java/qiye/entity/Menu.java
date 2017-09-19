package qiye.entity;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class Menu {
    private Integer id,parentId;
    private String text,menuUrl;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", text='" + text + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Menu() {
    }

    public Menu(Integer id, Integer parentId, String text, String menuUrl) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.menuUrl = menuUrl;
    }
}
