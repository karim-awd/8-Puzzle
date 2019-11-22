import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TreeNodeState implements TreeNode {

    private int emptyCellIndex ;
    private int [] nodeState;
    private String strRepresentation;
    private HashSet<String> exploredNodes = new HashSet<>();

    public TreeNodeState (int []nodeState, int emptyCellIndex){
        this.emptyCellIndex = emptyCellIndex;
        this.nodeState = nodeState;
        this.strRepresentation= Arrays.toString(nodeState);
    }

    @Override
    public void setAsExplored() {
        exploredNodes.add(strRepresentation);
    }

    @Override
    public boolean isExplored() {
        return exploredNodes.contains(strRepresentation);
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
        return false;
    }

    @Override
    public ArrayList<TreeNode> getChildren() {
        ArrayList<TreeNode> children = new ArrayList<>();
        if ( (emptyCellIndex - 3) > 0){
            children.add(swipe (emptyCellIndex, emptyCellIndex-3));
        }
        if ( (emptyCellIndex!=0) && (emptyCellIndex!=3) && (emptyCellIndex!=6)){
            children.add(swipe (emptyCellIndex, emptyCellIndex-1));
        }
        if ( (emptyCellIndex!=2) && (emptyCellIndex!=5) && (emptyCellIndex!=8)){
            children.add(swipe (emptyCellIndex, emptyCellIndex+1));
        }
        if ( (emptyCellIndex + 3) <9){
            children.add(swipe (emptyCellIndex, emptyCellIndex+3));
        }
        return children;
    }

    private TreeNode swipe(int emptyCellIndex, int gotoIndex) {
        int [] childNodeState = nodeState.clone();
        childNodeState[emptyCellIndex] = childNodeState[gotoIndex];
        childNodeState[gotoIndex] = 0;
        return new TreeNodeState(childNodeState, gotoIndex);
    }

}
