
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        MyList t = new MyList();
        String fname = "Person.txt";
        String fnameRep = "Person_output.txt";
        t.readFromFile(fname);
//        t.traverse();
//        t.addLast(p);
//        t.addLast(p2);
//        t.traverse();
//        t.addAfter(t.tail, );
//        System.out.println();
//        t.deleithnode(3);
//        t.deleteFromHead();
//        t.deleteFromTail();
//        t.deleteAfter(t.head);
//        System.out.println(t.search(p2));
//        System.out.println(t.search(p2).info);
//        System.out.println(t.count());
//        System.out.println(t.count());
//        t.deleithnode(2);
//        t.traverse();
//        t.deleithnode(1);
//        t.traverse();
//        t.dele(t.head);
//        t.toArray();
//        t.addBefore(t.head, p2);
//        System.out.println(t.max());
//        t.max();
//        System.out.println(t.min());
//        System.out.println(t.sum());
//        System.out.println(t.avg());
//        if(t.sorted()) {
//            System.out.println("True");
//        }
//        else
//            System.out.println("False");
//        t.reverse();
//        t.sortedInsert(p2);
//        t.traverse();
//        t.delefirstnode(p2);
//        t.deleby(18);
//        t.sort();
//        t.add_position("Khanh", 19, 10);
//        t.traverse();
//        t.delewithcondition();
//        t.delewithcondition2();
//        t.traverse();
//        t.reverse();
//        t.traverse();
//        t.traverse2();
//        t.traverse3();
//        t.reverse();
//        t.traverse();
//        t.sortbyAge(0,3);
        t.traverse();
        System.out.println();
//        System.out.println();
        t.reverse(1, 3);
        t.traverse();
//        t.traverse4();
//        System.out.println(t.max3());
//        System.out.println(t.pos(3).info);
//        System.out.println(t.max3());
        t.saveToFile(fnameRep);
        System.out.println();
    }
}
