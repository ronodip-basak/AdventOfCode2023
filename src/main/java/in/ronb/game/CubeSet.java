package in.ronb.game;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CubeSet {
    private Integer red;
    private Integer green;
    private Integer blue;

    public CubeSet(String cubeSetString){
        this.blue = 0;
        this.red = 0;
        this.green = 0;

        String[] cubesString = cubeSetString.split(",");
        for (String cubeString : cubesString){
            String[] cube = cubeString.trim().split(" ");
            Integer cubeCount = Integer.valueOf(cube[0]);
            String cubeName = cube[1];

            switch (cubeName){
                case "red":
                    this.red = cubeCount;
                    break;
                case "green":
                    this.green = cubeCount;
                    break;
                case "blue":
                    this.blue = cubeCount;
                    break;
                default:
                    // Do nothing
                    break;
            }
        }
    }


}
