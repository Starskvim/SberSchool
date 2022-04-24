package domain;

import rest.AccountController;

public class UserService {

    AccountController accountController;

    public String auth(String userInfo) {
        return accountController.authUser(userInfo);
    }

}
