import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

        while(true) {
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            int[] intialNodeState = new int[9];
            int emptyCellIndex = init(input, intialNodeState);
            TreeNodeState root = new TreeNodeState(intialNodeState, emptyCellIndex);

            searchAlgorithms.BFS(root);
            System.out.println();

            System.out.println("DFS");
            searchAlgorithms.DFS(root);
        }

    }

    private static int init(String input, int[] intialNodeState) {
        char[] chars = input.toCharArray();
        int index =0;
        int emptyCellIndex = 0;
        for (char ch : chars){
            if (ch >= '0' && ch <='8'){
                if (ch == '0'){
                    emptyCellIndex = index;
                }
                intialNodeState[index++] = Integer.parseInt(""+ ch);
            }
        }
        return emptyCellIndex;
    }

}
