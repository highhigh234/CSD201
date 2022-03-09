import java.util.*;
public class MyQueue {
    LinkedList<Integer> t;
    
    MyQueue(){
        t = new LinkedList<Integer>();
    }
    void clear(){
        t.clear();
    }
    boolean isEmpty(){
        return (t.isEmpty());
    }
    void enqueue(int p){
        t.addLast(p);
    }
    int dequeue(){
        return t.removeFirst();
    }
    int front(){
        return t.getFirst();
    }
}
