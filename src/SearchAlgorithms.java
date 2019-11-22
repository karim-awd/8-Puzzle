import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SearchAlgorithms {
    private final int MAXDEPTH = 100;

    public void BFS(TreeNode root){
        HashSet<String> exploredNodes = new HashSet<>();
        ArrayList<TreeNode> frontier = new ArrayList<>();
        frontier.add(root);
        HashSet<TreeNode> inQueue = new HashSet<>();
        while(!frontier.isEmpty()){
            TreeNode state = frontier.remove(0);
            state.print();
            inQueue.add(state);
            if(state.isGoalState()){
                System.out.println("END");
                return;
            }
            if(!isExplored(exploredNodes, state)) { //if not explored then it wasn't created before hence it is not in the queue
                setAsExplored(exploredNodes, state);
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
        HashSet<String> exploredNodes = new HashSet<>();
        if(state.isGoalState()){
            System.out.println("END");
            return;
        }
        if(!isExplored(exploredNodes, state)) {
            //state.print();
            System.out.println(state.getStringRepresentation());
            setAsExplored(exploredNodes, state);
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

    public void setAsExplored(HashSet<String> exploredNodes, TreeNode state) {
        exploredNodes.add(state.getStringRepresentation());
    }

    public boolean isExplored(HashSet<String> exploredNodes, TreeNode state) {
        return exploredNodes.contains(state.getStringRepresentation());
    }

}
