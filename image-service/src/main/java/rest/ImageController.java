package rest;

import domain.model.Image;
import domain.ImageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageController {

    ImageService imageService;

    public Image getImageForUser(String userId) {
        return imageService.getImage(userId);
    }
}
