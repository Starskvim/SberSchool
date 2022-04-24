package rest;

import domain.MessageService;
import domain.model.UserMessage;

public class MessageController {

    MessageService messageService;

    public UserMessage getMessageForUser(String userId){
        return messageService.getMessage(userId);
    }

}
