import java.util.HashSet;
import java.util.Set;

public class Xylophone {
    public int countKeys(int[] keys) {
        Set<Integer> set = new HashSet<>();
        for (int key : keys) {
            set.add(key % 7);
        }
        return set.size();
    }
}