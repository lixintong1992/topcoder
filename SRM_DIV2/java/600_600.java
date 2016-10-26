public class ORSolitaireDiv2 {
    public int getMinimum(int[] numbers, int goal) {
        int result = 0, fin = numbers.length;
        while (goal != 0) {
            if ((goal & 1) == 0) {
                for (int i = 0; i < numbers.length; i++) {
                    if ((numbers[i] & 1) == 1) numbers[i] = 0;
                    numbers[i] = numbers[i] >>> 1;
                }
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] > goal) numbers[i] = 0;
                    else {
                        if ((numbers[i] & 1) == 1) result++;
                        numbers[i] = numbers[i] >>> 1;
                    }
                }
                fin = Math.min(result, fin);
            }
            goal = goal >>> 1;
            result = 0;
        }
        return fin;
    }
}
