/*InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read binary data from a file and print it as characters.
The file contains data encoded in a specific charset (e.g., UTF-8).
Approach:
Create a FileInputStream object to read the binary data from the file.
Wrap the FileInputStream in an InputStreamReader to convert the byte stream into a character stream.
Use a BufferedReader to read characters efficiently from the InputStreamReader.
Read the file line by line and print the characters to the console.
Handle any encoding exceptions as needed.
*/

import java.io.*;
public class InputStreamProblemOne {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day04\\src\\file.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            //Reading the file line by line and print each line to the console
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);  //Printing each character line to the console
            }

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
