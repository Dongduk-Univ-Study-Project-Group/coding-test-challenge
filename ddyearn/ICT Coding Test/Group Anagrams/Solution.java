import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getGroupedAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static int getGroupedAnagrams(List<String> words) {
        // Write your code here
        List<String> sortedWords = new ArrayList<>();

        for(String word : words) {
            char[] sc = word.toCharArray();
            Arrays.sort(sc);
            sortedWords.add(String.valueOf(sc));
        }
        Set<String> ana = new HashSet<>(sortedWords);
        return ana.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.getGroupedAnagrams(words);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}