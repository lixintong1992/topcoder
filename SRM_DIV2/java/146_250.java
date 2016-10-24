public class YahtzeeScore{
    public int maxPoints(int[] toss){
        int[] result = new int[6];
        for (int i : toss){
            result[i - 1] += i;
        }
        int max = 0;
        for (int i : result){
            max = Math.max(i, max);
        }
        return max;
    }
}