package OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface AccountManager {

    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    User getUserByName(String name);

    void changePassword(String oldPass, String newPass);

}
