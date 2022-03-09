package BinaryTree_object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyBSTree {

    Node root;

    MyBSTree() {
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
        String id, name;
        int GPA;
        while (true) {
            line = br.readLine();
            if (line == null || line.trim().equals("")) {
                break;
            }
            tokens = line.split("[|]");
            id = tokens[0];
            name = tokens[1];
            GPA = Integer.parseInt(tokens[2]);
            insert(new Student(id, name, GPA));
        }
        fr.close();
        br.close();
    }

    public void saveToFile(String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            PrintWriter pw = new PrintWriter(fw);
            Node current = root;
            
            while (current != null) {
                Student x = current.info;
                pw.println(x.id + "|" + x.name + "|" + x.GPA);
                current = current.left;
            }
//            if (root == null) {
//                return;
//            }
//            MyQueue q = new MyQueue();
//            q.enqueue(root);
//            Node p;
//            while (!q.isEmpty()) {
//                p = (Node) q.dequeue();
//                if (p.left != null) {
//                    q.enqueue(p.left);
//                }
//                if (p.right != null) {
//                    q.enqueue(p.right);
//                }
//                Student x = p.info;
//                pw.println(x.id + "|" + x.name + "|" + x.GPA);
//            }

            pw.close();
            fw.close();
        }
    }

    void insert(Student x) {
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
            if (p.info.id.equalsIgnoreCase(x.id)) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            //nếu như x có giá trị bé hơn node p 
            //đưa sang bên trái cây, nếu k thì đưa sang bên phải
            if (p.info.id.compareToIgnoreCase(x.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //tạo 1 node mới với giá trị x và gắn nó vào vị trí thích hợp
        if (f.info.id.compareToIgnoreCase(x.id) > 0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insertall(String[] id, String[] name, int[] GPA) {
        for (int i = 0; i < id.length; i++) {
            insert(new Student(id[i], name[i], GPA[i]));

        }
    }

    void visit(Node p) {
        System.out.println(p.info.id + " " + p.info.name + " " + p.info.GPA);
    }

    void preOrder(Node p) {
        //Root-Left-right
        if (p == null) {
            return;
        }
        visit(p);
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
        visit(p);
        inOrder(p.right);
    }

    void inOrder() {
        inOrder(root);
    }

    void postorder(Node p) {
        //left-right-root
        if (p == null) {
            return;
        }
        postorder(p.left);
        postorder(p.right);
        visit(p);
    }

    void postOrder() {
        postorder(root);
    }

    Node search(Node p, Student x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return (p);
        }
        if (p.info.id.compareToIgnoreCase(x.id) > 0) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    Node max() {
        Node p = root;
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        visit(p);
        return p;
    }

    Node min() {
        Node p = root;
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        visit(p);
        return p;
    }

    int count() {
        int c = 0;
        if (root == null) {
            return c;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        c++;
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                c++;
                q.enqueue(p.left);
            }
            if (p.right != null) {
                c++;
                q.enqueue(p.right);
            }

        }
        return c;
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
            sum += p.info.GPA;
            if (p.left != null) {
                q.enqueue(p.left);

            }
            if (p.right != null) {
                q.enqueue(p.right);
            }

        }
        return sum;
    }

    int average() {
        int avg = 0;
        int sum = 0;
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
            sum += p.info.GPA;
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

    void delebycopy(String xid) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.id.compareToIgnoreCase(xid) == 0) {
                break;
            }
            parent = p;
            if (p.info.id.compareToIgnoreCase(xid) > 0) {
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

    void breadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p = null;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            visit(p);
        }
    }
    
}
