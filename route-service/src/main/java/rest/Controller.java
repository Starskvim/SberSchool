package rest;

import domain.ContentService;
import domain.UserService;
import rest.model.MainPage;

public class Controller {

    UserService userService;
    ContentService contentService;

    public Controller (UserService userService){
        this.userService = userService;
    }

    public String login (String userInfo){
        return userService.auth(userInfo);
    }

    public MainPage getMainPageUser(String userId){
        return contentService.getMainPageUser(userId);
    }

}
