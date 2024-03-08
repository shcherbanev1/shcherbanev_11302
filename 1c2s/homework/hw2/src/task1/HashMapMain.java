public class HashMapMain {

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> m = new MyHashMap<>(16);
        m.put(10, 33);
        m.put(1310, 14);
        m.put(-1310, 24);
        m.put(-10, 33);
        m.put(-13, 33);
        m.put(-1310, 11);
        System.out.println(m.containsKey(-13));
        System.out.println(m.get(1310));
        System.out.println(m.remove(-13));
        m.put(-13, 12131);
        System.out.println(m.containsValue(2123));
        System.out.println(m);
        m.clear();
        System.out.println("cleared");
        System.out.println(m);
    }

}
