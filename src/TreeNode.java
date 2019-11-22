public interface TreeNode {

    void setExploredState (boolean exploredState);

    boolean isExplired();

    int getSCoreToNode ();

    boolean isGoalState (TreeNode r);


}
