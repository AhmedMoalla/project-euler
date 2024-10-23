/// # Special Pythagorean triplet
/// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
/// a^2 + b^2 = c^2
/// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2. There exists exactly one Pythagorean triplet for which a + b + c = 1000.
/// Find the product abc.
void main() {
    int step = 1;
    for (int a = 1; a <= 1000; a++) {
        if (a % 2 == 0) step = 2;
        for (int b = a + 1; b <= 1000; b += step) {
            for (int c = b + step; c <= 1000; c += step) {
                if (a * a + b * b == c * c
                    && a + b + c == 1000
                    && a < b && b < c) {
                    println(a * b * c);
                    return;
                }
            }
        }
    }
}