package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_Nodes_Distance_K_in_Binary_Tree_863 {
    private Integer targetVal;
    private Integer targetDistance;
    private Boolean targetIsLeft;
    private Map<Integer, List<Integer>> leftTreeNodeMap = new HashMap<>();
    private Map<Integer, List<Integer>> rightTreeNodeMap = new HashMap<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        targetVal = target.val;
        iteratorAllTree(root, 0, null);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        leftTreeNodeMap.put(0 , rootList);
        if (K == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(targetVal);
            return result;
        }
        int childIndex = targetDistance + K;
        int otherIndex = targetDistance - K;
        List<Integer> leftLeftRootTree = leftTreeNodeMap.getOrDefault(childIndex, new ArrayList<>());
        List<Integer> leftRightRootTree = rightTreeNodeMap.getOrDefault(childIndex, new ArrayList<>());
        List<Integer> rightLeftRootTree = leftTreeNodeMap.getOrDefault(otherIndex, new ArrayList<>());
        List<Integer> rightRightRootTree = rightTreeNodeMap.getOrDefault(otherIndex, new ArrayList<>());
        List<Integer> otherRootTree = new ArrayList<>();

        if (targetIsLeft != null) {
            if (targetDistance != 1 && targetDistance != -1) {
                int index = 0;
                if (targetDistance < 0) {
                    index = targetDistance + 1 - (K - 1) ;
                } else {
                    index = targetDistance - 1 + (K - 1);
                }
                if (index != 0 && K != 1) {
                    if (targetIsLeft) {
                        otherRootTree = rightTreeNodeMap.getOrDefault(index, new ArrayList<>());
                    } else {
                        otherRootTree = leftTreeNodeMap.getOrDefault(index, new ArrayList<>());
                    }
                }
            }
        }
        leftLeftRootTree.addAll(leftRightRootTree);
        leftLeftRootTree.addAll(rightLeftRootTree);
        leftLeftRootTree.addAll(rightRightRootTree);
        leftLeftRootTree.addAll(otherRootTree);
        return leftLeftRootTree;
    }

    private void iteratorAllTree(TreeNode root, int distance, Boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.val == targetVal) {
            targetDistance = distance;
            if (distance != 0 && isLeft != null) {
                targetIsLeft = isLeft;
            }
        }
        if (isLeft != null && isLeft) {
            List<Integer> list = leftTreeNodeMap.getOrDefault(distance, new ArrayList<>());
            list.add(root.val);
            leftTreeNodeMap.put(distance, list);
        } else if (isLeft != null) {
            List<Integer> list = rightTreeNodeMap.getOrDefault(distance, new ArrayList<>());
            list.add(root.val);
            rightTreeNodeMap.put(distance, list);
        }
        if (distance == 0) {
            iteratorAllTree(root.left, distance + 1, true);
            iteratorAllTree(root.right, distance - 1, false);
        } else if (distance > 0) {
            iteratorAllTree(root.left, distance + 1, true);
            iteratorAllTree(root.right, distance + 1, false);
        } else {
            iteratorAllTree(root.left, distance - 1, true);
            iteratorAllTree(root.right, distance - 1, false);
        }

    }

//    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        treeNode1.left = new TreeNode(3);
//        treeNode1.right = new TreeNode(2);
//        TreeNode treeNode = new TreeNode(0);
//        treeNode.left = treeNode1;
//
//        All_Nodes_Distance_K_in_Binary_Tree_863 All_Nodes_Distance_K_in_Binary_Tree_863 = new All_Nodes_Distance_K_in_Binary_Tree_863();
//        All_Nodes_Distance_K_in_Binary_Tree_863.distanceK(treeNode, new TreeNode(2), 1);
//    }
}
