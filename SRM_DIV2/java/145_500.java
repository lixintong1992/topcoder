public class ExerciseMachine{
    public int getPercentages(String time){
        String[] split = time.split(":");
        int h = Integer.valueOf(split[0]);
        int m = Integer.valueOf(split[1]);
        int s = Integer.valueOf(split[2]);
        int seconds = s + m * 60 + h * 3600;
        int sum;
        for (int i = 1; i < seconds; i++){
            if (i * 100 % seconds == 0){
                sum++;
            }
        }
        return sum;
    }
}