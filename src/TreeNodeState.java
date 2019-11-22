import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TreeNodeState implements TreeNode {

    private int emptyCellIndex;
    private int[] nodeState;
    private String strRepresentation;
    private String goalState = "[0, 1, 2, 3, 4, 5, 6, 7, 8]";

    public TreeNodeState(int[] nodeState, int emptyCellIndex) {
        this.emptyCellIndex = emptyCellIndex;
        this.nodeState = nodeState;
        this.strRepresentation = Arrays.toString(nodeState);
    }


    @Override
    public String getStringRepresentation() {
        return strRepresentation;
    }

    @Override
    public int getManhattanDistance() {
        return 0;
    }

    @Override
    public int getEuclideanDistance() {
        return 0;
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

    @Override
    public void print() {
        int row = 0;
        int col = 0;
        int[][] prettyState = new int[3][3];
        for (int cell : nodeState) {
            if (row == 3) {
                row = 0;
                col++;
            }
            prettyState[col][row] = cell;
            row++;
        }

        System.out.println(Arrays.toString(prettyState[0]));
        System.out.println(Arrays.toString(prettyState[1]));
        System.out.println(Arrays.toString(prettyState[2]));
        System.out.println("*********************************************");
    }

    private TreeNode swipe(int emptyCellIndex, int gotoIndex) {
        int[] childNodeState = nodeState.clone();
        childNodeState[emptyCellIndex] = childNodeState[gotoIndex];
        childNodeState[gotoIndex] = 0;
        return new TreeNodeState(childNodeState, gotoIndex);
    }

}
