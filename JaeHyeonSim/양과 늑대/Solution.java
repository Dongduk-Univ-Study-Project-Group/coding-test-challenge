import java.util.Arrays;
import java.util.ArrayList;

class SolutionSheepWolf {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        ArrayList<Node> tree = makeTree(info, edges);
//        for (Node n : tree) {
//        	System.out.println(n.toString());
//        }
        int[] level = new int[info.length];
        level[1] = 0;
        int parent = 0;
//        for (int i = 2; i < tree.size(); i += 2) {
//        	level[i] = tree.get(parent).left;
//        	level[i + 1] = tree.get(parent).right;
//        }
        
        int wolf = 0;
        int sheep = 1;
        int node = tree.get(0).left;
        ArrayList<Integer> visited = new ArrayList<Integer>();
        while ((wolf < sheep) && (node < tree.size())) {
        	if (tree.get(node).data == 0) {
                System.out.println(node + " findSheep");

    			visited.add(node);
        		for (int j = tree.get(node).parent; tree.get(j).data != 0; j = tree.get(j).parent) {
					if (visited.contains(j) || wolf >= sheep) {
					    break;
					}
        			wolf++;
        			visited.add(j);
        		}
                if (wolf < sheep) {
	                sheep++;
	            }
        		
        	}

        	while (!visited.contains(node)) {
        		node = tree.get(tree.get(node).parent).left;
            	if (tree.get(node).data == -1) {
            		node = tree.get(tree.get(node).parent).right;
            	}
        	}
        	
//        	if () {
//        		
//        	}
        }
        System.out.print(node + " " + sheep + " " + wolf);
        System.out.println(visited.toString());
        answer = sheep;
        
        return answer;
    }
    
//    public int[] findSheep(ArrayList<Node> tree, int parent) {
//    	int sheep, wolf;
//    	sheep = wolf = 0;
//    	
//    	switch(tree.get(parent).data) {
//    		case -1:
//    			return null;
//    		case 0:
//        		sheep++;
//    			break;
//    		case 1:
//    			wolf++;
//    			break;
//    	}
//
//    	int[] sum = findSheep(tree, tree.get(parent).left);
//    	if (sum != null) {
//        	sheep += sum[0];
//        	wolf += sum[1];
//    	}
//    	
//    	
//    	return new int[] { sheep, wolf };
//    }
    
    public ArrayList<Node> makeTree(int[] info, int[][] edges) {
        ArrayList<Node> tree = new ArrayList<Node>();
        for (int i = 0; i < info.length; i++) {
        	tree.add(new Node(info[i], -1, -1, -1));
        }
        for (int i = 0; i < edges.length; i++) {
        	Node node = tree.get(edges[i][0]);
        	if (node.left == -1) {
        		node.left = edges[i][1];
        		tree.get(node.left).parent = edges[i][0];
        	} else {
        		node.right = edges[i][1];
        		tree.get(node.right).parent = edges[i][0];
        	}
        }
        
//        for (int i = 0; i < )
        
        return tree;
    }
    
    class Node {
    	int data;
    	int parent;
    	int left;
    	int right;
    	
    	public Node() {
    	}
    	public Node(int data, int parent, int left, int right) {
    		this.data = data;
    		this.parent = parent;
    		this.left = left;
    		this.right = right;
    	}
    	
    	public String toString() {
    		return data + "\nparent: " + parent + " left: " + left + " right: " + right;
    	}
    	
    }
    
}

//
//import java.util.Arrays;
//import java.util.ArrayList;
//
//class Solution {
//    public int solution(int[] info, int[][] edges) {
//        int answer = 0;
//        
//        int[] tree = new int[(int)Math.pow(2, info.length) + 1];
//        Arrays.fill(tree, -1);
//        tree[1] = 0;
//        tree = makeTree(info, edges, tree, 0);
//        
//        int sheep = 1;
//        int wolf = 0;
//        int parent = 1;
//        ArrayList<Integer> path = new ArrayList<Integer>();
//        for (int i = 2; (wolf < sheep) && (i < tree.length); i++) {
//            switch (tree[i]) {
//                case -1:
//                    continue;
//                case 0:
//                    System.out.println(i + " findSheep");
//                    for (int j = i / 2; tree[j] != 0; j /= 2) {
//                        if (path.contains(j) || wolf >= sheep) {
//                            break;
//                        }
//                        wolf++;
//                        path.add(j);
//                    }
//                    if (wolf < sheep) {
//                        sheep++;
//                    }
//                    break;
//                case 1:
//                    continue;
//            }
//            System.out.print(i + " " + sheep + " " + wolf);
//            System.out.println(path.toString());
//        }
//        answer = sheep;
//        
//        return answer;
//    }
//    
//    public int[] makeTree(int[] info, int[][] edges, int[] tree, int node) {
//
//        if (node == info.length) {
//            return tree;
//        }
//        
//        for (int i = 0; i < edges.length; i++) {
//            if (edges[i][0] == node) {
//                if (tree[i * 2 + 1] == -1) {
//                    tree[i * 2 + 1] = info[edges[i][1]];
//                } else {
//                    tree[i * 2 + 2] = info[edges[i][1]];
//                }
//            }
//        }
//        
//        return makeTree(info, edges, tree, node + 1);
//    }
//    
//}