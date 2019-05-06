package az.azex.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1485241224794391692L;
    private String email;
    private String password;
    private String name;
    private String surname;
    private List<Role> roleList;

    public User() {
        this.roleList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
