package prep.eop.ll;

import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}

class LIterator<T> implements Iterator<T>{
    Node<T> current;
    public LIterator(LList<T> list) {
        current = list.head;
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }
    @Override
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }
}

public class LList<T> implements Iterable<T>{
    Node<T> head = null;
    int size = 0;

    @Override
    public Iterator iterator() {
        return new LIterator<T>(this);
    }

    void add(T e){
        if(head == null){
            head = new Node(e);
        }else {
            Node temp = head.next;
            head.next = new Node<>(e);
            head.next.next = temp;
        }
        size++;
    }

    public static void main(String[] args) {
//        LList<String> list = new LList<>();
//        list.add("abc");list.add("mno");list.add("xyz");
//        Iterator<String> iter = list.iterator();
//
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }

        List<Integer> l = new LinkedList<>();
        Collections.addAll(l, 1,2,3,4,5);
        System.out.println(l.subList(2,4));
        System.out.println(Collections.binarySearch(l, 43));
    }
}
