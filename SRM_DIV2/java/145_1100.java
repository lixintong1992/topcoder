public class VendingMachine{
    private int[][] machine;
    private int rows, cols;
    private int sumi;
    public int motorUse(String[] prices, String[] purchases){
        rows = prices.length;
        machine = new int[rows + 1][];
        sumi = prices.length;
        for ( int i = 0; i < rows; i++){
            String[] strVals = prices[i].split(" ");
            machine[i] = new int[strVals.length];
            for (int j = 0; j < strVals.length; j++){
                machine[i][j] = Integer.valueOf(strVals[j]);
            }
        }
        cols = machine[0].length;
        machine[sumi] = new int[cols];

        for (int j = 0; j < cols; j++){
            int sum = 0;
            for (int i = 0; i < rows; i++){
                sum += machine[i][j];
            }
            machine[sumi][j] = sum;
        }

        int max = getMaxColumn();
        int seconds = getRotateTime(0 , max);
        int currentColumn = max;
        int lastMinute = Integer.valueOf(purchases[0].split(":")[1]);

        for (int i = 0; i < purchases.length; i++){
            String[] coordsMinute = purchases[i].split(":");
            String[] coords = coordsMinute[0].split(",");
            int row = Integer.valueOf(coords[0]);
            int col = Integer.valueOf(coords[1]);
            int minute = Integer.valueOf(coordsMinute[1]);

            if (minute - lastMinute >= 5){
                max = getMaxColumn();
                seconds += getRotateTime(currentColumn, max);
                currentColumn = max;
            }

            if (machine[row][col] == 0){
                return -1;
            }
            seconds += getRotateTime(currentColumn, col);
            currentColumn = col;
            machine[sumi][col] -= machine[row][col];
            machine[row][col] = 0;
            lastMinute = minute;
        }
            seconds += getRotateTime(currentColumn, getMaxColumn());

            return seconds;
    }

    private int getRotateTime(int currentColumn, int destinationColumn){
        int abs = Math.abs(destinationColumn - currentColumn);
        return Math.min(abs, cols - abs);
    }

    private int getMaxColumn(){
        int maxi = 0;
        int max = machine[sumi][0];
        for (int i = 1; i < machine[0].length; i++){
            if (machine[sumi][i] > max){
                maxi = i;
                max = machine[sumi][i];
            }
        }
        return maxi;
    }
}