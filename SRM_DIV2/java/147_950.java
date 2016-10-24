import java.util.Arrays;

public class GoldenChain{
    public int minCuts(int[] sections){
        int cuts = 0;
        Arrays.sort(sections);
        for( int i = 0; i < sections.length; i++){
            if (sections.length - i - 1 >= sections[i] + cuts)cuts += sections[i];
            else cuts += Math.max(0, sections.length - cuts -i);
        }
        return cuts;
    }
}