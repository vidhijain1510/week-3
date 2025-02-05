/*StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate all the strings in the array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.
 */
public class StringBufferProblemOne{

    //Method to concate strings of an array
    public static String concatString(String[] stringArray){

        //Creating a new StringBuffer object.
        StringBuffer stringBufferObject = new StringBuffer();

        //Iterating through each string in the array and appending it to the StringBuffer.
        for(String string : stringArray){
            stringBufferObject.append(string);
        }
        //Returning the concatenated string after the loop finishes.
        return stringBufferObject.toString();
    }
    public static void main(String[] args) {

        //Input String type Array
        String[] stringArray = {"Hello", "!"," ", "CG","."};
        String concatedString = concatString(stringArray);//Calling method to concat strings
        System.out.println(concatedString);
    }
}