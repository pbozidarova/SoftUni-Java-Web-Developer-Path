package OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity;

import OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountManager;
import OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;

public class AccountManagerImpl implements AccountManager {
    private boolean requireUniqueEmail;

    private static int MIN_REQUIRED_PASSWORD_LENGTH =5;
    private static int MAX_REQUIRED_PASSWORD_LENGTH =5;

//    @Override
//    public boolean getRequireUniqueEmail() {
//        return this.requireUniqueEmail;
//    }
//
//    @Override
//    public int getMinRequiredPasswordLength() {
//        return this.minRequiredPasswordLength;
//    }
//
//    @Override
//    public int getMaxRequiredPasswordLength() {
//        return this.maxRequiredPasswordLength;
//    }
//
//    @Override
//    public void register(String username, String password) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public void login(String username, String password) {
//        throw new UnsupportedOperationException();
//    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }

    @Override
    public Iterable<User> getAllUsersOnline() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<User> getAllUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User getUserByName(String name) {
        throw new UnsupportedOperationException();
    }

}
