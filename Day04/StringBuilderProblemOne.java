/*StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.*/

public class StringBuilderProblemOne{
    public static void main(String[] args) {
        //Creating a new StringBuilder object.
        StringBuilder stringBuilderObject = new StringBuilder();

        //Append the string to the StringBuilder.
        stringBuilderObject.append("Hello");
        //Printing the string builder object
        System.out.println("Original string: " + stringBuilderObject.toString());

        //reverse() method of StringBuilder to reverse the string.
        stringBuilderObject.reverse();

        //Converting the StringBuilder back to a string and returning it
        String reversedString  = stringBuilderObject.toString();
        System.out.println("Reversed String: " + reversedString );
    }
}