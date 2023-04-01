package hashtablesetandmap;

import java.util.HashMap;
import java.util.Map;

public class Map387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (myMap.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
