package repository;

import domain.model.Image;

public interface ImageRepository {

    Image getImageForUser(String user);

}
