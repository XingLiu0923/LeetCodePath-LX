import java.util.ArrayList;
import java.util.List;

public class Q39_test1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int i) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(path);
            res.add(newList);
            return;
        }
        for (int j = i; j< candidates.length; j++) {
            path.add(candidates[j]);
            dfs(res, path, candidates, target - candidates[j], j);
            path.remove(path.size() - 1);
        }
    }
}
