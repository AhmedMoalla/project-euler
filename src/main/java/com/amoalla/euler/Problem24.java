/// # Lexicographic Permutations
/// <p>A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of
/// the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it
/// lexicographic order. The lexicographic permutations of 0, 1 and 2 are:</p>
/// <p class="center">012   021   102   120   201   210</p>
/// <p>What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?</p>
record Node(int value, List<Node> children) {}

List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

void main() {
    List<String> possibilities = new ArrayList<>();
    for (Integer number : numbers) {
        Node root = buildPossibilityTree(number, numbers);
        printPossibilities(root, "", possibilities);
    }
    print(possibilities.get(999_999));
}

private void printPossibilities(Node root, String prefix, List<String> possibilities) {
    for (Node child : root.children) {
        printPossibilities(child, prefix + root.value, possibilities);
    }
    String str = prefix + root.value;
    if (str.length() != numbers.size()) return;
    possibilities.add(str);
}

private Node buildPossibilityTree(int n, List<Integer> numbers) {
    List<Integer> remaining = new ArrayList<>(numbers);
    remaining.remove((Object) n);
    if (remaining.isEmpty()) return new Node(n, new ArrayList<>());
    List<Node> children = new ArrayList<>();
    for (int i : remaining) {
        children.add(buildPossibilityTree(i, remaining));
    }
    return new Node(n, children);
}
