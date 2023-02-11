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
     * Complete the 'maxEnergy' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY mat as parameter.
     */

    public static int maxEnergy(List<List<Integer>> mat) {
        // Write your code here

        int min = 401;
        for(int j = 0; j<4; j++) {
            if(path(mat, 3, j)<min) {
                min = path(mat, 3, j);
            }
        }
        return 100 - min;
    }
    public static int path(List<List<Integer>> mat, int i, int j) {
        if(i==0) {
            return mat.get(i).get(j);
        }
        if(j==3) {
            return Math.min(path(mat, i-1, j), path(mat, i-1, j-1)) + mat.get(i).get(j);
        } else if(j==0) {
            return Math.min(path(mat, i-1, j),path(mat, i-1, j+1)) + mat.get(i).get(j);
        } else {
            return Math.min((Math.min(path(mat, i-1, j-1),path(mat, i-1, j))),path(mat, i-1, j+1)) + mat.get(i).get(j);
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> mat = new ArrayList<>();

        IntStream.range(0, matRows).forEach(i -> {
            try {
                mat.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.maxEnergy(mat);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}