/*StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.*/

import java.util.HashSet;
public class StringBuilderProblemTwo{

    //Method to remove duplicate characters
    public static String removeDuplicate(String string){

        //Initializing an empty StringBuilder and a HashSet to keep track of characters.
        StringBuilder stringBuilderObject = new StringBuilder();
        HashSet<Character> seenCharacters = new HashSet<>();

        //Iterating over each character in the string:
        for(char ch:string.toCharArray()){

            //If the character is not in the HashSet, we'll append it to the StringBuilder and add it to the HashSet.
            if(!seenCharacters.contains(ch)){
                stringBuilderObject.append(ch);
                seenCharacters.add(ch);
            }
        }
        //Returning the StringBuilder as a string without duplicates.
        return stringBuilderObject.toString();
    }

    public static void main(String[] args) {
        String string = "Malayalam"; //Original string containing duplicate characters
        System.out.println("Original String: " + string);
        String removedDuplicate = removeDuplicate(string); //Calling method to remove duplicate characters
        System.out.println("String after duplicate character removed: " + removedDuplicate);
    }
}