package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();

        nodeQueue.add(root);
        valQueue.add(root.val);

        int sum=0;

        while (!nodeQueue.isEmpty()){
            TreeNode now = nodeQueue.poll();
            Integer val = valQueue.poll();
            if(now.left==null && now.right==null){
                //叶子结点
                sum+=val;
            }
            if (now.left!=null){
                nodeQueue.add(now.left);
                valQueue.add(val*10);
            }
            if (now.right!=null){
                nodeQueue.add(now.left);
                valQueue.add(val*10);
            }
        }
        return sum;
    }
}
