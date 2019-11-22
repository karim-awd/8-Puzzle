import java.util.ArrayList;

public interface TreeNode {

    void setExploredState (boolean exploredState);

    boolean isExplored ();

    int getManhattanDistance ();

    int getEuclideanDistance ();

    boolean isGoalState ();

    ArrayList<TreeNode> getChildren ();
}
