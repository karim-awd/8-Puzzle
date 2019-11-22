import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SearchAlgorithms {
    private final int MAXDEPTH = 100;
    public void BFS(TreeNode root){
        ArrayList<TreeNode> frontier = new ArrayList<>();
        root.setAsExplored();
        frontier.add(root);
        HashSet<TreeNode> inQueue = new HashSet<>();
        while(!frontier.isEmpty()){
            TreeNode state = frontier.remove(0);
            //state.print();
            inQueue.add(state);
            if(state.isGoalState()){
                return;
            }
            if(!state.isExplored()) { //if not explored then it wasn't created before hence it is not in the queue
                ArrayList<TreeNode> children = state.getChildren();
                for (TreeNode child : children) {
                    //could check if it is in queue or not
                    frontier.add(child);
                    inQueue.add(state);
                }
            }
        }
    }
    public void DFS(TreeNode state, int depth){
        if(state.isGoalState()){
            return;
        }
        if(!state.isExplored()) {
            //state.print();
            state.setAsExplored();
            ArrayList<TreeNode> children = state.getChildren();
            for (TreeNode child : children){
                if(depth < MAXDEPTH) {
                    DFS(child, depth + 1);
                }
            }
        }
    }
    public static void A_Star(TreeNode root){
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>();

    }
}
