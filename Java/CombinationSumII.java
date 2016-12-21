/*
 * Given a collection of candidate numbers (C) and a target number (T), find all 
 * unique combinations in 
 * C where the candidate numbers sums to T.

 * Each number in C may only be used once in the combination.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(res, list, num, 0, 0, target);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
            int[] num, int pos, int sum, int target) {
        if(sum == target)
            res.add(new ArrayList<Integer>(list));
        if(sum < target) {
            for(int i = pos; i < num.length; i++) {
                if(i > pos && num[i] == num[i - 1])
                    continue;
                list.add(num[i]);
                dfs(res, list, num, i + 1, sum + num[i], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
