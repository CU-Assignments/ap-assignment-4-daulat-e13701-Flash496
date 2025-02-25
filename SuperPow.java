class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;
        
        for (int digit : b) {
            result = powerMod(result, 10) * powerMod(a, digit) % MOD;
        }
        return result;
    }

    private int powerMod(int x, int n) {
        int res = 1;
        x %= MOD;
        while (n > 0) {
            if (n % 2 == 1) res = res * x % MOD;
            x = x * x % MOD;
            n /= 2;
        }
        return res;
    }
}

