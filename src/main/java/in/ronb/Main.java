package in.ronb;

import in.ronb.exceptions.InvalidInputStringException;
import in.ronb.game.Game;
import in.ronb.game.GameCollection;
import in.ronb.game.CubeSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InvalidInputStringException, IllegalArgumentException {
        if(args.length < 1){
            throw new  IllegalArgumentException("No input file supplied");
        }
        String fileName = args[0];
        File fileHandler = new File(fileName);
        GameCollection gameCollection = new GameCollection();
        try{
            Scanner scanner = new Scanner(fileHandler);
            Pattern pattern = Pattern.compile("^Game \\d+:( \\d+ (red|green|blue)(,|;))+ \\d+ (red|green|blue)$");
            int lineIndex = 0;
            while (scanner.hasNextLine()){
                lineIndex++;
                String line = scanner.nextLine();
                if(!pattern.matcher(line).matches()){
                    throw new InvalidInputStringException("Invalid input file. Invalid format on Line No : " + lineIndex);
                }
                gameCollection.add(new Game(line));
            }
        }
        catch (FileNotFoundException error){
            System.out.println("File " + fileName + " not found");
            throw error;
        }

        System.out.println("Challenge 1 Answer : ");
        System.out.println(gameCollection.getSumOfPossibleGameIds(new CubeSet(12,13,14)));
        System.out.println("__________________________________________________________________________");
        System.out.println("Challenge 2 Answer");
        System.out.println(gameCollection.getSumOfPower());

    }
}