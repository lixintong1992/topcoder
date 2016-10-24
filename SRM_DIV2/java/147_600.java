import java.util.Arrays;

public class PeopleCircle{
    public String order(int numMales, int numFemales, int K){
        int pointer = 0, allMen = numMales + numFemales;
        K--;
        int temp_k = K;
        char[] result = new char[allMen];
        Arrays.fill(result, 'M');
        if (numFemales == 0)
            return String.valueOf(result);
        while (numFemales > 0) {
            while (K > 0) {
                if (result[pointer] == 'M')
                    K--;
                pointer++;
                if (pointer >= allMen) {
                    pointer = pointer % allMen;
                }
            }
            K = temp_k;
            while (result[pointer] != 'M') {
                pointer++;
                if (pointer >= allMen) {
                    pointer = pointer % allMen;
                }
            }
                result[pointer] = 'F';
                pointer++;
                if (pointer >= allMen) {
                    pointer = pointer % allMen;
                }
                numFemales--;
            }

        return String.valueOf(result);
        }
}
