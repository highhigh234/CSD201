
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {


    public static void main(String[] args) {
        UsingMyQueue Queue = new UsingMyQueue();
        Queue.enqueue(9);
        Queue.enqueue(5);
        Queue.enqueue(10);
        Queue.enqueue(8);
        Queue.enqueue(34);
        Queue.traverse();
//        Queue.dequeue();
//        System.out.println(Queue.dequeue());
//        Queue.traverse();
        while (!Queue.isEmpty()) {            
            System.out.println(Queue.dequeue());
        }
        

    }
    
}
