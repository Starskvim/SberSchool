import domain.ContentService;
import domain.model.Image;
import domain.model.UserMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rest.ImageController;
import rest.MessageController;
import rest.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContentServiceTest {

    @InjectMocks
    ContentService contentService;

    @Mock
    ImageController imageController;

    @Mock
    MessageController messageController;


    @Test
    public void init(){
        UserMessage userMessage = new UserMessage();
        userMessage.setMessage("test");
        Image image = new Image();
        image.setImage("test");
        MainPage testPage = new MainPage();
        testPage.setUserMessage(userMessage);
        testPage.setImage(image);

        when(imageController.getImageForUser(any())).thenReturn(image);
        when(messageController.getMessageForUser(any())).thenReturn(userMessage);

        MainPage result = contentService.getMainPageUser("test");

        assertAll(() -> assertEquals(result.getImage(),testPage.getImage()),
                () -> assertEquals(result.getUserMessage(), testPage.getUserMessage()));
    }

}
