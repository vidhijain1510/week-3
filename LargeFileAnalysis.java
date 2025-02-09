import java.io.*;

public class LargeFileAnalysis {
    public static void main(String[] args) {
        //Ensuring these files exist before running the program
        String[] filePaths = {"C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day06-TimeSpaceComplexity\\src\\SmallFile1MB.txt", "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day06-TimeSpaceComplexity\\src\\LargeFile100MB.txt", "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-3\\Day06-TimeSpaceComplexity\\src\\LargeFile500MB.txt"};

        for(String filepath:filePaths){
            System.out.println("\nreading file:  "+filepath);

            long start =System.nanoTime();
            readUsingFileReader(filepath);
            long end=System.nanoTime();
            System.out.println("FileReader Time: "+(end-start)/1_000_000.0+" ms");

            start =System.nanoTime();
            readUsingInputStreamReader(filepath);
            end=System.nanoTime();
            System.out.println("InputStreamReader Time: "+(end-start)/1_000_000.0+" ms");
        }
    }

    //Reading using FileReader (Character Stream)
    private static void readUsingFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            char[] buffer = new char[8192]; // 8KB buffer for efficiency
            while (reader.read(buffer) != -1) {
                // Read file in chunks instead of character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Reading using InputStreamReader (Byte Stream)
    private static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[8192]; // 8KB buffer for efficiency
            while (reader.read(buffer) != -1) {
                // Read file in chunks instead of byte by byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}