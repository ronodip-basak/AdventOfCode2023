package in.ronb;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            throw new Exception("No input file specified");
        }


        String fileName = args[0];
        File fileHandler = new File(fileName);

        try{
            MatchNumbers matchNumbers = new MatchNumbers(fileHandler);
            System.out.println(matchNumbers.run());

        }
        catch (FileNotFoundException error){
            System.out.println("File " + fileName + " not found");
        }
    }
}