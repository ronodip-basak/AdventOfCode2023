package in.ronb.game;
import lombok.*;

import java.util.ArrayList;

@EqualsAndHashCode
@ToString
@Getter
public class Game {
    private final Integer id;
    private ArrayList<CubeSet> cubeSets;

    public Game(String gameString) {
        ArrayList<CubeSet> cubeSets = new ArrayList<>();

        String[] splitGameString = gameString.split(":");

        this.id = Integer.parseInt(splitGameString[0].split(" ")[1]);

        String[] cubeSetsString = splitGameString[1].split(";");

        for (String cubeSetString : cubeSetsString) {
            cubeSets.add(new CubeSet(cubeSetString));
        }

        this.cubeSets = cubeSets;
    }

    private CubeSet getMinimumCubeSetRequired(){
        Integer red = 0;
        Integer green = 0;
        Integer blue = 0;

        for (CubeSet cubeSet : cubeSets){
            if(cubeSet.getRed() > red){
                red = cubeSet.getRed();
            }

            if(cubeSet.getGreen() > green){
                green = cubeSet.getGreen();
            }

            if(cubeSet.getBlue() > blue){
                blue = cubeSet.getBlue();
            }
        }
        return new CubeSet(red, green, blue);
    }

    public Integer getPower(){
        CubeSet cubeSet = getMinimumCubeSetRequired();
        return cubeSet.getRed() * cubeSet.getGreen() * cubeSet.getBlue();
    }
}
