/*Linear Search Problem 2: Search for a Specific Word in a List of Sentences
Problem:
You are given an array of sentences (strings).
Write a program that performs Linear Search to find the first sentence containing a specific word. If the word is found,
return the sentence. If no sentence contains the word, return "Not Found".
Approach:
Iterate through the list of sentences.
For each sentence, check if it contains the specific word.
If the word is found, return the current sentence.
If no sentence contains the word, return "Not Found".
*/

public class LinearSearchProblemTwo {

    //Method performing linear search
    public static String linearSearch(String[] sentencesArray, String word){
        for(String str : sentencesArray){//Iterating through the list of sentences.
            if(str.contains(word)){
                return str;//If the word is found returning the current sentence.
            }
        }
        //If no sentence contains the word returning "Not Found".
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentencesArray = {"I'm learning java",
                                    "My name is Vidhi!",
                                    "My friend's name is suhani"};
        String word = "Vidhi"; //Word to be searched
        String results = linearSearch(sentencesArray, word);//Calling method to search word in a sentence
        System.out.println("The sentence that contains '" + word + "' is: " + results);
    }
}