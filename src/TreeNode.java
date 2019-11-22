import java.util.ArrayList;

public interface TreeNode {

    String getStringRepresentation ();

    int getDistanceByManhattan ();

    int getDistanceByEuclidean ();

    int getDepth();

    boolean isGoalState ();

    ArrayList<TreeNode> getChildren ();

    void print();
}
