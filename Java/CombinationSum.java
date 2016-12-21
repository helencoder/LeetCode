/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where
 * the candidate numbers sums to T.

 * The same repeated number may be chosen from C unlimited number of times.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(res, list, candidates, 0, 0, target);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
            int[] num, int pos, int sum, int target) {
        if(sum == target)
            res.add(new ArrayList<Integer>(list));
        if(sum < target) {
            for(int i = pos; i < num.length; i++) {
                list.add(num[i]);
                dfs(res, list, num, i, sum + num[i], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
