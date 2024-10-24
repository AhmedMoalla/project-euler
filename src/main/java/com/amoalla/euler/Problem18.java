package com.amoalla.euler;

import java.util.*;
import java.util.stream.Collectors;

import static java.io.IO.println;

/// # Maximum Path Sum I
/// <p>By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23</p>
/// <p class="monospace center"><span class="red"><b>3</b></span><br><span class="red"><b>7</b></span> 4<br>
/// 2 <span class="red"><b>4</b></span> 6<br>
/// 8 5 <span class="red"><b>9</b></span> 3</p>
/// <p>That is, 3 + 7 + 4 + 9 = 23</p>
/// <p>Find the maximum total from top to bottom of the triangle below:</p>
/// <p class="monospace center">75<br>
/// 95 64<br>
/// 17 47 82<br>
/// 18 35 87 10<br>
/// 20 04 82 47 65<br>
/// 19 01 23 75 03 34<br>
/// 88 02 77 73 07 63 67<br>
/// 99 65 04 28 06 16 70 92<br>
/// 41 41 26 56 83 40 80 70 33<br>
/// 41 48 72 33 47 32 37 16 94 29<br>
/// 53 71 44 65 25 43 91 52 97 51 14<br>
/// 70 11 33 28 77 73 17 78 39 68 17 57<br>
/// 91 71 52 38 17 14 91 43 58 50 27 29 48<br>
/// 63 66 04 68 89 53 67 30 73 16 69 87 40 31<br>
/// 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23</p>
/// <p class="note"><b>NOTE:</b> As there are only 16384 routes, it is possible to solve this problem by trying every route. However, <a href="problem=67">Problem 67</a>, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)</p>

public class Problem18 {

    static String tree = """
       75
       95 64
       17 47 82
       18 35 87 10
       20 04 82 47 65
       19 01 23 75 03 34
       88 02 77 73 07 63 67
       99 65 04 28 06 16 70 92
       41 41 26 56 83 40 80 70 33
       41 48 72 33 47 32 37 16 94 29
       53 71 44 65 25 43 91 52 97 51 14
       70 11 33 28 77 73 17 78 39 68 17 57
       91 71 52 38 17 14 91 43 58 50 27 29 48
       63 66 04 68 89 53 67 30 73 16 69 87 40 31
       04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
       """.trim();


    public static void main(String[] args) {
        println(maxPathSum(tree));
    }


    public static int maxPathSum(String tree) {
        List<Level> levels = parseTree(tree);

        // ParentNode => ChildNode
        Map<Node, Node> candidates = new HashMap<>();
        for (Level level : levels.reversed()) {
            for (Node node : level.nodes()) {
                // 1-. Get parent
                List<Node> parents = node.parents;
                if (parents.isEmpty()) continue;
                if (parents.size() != 1) throw new IllegalStateException("Node %d has %d parents".formatted(node.value, parents.size()));
                Node parent = parents.getFirst();

                // 2- Get siblings
                List<Node> siblings = parent.children;

                // 3- Choose the bigger sibling
                Node biggerSibling = siblings.get(0).value > siblings.get(1).value ? siblings.get(0) : siblings.get(1);

                // 4- Update parent value
                parent.value += biggerSibling.value;

                // 5- Store the bigger sibling value as potential candidate
                candidates.put(parent, biggerSibling);

                // 6- Remove child relationship from parent
                parent.children.forEach(child -> child.parents.remove(parent));
                parent.children.clear();
            }
        }

        Node rootNode = candidates.keySet().stream()
                .filter(node -> node.id == 0)
                .findFirst().orElseThrow();

        List<Integer> path = new ArrayList<>();
        path.add(rootNode.originalValue);
        Node childValue = candidates.get(rootNode);
        path.add(childValue.originalValue);
        while (true) {
            childValue = candidates.get(childValue);
            if (childValue == null) break;
            path.add(childValue.originalValue);
        }

        return path.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Level> parseTree(String tree) {
        List<Level> levels = new ArrayList<>();

        String[] split = tree.split("\n");
        for (int levelIndex = 0; levelIndex < split.length; levelIndex++) {
            String line = split[levelIndex].trim();
            int[] values = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            List<Node> nodes = new ArrayList<>();

            if (levelIndex == 0) {
                nodes.add(new Node(values[0], new ArrayList<>()));
                levels.add(new Level(0, nodes));
                continue;
            }

            for (int childNodeIndex = 0; childNodeIndex < values.length; childNodeIndex++) {
                int value = values[childNodeIndex];

                Level previousLevel = levels.get(levelIndex - 1);
                List<Node> parentNodes = previousLevel.nodes();
                Node leftParent = childNodeIndex == 0 ? null : parentNodes.get(childNodeIndex - 1);
                Node rightParent = childNodeIndex == values.length - 1 ? null : parentNodes.get(childNodeIndex);

                Node childNode = new Node(value, new ArrayList<>());

                if (leftParent != null) {
                    leftParent.children.add(childNode);
                    childNode.parents.add(leftParent);
                }

                if (rightParent != null) {
                    rightParent.children.add(childNode);
                    childNode.parents.add(rightParent);
                }

                nodes.add(childNode);
            }
            levels.add(new Level(levelIndex, nodes));
        }
        return levels;
    }

    public record Level(int level, List<Node> nodes) {

        @Override
        public String toString() {
            return "Level %d: \n%s".formatted(level, nodes.stream().map(node -> "\t- " + node.toString())
                    .collect(Collectors.joining("\n")));
        }
    }

    public static final class Node {
        private static int nextId = 0;
        public final int id;
        public int value;
        public final int originalValue;
        public final List<Node> children;
        public final List<Node> parents;

        Node(int id, int value, int originalValue, List<Node> children, List<Node> parents) {
            this.id = id;
            this.value = value;
            this.originalValue = originalValue;
            this.children = children;
            this.parents = parents;
        }

        public Node(int value, List<Node> children, List<Node> parents) {
            this(nextId++, value, value, children, parents);
        }

        public Node(int value, List<Node> parents) {
            this(value, new ArrayList<>(), parents);
        }

        @Override
        public String toString() {
            String children = this.children.isEmpty() ? "" : " -> [children: %s]".formatted(
                    this.children.stream()
                            .map(node -> node.value)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")));
            String parentStr = parents.isEmpty() ? "ROOT" : parents.stream()
                    .map(node -> node.value)
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            return "[parents: %s] -> [value: %d]".formatted(
                    parentStr,
                    value) + children;
        }
    }
}
