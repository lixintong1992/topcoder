public class PowerOutage{
        int[] f;
        int[] t;
        int[] d;
        int dfs(int s){
            int res = 0;
            for (int i = 0; i < f.length; i++){
                if (f[i] == s){
                    res = Math.max(res, dfs(t[i]) + d[i]);
                }
            }
            return res;
        }
    public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength){
        f = fromJunction;
        t = toJunction;
        d = ductLength;
        int n = fromJunction.length;
        int total = 0;
        for (int i = 0; i < n; i++){
            total += 2*d[i];
        }
        return total - dfs(0);
    }
}