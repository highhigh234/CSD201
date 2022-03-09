
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    public void readFromFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] tokens;
        String name;
        int age;
        while (true) {
            line = br.readLine();
            if (line == null || line.trim().length() < 3) {
                break;
            }
            tokens = line.split("[|]");
            name = tokens[0];
            age = Integer.parseInt(tokens[1]);
            addLast2(name, age);
        }
        fr.close();
        br.close();
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        Node current = head;
        while (current != null) {
            Person x = current.info;
            pw.println(x.name + "|" + x.age);
            current = current.next;

        }

        pw.close();
        fw.close();
    }

    public MyList() {
        head = tail = null;
        size = 0;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Person x) {
        Node p = new Node(x);
        if (tail == null) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }
//1
    void addLast2(String xName, int xage) {
        if (xName.charAt(0) == 'B' || xage < 17) {
            return;
        } else {
            if (isEmpty()) {
                Person x = new Person(xName, xage);
                Node x1 = new Node(x);
                head = tail = x1;
            } else {
                Person x = new Person(xName, xage);
                Node x1 = new Node(x);
                tail.next = x1;
                tail = x1;
            }
        }
    }

    void addLast(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            tail = p;
            head = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void addAfter(Node p, Person x) {
        Node q = new Node(x);
        if (p == null) {
        } else {
            q.next = p.next;
            p.next = q;
        }
    }
//9
    void add_position(String xname, int xage, int k) {
        Node p = head;
        int count = 0;
        if (k == 0) {
            addFirst(new Person(xname, xage));
            return;
        }
        while (p != null) {
            count++;
            if (count == k) {
                Node q = new Node(new Person(xname, xage));
                q.next = p.next;
                p.next = q;
            }
            p = p.next;
        }
        if (tail.next != null) {
            tail = tail.next;
        }
    }
    
    void add_position(Person x, int k) {
        Node p = head;
        int count = 0;
        if (k == 0) {
            addFirst(x);
            return;
        }
        while (p != null) {
            count++;
            if (count == k) {
                Node q = new Node(x);
                q.next = p.next;
                p.next = q;
            }
            p = p.next;
        }
        if (tail.next != null) {
            tail = tail.next;
        }
    }
    

    void traverse() {
        //node p trỏ đến đầu
        Node p = head;
        while (p != null) {
            //in các node ra 
            System.out.print(p.info + " ");
            //node p trỏ đến node tiếp theo
            p = p.next;
        }
        System.out.println();
    }
//3
    void traverse2() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node p = head;
        int count = 0;
        while (p != null && count != 5) {
            if (p.info.age > 22) {
                System.out.print(p.info);
                count++;
            }
            p = p.next;
        }
        System.out.println();
    }
//7.1
    void traverse3() {
        Node p = head;
        while (p != null) {
            p = p.next;
        }
        reverse();
        traverse2();
        reverse();
    }
//7.2              
void traverse4(){
        Node p = head;
        int count = 1;
        int pos = count() - 5;
        while(p.next != null){
            if(count >= pos){
                if(p.info.age>22){
                System.out.print(p.info);
                }
            }
            p = p.next;
            count++;
        }
    }

    Person deleteFromHead() {
        Node p = head;
        if (p == null) {
            return null;
        } else {
            head = head.next;
            return p.info;
        }
    }

    Person deleteFromTail() {
        //node p vị trí đầu tiên
        Node p = head;
        if (p == null) {
            return null;
        } else {
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
            return tail.info;
        }
    }

    Person deleteAfter(Node p) {
        Person q = null;
        if (p == null) {
        } else {
            if (p.next != null) {
                q = p.next.info;
                p.next = p.next.next;
            }
        }
        return q;
    }

    void delefirstnode(Person x) {
        Node p = head;
        Node q = null;
        if (p == null) {
        } else {
            while (p != null && p.info.age == x.age) {
                q = p;
                p = p.next;
            }
            if (p == head) {
                deleteFromHead();
            } else {
                if (tail == null) {
                    p.next = q.next;
                }
            }
        }
    }

    void removePos(int k) {
        Node q = pos(k);
        dele(q);
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    Node search(Person x) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(x.name) && p.info.age == x.age) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    int count() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    void deleithnode(int i) {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        int index = 1;
        while (p != null) {
            if (i == index) {
                dele(p);
                break;
            }
            index++;
            p = p.next;
        }
    }
