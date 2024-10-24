import com.amoalla.euler.utils.FileUtils;

/// # Names scores
/// <p>Using 'names.txt' (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand
/// first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
/// multiply this value by its alphabetical position in the list to obtain a name score.</p>
/// <p>For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
/// is the 938th name in the list. So, COLIN would obtain a score of 938 * 53 = 49714.</p>
/// <p>What is the total of all the name scores in the file?</p>
void main() {
    AtomicInteger i = new AtomicInteger(1);
    println(Arrays.stream(FileUtils.readFile("names.txt")
            .split(","))
            .map(name -> name.replace("\"", ""))
            .sorted()
            .mapToInt(name -> name.chars().map(ch -> ch - 'A' + 1).sum())
            .map(score -> score * i.getAndIncrement())
            .sum());
}