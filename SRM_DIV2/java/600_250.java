import java.util.Arrays;

public class TheShuttles {
    public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(cnt);
        for (int seat = 1; seat <= cnt[cnt.length - 1]; seat++) {
            int maxCars = 0;
            for (int persons : cnt) {
                int x = (int) Math.ceil(persons / (double) (seat));
                maxCars += x;
            }
            result = Math.min(result, maxCars * (seat * seatCost + baseCost));
        }
        return result;
    }
}
