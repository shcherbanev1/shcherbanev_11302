public class MapMain {

    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>(32);
        map.put(25, "kostya");
        map.put(25, "kya");
        map.put(4, "kokA");
        map.put(13, "FAQ");
        map.put(11, "ioyi");
        map.put(123, "jhmnvc");
        map.put(17, "pyoe");
        map.put(22, "hgha");
        map.put(23, "ksds");
        map.remove(4);
        map.put(13, "qoade");
        map.put(22, "KISS");
        System.out.println(map);
    }


}
