
public interface TAD_Queue {
    public Object enqueue(Object x);
    public Object dequeue();
    public Object peek();
    public boolean isEmpty();
    @Override
    public String toString();
}
