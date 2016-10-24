import java.util.Arrays;

public class BridgeCrossing{
    private boolean[] leftSide;
    private boolean[] rightSide;
    private int minTime = Integer.MIN_VALUE;
    private int time = 0;

    public int minTime(int[] times){
        int length = times.length;
        if (length == 1){
            return times[0];
        }

        leftSide = newBooleanArray(length, true);
        rightSide = newBooleanArray(length, false);
        goToTheRight(times);

        return minTime;
    }

    private boolean[] newBooleanArray(int length, boolean b){
        boolean[] array = new boolean[length];
        Arrays.fill(array, b);
        return array;
    }

    private void goToTheRight(int[] times){
        for( int i = 0; i < times.length - 1; i++){
            if(!leftSide[i]) continue;

            for (int j = i + 1; j < times.length; j++){
                if(!leftSide[j]) continue;

                // next state
                leftSide[i] = leftSide[j] = false;
                rightSide[i] = rightSide[j] = true;
                int t = Math.max(times[i], times[j]);
                time += t;

                goToTheLeft(times);

                // reset state
                time -= t;
                leftSide[i] = leftSide[j] = true;
                rightSide[i] = rightSide[j] = false;
            }
        }
    }

    private void goToTheLeft(int[] times){
        if(allTrue(rightSide)){
            minTime = Math.min(minTime, time);
        }else{
            for( int i = 0; i < times.length; i++){
                if(!rightSide[i]) continue;

                // next state
                rightSide[i] = false;
                leftSide[i] = true;
                time += times[i];

                goToTheRight(times);

                // rest state
                time -= times[i];
                rightSide[i] = true;
                leftSide[i] = false;
            }
        }
    }
    private boolean allTrue(boolean[] rightSide){
        for(boolean b : rightSide){
            if(!b) return false;
        }
        return true;
    }
}