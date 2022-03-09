
public class UsingMyQueue {

    QueueNode head, tail;
    int size;

    public UsingMyQueue() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(int x) {
        QueueNode p = new QueueNode(x);
        if (isEmpty()) {
            tail = p;
            head = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    int dequeue() {
        QueueNode p = head;
        if (!isEmpty()) {
            head = head.next;
            return p.info;
        } else {
           return 0;
        }
    }
    int first(){
        QueueNode p = head;
        if(!isEmpty()){
            return p.info;
        }
        else
            return 0;
    }
    void traverse() {
        //node p trỏ đến đầu
        QueueNode p = head;
        while (p != null) {
            //in các node ra 
            System.out.print(p.info + " ");
            //node p trỏ đến node tiếp theo
            p = p.next;
        }
        System.out.println();
    }
    void clear(){
        head = tail = null;
    }
}
