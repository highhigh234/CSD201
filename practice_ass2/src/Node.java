

public class Node {

    person info;
    //info chứa 1 đối tượng: Person, Student, ...
    //mỗi đối tượng có 1 thuộc tính
    //có 1 thuộc tính làm key, ví dụ như id được chọn làm key
    //các đối tượng trong cây luôn có id khác nhau
    Node left;
    Node right;

    Node(person x){
        info = new person(x.name,x.age);
        left = right = null;
    }
    /*
        info
    null    null
    */
    
    
}
