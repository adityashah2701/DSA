class Solution {
    public double myPow(double x, int n) {
        long N = n; // convert to long

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    static double power(double x, long n) {
        if (n == 0)
            return 1.0;

        double half = power(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        return x * half * half;
    }
}