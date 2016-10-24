public class CCipher{
    public String decode(String cipherText, int shift){
        StringBuilder result = new StringBuilder();
        for (char i : cipherText.toCharArray()){
            int temp = i - 'A' - shift;
            if (temp < 0) temp += 26;
            result.append((char)(temp + 'A'));
        }
        return result.toString();
        
    }
}