package OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity;

import OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;

public class UserImpl implements User {
    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPasswordHash() {
        return null;
    }

    @Override
    public void changePassword(String oldPass, String newPass) {

    }
}
