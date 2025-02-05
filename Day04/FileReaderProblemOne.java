/*FileReader Problem 1: Read a File Line by Line Using FileReader
Problem:
Write a program that uses FileReader to read a text file line by line and print each line to the console.
Approach:
Create a FileReader object to read from the file.
Wrap the FileReader in a BufferedReader to read lines efficiently.
Use a loop to read each line using the readLine() method and print it to the console.
Close the file after reading all the lines.
*/
import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaders{
    public static void main(String[] args) {
        //File Path
        String filePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day04\\src\\file.txt";

        //FileReader object to read from the file.
        //Wraping the FileReader in a BufferedReader to read lines efficiently.
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            //Loop to read each line using the readLine() method and printing it to the console.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);  // Print each line to the console
            }
            fileReader.close();

            //Closing the file after reading all the lines.



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

