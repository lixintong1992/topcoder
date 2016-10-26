import java.util.HashMap;

public class CeyKaps {
    public String decipher(String typed, String[] switches) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), (char) ('A' + i));
        }
        for (String aSwitch : switches) {
            char temp1 =  map.get(aSwitch.toCharArray()[0]);
            char temp2 =  map.get(aSwitch.toCharArray()[2]);
            map.put(temp2, aSwitch.toCharArray()[0]);
            map.put(temp2, aSwitch.toCharArray()[2]);
        }
        for (char c : typed.toCharArray()) {
            result.append(map.get(c));
        }
        return result.toString();
    }
}
