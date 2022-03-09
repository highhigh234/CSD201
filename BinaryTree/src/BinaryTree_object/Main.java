package BinaryTree_object;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MyBSTree t = new MyBSTree();
        Student stu1 = new Student("HE163978", "Le Cao Khanh", 3);
        Student stu2 = new Student("HE163333", "Viet Hoang", 2);
        Student stu3 = new Student("HE133947", "Nguyen Van D",2 );
        t.readFromFile("input.txt");
//        t.insert(stu1);
//        t.insert(stu2);
//        t.insert(stu3);
//        t.preOrder(t.root);
//        t.delebycopy("HE133946");
//        System.out.println();
//        t.max();
//        t.min();
        
//        System.out.println(t.count());
//        System.out.println(t.sum());

//        t.preOrder(t.root);
//        t.search(t.root, st1);
        t.inOrder();
        t.saveToFile("output.txt");
    }
}
