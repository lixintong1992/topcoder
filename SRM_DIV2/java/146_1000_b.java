import java.util.Arrays;

public class BridgeCrossing{
    public int minTime(int[] times){
        int total = 0, remaining = times.length;
        Arrays.sort(times);

        while (remaining > 3){
            total += Math.min(times[0] * 2 + times[remaining - 2] + times[remaining - 1], times[0] + times[1] * 2 + times[remaining - 1]);
            remaining -= 2;
        }

        switch (remaining){
            case 1:
                return times[0];
            case 2:
                return total += times[1];
            case 3:
                return total += times[0] + times[1] + times[2];
            default:
                break;
        }
        return total;
    }
}