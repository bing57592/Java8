package com.ysu._00_common.bean;

/**
 * 定义
 *
 * @Author bing57592
 * @Date 2018-11-05 20:23
 */
public class Node {

    public Node(Integer value) {
        this.value = value;
    }

    public Node() {
    }

    /**
     * 左子节点
     */
    Node leftChild;
    /**
     * 右子节点
     */
    Node rightChild;
    /**
     * 在当前节点中保存的数据.
     */
    Integer value;


    public void insertLeft(Node root, Node current) {
        if (root.leftChild != null) {
            
        }
    }

    /**
     * 向当前树中添加一个节点.
     *
     * @param node
     * @return
     */
    public Node insert(Node node) {
        if (this.leftChild.value > node.value) {

        }

        return this;
    }
}
