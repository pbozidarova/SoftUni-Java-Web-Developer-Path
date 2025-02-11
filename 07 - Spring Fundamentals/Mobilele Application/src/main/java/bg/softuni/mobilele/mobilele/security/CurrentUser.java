package bg.softuni.mobilele.mobilele.security;

import bg.softuni.mobilele.mobilele.enums.UserRoleEnum;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS_NAME = "anonymous";

    private String name = ANONYMOUS_NAME;
    private boolean isAnonymous = true;
    private List<UserRoleEnum> userRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public void setUserRoles(List<UserRoleEnum> newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
    }

    public boolean isAdmin() {
        return userRoles.contains(UserRoleEnum.ADMIN);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn() {
        return !isAnonymous;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if(anonymous) {
            this.name = ANONYMOUS_NAME;
            this.userRoles.clear();
        }

        isAnonymous = anonymous;
        return this;
    }
}
