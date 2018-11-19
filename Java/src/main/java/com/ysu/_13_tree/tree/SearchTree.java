package com.ysu._13_tree.tree;

/**
 * @Author bing57592
 * @Date 2018-11-19 23:29
 */
public class SearchTree {
    public Node root;

    private SearchTree() {

    }


    public void insertNode(int value) {
        Node node = new Node(value);
        insertNode(node);
    }

    public void insertNode(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            root.insertNode(node);
        }
    }


    /**
     * 初始化一个搜索树
     *
     * @param value
     * @return
     */
    public static SearchTree initTree(int value) {
        SearchTree searchTree = new SearchTree();
        Node node = new Node(value);
        searchTree.root = node;
        return searchTree;
    }

    static class Node {
        public Node lChild;
        public Node rChild;
        public int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

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


    }


}
