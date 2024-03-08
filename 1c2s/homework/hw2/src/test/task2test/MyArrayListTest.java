import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyArrayList<String> list;

    @BeforeEach
    public void init() {
        list = new MyArrayList<>();
    }

    @Test
    public void testValidateIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testIncreaseCapacity() {
        list = new MyArrayList<>(4);
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        assertEquals(8, list.capacity());

    }

    @Test
    public void testAdd1() {
        boolean r1 = list.add("do");
        boolean r2 = list.add("did");
        boolean r3 = list.add("done");
        assertEquals(3, list.size());
        assertTrue(r1 & r2 & r3);
    }

    @Test
    public void testGet1() {
        String s1 = "may";
        String s2 = "I";
        String s3 = "have";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        assertEquals(s1, list.get(0));
        assertEquals(s2, list.get(1));
        assertEquals(s3, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testAdd2() {
        list.add("Alice");
        list.add("Bob");
        list.add(1, "Eva");
        assertEquals("Alice", list.get(0));
        assertEquals("Eva", list.get(1));
        assertEquals("Bob", list.get(2));
    }

    @Test
    public void testGet2() {
        list.add("Wow");
        assertEquals(0, list.get("Wow"));
        assertEquals(-1, list.get("Uwu"));
    }

    @Test
    public void testContains() {
        list.add("Leo");
        assertTrue(list.contains("Leo"));
        assertFalse(list.contains("Mike"));
    }

    @Test
    public void testRemove1() {
        list.add("1");
        list.add("2");
        list.add("3"); // removed
        list.add("4");
        String r = list.remove(2);
        assertEquals("3", r);
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(17));
    }

    @Test
    public void testRemove2() {
        list.add("1");
        list.add("2");
        list.add("3"); // removed
        list.add("4");
        boolean r1 = list.remove("17");
        boolean r2 = list.remove("3");
        assertFalse(r1);
        assertTrue(r2);
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(3));
    }

}
