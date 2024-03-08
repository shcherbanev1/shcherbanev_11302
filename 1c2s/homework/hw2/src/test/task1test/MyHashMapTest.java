import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {

    private static MyHashMap<Integer, String> map;

    @BeforeAll
    public static void init() {
        map = new MyHashMap<>(16);
    }

    @AfterEach
    public void clear() {
        map.clear();
    }

    @Test
    public void testPut1() {
        String r = map.put(18, "name");
        assertNull(r);
    }

    @Test
    public void testPut2() {
        map.put(18, "name");
        String r = map.put(18, "kostya");
        assertEquals("name", r);
    }

    @Test
    public void testContainsKey() {
        map.put(16, "Alice");
        map.put(-132, "sad");
        assertTrue(map.containsKey(-132));
        assertTrue(map.containsKey(16));
        assertFalse(map.containsKey(-16));
        assertFalse(map.containsKey(3242));
    }

    @Test
    public void testGet1() {
        map.put(19, "kostya");
        map.put(23, "julia");
        assertEquals("kostya", map.get(19));
        assertNotEquals("kostya", map.get(23));
    }

    @Test
    public void testGet2() {
        map.put(19, "kostya");
        assertNull(map.get(23));
    }

    @Test
    public void testRemove1() {
        map.put(18, "amir");
        map.put(-18, "neAmir");
        String r = map.remove(18);
        assertEquals("amir", r);
        assertEquals("neAmir", map.get(-18));
    }

    @Test
    public void testRemove2() {
        map.put(19, "kamila");
        assertNull(map.remove(18));
    }

    @Test
    public void testContainsValue() {
        map.put(19, "nastya");
        assertTrue(map.containsValue("nastya"));
        assertFalse(map.containsValue("julia"));
    }

}
