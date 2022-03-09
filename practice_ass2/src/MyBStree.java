//

import java.io.*;
import java.util.LinkedList;
public class MyBStree {

    Node root;

    MyBStree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    public void readFromFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] tokens;
        String name;
        int age;
        while (true) {
            line = br.readLine();
            if (line == null || line.trim().equals("")) {
                break;
            }
            tokens = line.split("[|]");
            name = tokens[0];
            age = Integer.parseInt(tokens[1]);
            insert(name, age);
        }
        fr.close();
        br.close();
    }

    public void saveToFile(String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            PrintWriter pw = new PrintWriter(fw);
            if (root == null) {
                return;
            }
            Node current = root;
            while (current != null) {
                person x = current.info;
                if (current.left == null) {
                    pw.print("(" + x.name + "," + x.age + ")");
                    current = current.right;

                } else {
                    Node pre = current.left;
                    while (pre.right != null && pre.right != current) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = current;
                        current = current.left;
                    } else {
                        pre.right = null;
                        pw.print("(" + x.name + "," + x.age + ")");
                        current = current.right;
                    }
                }
            }
            pw.close();
        }
    }

    void writeFile(String data, String name) throws FileNotFoundException, IOException {
        File file = new File(name);
        OutputStream outputStream = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(data);
        outputStreamWriter.flush();
    }

    void insert(person x) {
        Node f, p;
        //bắt đầu với root
        p = root;
        //con trỏ chứa parent của node p 
        f = null;
        //tạo 1 node mới và set là root nếu như cây trống
        if (root == null) {
            root = new Node(x);
            return;
        }
        //traverse để tìm parent node của phần tử x
        while (p != null) {
            //update node parent sang node p 
            f = p;
            //nếu như info của node p = x thì không thêm vào trê
            if (p.info.name.equalsIgnoreCase(x.name)) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            //nếu như x có giá trị bé hơn node p 
            //đưa sang bên trái cây, nếu k thì đưa sang bên phải
            if (p.info.name.compareToIgnoreCase(x.name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //tạo 1 node mới với giá trị x và gắn nó vào vị trí thích hợp
        if (f.info.name.compareToIgnoreCase(x.name) > 0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
//1
    void insert(String xname, int xage) {
        if (xname.charAt(0) == 'B') {
            return;
        } else {
            person p = new person(xname, xage);
            insert(p);
        }
    }

    void visit2(Node p) {
        System.out.print("(" + p.info.name + "," + p.info.age + ")");
    }

    void preOrder(Node p) {
        //Root-Left-right
        if (p == null) {
            return;
        }
        visit2(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }

    void inOrder(Node p) {
        //Left-root-right
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit2(p);
        inOrder(p.right);
    }

    void inOrder() {
        inOrder(root);
    }
//2
    void postorder(Node p) throws IOException {
        //left-right-root
        if (p == null) {
            return;
        }
        postorder(p.left);
        postorder(p.right);
        if(p.info.age<=average()){
            writeFile("(" + p.info.name + "," + p.info.age + ")", "q2.txt");
            visit2(p);
        }
    }

    void postOrder() throws IOException {
        postorder(root);
    }

    void breadth2() throws IOException {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            writeFile("(" + p.info.name + "," + p.info.age + ")", "q2.out.txt");
        }
    }
    
    int sum() {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            sum += p.info.age;
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            
        }
        return sum;
    }
    
    double average() {
        int avg = 0;
        int sum = sum();
        int c = 0;
        if (root == null) {
            return avg;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        c++;
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
                c++;
            }
            if (p.right != null) {
                q.enqueue(p.right);
                c++;
            }
            
        }
        avg = sum / c;
        return avg;
    }
    
    void writetoFile() throws IOException {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if(p.info.age<average()){
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            writeFile("(" + p.info.name + "," + p.info.age + ")", "q2.out.txt");
            }
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info.name + " "+p.info.age);
        }
    }
//3
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);//use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }
//4
    int countNode(Node q) {
        if (q == null) {
            return 0;
        } else {
            return 1 + countNode(q.left) + countNode(q.right);
        }
    }
    
    int countNode() {
        return countNode(root);
    }

    void delebycopy(int xage) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.age == xage) {
                break;
            }
            parent = p;
            if (p.info.age >= xage) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        //p không có con/has no child
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            } else if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //p chỉ có con trái/has left-child
        if (p.left != null && p.right == null) {
            if (parent == null) {
                root = p.left;
            } else if (parent.left == p) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        }
        //p chỉ có con phải/has right-child
        if (p.left == null && p.right != null) {
            if (parent == null) {
                root = p.right;
            } else if (parent.left == p) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        }
        //p có 2 con/has both children
        if (p.left != null && p.right != null) {
            Node rm = p.left;
            Node parentRm = null;
            while (rm.right != null) {
                parentRm = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRm == null) {
                p.left = rm.left;
            } else {
                parentRm.right = rm.left;
            }
        }
    }

    public Node findParent(Node child) {
        Node p = root;
        LinkedList<Node> q = new LinkedList<>();

        if (p == null) {
            return null;
        }

        q.add(p);
        while (!q.isEmpty()) {
            p = q.remove();
            if (p.left != null) {
                if (p.left == child) {
                    return p;
                }
            }
            if (p.right != null) {
                if (p.right == child) {
                    return p;
                }
            }
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
        return null;
    }

    public void deletebycopying(Node p) {
        Node pn = findParent(p), n = p;
        n = p;
        if (p != null) {
            if (n.right == null) {
                n = n.left;
            } else if (n.left == null) {
                n = n.right;
            } else {
                Node t = n.left;
                Node pt = n;
                while (t.right != null) {
                    pt = t;
                    t = t.right;
                }
                n.info = t.info;
                if (pt == n) {
                    pt.left = t.left;
                } else {
                    pt.right = t.left;
                }
            }
            if (p == root) {
                root = n;
            } else if (pn.left == p) {
                pn.left = n;
            } else {
                pn.right = n;
            }
        } else {
            System.out.println("Tree is empty");
        }
    }
//6
    void breadth23(){
        Node q123 = null;
        int count = 0;
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p = null;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.info.age >=average()) {
                count++;
                if (count == 2) {
                    deletebycopying(p);
                    break;
                }
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    }
    
    void q3() throws IOException{
        breadth23();
        breadth2();
    }
//9
    public int BalanceFactor(Node t) {
        if (t == null) {
            return 0;
        }

        if (t.left == null && t.right == null) {
            return 1;
        }

        int heightL = BalanceFactor(t.left);
        int heightR = BalanceFactor(t.right);
        int balance = heightL - heightR;
        return balance + 1;
    }

    void balancefactorinbreadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            System.out.print("(" + p.info.name + "," + p.info.age + "," + BalanceFactor(p) + ")");
        }
    }
//10
    boolean isBalanced(Node node){
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */
        /* If tree is empty then return true */
        if (node == null)
            return true;
        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);
        if (Math.abs(lh - rh) <= 1&& isBalanced(node.left)&& isBalanced(node.right))
            return true;
        /* If we reach here then tree is not height-balanced */
        return false;
    }
//11
    int levelcalculate(Node p) {
        Node q = root;
        int level = 0;
        while (q != null) {
            level++;
            if (q.info.age == p.info.age) {
                break;
            }
            if (q.info.age < p.info.age) {
                q = q.right;
            } else {
                q = q.left;
            }
        }
        return level;
    }

    void levelinbreadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            System.out.print("(" + p.info.name + "," + p.info.age + "," + levelcalculate(p) + ")");
        }
    }
}
