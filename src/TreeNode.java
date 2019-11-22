public interface TreeNode {

    void setExploredState (boolean exploredState);

    boolean isExplored ();

    int getManhattanDistance ();

    int getEuclideanDistance ();

    boolean isGoalState (TreeNode root);

    TreeNode getChildren (TreeNode node);


}
