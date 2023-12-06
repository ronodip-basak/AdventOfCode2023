package in.ronb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Solves Day 1 challenge for AdventOfCode 2023 (https://adventofcode.com/)
// Set the writtenWords List to an empty list for Part 1
// This solves Part 2

public class MatchNumbers {
    private final Scanner scanner;

    // Set this list to empty List to get Part 1 answer
    // Leave it as is for Part 2
    private final List<String> writtenWords = List.of(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    );
    public MatchNumbers (File fileHandler) throws FileNotFoundException {
        this.scanner = new Scanner(fileHandler);
    }

    public Integer run() {
        List<String> lines = getLines();
        int total = 0;
        for (String line : lines) {
            Integer num = getIntegerFromInputString(line);
            total += num;
        }
        return total;
    }

    private List<String> getLines(){
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()){
            lines.add(scanner.nextLine());
        }

        return lines;
    }



    private Integer getIntegerFromInputString(String input){
        List<String> matches = new ArrayList<>();
        String regexString = writtenWords.isEmpty() ? "(?=([0-9]))" : "(?=([0-9]|" + customImplode("|", writtenWords) +"))";
        Matcher matcher = Pattern.compile(regexString).matcher(input);
        while(matcher.find()){
            for (int i = 1; i <= matcher.groupCount(); i++){
                matches.add(matcher.group(i));
            }

        }
        if(matches.isEmpty()){
            return 0;
        }
        return getIntegerFromMatchList(matches);
    }

    private Integer getIntegerFromMatchList(List<String> matches){
        if(matches.isEmpty()){
            return 0;
        }

        Integer first = getIntegerFromMatchString(matches.get(0));
        Integer last = getIntegerFromMatchString(matches.get(matches.size() - 1));

        return  Integer.valueOf("" + first + last);

    }

    public Integer getIntegerFromMatchString(String match){
        Integer output;
        try{
            output = Integer.valueOf(match);
        }
        catch (NumberFormatException err){
            Integer index = writtenWords.indexOf(match);
            output = index + 1;
        }

        return output;
    }

    // Join List<String> elements with a String (glue)
    // Similar to implode() function on PHP
    // https://www.php.net/manual/en/function.implode.php
    public static String customImplode(String glue, List<String> strings)
    {
        String ret = "";
        for(int i=0;i<strings.size();i++)
        {
            if (strings.get(i).trim() != "")
                ret += (i == strings.size() - 1) ? strings.get(i) : strings.get(i) + glue;
        }
        return ret;
    }

}
