import java.util.ArrayList;

public interface TreeNode {

    String getStringRepresentation ();

    int getManhattanDistance ();

    int getEuclideanDistance ();

    boolean isGoalState ();

    ArrayList<TreeNode> getChildren ();
}
