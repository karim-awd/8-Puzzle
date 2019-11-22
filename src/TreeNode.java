import java.util.ArrayList;

public interface TreeNode {

    String getStringRepresentation ();

    int getDistanceByManhattan ();

    int getDistanceByEuclidean ();

    boolean isGoalState ();

    ArrayList<TreeNode> getChildren ();

    void print();
}
