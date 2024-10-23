import com.amoalla.euler.utils.Algorithms;

/// # Largest prime factor
/// The prime factors of 13195 are 5, 7, 13 and 29.
/// What is the largest prime factor of the number 600851475143?
void main() {
    long n = 600851475143L;
    int primeDivisor = 2;
    while (n != 1) {
        if (n % primeDivisor == 0) {
            n = n / primeDivisor;
        } else {
            while (!Algorithms.Primes.isPrime(++primeDivisor));
        }
    }
    println(primeDivisor);
}
