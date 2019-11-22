import java.util.ArrayList;
import java.util.HashSet;

public class SearchAlgorithms {
    public static void BFS(TreeNode root){
        ArrayList<TreeNode> frontier = new ArrayList<>();
        frontier.add(root);
        HashSet<TreeNode> explored = new HashSet<>();

        while(!frontier.isEmpty()){
            TreeNode state = frontier.remove(0);
            explored.add(state);
            //state.setExploredState();
        }
    }
    public static void DFS(TreeNode root){
        //Queue<TreeNode> frontier = new Que
    }
    public static void A_Star(TreeNode root){
        //Queue<TreeNode> frontier = new Que
    }
}
