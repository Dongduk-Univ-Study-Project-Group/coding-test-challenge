import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
	        answer = new int[2];
	        int result[][] = new int[gates.length][];
	        
	        for (int gIdx = 0; gIdx < gates.length; gIdx++) {
	            ArrayList<Integer> visited = new ArrayList<Integer>();
	            visited.add(gates[gIdx]);
	            
	            int minV = gates[gIdx];
	            int summit = -1;
	            int intensity = -1;
	            

	    		ArrayList<Edge>[] graph = new ArrayList[n + 1];
	    		for (int i = 0; i < graph.length; i++)  {
	    			graph[i] = new ArrayList<>();
	    		}
            	for (int i = 0; i < paths.length; i++) {
	    			int v = paths[i][0];
	    			int w = paths[i][1];
	    			int cost = paths[i][2];
	    			
	    			graph[v].add(new Edge(v, w, cost));
	    			graph[w].add(new Edge(w, v, cost));
            	}

	    		result[gIdx] = prim(minV, n, graph, summits);
	        }
            
	        int min = 0;
	        for (int i = 0; i < result.length; i++) {
	            if (result[i][2] < result[min][2]) {
	                min = i;
	            }
	        }
	        
	        answer[0] = result[min][1];
	        answer[1] = result[min][2];
	        
	        return answer;
    }
    
        public static int[] prim(int start, int n, ArrayList<Edge>[] list, int[] summits) {
	        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
	        Queue<Integer> queue = new LinkedList<>();
	        int result[]= new int[3];
	        int summit = -1;
	        int intensity = -1;
	        boolean[] visit = new boolean[n + 1];

	        queue.add(start);
	        while(!queue.isEmpty()){
	            //시작 정점 및 연결된 정점 방문처리
	            int curNode = queue.poll();
	            visit[curNode] = true;

	            for(Edge edge : list[curNode]){
	                if(!visit[edge.end])
	                    priorityQueue.add(edge);
	            }

	            while(!priorityQueue.isEmpty() && summit == -1){
	                Edge edge = priorityQueue.poll();
	                if(!visit[edge.end]){
	                    queue.add(edge.end);
	                    visit[edge.end] = true;
	                    
	                    for (int sIdx = 0; sIdx < summits.length; sIdx++) {
		                    if (edge.end == summits[sIdx]) {
		                        summit = summits[sIdx];
		                        break;
		                    }
		                }
	                    if (edge.cost > intensity) {
	                    	intensity = edge.cost;
	                    }
                        
	                    break;
	                }
	            }
	        }

            result[0] = start;
            result[1] = summit;
            result[2] = intensity;
	        return result;
	    }
    
      public static int getMinPath(int[][] paths, int v, ArrayList<Integer> visited) {
	        int minIdx = -1;
	        for (int i = 0; i < paths.length; i++) {
	            if (paths[i][0] == v || paths[i][1] == v) {
	            	
	            	if (visited.contains(paths[i][0]) && visited.contains(paths[i][1])) {
	            		continue;
	            	}
	                
	                if (minIdx == -1) {
	                    minIdx = i;
	                } else if (paths[i][2] < paths[minIdx][2]) {
	                    minIdx = i;
	                }
	                
	            }
	        }
	        
	        return minIdx;
	    }
}

class Edge implements Comparable<Edge>{
    int start, end, cost;

    public Edge(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}