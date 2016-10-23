import java.util.*;
public class ImageDithering{
    public int count(String dithered, String[] screen){
        Set<Character> set = new HashSet<>();
        for (char i : dithered.toCharArray()){
            set.add(i);
        }
        int result = 0;
        for (String i : screen){
            for (char j : i.toCharArray()){
                if (set.contains(j)) result++;
            }
        }
        return result;
    }
}