import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        compareFileReaderAndInputStreamReader("./ByteToCharConverter.java"); // Change to your 100MB file path
    }

    // Compare StringBuilder vs. StringBuffer for concatenation
    private static void compareStringBuilderAndStringBuffer() {
        int iterations = 1000000;
        String text = "hello";

        // Measure StringBuilder performance
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure StringBuffer performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Compare FileReader vs. InputStreamReader for reading large files
    private static void compareFileReaderAndInputStreamReader(String filePath) {
        System.out.println("\nReading file using FileReader...");
        long startTime = System.nanoTime();
        int wordCount1 = countWordsUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount1);
        System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        System.out.println("\nReading file using InputStreamReader...");
        startTime = System.nanoTime();
        int wordCount2 = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount2);
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Read file and count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    // Read file and count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }
}
