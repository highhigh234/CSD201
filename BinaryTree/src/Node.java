
public class Node {

    int info;
    //info chứa 1 đối tượng: Person, Student, ...
    //mỗi đối tượng có 1 thuộc tính
    //có 1 thuộc tính làm key, ví dụ như id được chọn làm key
    //các đối tượng trong cây luôn có id khác nhau
    Node left, right;

    Node(int x){
        info = x;
        left = right = null;
    }
    /*
        info
    null    null
    */

    @Override
    public String toString() {
        return super.toString(); 
    }

    
}
