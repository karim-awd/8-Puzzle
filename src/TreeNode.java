import java.util.ArrayList;

public interface TreeNode {

    void setAsExplored ();

    boolean isExplored ();

    int getManhattanDistance ();

    int getEuclideanDistance ();

    boolean isGoalState ();

    ArrayList<TreeNode> getChildren ();
}
