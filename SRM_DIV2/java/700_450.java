import java.util.ArrayList;
import java.util.List;

public class XMarksTheSpot {
    public int countArea(String[] board) {
        char[][] newBoard = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i].toCharArray();
        }

        int[] result = {newBoard.length, 0, newBoard[0].length, 0}; // topmost row, bottommost row, leftmost column, rightmost column
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                if (newBoard[i][j] == 'O') {
                    if (i < result[0]) result[0] = i;
                    if (i > result[1]) result[1] = i;
                    if (j < result[2]) result[2] = j;
                    if (j > result[3]) result[3] = j;
                }
                if (newBoard[i][j] == '?') {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int fin = 0;
        int[] finResult = result.clone();
        int arrange = 1 << x.size();
        for (int i = 0; i < arrange; i++) {
            for (int j = 0; j < x.size(); j++) {
                if (((i >>> j) & 1) == 1) {
                    result[0] = Math.min(result[0], x.get(j));
                    result[1] = Math.max(result[1], x.get(j));
                    result[2] = Math.min(result[2], y.get(j));
                    result[3] = Math.max(result[3], y.get(j));
                }
            }
            fin += (result[1] - result[0] + 1) * (result[3] - result[2] + 1);
            result = finResult.clone();
        }
        return fin;
    }
}
