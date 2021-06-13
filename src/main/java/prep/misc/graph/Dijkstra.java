package prep.misc.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    static int shortestPath(Map<String, Map<String, Integer>> adjMap, String src, String dest){
        Map<String, Integer> costs = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Set<String> processed = new HashSet<>();
        for(String s : adjMap.keySet()){
            if(s.equals(src))
                costs.put(s, 0);
            else
                costs.put(s, Integer.MAX_VALUE);
        }

        String node = lowestCodeNode(costs, processed);
        while (node != null){
            int cost = costs.get(node);
            for(Map.Entry<String, Integer> entry : adjMap.get(node).entrySet()){
                int newCost = cost + entry.getValue();
                if(newCost < costs.get(entry.getKey())) {
                    costs.put(entry.getKey(), newCost);
                    parents.put(entry.getKey(), node);
                }
            }
            processed.add(node);
            node = lowestCodeNode(costs, processed);
        }

        if(costs.get(dest) < Integer.MAX_VALUE) {
            String curr = dest;
            while (curr != src){
                System.out.print(curr+" >> ");
                curr = parents.get(curr);
            }
            System.out.println(curr);
        }
        return costs.get(dest);
    }

    static private String lowestCodeNode(Map<String, Integer> costs, Set<String> processed){
        int min = Integer.MAX_VALUE;
        String resNode = null;
        for(String node : costs.keySet()){
            if(costs.get(node) < min && !processed.contains(node)){
                min = costs.get(node);
                resNode = node;
            }
        }
        return resNode;
    }

    public static void main(String[] args) {

        /*          >A
        *       6    ^   1>
        *   S        3       F
        *       2    ^   5>
        *           >B
        * */
        Map<String, Map<String, Integer>> adjMap = new LinkedHashMap<>();
        adjMap.put("S", Map.of("A", 6, "B", 2));
        adjMap.put("A", Map.of("F", 1));
        adjMap.put("B", Map.of("A", 3, "F", 5));
        adjMap.put("F", Map.of());


        Map<String, Map<String, Integer>> adjMap2 = new LinkedHashMap<>();
        adjMap2.put("S", Map.of("A", 14, "B", 10));
        adjMap2.put("A", Map.of("D", 21));
        adjMap2.put("B", Map.of("C", 5, "E", 8));
        adjMap2.put("C", Map.of("D", 16));
        adjMap2.put("D", Map.of("F", 4));
        adjMap2.put("E", Map.of("D", 12));
        adjMap2.put("F", Map.of());


        System.out.println(shortestPath(adjMap2, "S", "F"));
    }
}
