/// # Reciprocal Cycles
/// <p>A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:</p>
/// 1/2 = 0.5<br>
/// 1/3 = 0.(3)<br>
/// 1/4 = 0.25<br>
/// 1/5 = 0.2<br>
/// 1/6 = 0.1(6)<br>
/// 1/7 = 0.(142857)<br>
/// 1/8 = 0.125<br>
/// 1/9 = 0.(1)<br>
/// 1/10 = 0.1<br>
/// <p>Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.</p>
/// <p>Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.</p>
void main() {
    int maxCycleSize = 0;
    int maxD = 0;
    for (int d = 2; d <= 1000; d++) {
        int cycleLength = reciprocal(d);
        if (cycleLength > maxCycleSize) {
            maxCycleSize = cycleLength;
            maxD = d;
        }
    }
    println(maxD);
}

int reciprocal(int n) {
    List<Integer> mods = new ArrayList<>();

    int d = 1;
    while (!mods.contains(d)) {
        mods.add(d);

        if (d >= n) {
            int remainder = d % n;
            d = remainder * 10;
        } else {
            d *= 10;
        }
    }

    return mods.size() - mods.indexOf(d);
}