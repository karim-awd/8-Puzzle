import java.util.ArrayList;
import java.util.Arrays;

public class TreeNodeState implements TreeNode {

    private int emptyCellIndex;
    private int[] nodeState;
    int[][] prettyState = new int[3][3];
    private String strRepresentation;
    private String goalState = "[0, 1, 2, 3, 4, 5, 6, 7, 8]";
    private int depth;

    public TreeNodeState(int[] nodeState, int emptyCellIndex, int depth) {
        this.emptyCellIndex = emptyCellIndex;
        this.nodeState = nodeState;
        this.strRepresentation = Arrays.toString(nodeState);
        this.depth = depth;
        this.buildGrid();
    }


    @Override
    public String getStringRepresentation() {
        return strRepresentation;
    }

    @Override
    public int getDistanceByManhattan() {
        int totalDistance = 0;

        for (int x = 0; x<3; x++){
            for (int y = 0; y< 3; y++){
                totalDistance += Math.abs(x- prettyState[x][y]/3) + Math.abs(y- prettyState[x][y]%3);
            }
        }

        return totalDistance + this.depth;
    }

    @Override
    public int getDistanceByEuclidean() {
        int totalDistance = 0;
        for (int x = 0; x<3; x++){
            for (int y = 0; y< 3; y++){
                totalDistance += Math.sqrt(Math.pow((x- (prettyState[x][y]/3)),2) + Math.pow((y- (prettyState[x][y]%3)),2));
            }
        }
        return totalDistance + this.depth;
    }

    @Override
    public boolean isGoalState() {
        return goalState.equals(strRepresentation);
    }

    @Override
    public ArrayList<TreeNode> getChildren() {
        ArrayList<TreeNode> children = new ArrayList<>();
        if ((emptyCellIndex - 3) > 0) {
            children.add(swipe(emptyCellIndex, emptyCellIndex - 3));
        }
        if ((emptyCellIndex != 0) && (emptyCellIndex != 3) && (emptyCellIndex != 6)) {
            children.add(swipe(emptyCellIndex, emptyCellIndex - 1));
        }
        if ((emptyCellIndex != 2) && (emptyCellIndex != 5) && (emptyCellIndex != 8)) {
            children.add(swipe(emptyCellIndex, emptyCellIndex + 1));
        }
        if ((emptyCellIndex + 3) < 9) {
            children.add(swipe(emptyCellIndex, emptyCellIndex + 3));
        }
        return children;
    }

    private void buildGrid() {
        int col = 0;
        int row = 0;
        for (int cell : nodeState) {
            if (col == 3) {
                col = 0;
                row++;
            }
            prettyState[row][col] = cell;
            col++;
        }
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(prettyState[0]));
        System.out.println(Arrays.toString(prettyState[1]));
        System.out.println(Arrays.toString(prettyState[2]));
        System.out.println("*********************************************");
    }

    private TreeNode swipe(int emptyCellIndex, int gotoIndex) {
        int[] childNodeState = nodeState.clone();
        childNodeState[emptyCellIndex] = childNodeState[gotoIndex];
        childNodeState[gotoIndex] = 0;
        return new TreeNodeState(childNodeState, gotoIndex, this.depth + 1);
    }

}
