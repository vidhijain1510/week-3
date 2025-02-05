/*InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read user input from the console and write the input to a file.
Each input should be written as a new line in the file.
Approach:
Create an InputStreamReader to read from System.in (the console).
Wrap the InputStreamReader in a BufferedReader for efficient reading.
Create a FileWriter to write to the file.
Read user input using readLine() and write the input to the file.
Repeat the process until the user enters "exit" to stop inputting.
Close the file after the input is finished.
*/

import java.io.*;
public class InputStreamProblemTwo {

    public static void main(String[] args) {
        //Creating a BufferedReader to read input from the console
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter("C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day04\\src\\file.txt", true);  // Open file in append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String input;
            System.out.println("Enter text to write to the file (type 'exit' to quit):");

            //Repeating the process until the user enters "exit"
            while (true) {
                input = consoleReader.readLine();  //user input

                //If user enters "exit", stop the loop and close the file
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                //Writing the input to the file
                bufferedWriter.write(input);
                bufferedWriter.newLine();
            }

            System.out.println("Input saved to file. Program terminated.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}