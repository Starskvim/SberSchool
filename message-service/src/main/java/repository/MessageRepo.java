package repository;


import domain.model.UserMessage;

public interface MessageRepo {

    UserMessage getMessageForUser(String userId);

}