//5
    void sort() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.age > pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
//10
    void sortbyAge(int k, int h) {
        int n = count();
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        if (h > n - 1) {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h + 1);
        Node pi, pj;
        Person x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    void dele(Node p) {
        if (p == null) {
            return;
        }
        Node c = head;
        Node prev = null;
        while (c != null && c != p) {
            prev = c;
            c = c.next;
        }
        if (prev == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            prev.next = p.next;
            if (p == tail) {
                tail = prev;
            }
        }
        p.next = null;
    }
//2
    void delewithcondition() {
        Node p = head;
        while (p != null) {
            if (p.info.age == 20) {
                dele(p);
                break;
            }
            p = p.next;
        }
    }
//6.1
    void delewithcondition2() {
//        Node p = head;
//        while (p != null) {
//            p = p.next;
//        }
        reverse();
        delewithcondition();
        reverse();
    }

    int[] toArray() {
        Node p = head;
        if (p == null) {
            return null;
        } else {
            int arr[] = new int[count()];
            int index = 0;
            while (p != null) {
                arr[index] = p.info.age;
                index++;
                p = p.next;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            return arr;
        }
    }
    
     Person[] toArrayP() {
        int n, i;
        n = size();
        Person[] persons = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            persons[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return (persons);
    }
    void addBefore(Node p, Person x) {
        if (p == null) {
            return;
        }
        if (isEmpty()) {
            return;
        }
        Node f, h;
        f = null;
        h = head;
        while (h != null) {
            if (h == p) {
                break;
            }
            f = h;
            h = h.next;
        }
        if (h == null) {
            return;
        }
        if (f == null) {
            addFirst(x);
            return;
        }
        Node q = new Node(x);
        q.next = p;
        f.next = q;
    }

    void attach(MyList list2) {
        if (isEmpty()) {
            head = list2.head;
            tail = list2.tail;
        } else {
            tail.next = list2.head;
            tail = list2.tail;
        }
    }

    int max() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int max = head.info.age;
            while (p != null) {
                if (p.info.age > max) {
                    max = p.info.age;
//                    System.out.println(p.info);
                }
                p = p.next;
            }
            return max;
        }
    }
//4
    int max1() {
        Node p = head;
        int max = 0;
        if (isEmpty()) {
            return 0;
        }
        while (p != null) {
            if (max < p.info.age) {
                max = p.info.age;
            }
            p = p.next;
        }
        return max;
    }

    int max2() {
        Node p = head;
        int max = max1();
        int max2 = 0;
        if (isEmpty()) {
            return 0;
        }
        while (p != null) {
            if (max2 < p.info.age && p.info.age < max) {
                max2 = p.info.age;
            }
            p = p.next;
        }
        return max2;
    }

    int max3() {
        Node p = head;
        int max2 = max2();
        int max3 = 0;
        if (isEmpty()) {
            return 0;
        }
        while (p != null) {
            if (max3 < p.info.age && p.info.age < max2) {
                max3 = p.info.age;
            }
            p = p.next;
        }
        return max3;
    }

    void display() {
        Node q = head;
        while (q != null) {
            if (q.info.age < max2()) {
                System.out.println(q.info);
            }
            q = q.next;
        }
    }

    int min() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int min = head.info.age;
            while (p != null) {
                if (p.info.age < min) {
                    min = p.info.age;
                }
                p = p.next;
            }
            return min;
        }
    }

    int sum() {
        Node p = head;
        int sum = 0;
        while (p != null) {
            sum += p.info.age;
            p = p.next;
        }
        return sum;
    }

    int avg() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int sum = 0, count = 0, avg = 0;
            while (p != null) {
                sum += p.info.age;
                count++;
                p = p.next;
            }
            return avg = sum / count;
        }
    }

    boolean sorted() {
        int length = count();
        Node a = head;
        if (a == null) {
            return false;
        } else {
            Node b = head.next;
            for (int i = 0; i < length - 1; i++) {
                if (a.info.age < b.info.age) {
                    return true;
                }
            }
            return false;
        }
    }

    void sortedInsert(Person x) {
        Node p = new Node(x);
        Node prev = null;
        Node curr = head;
        while (curr != null && x.age > curr.info.age) {
            prev = curr;
            curr = curr.next;
        }
        p.next = curr;
        if (prev == null) {
            head = p;
        } else {
            prev.next = p;
        }
    }

    void reverse() {
        Node curr = head;
        Node prev = null, after = null;
        while (curr != null) {
            after = curr;
            curr = curr.next;
            after.next = prev;
            prev = after;
            head = after;
        }
    }

       int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return (count);
    }
       
