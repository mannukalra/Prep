package prep.misc;

import java.util.Arrays;

public class ArrBsdQ {
    Integer[] q = null;
    int size = 0;
    ArrBsdQ(int len){
        q = len > 0 ? new Integer[len] : new Integer[20];
        size = 0;
    }

    void enque(int elem){
        q[size++] = elem;
    }

    int dequeue(){
        int elem = q[--size];
        q[size] = null;
        return elem;
    }

    public static void main(String[] args) {
        ArrBsdQ q = new ArrBsdQ(0);
        q.enque(10);
        q.enque(12);
        q.enque(13);
//        List<Integer> l = Arrays.asList(q.q);
        System.out.println(Arrays.asList(q.q)+" "+q.size);
        System.out.println(q.dequeue());
        System.out.println(Arrays.asList(q.q));
    }
}
