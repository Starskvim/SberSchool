package rest.model;

import domain.model.Image;
import domain.model.UserMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainPage {

    private Image image;
    private UserMessage userMessage;

}
