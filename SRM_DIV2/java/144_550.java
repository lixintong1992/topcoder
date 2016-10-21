public class BinaryCode{
    public String[] decode(String message){
        String[] ret = new String[] {"", ""};
        int[] a = new int[message.length() + 2];
        for (int i = 0; i < 2; i++){
            a[a.length - 1] = 0;
            a[1] = i;
            for (int j = 0; j < message.length(); j++){
                a[j + 2] = (message.charAt(j) - '0') - a[j] - a[j + 1];
                if (a[j + 2] < 0 || a[j + 2] > 1 || a[a.length - 1] != 0){
                    ret[i] = "NONE";
                    break;
                }
                ret[i] += a[j + 1];
            }
        }
        return ret;
    }
}