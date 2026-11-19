class Solution {
    // public int climbStairs(int n) {
    //     int []dp = new int[n+1];
    //     dp[0]=1;
    //     dp[1]=1;

    //     for(int i = 2;i<=n;i++){
    //         dp[i] = dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }


    // top-down appraoch

    private int climbingRep(int n , int []dp ){
        if (n ==0 || n==1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }


        return dp[n] = climbingRep(n-1 ,dp) + climbingRep(n- 2, dp);
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return climbingRep(n , dp);
    }
}
