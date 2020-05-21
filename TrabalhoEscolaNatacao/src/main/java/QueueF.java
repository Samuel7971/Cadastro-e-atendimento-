
public class QueueF implements TAD_Queue{
     private Node head = null;
    private Node tail = null;
    
    public QueueF(){
        head = null;
        tail = null;
    }
    
     @Override
    public Object peek(){
        if(head == null)
            return null;
        else
            return head.getValue();
    }
    
     @Override
    public Object enqueue(Object x){
        if(x == null) return null;
        try {
            Node novo = new Node();
            novo.setValue(x);
            novo.setNext(null);
            if(tail == null){
                head = novo;
                tail = novo;
            }
            else{
                tail.setNext(novo);
                tail = novo;
            }
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public Object dequeue(){
        if(head == null) return null;
        Object obj = head.getValue();
        head = head.getNext();
        if(head == null)
            tail = null;
        return obj;
    }
    
     @Override
    public boolean isEmpty(){
        return head == null;
    }
    
    @Override
    public String toString(){
        if(!isEmpty()){
            String str = "";
            Node aux = head;
            while(aux != null){
                str += aux.getValue().toString() + "\n";
                aux = aux.getNext();
            }
            return ("Fila Fem: [\n" + str + "\n]");
        }
        else return ("Fila Fem: []");
    }
}
