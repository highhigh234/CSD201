
public class UsingMyList {

    Node head, tail;
    int size;

    public UsingMyList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }
//1.void addToHead(int x) - add a node with value x  at the head of  a list.

    void addFirst(int x) {
        Node p = new Node(x);
        if (head == tail) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }
//2.void addToTail(int x) - add a node with value x  at the tail of  a list.

    void addLast(int x) {
        Node p = new Node(x);
        if (tail == null) {
            tail = p;
            head = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

//3.void addAfter(Node p, int x) - add a node with value x  after the node p.
    void addAfter(Node p, int x) {
        Node q = new Node(x);
        if (p == null) {
        } else {
            q.next = p.next;
            p.next = q;
        }

    }

//4.void traverse() - traverse from head to tail and dislay info of all nodes in the list.    
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

//5.int deleteFromHead() - delete the head and return its info.
    int deleteFromHead() {

        Node p = head;
        if (p == null) {
            return 0;
        } else {
            head = head.next;
            return p.info;
        }
    }

//6.int deleteFromTail() - delete the tail and return its info.
    int deleteFromTail() {
        //node p vị trí đầu tiên
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
            return tail.info;
        }
    }

//7.int deleteAter(Node p) - delete the node after the node  p  and return its info.
    int deleteAfter(Node p) {
        int i = 0;
        if (p == null) {
            return 0;
        } else {
            if (p.next != null) {
                i = p.next.info;
//            Node q = p.next;
//            q = null;
                p.next = p.next.next;
            }
            return i;
        }
    }

//8.void dele(int x) - delele the first node whose info is equal to  x.
    void delefirstnode(int x) {
        Node p = head;
        Node q = null;
        if (p == null) {
        } else {
            while (p != null && p.info != x) {
                q = p;
                p = p.next;
            }
            if (p == head) {
                deleteFromHead();
            } else {
                if (p != null) {
                    q.next = p.next;
                }
            }
        }
    }

//9.Node search(int x) - search and return the reference to the first node having info x.
    Node search(int x) {
        Node p = head;
        while (p != null && p.info != x) {
            p = p.next;
        }
        return p;
    }

//10.int count() - count and return number of nodes in the list. 
    int count() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

//11.void dele(int i) - delete an i-th node on the list. Besure that such a node exists.
    void deleithnode(int i) {
        Node p = head;
        int length = count();
        int index = 1;
        if (i <= length) {
            while (p != null) {
                index++;
                p = p.next;
                if (i == index) {
                    dele(p);
                    break;
                }
            }
        } else {
        }
    }
//12. void sort() - sort the list by ascending order of info.

    void sort() {
        Node p = head;
        //node p sẽ đến đầu 
        Node q; //node q dùng để so sánh 2 
        int temp;// node với nhau
        while (p != null) {
            // node p sẽ đến node 
            //tiếp theo trong list 
            q = p.next;
            while (q != null) {
                if (p.info > q.info) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
//13.void dele(Node p) - delete node p if it exists in the list.

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
//14.int [] toArray() - create and return array containing info of all nodes in the list.

    int[] toArray() {
        Node p = head;
        //tìm độ dài của linkedlist = kích thước của mảng
        if (p == null) {
            return null;
        } else {
            int length = count();
            //khởi tạo mảng với độ dài của linkedlist
            int arr[] = new int[length];
            //bắt đầu với vị trí đầu tiên trong mảng
            int index = 0;
            //cho chạy từ đầu đến cuối linkedlist và 
            //thêm từng phần tử 1 vào trong mảng
            while (p != null) {
                arr[index] = p.info;
                index++;
                p = p.next;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            return arr;
        }
    }
//15.Merge two ordered singly linked lists of integers into one ordered list.
//16.void addBefore(Node p, int x) - add a node with value x before the node p.
    void addBefore(Node p, int x) {
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
//17.Attach a singly linked list to the end of another singly linked list.

    void attach(UsingMyList list2) {
        if (isEmpty()) {
            head = list2.head;
            tail = list2.tail;
        } else {
            tail.next = list2.head;
            tail = list2.tail;
        }
    }

//18.int max() - find and return the maximum value in the list. 
    int max() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int max = head.info;
            while (p != null) {
                if (p.info > max) {
                    max = p.info;
                }
                p = p.next;
            }
            return max;
        }
    }
//19.int min() - find and return the minimum value in the list. 

    int min() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int min = head.info;
            while (p != null) {
                if (p.info < min) {
                    min = p.info;
                }
                p = p.next;
            }
            return min;
        }
    }

//20.int sum() - return the sum of all values in the list. 
    int sum() {
        Node p = head;
        int sum = 0;
        while (p != null) {
            sum += p.info;
            p = p.next;
        }
        return sum;
    }
//21.int avg() - return the average of all values in the list.

    int avg() {
        Node p = head;
        if (p == null) {
            return 0;
        } else {
            int sum = sum(), count = 0, avg = 0;
            while (p != null) {
                count++;
                p = p.next;
            }
            return avg = sum / count;
        }
    }
//22.boolean sorted() - check and return true if the list is sorted, return false if the list is not sorted.

    boolean sorted() {
        int length = count();
        Node a = head;
        if (a == null) {
            return false;
        } else {
            Node b = head.next;
            for (int i = 0; i < length - 1; i++) {
                if (a.info < b.info) {
//                System.out.println("TRUE");
                    return true;
                }
            }
//        System.out.println("FALSE");
            return false;
        }

    }
//23.void insert(int x) - insert node with value x into sorted list so that the new list is sorted
    void sortedInsert(int x) {
        Node newNode = new Node(x);
        Node previous = null;
        Node current = head;

        while (current != null && x < current.info) {
            previous = current;
            current = current.next;
        }
        newNode.next = current;
        if (previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
    }
//24.Reverse a singly linked list using only one pass through the list.

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
    
    
}
