
public class Main {

    /*
            25
        10      30
    5      20
         15
     */
    public static void main(String[] args) {
        MyBSTree t = new MyBSTree();
        int[] a = {25, 10, 30, 5, 20, 10, 15};
        t.addMany(a);
//        t.insert_nonrecursive(18);
//        t.preOrder();
//        t.postOrder();
//        t.inOrder();        
//        t.preOrder(t.root);
//        t.breadth();
//        t.delebycopy(t.root.info);
//        t.inOrder(t.root);
//        t.postorder(t.root);
//        if(t.search(t.root,25)!=null)
//            System.out.println("Found");
//        System.out.println(t.max());
//        System.out.println(t.min());
//        t.clear();
//        t.delebycopy(25);
//        System.out.println(t.count());
//        System.out.println(t.sum());
//        System.out.println();
//        System.out.println(t.height());
//        System.out.println(t.height2(t.root));
//        t.balance();
//        System.out.println(t.count());
//        t.rotateLeft(t.root.left);
//        t.preOrder();
//        System.out.println();
//        System.out.println(t.height2(t.root.left.left));
//        System.out.println(t.height2(t.root.left.left.left));
//        System.out.println(t.height(t.root.left));
//        t.delebycopy(25);
//        t.preOrder();
        t.breadth2();
    }

}
