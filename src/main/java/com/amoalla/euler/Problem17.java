/// # Number letter counts
/// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
/// 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
/// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
/// how many letters would be used?
/// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
/// contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.

void main() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 1000; i++) {
        String words = toWords(i);
        if (!words.isEmpty()) {
            sb.append(words.replace(" ", ""));
        }
    }
    println(sb.length());
}

String toWords(int number) {
    if (number < 10) return units(number);
    if (number < 20) return teens(number);
    if (number < 100) return tens(number);
    if (number < 1000) return hundreds(number);
    return "one thousand";
}

String units(int number) {
    return switch (number) {
        case 1 -> "one";
        case 2 -> "two";
        case 3 -> "three";
        case 4 -> "four";
        case 5 -> "five";
        case 6 -> "six";
        case 7 -> "seven";
        case 8 -> "eight";
        case 9 -> "nine";
        default -> throw new IllegalStateException("Unexpected value: " + number);
    };
}

private Map<Integer, String> prefixes = Map.ofEntries(
        Map.entry(3, "thir"),
        Map.entry(5, "fif"),
        Map.entry(8, "eigh")
);

String teens(int number) {
    return switch (number) {
        case 10 -> "ten";
        case 11 -> "eleven";
        case 12 -> "twelve";
        default -> {
            int unit = number % 10;
            String prefix = prefixes.get(unit);
            yield (prefix != null ? prefix : toWords(unit)) + "teen";
        }
    };
}

String tens(int number) {
    int tens = number / 10;
    String tensWord;

    if (number == 20 || tens == 2) {
        tensWord = "twenty";
    } else if (number == 40 || tens == 4) {
        tensWord = "forty";
    } else {
        String prefix = prefixes.get(tens);
        tensWord = (prefix != null ? prefix : toWords(tens)) + "ty";
    }

    if (number % 10 == 0) return tensWord;

    int unit = number % 10;
    return tensWord + " " + toWords(unit);
}

private String hundreds(int number) {
    int hundreds = number / 100;
    if (number % 100 == 0) return units(hundreds) + " hundred";
    return toWords(hundreds) + " hundred and " + toWords(number % 100);
}