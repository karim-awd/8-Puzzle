import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        int [] intialNodeState = new int [9];
        int emptyCellIndex = init(input, intialNodeState);
        TreeNodeState root = new TreeNodeState(intialNodeState, emptyCellIndex);

        //searchAlgorithms.BFS(root);
        searchAlgorithms.DFS(root,0);
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
