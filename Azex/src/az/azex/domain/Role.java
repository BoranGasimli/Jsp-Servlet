package az.azex.domain;

import java.io.Serializable;

public class Role extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 3214620537718907618L;

    private String name;
    private String defaultController;
    private String defaultPage;

    public String getDefaultController() {
        return defaultController;
    }

    public void setDefaultController(String defaultController) {
        this.defaultController = defaultController;
    }

    public Role() {
        this.name = "";
        this.defaultController = "";
        this.defaultPage = "";
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultController='" + defaultController + '\'' +
                ", defaultPage='" + defaultPage + '\'' +
                ", status=" + status +
                '}';
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
