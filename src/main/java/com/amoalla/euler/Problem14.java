/// # Longest Collatz sequence
/// The following iterative sequence is defined for the set of positive integers:
///
/// n -> n/2 (n is even)
/// n -> 3n + 1 (n is odd)
///
/// Using the rule above and starting with 13, we generate the following sequence:
///
/// 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
///
/// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
/// Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1
///
/// Which starting number, under one million, produces the longest chain?
///
/// <b>NOTE:</b> Once the chain starts the terms are allowed to go above one million.
Map<Long, Integer> sequenceSizeCache = new HashMap<>();

void main() {
    int max = 0;
    long starting = 0;
    for (long i = 1; i < 1_000_000; i++) {
        int size = collatzSequenceSize(i);
        sequenceSizeCache.put(i, size);
        if (size > max) {
            max = size;
            starting = i;
        }
    }

    println(starting);
}

int collatzSequenceSize(long n) {
    int nb = 0;
    while (n != 1) {
        nb++;
        n = n % 2 == 0 ? n / 2 : 3 * n + 1;
        Integer size = sequenceSizeCache.get(n);
        if (size != null) {
            return nb + size;
        }
    }
    return nb + 1; // +1 for the 1
}