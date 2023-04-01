package hashtablesetandmap;

import java.util.HashSet;
import java.util.Set;

public class Set217 {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> mySet = new HashSet<>();
        for (var a : nums) {
            if (mySet.contains(a)) {
                return true;
            }
            mySet.add(a);
        }
        return false;
    }
}
