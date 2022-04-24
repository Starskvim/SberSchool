package domain;

import domain.model.Image;
import domain.model.UserMessage;
import lombok.AllArgsConstructor;
import rest.ImageController;
import rest.MessageController;
import rest.model.MainPage;

@AllArgsConstructor
public class ContentService {

    ImageController imageController;
    MessageController messageController;

    public MainPage getMainPageUser(String userId){
        MainPage mainPage = new MainPage();
        Image image = imageController.getImageForUser(userId);
        UserMessage userMessage = messageController.getMessageForUser(userId);

        mainPage.setImage(image);
        mainPage.setUserMessage(userMessage);

        return mainPage;
    }

}
