import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        int[] tree = new int[(int)Math.pow(2, info.length) + 1];
        Arrays.fill(tree, -1);
        tree[1] = 0;
        tree = makeTree(info, edges, tree, 0);
        
        int sheep = 1;
        int wolf = 0;
        int parent = 1;
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = 2; (wolf < sheep) && (i < tree.length); i++) {
            switch (tree[i]) {
                case -1:
                    continue;
                case 0:
                    System.out.println(i + " findSheep");
                    for (int j = i / 2; tree[j] != 0; j /= 2) {
                        if (path.contains(j) || wolf >= sheep) {
                            break;
                        }
                        wolf++;
                        path.add(j);
                    }
                    if (wolf < sheep) {
                        sheep++;
                    }
                    break;
                case 1:
                    continue;
            }
            System.out.print(i + " " + sheep + " " + wolf);
            System.out.println(path.toString());
        }
        answer = sheep;
        
        return answer;
    }
    
    public int[] makeTree(int[] info, int[][] edges, int[] tree, int node) {

        if (node == info.length) {
            return tree;
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == node) {
                if (tree[i * 2 + 1] == -1) {
                    tree[i * 2 + 1] = info[edges[i][1]];
                } else {
                    tree[i * 2 + 2] = info[edges[i][1]];
                }
            }
        }
        
        return makeTree(info, edges, tree, node + 1);
    }
    
}