package domain;

import domain.model.Image;
import repository.ImageRepository;

public class ImageService {

    ImageRepository imageRepository;

    public Image getImage(String userId) {
        return imageRepository.getImageForUser(userId);
    }
}
