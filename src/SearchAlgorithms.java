import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SearchAlgorithms {
    private final int MAXDEPTH = 20;
    public void BFS(TreeNode root){
        HashSet<String> exploredNodes = new HashSet<>();
        ArrayList<TreeNode> frontier = new ArrayList<>();
        frontier.add(root);
        while(!frontier.isEmpty()){
            TreeNode state = frontier.remove(0);
            setAsExplored(exploredNodes, state);
            state.print();
            System.out.println("Step: "+state.getDepth());
            if(state.isGoalState()){
                System.out.println("END");
                return;
            }
            ArrayList<TreeNode> children = state.getChildren();
            for (TreeNode child : children) {
               if(!isExplored(exploredNodes, child)) { //if not explored then it wasn't created before hence it is not in the queue
                   frontier.add(child);
               }
            }
        }
    }
    int st = 0;
    public void DFS(TreeNode root) {
        HashSet<String> exploredNodes = new HashSet<>();
        Stack<TreeNode> frontier = new Stack<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            TreeNode state = frontier.pop();
            setAsExplored(exploredNodes, state);
            state.print();
            System.out.println("Step: " + state.getDepth());
            if (state.isGoalState()) {
                System.out.println("END");
                return;
            }
            ArrayList<TreeNode> children = state.getChildren();
            for (TreeNode child : children) {
                if (!isExplored(exploredNodes, child)) { //if not explored then it wasn't created before hence it is not in the queue
                    frontier.add(child);
                }
            }
        }
    }


    public  void Euclidean_A_Star(TreeNode root){
        int initialCapacity = 1;
        PriorityQueue<TreeNode> frontier = new PriorityQueue<>(initialCapacity,new EuclideanComparator());
        HashSet<String> exploredNodes = new HashSet<>();
        frontier.add(root);
        while(!frontier.isEmpty()){
            TreeNode state = frontier.poll();
            exploredNodes.add(state.getStringRepresentation());
            state.print();
            System.out.println("Step: "+state.getDepth());
            if(state.isGoalState()){
                System.out.println("END");
                return;
            }
            if(!exploredNodes.contains(state.getStringRepresentation()) && !frontier.contains(state)) { //if not explored then it wasn't created before hence it is not in the queue
                setAsExplored(exploredNodes, state);
                ArrayList<TreeNode> children = state.getChildren();
                for (TreeNode child : children) {
                    frontier.add(child);
                }
            }
            else if(frontier.contains(state)){
                frontier.add(state);
            }
        }
    }

    public  void Manhattan_A_Star(TreeNode root){
        int initialCapacity = 1;
        PriorityQueue<TreeNode> frontier = new PriorityQueue<>(initialCapacity,new ManhattanComparator());
        HashSet<String> exploredNodes = new HashSet<>();
        frontier.add(root);
        while(!frontier.isEmpty()){
            TreeNode state = frontier.poll();
            exploredNodes.add(state.getStringRepresentation());
            state.print();
            System.out.println("Step: "+state.getDepth());
            if(state.isGoalState()){
                System.out.println("END");
                return;
            }
            if(!exploredNodes.contains(state.getStringRepresentation()) && !frontier.contains(state)) { //if not explored then it wasn't created before hence it is not in the queue
                setAsExplored(exploredNodes, state);
                ArrayList<TreeNode> children = state.getChildren();
                for (TreeNode child : children) {
                    frontier.add(child);
                }
            }
            else if(frontier.contains(state)){ // decrease the state distance in queue
                frontier.add(state);
            }
        }
    }

    public void setAsExplored(HashSet<String> exploredNodes, TreeNode state) {
        exploredNodes.add(state.getStringRepresentation());
    }

    public boolean isExplored(HashSet<String> exploredNodes, TreeNode state) {
        return exploredNodes.contains(state.getStringRepresentation());
    }

}
class EuclideanComparator implements Comparator<TreeNode> {
  public int compare(TreeNode t1, TreeNode t2) {
        if (t1.getDistanceByEuclidean() > t2.getDistanceByEuclidean())
            return 1;
        else if (t1.getDistanceByEuclidean() < t2.getDistanceByEuclidean())
            return -1;
        return 0;
    }
}

class ManhattanComparator implements Comparator<TreeNode> {
    public int compare(TreeNode t1, TreeNode t2) {
        if (t1.getDistanceByManhattan() > t2.getDistanceByManhattan())
            return 1;
        else if (t1.getDistanceByManhattan() < t2.getDistanceByManhattan())
            return -1;
        return 0;
    }
}
