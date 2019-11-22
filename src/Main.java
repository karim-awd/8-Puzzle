import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

        while(true) {
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

        int [] intialNodeState = new int [9];
        int emptyCellIndex = init(input, intialNodeState);
        TreeNodeState root = new TreeNodeState(intialNodeState, emptyCellIndex, 0);

            //searchAlgorithms.BFS(root);
            System.out.println();

//            System.out.println("DFS");
            //searchAlgorithms.DFS(root);
            System.out.println();

            System.out.println("Euclidean");

            searchAlgorithms.Euclidean_A_Star(root);
            System.out.println();

            System.out.println("Manhattan");

            searchAlgorithms.Manhattan_A_Star(root);

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