void reverse(int k, int h) // reverse from k to h 
     {if(k>h) return;
      int n=size();int i,j;
      if(k<0 || h>n-1) return;
      Person [] a = toArrayP();
      i=k;
      j=h;Person x;
      while(i<j) {
        x=a[i];a[i]=a[j];a[j]=x;
        i++; j--;
      }
     clear();
     //in bao nhiêu phần tử thì thay đổi n = bấy nhiêu
     for(i=0;i<n;i++) addLast(a[i]);
    }
    
    
    void deleby(int x) {
        Node q = null;
        Node p = head;
        if (p == null) ; else {
            while (p.next != null) {
                if (p.info.age == x) {
                    dele(p);
                    break;
                }
                q = p;
                p = p.next;
            }
        }
    }

}


/*
csd201 fa21

Q1
f1 
addLast(String xForest, int xRate, int xSound), check xForest.charAt(0)=='B' then do nothing,
otherwisw add new node with forest = xForest, rate = xRate, sound = xSound to the end of list
output =  (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7) 
f2
there are 2 given Bee object x,y. add 2 elements into the list so that x will be second node, 
y will be 3rd node
output =     (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9) 
             (C,9,8) (X,1,2) (Y,3,4) (D,6,3) (E,8,5) (F,5,4) (I,4,9)  

f3
delete the first and the third elements of the original list
output =   (C,8,6) (D,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3) 
           (D,3,5) (F,5,8) (G,9,7) (H,6,8) (I,7,3) 

f4
sort the first 4 element ascendingly by rate
output = (C,7,11) (D,10,7) (E,6,5) (F,5,6) (I,4,4) (J,3,2) (K,2,1) 
         (F,5,6) (E,6,5) (C,7,11) (D,10,7) (I,4,4) (J,3,2) (K,2,1) 


Q2
f1
insert insert(String xForest, int xRate, int xSound) check xForest.charAt(0)=='B' then do nothing,
otherwise add new node with forest = xForest, rate = xRate, sound = xSound to the tree
output =   (A,7,9) (C,4,3) (D,8,6) (E,2,5) (F,6,7) 
           (E,2,5) (C,4,3) (F,6,7) (A,7,9) (D,8,6)

f2
perform pre-order traverse but display nodes with sound < 6
output =   (C,3,6) (E,2,8) (D,7,2) (F,4,5) (H,6,3) (I,5,4) (G,8,7) 
           (D,7,2) (F,4,5) (H,6,3) (I,5,4) 

f3
suppose p is the 4-th elements when performing pre-order traversal. dele p by copying
output =   (C,5,2) (D,2,1) (F,1,3) (G,4,6) (H,3,4) (E,6,5) 
           (C,5,2) (D,2,1) (F,1,3) (H,3,4) (E,6,5) 

f4
suppose p is the 4-th elements when performing pre-order traversal. check if p has left son then
rotate it to the right about its'left son
output =   (C,5,2) (D,2,1) (F,1,3) (G,4,6) (H,3,4) (E,6,5) 
           (C,5,2) (D,2,1) (F,1,3) (H,3,4) (G,4,6) (E,6,5)

*/
