package in.ronb.game;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class GameCollection extends ArrayList<Game> {

    private List<Game> getPossibleGames(CubeSet cubeSet){
        return this.stream().filter((Game game) -> {
            Boolean isPossible = true;
            for (CubeSet gameCubeSet : game.getCubeSets()){
                if((gameCubeSet.getBlue() > cubeSet.getBlue()) || (gameCubeSet.getRed() > cubeSet.getRed()) || gameCubeSet.getGreen() > cubeSet.getGreen()){
                    isPossible = false;
                    break;
                }
            }

            return isPossible;

        }).toList();
    }

    public Integer getSumOfPossibleGameIds(CubeSet cubeSet){
        Integer sum = 0;
        for (Game game : getPossibleGames(cubeSet)){
            sum += game.getId();
        }
        return sum;
    }

    public Integer getSumOfPower(){
        Integer sum = 0;
        for (Game game : this){
            sum += game.getPower();
        }
        return sum;
    }
}
