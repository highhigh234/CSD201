
public class UsingMyStack {

    StackNode top;
    int size;

    public UsingMyStack() {
        top = null;
        size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    void clear() {
        top = null;
    }

    void push(int x) {
        StackNode p = new StackNode(x);
        if (isEmpty()) {
            top = p;
        } else {
            p.next = top;
            top = p;
        }
    }

    int pop()  {
        StackNode p = top;
        if (!isEmpty()) {
            top = top.next;
            return p.info;
        } else  
        return 0;
        
    }

    int top() {
        StackNode p = top;
        if(!isEmpty()){
            return p.info;
        }
        else
            return 0;
    }

    void traverse() {
        //node p trỏ đến đầu
        StackNode p = top;
        while (p != null) {
            //in các node ra 
            System.out.print(p.info + " ");
            //node p trỏ đến node tiếp theo
            p = p.next;
        }
        System.out.println();
    }
    
    void DectoBin(int x){
        StackNode p;
        while(x>0){
            push(x%2);
            x= x/2;
        }
        while(!isEmpty()){
            System.out.print(pop());
            System.out.println();
        }
    }
    
     
}
