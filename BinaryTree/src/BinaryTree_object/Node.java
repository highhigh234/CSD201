package BinaryTree_object;

public class Node {

    Student info;
    //info chứa 1 đối tượng: Person, Student, ...
    //mỗi đối tượng có 1 thuộc tính
    //có 1 thuộc tính làm key, ví dụ như id được chọn làm key
    //các đối tượng trong cây luôn có id khác nhau
    Node left, right;

    Node(Student x){
        info = new Student(x.id,x.name,x.GPA);
        left = right = null;
    }
    /*
        info
    null    null
    */
    
    
}
