# Advent of Code 2023 Solution
## _Works for both Part 1 and Part 2_

[Advent of Code](https://adventofcode.com/)

Implements the Advent of Code 2023 solution for day 1 using RegEx

## This is for Part 2. Where's Part 1?

- This solution will work for both Part 1 and Part 2
- To use as part 1 solution, open the MatchNumbers class (in.ronb.MatchNumbers) and set writtenWords to an empty list
- This will provide solution for Part 1


## How to use?
> This is a guide for running the code in compiled java. If you know what you're doing, just pass the input text file as first paramete to the application
- This application accepts the input text file as First parameter.
- Ensure you have JDK 17 installed. I personally use [OpenJDK](https://openjdk.org/) or [Bellsoft Liberica JDK](https://bell-sw.com/pages/downloads/#jdk-17-lts)
- Go to project directory and type the following
```
./mvnw clean compile
# replace "input.txt with file name for your input string"
java -classpath ./target/classes in.ronb.Main input.txt
```
- Or if you're on windows:
```
.\mvnw.cmd clean compile
# replace "input.txt with file name for your input string"
java -classpath .\\target\\classes in.ronb.Main input.txt
```
