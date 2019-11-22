public class MovesTreeBuilder implements CompinationsTree {

    int [][] initialState = new int [3][3];
    TreeNodeState root ;

    public MovesTreeBuilder(int [] inputState){
        int [] entryPoint = initializeTreeRoot(inputState);
//        root = new TreeNodeState(initialState, entryPoint);
    }

    private int[] initializeTreeRoot(int[] inputState) {
        int row = 0;
        int col = 0;
        int [] entryPoint = new int[2];
        for (int cell: inputState){
            if (row ==3) {
                row = 0;
                col++;
            }
            initialState[row][col] = cell;
            if (cell == 0){
                entryPoint[0] = row;
                entryPoint[1] =col;
            }
            row++;
        }
        return entryPoint;
    }



    @Override
    public TreeNode getTree() {
        return null;
    }
}
