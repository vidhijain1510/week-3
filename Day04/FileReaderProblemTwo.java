/*FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count.
*/

import java.io.*;
public class FileReaderProblemTwo {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;//Counter variable to keep track of word occurrences

        //FileReader to read from the file and wrapping it in a BufferedReader.
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive match
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;//Final count
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day04\\src\\file.txt"; //file path
        String targetWord = "Hello"; //Word we want to count

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}