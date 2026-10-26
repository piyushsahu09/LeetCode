class Solution {
    public int countPrimes(int n) {
        // Condition 1: There are no prime numbers less than 2
        if (n <= 2) {
            return 0;
        }
        
        // Step 1: Create a boolean array to track primes
        // Default value for boolean is false. Let's assume 'false' means it IS prime.
        boolean[] isNotPrime = new boolean[n];
        
        // Step 2: Sieve of Eratosthenes
        // We only need to check up to the square root of n (i * i < n)
        for (int i = 2; i * i < n; i++) {
            
            // If the number hasn't been crossed out, it is a prime
            if (isNotPrime[i] == false) {
                
                // Cross out all multiples of this prime number
                // We can start at i * i because smaller multiples were already crossed out
                for (int j = i * i; j < n; j += i) {
                    isNotPrime[j] = true; // Mark as NOT prime
                }
            }
        }
        
        // Step 3: Count the remaining primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isNotPrime[i] == false) {
                count++;
            }
        }
        
        return count;
    }
}