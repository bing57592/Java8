package com.ysu._13_tree;

import com.ysu._13_tree.tree.SearchTree;

/**
 * @Author bing57592
 * @Date 2018-11-19 23:03
 */
public class Node {
    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    /**
     * 左儿子
     */
    public Node lChild;
    /**
     * 右儿子
     */
    public Node rChild;


    /**
     * 树中保存的值
     */
    public int value;

    public void insertNode(Node node) {

        /**
         * 如果节点已经存在, 直接返回.
         */
        if (this.value == node.value) return;

        /**
         * 如果想要插入的节点值 < 当前节点值, 则插入左子树
         */
        if (node.value < this.value) {
            //判断左子树是否为空, 如果为空, 直接插入
            if (this.lChild == null) {
                this.lChild = node;
                return;
            } else {// 左子树不为空, 对左子树进行插入
                this.lChild.insertNode(node);
            }
        }
        /**
         * 如果想要插入的节点值 > 当前节点值, 则插入右子树
         */
        if (node.value > this.value) {
            if (this.rChild == null) {
                this.rChild = node;
                return;
            } else {// 左子树不为空, 对右子树进行插入
                this.rChild.insertNode(node);
            }
        }

    }

    public static void main(String[] args) {
        SearchTree searchTree = SearchTree.initTree(40);
        searchTree.insertNode(1234);
        searchTree.insertNode(14);
        searchTree.insertNode(88);
        searchTree.insertNode(5);
        searchTree.insertNode(12);
        searchTree.insertNode(99);
    }
}
