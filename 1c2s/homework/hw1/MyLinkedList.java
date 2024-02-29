import java.util.Scanner;

public class MyLinkedList {

    protected Node head;
    protected Node tail;
    protected int size = 0;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void inputList(int n) {
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(System.in);
            this.add(sc.nextInt());
        }
    }

    public int max() {
        Node temp = head;
        int max = head.getData();
        while (temp != null) {
            temp = temp.getNext();
            if (temp.getData() > max) {
                max = temp.getData();
            }
        }
        return max;
    }

    public boolean contains(int n) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == n) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    private static void swap(Node node1, Node node2) {
        int temp = node2.getData();
        node2.setData(node1.getData());
        node1.setData(temp);
    }

    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            Node curNode = head;
            for (int j = 0; j < size - i - 1; j++) {
                if (curNode.getNext() != null) {
                    if (curNode.getData() > curNode.getNext().getData()) {
                        swap(curNode, curNode.getNext());
                    }
                }
                curNode = curNode.getNext();
            }
        }
    }

    @Override
    public String toString() {
        String str;
        Node temp = head;
        StringBuilder strBuilder = new StringBuilder();
        while (temp.getNext() != null) {
            strBuilder.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        strBuilder.append(temp.getData());
        str = strBuilder.toString();
        return str;
    }



    // Следующие методы статик потому что они не нужны классу MyLinkedList,
    // методы восприняты как абстрактные таски - просто на работу с ЛинкедЛистом
    // но выносить в отдельный класс не захотелось :/
    public static boolean delete2First(MyLinkedList list) {
        if (list.size < 2) {
            return false;
        }
        Node curNode = list.head;
        for (int i = 0; i < 2; i++) {
            curNode = curNode.getNext();
        }
        list.head = curNode;
        list.size -= 2;
        return true;
    }

    public static boolean removeValue(int value, MyLinkedList list) {
        if (list.head == null) {
            return false;
        }

        Node prevNode = null;
        Node curNode = list.head;

        if (curNode.getData() == value) {
            if (curNode == list.tail) {
                list.head = null;
            } else {
                list.head = curNode.getNext();
            }
            list.size--;
            return true;
        }

        while (curNode != null) {
            if (curNode.getData() == value) {
                if (curNode == list.tail) {
                    prevNode.setNext(null);
                    list.tail = prevNode;
                } else {
                    prevNode.setNext(curNode.getNext());
                }
                list.size--;
                return true;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        return false;
    }

    public static boolean removeAllValues(int value, MyLinkedList list) {
        Node curNode = list.head;
        Node prevNode = null;
        boolean deleted = false;

//        if (curNode.getData() == value) {
//            if (curNode == list.tail) {
//                list.head = null;
//                list.size--;
//                return true;
//            }
//        }

        while (curNode != null) {
            if (curNode.getData() == value) {
                if (prevNode == null) {
                    list.head = curNode.getNext();
                } else if (curNode == list.tail) {
                    prevNode.setNext(null);
                    list.tail = prevNode;
                } else {
                    prevNode.setNext(curNode.getNext());
                }
                list.size--;
                deleted = true;
            } else {
                prevNode = curNode;
            }
            curNode = curNode.getNext();
        }
        return deleted;
    }

    public static void insertYafterX(int x, int y, MyLinkedList list) {
        Node curNode = list.head;
        Node prevNode = null;

        while (curNode != null) {
            if (curNode.getData() == x) {
                Node newNode = new Node(y);
                if (curNode == list.tail) {
                    curNode.setNext(newNode);
                    list.tail = newNode;
                } else {
                    newNode.setNext(curNode.getNext());
                    curNode.setNext(newNode);
                }
                list.size++;
                return;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
    }

    public static void insertYbeforeX(int x, int y, MyLinkedList list) {
        Node curNode = list.head;
        Node prevNode = null;

        while (curNode != null) {
            if (curNode.getData() == x) {
                Node newNode = new Node(y);
                if (prevNode == null) {
                    newNode.setNext(list.head);
                    list.head = newNode;
                } else {
                    newNode.setNext(curNode);
                    prevNode.setNext(newNode);
                }
                list.size++;
                return;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
    }

    public static void insertYafterAllX(int x, int y, MyLinkedList list) {
        Node curNode = list.head;
        Node prevNode = null;

        while (curNode != null) {
            if (curNode.getData() == x) {
                Node newNode = new Node(y);
                if (curNode == list.tail) {
                    curNode.setNext(newNode);
                    list.tail = newNode;
                } else {
                    newNode.setNext(curNode.getNext());
                    curNode.setNext(newNode);
                }
                list.size++;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
    }

}
