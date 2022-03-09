
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        MyBStree t = new MyBStree();
        String input = "input.txt";
        String output1 = "output1.txt";
        String output2 = "output2.txt";
        t.readFromFile(input);
        person p = new person("X", 10);
        t.insert(p);
//        t.preOrder();
//        t.postOrder();
//        System.out.println(t.height(t.root));
//        System.out.println(t.countNode());
//        t.breadth23();
//        t.balancefactorinbreadth();
        t.levelinbreadth();
        System.out.println();
        t.levelinbreadth();
        
    }

}
