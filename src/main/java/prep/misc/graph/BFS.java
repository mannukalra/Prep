package prep.misc.graph;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    static String bfs(Map<String, List<String>> adjLMap, String start, String endsWith){
        Queue<String> queue = new LinkedList<>();
        queue.addAll(adjLMap.get(start));
        List<String> tracker = new ArrayList<>();
        String result = null;
        while (!queue.isEmpty()) {
            String next = queue.poll();
            if (next.endsWith(endsWith)) {
                result = next;
                break;
            }
            if(adjLMap.containsKey(next)){
                tracker.add(next);
            }
            queue.addAll(adjLMap.get(next));
        }
        System.out.println(tracker);
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> adjLMap = new HashMap<>();
        adjLMap.put("you", Arrays.asList("alice", "bob", "clare"));
        adjLMap.put("bob", Arrays.asList("anuj", "peggy"));
        adjLMap.put("alice", Arrays.asList("peggy"));
        adjLMap.put("clare", Arrays.asList("thom", "jonny"));
        adjLMap.put("anuj", Arrays.asList());
        adjLMap.put("peggy", Arrays.asList());
        adjLMap.put("thom", Arrays.asList());
        adjLMap.put("jonny", Arrays.asList());

        System.out.println(bfs(adjLMap, "you", "y"));
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,3));
        set1.retainAll(set2);
        System.out.println(set1);
    }
}
