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
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : ids) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        int answer = keySetList.size();
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

        for(Integer key : keySetList) {
            if(m<map.get(key)) {
                break;
            } else {
                m -= map.get(key);
                answer--;
            }
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int idsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ids = IntStream.range(0, idsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.deleteProducts(ids, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}