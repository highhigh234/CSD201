
import java.util.ArrayList;
import java.util.LinkedList;

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
    
    void addMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            insert_nonrecursive(a[i]);
        }
    }
    
    void insert_nonrecursive(int x) {
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
//            if (p.info == x) {
//                System.out.println("The key " + x + " already exists, no insertion");
//                return;
//            }
            //nếu như x có giá trị bé hơn node p 
            //đưa sang bên trái cây, nếu k thì đưa sang bên phải
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //tạo 1 node mới với giá trị x và gắn nó vào vị trí thích hợp
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
    
    void visit(Node p) {
        System.out.println(p.info + " ");
    }
    
    void preOrder(Node p) {
        //Root-Left-right
        if (p == null) {
            return;
        }
        if (p.info >= 10 && p.info <= 30) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
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
    
    Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return (p);
        }
        if (x < p.info) {
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
        System.out.println(p.info);
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
        System.out.println(p.info);
        return p;
    }
    
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

//    int count() {
//        int c = 0;
//        if (root == null) {
//            return c;
//        }
//        MyQueue q = new MyQueue();
//        q.enqueue(root);
//        c++;
//        Node p;
//        while (!q.isEmpty()) {
//            p = (Node) q.dequeue();
//            if (p.left != null) {
//                c++;
//                q.enqueue(p.left);
//            }
//            if (p.right != null) {
//                c++;
//                q.enqueue(p.right);
//            }
//
//        }
//        return c;
//    }
    void delebycopy(int x) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            parent = p;
            if (p.info > x) {
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
    public Node findParent(Node child){
      Node p = root;
      LinkedList<Node> q = new LinkedList<>();
      
      if(p == null)
          return null;
      
      q.add(p);
      while(!q.isEmpty()){
          p = q.remove();
          if(p.left != null){
              if(p.left == child)
                  return p;
          }
          if(p.right != null){
              if(p.right == child){
                  return p;
              }
          }
          if(p.left != null){
              q.add(p.left);
          }
          if(p.right != null){
              q.add(p.right);
          }
      }
      return null;   
  }
    public void deletebycopying(Node p){
      Node pn = findParent(p), n = p;
      n = p;
      if(p != null){
          if(n.right == null){
              n = n.left;
          }
          else if(n.left == null){
              n = n.right;
          }
          else{
              Node t = n.left;
              Node pt = n;
              while(t.right != null){
                  pt = t;
                  t = t.right;
              }
              n.info = t.info;
              if(pt == n){
                  pt.left = t.left;
              }
              else{
                  pt.right = t.left;
              }
          }
          if(p==root){
              root = n;
          }
          else if(pn.left == p){
              pn.left = n;
          }
          else{
              pn.right = n;
          }
      }
      else{
          System.out.println("Tree is empty");
      }
  }
    
    void breadth2() {
        int count = 0;
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p = null;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.info != 10) {
                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
            }
            if(p.info==20){
                count++;
                if(count==2){
                    deletebycopying(p);
                }
            }
            
            visit(p);
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
            sum += p.info;
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
    
    int height() {
        int height = 0;
        if (root == null) {
            return height;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        height++;
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                height++;
                q.enqueue(p.left);
            }
            if (p.right != null) {
                height++;
                q.enqueue(p.right);
            }
        }
        height = (int) Math.ceil(Math.log(height)) + 1;
        return height;
    }
    
    int height2(Node p) {
        int height = 0;
        if (root == null) {
            return height;
        }
        if (p == root) {
            return 0;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        height++;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                height++;
                q.enqueue(p.left);
            }
            if (p.right != null) {
                height++;
                q.enqueue(p.right);
            }
        }
        height = (int) Math.ceil(Math.log(height)) + 1;
        return height;
    }
    
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
    
    void nodewithheight(Node p) {
        if (p == null) {
            return;
        }
        nodewithheight(p.left);
        System.out.println("" + p.info + " " + height2(p));
        nodewithheight(p.right);
    }
    
    void nodewithheight() {
        nodewithheight(root);
    }
    
    public Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            System.out.println("Can't not rotate left");
            return p;
        }
        Node p1 = p.right;
        p.right = p1.left;
        p1.left = p;
        return p1;
    }
    
    public Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            System.out.println("Can't not rotate right");
            return p;
        }
        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        return p1;
    }
    
}
