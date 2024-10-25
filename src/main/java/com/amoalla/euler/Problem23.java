/// # Non-abundant sums
/// <p>A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
/// For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that
/// 28 is a perfect number.</p>
/// <p>A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if
/// this sum exceeds n.</p>
///
/// <p>As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be
/// written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that
/// all integers greater than 28123 can be written as the sum of two abundant numbers. However, this
/// upper limit cannot be reduced any further by analysis even though it is known that the greatest
/// number that cannot be expressed as the sum of two abundant numbers is less than this limit.</p>
///
/// <p>Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.</p>
void main() {
    Set<Integer> abundants = new HashSet<>();
    for (int i = 1; i < 28123; i++) {
        if (isAbundant(i)) {
            abundants.add(i);
        }
    }

    Set<Integer> writable = new HashSet<>();
    for (int abundant1 : abundants) {
        for (int abundant2 : abundants) {
            int sum = abundant1 + abundant2;
            if (sum < 28123) {
                writable.add(sum);
            }
        }
    }

    Set<Integer> nonWritable = new HashSet<>();
    for (int i = 1; i < 28123; i++) {
        if (!writable.contains(i)) {
            nonWritable.add(i);
        }
    }

    println(nonWritable.stream().mapToInt(Integer::intValue).sum());
}

public boolean isAbundant(int n) {
    int sum = 0;
    for (int i = 1; i < (n / 2) + 1; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum > n;
}