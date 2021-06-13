package prep.misc.graph;

import java.util.*;

public class RadioStation {
    static class Clon implements Cloneable{
        int i = 20;
        Integer j = 200;
        String s = "1s";

        @Override
        public String toString() {
            return "Clon{" +
                    "i=" + i +
                    ", j=" + j +
                    ", s='" + s + '\'' +
                    '}';
        }

        @Override
        public Clon clone(){
            try{
                return (Clon)super.clone();
            }catch (CloneNotSupportedException e){
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Set<String> states_needed = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();

        stations.put("kone", new HashSet(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet(Arrays.asList("ca", "az")));

        Set<String> result = new HashSet<>();
        while (!states_needed.isEmpty()){
            String best = null;
            Set<String> covered = new HashSet<>();
            for(Map.Entry<String, Set<String>>  e : stations.entrySet()){
                Set<String> copy = new HashSet<>(states_needed);
                copy.retainAll(e.getValue());
                if(copy.size() > covered.size()){
                    best = e.getKey();
                    covered = copy;
                }
            }
            result.add(best);
            states_needed.removeAll(covered);
        }
        System.out.println(result);

        Clon c = new Clon();
        Clon c1 = c.clone();
        c1.i = 30; c1.j = 300; c1.s = "2s";
        System.out.println(c+"  "+c1);
    }
}
