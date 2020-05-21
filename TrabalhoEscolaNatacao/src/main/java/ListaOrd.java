
public class ListaOrd<E extends Comparable<E>>{
      private Node head; //início da Lista Ordenada

    //Cria uma Lista no estado vazia (construtor)
    public ListaOrd() {
        head = null;
    }

    //Verifica se a lista está vazia
    public boolean isEmpty() {
        return (head == null);
    }

    //Insere um elemento na Lista Ordenada
    public <E extends Comparable<E>> E insert(E x) {
        if(x==null)return null;
        try {
            Node novo = new Node();
            Node aux;
            novo.setValue(x);
            //Se a lista estiver vazia ou o elemento for menor que o primeiro
            if (isEmpty() || x.compareTo((E) head.getValue()) < 0) {
                novo.setNext(head);
                head = novo;
            } else {
                aux = head;
                while (aux.getNext() != null && x.compareTo((E) aux.getNext().getValue()) > 0) {
                    aux = aux.getNext();
                }
                novo.setNext(aux.getNext());
                aux.setNext(novo);
            }
        } catch (Exception ex) { //se memória insuficiente
            return null;
        }
        return x;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            Node aux;
            aux = head;
            String saida = "";
            while (aux != null) {
                saida += aux.getValue().toString() + "\n";
                aux = aux.getNext();
                if (aux != null) {
                    saida += ", ";
                }
            }
            return "ListaOrd: [\n" + saida + "]";
        } else {
            return "ListaOrd: []";
        }
    }
    
      //Busca por um elemento na lista e retorna o nó onde encontrou
    public <E extends Comparable<E>> Node find(E x) {
        Node aux = head;

        //Navega até o nó de interesse
        while (aux != null && x.compareTo((E) aux.getValue()) > 0) {
            aux = aux.getNext();
        }
        //Se achou o elemento
        if (aux != null && x.compareTo((E) aux.getValue()) == 0) {
            return aux;
        } else {
            return null;
        }
    } 
}
