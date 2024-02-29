public class OrderedLinkedList extends MyLinkedList {

    @Override
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else if (data < head.getData()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node curNode = head;

            while (curNode.getNext() != null && curNode.getData() < data) {
                curNode = curNode.getNext();
            }

            newNode.setNext(curNode.getNext());
            curNode.setNext(newNode);

        }
    }
}
