package OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity;

import OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountController;
import OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountManager;

public class AccountControllerImpl implements AccountController  {
    private AccountManager accountManager;

    public AccountControllerImpl(AccountManager manager) {
        this.accountManager = manager;
    }

    public void changePassword(String oldPass,String newPass){
        this.accountManager.changePassword(oldPass,newPass);
    }

}
