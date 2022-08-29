package it.bitrock.mongodbstart.dto.transformer;

import it.bitrock.mongodbstart.dto.TomatoesDTO;
import it.bitrock.mongodbstart.dto.ViewerDTO;
import it.bitrock.mongodbstart.model.Tomatoes;
import it.bitrock.mongodbstart.model.Viewer;

public class TomatoesTransformer {

    private TomatoesTransformer(){

    }
    public static TomatoesDTO fromTomatoesToTomatoesDTO(Tomatoes tomatoes){
        if (tomatoes != null) {
            return new TomatoesDTO(new ViewerDTO(tomatoes.getViewer().getRating(), tomatoes.getViewer().getNumReviews()), tomatoes.getLastUpdated());
        }
        return new TomatoesDTO();
    }
}
