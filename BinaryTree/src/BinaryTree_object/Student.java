/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree_object;


public class Student {
    String id; //key, với bài tập kiểm tra phải xác định 
               //key là gì
    String name;
    int GPA;

    public Student(String id, String name, int GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGPA() {
        return GPA;
    }
    
    
}
