import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

        while (true) {
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            int[] intialNodeState = new int[9];
            int emptyCellIndex = init(input, intialNodeState);
            TreeNodeState root = new TreeNodeState(intialNodeState, emptyCellIndex, 0, new ArrayList<>());
            double before = System.currentTimeMillis();
            searchAlgorithms.BFS(root);
            double after = System.currentTimeMillis();

            System.out.println("BFS time " + (after - before));
            System.out.println("DFS");
            before = System.currentTimeMillis();
            searchAlgorithms.DFS(root);
            System.out.println();
            after = System.currentTimeMillis();
            System.out.println("DFS time " + (after - before));

            System.out.println("Euclidean");

            before = System.currentTimeMillis();
            searchAlgorithms.Euclidean_A_Star(root);
            after = System.currentTimeMillis();
            System.out.println("Euclidean time " + (after - before));

            System.out.println("Manhattan");

            before = System.currentTimeMillis();
            searchAlgorithms.Manhattan_A_Star(root);
            after = System.currentTimeMillis();
            System.out.println("Manahattan time " + (after - before));

        }

    }

    private static int init(String input, int[] intialNodeState) {
        char[] chars = input.toCharArray();
        int index = 0;
        int emptyCellIndex = 0;
        for (char ch : chars) {
            if (ch >= '0' && ch <= '8') {
                if (ch == '0') {
                    emptyCellIndex = index;
                }
                intialNodeState[index++] = Integer.parseInt("" + ch);
            }
        }
        return emptyCellIndex;
    }


}
