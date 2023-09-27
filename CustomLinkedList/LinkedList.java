package CustomLinkedList;

class Node<T> {
    T item;
    Node<T> next;

    public Node() {
        item = null;
        next = null;
    }

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    // public String toString() {
    // return item.toString();
    // }
}

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = new Node<T>();
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * This method returns an object provided the index.
     * NOTE: it can support negative by applying the modulus operator to the index
     * (if you want but you need to change the code).
     * 
     * @param index an integer that describes the item in an indexed list
     *              that you would like to extract and get the value of.
     * @return the object found by the index.
     * @throws Exception
     */
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Dude, watch your index, you can do better than that. My code is bullet proof.");
        }

        index = Math.floorMod(index, size); // Not needed anymore
        int counter = -1;
        Node<T> n = head;

        do {
            counter++;
            n = n.next;
            if (counter == index) {
                return n.item;
            }
        } while (counter != index);

        return null;
    }

    // Add the end of the list
    public void add(T obj) {
        // Verify if we already have an item in the list
        if (size == 0 /* head.next == null */) {
            Node<T> n = new Node<>(obj);
            head.next = n;
        } else { // Add the item if we already have stuff in the list
            Node<T> curr = head; // i = 0;
            while (curr.next != null) { // i != length() - 1
                curr = curr.next; // i++;
            }
            // for (; curr.next != null; curr = curr.next){}

            Node<T> n = new Node<>(obj);
            curr.next = n;
        }
        size++;
    }

    public T replace(int index, T obj) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Dude, watch your index, you can do better than that. My code is bullet proof.");
        }
        // index = Math.floorMod(index, size); // Not needed anymore
        int counter = -1;
        Node<T> n = head;

        do {
            counter++;
            n = n.next;
            if (counter == index) {
                Object j = n.item;
                n.item = obj;
                return j;
            }
        } while (counter != index);

        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(0);
        ll.add(2);
        ll.add(2);
        ll.add(3);

        int index = -1;
        try {
            System.out.println(ll.get(index));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Recovered! Just a bad day.You gave me " + index
                    + " but I do not support it. Sorry about that. No, not really sorry.");
        }

        System.out.println("I am here!");
    }
}