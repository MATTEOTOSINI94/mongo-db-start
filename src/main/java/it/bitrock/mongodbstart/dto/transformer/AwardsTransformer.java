package it.bitrock.mongodbstart.dto.transformer;

import it.bitrock.mongodbstart.dto.AwardsDTO;
import it.bitrock.mongodbstart.model.Awards;

public class AwardsTransformer {

    private AwardsTransformer(){

    }

    public static AwardsDTO fromAwardsToAwardsDTO(Awards awards){
        if(awards!=null) {
            return new AwardsDTO(awards.getWins(), awards.getNominations(), awards.getText());
        }
        return new AwardsDTO();
    }
}
