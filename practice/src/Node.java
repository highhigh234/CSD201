/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Node {
    Person info;
    Node next;

    Node (Person x){
        info = new Person(x.name,x.age);
        next = null;
    }
    
}
