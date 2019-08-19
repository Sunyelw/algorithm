package com.sun.yelw.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.binary
 * 类名称:     BinarySearchTree
 * 类描述:     二叉搜索树
 * 创建人:     huangyang
 * 创建时间:   2019/7/21 10:01
 */
public class BinarySearchTree {

    // 前序
    private final static int PRE_ORDER = 1;
    // 中序
    private final static int IN_ORDER = 2;
    // 后序
    private final static int POST_ORDER = 3;

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        int[] daArr = {7, 4, 2, 3, 6, 9, 8, 10};

        Node tree = bst.init(daArr);
        bst.print(tree, IN_ORDER);

        System.out.println();

        List<Node> nList = bst.search(tree, 4);
        nList.forEach(System.out::println);

    }

    // 树 删除
    private void deleteNode(Node tree, int dat) {

        if (dat < 2) return;
        // TODO 使用左子树的最大节点
        Node p = prevNode(tree);

        // TODO 使用右子树的最小节点


    }

    // 右子树最小节点
    private Node rightMin(Node tree) {
        if (tree.right == null) return null;
        Node p = tree.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    // 左子树最大节点
    private Node leftMax(Node tree) {
        if (tree.left == null) return null;
        Node p = tree.left;
        while (p.right != null)
            p = p.right;
        return p;
    }

    // 前驱
    private Node prevNode(Node node) {

        Node p = leftMax(node);
        if (null == p) {
            Node pp = node.parent;
            if (node == pp.left) {
                // left
                while (pp != null) {
                    p = pp;
                    pp = pp.parent;
                }
            } else {
                // right
                p = pp;
            }
        }
        return p;
    }

    // 后继
    private Node nextNode(Node node) {
        return null;
    }

    // 树 - 遍历
    private void print(Node tree, int flag) {
        if (PRE_ORDER == flag) {
            // 前序 mid left right
            if (tree == null) return;
            System.out.println(tree.data);
            print(tree.left, 1);
            print(tree.right, 1);

//            if (null != tree) {
//                System.out.println(tree.data);
//                if (tree.right != null) {
//                    print(tree.right, 1);
//                } else {
//                    print(tree.left, 1);
//                }
//            }
        } else if (IN_ORDER == flag) {
            // 中序 left mid right
            if (tree == null) return;
            print(tree.left, 2);
            System.out.println(tree.data);
            print(tree.right, 2);

//            if (null != tree.left) {
//                print(tree.left, 2);
//                System.out.println(tree.data);
//            } else {
//                System.out.println(tree.data);
//            }
//            if (null != tree.right) print(tree.right, 2);
        } else if (POST_ORDER == flag) {
            // 后序 left right mid
            if (tree == null) return;
            print(tree.left, 3);
            print(tree.right, 3);
            System.out.println(tree.data);

//            if (null != tree.left) {
//                if (null != tree.right) {
//                    print(tree.left, 3);
//                    print(tree.right, 3);
//                }
//                System.out.println(tree.data);
//            } else {
//                System.out.println(tree.data);
//            }

//                        if (null == tree.right && null == tree.left) {
//                System.out.println(tree.data);
//            } else {
//                if (null != tree.left) {
//                    print(tree.left, 3);
//                    if (null != tree.right) print(tree.right, 3);
//                    else  System.out.println(tree.data);
//                }
//            }
        }
    }

    // 树 - 查找 -- 有重复数据的节点的情况
    private List<Node> search(Node tree, int data) {

        List<Node> nList = new ArrayList <>();
        while (null != tree) {
            if (tree.data == data) {
                nList.add(tree);
                // 需要继续遍历其右子树找相同数据的节点
            }
            else if (tree.data > data) tree = tree.left;
            else tree = tree.right;
        }
        return nList;
    }

    // 树 - 插入 - 重复数据插入右子树
    private void insert(Node tree, int data) {
        Node n = new Node(data);
        while (tree.left != n && tree.right != n) {
            if (tree.data > data) {
                if (null == tree.left) tree.left = n;
                else tree = tree.left;
            } else {
                // 这里包含等于的情况
                if (null == tree.right) tree.right = n;
                else tree = tree.right;
            }
        }
    }

    // 树 - 删除 - 三种情况
    private int delete(Node tree, int data) {

        if (null == tree) return 0;

        int re;
        List<Node> nList = search(tree, data);
        // 父节点
        Node pp = null;
        // 树中遍历节点: n != p
        Node p = tree;
        for (Node n : nList) {
            // 先找父节点
            while (null != p && n != p) {
                pp = p;
                if (tree.data > data) p = p.left;
                else p = p.right;
            }

            if (null == n.left && null == n.right) {
                // 这颗树只有一个根节点，删除树就没了
                if (null == pp) re = -1;
                else if (pp.data > n.data) pp.left = null;
                else pp.right = null;
            } else if (null == n.right) {
                // 只有左子树
                if (null == pp) {
                    n.left = null;
                    re = 1;
                } else if (pp.data > n.data) {
                    pp.left = findNode(n, 1);
                } else {
                    pp.right = findNode(n, 1);
                }
            } else {
                // 右子树存在的情况，肯定取右子树最小的值
                Node right = findNode(n, 2);
                if (null == pp) {
                    right.left = findNode(p.left, 1);
                    right.right = findNode(p.right, 2);
                } else if (pp.data > n.data) {
                    pp.left = right;
                } else {
                    pp.right = right;
                }
            }
        }

        return 0;
    }

    // left max
    // right min
    private Node findNode(Node p, int flag) {

        if (flag == 1) {
            // left tree max node
            p = p.left;
            while (null != p.right) p = p.right;
        } else {
            // right tree min node
            p = p.right;
            while (null != p.left) p = p.left;
        }
        return p;
    }

    // 树的初始化
    private Node init(int[] daArr) {
        if (null == daArr || daArr.length == 0) {
            return null;
        }
        Node tree = new Node(daArr[0]);

        Node tmp, p;
        for (int i = 1; i < daArr.length; i++) {
            p = tree;
            tmp = new Node(daArr[i]);
            while (true) {
                if (tmp.data > p.data) {
                    // 比根节点大，右子树
                    if (null == p.right) {
                        p.right = tmp;
                        break;
                    } else {
                        p = p.right;
                    }
                } else {
                    // 比根节点小，左子树
                    if (null == p.left) {
                        p.left = tmp;
                        break;
                    } else {
                        p = p.left;
                    }
                }
            }
        }
        return tree;
    }

    /**
     * 树中节点对象
     * data 实际对象
     * left 左子树
     * right 右子树
     */
    class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int data) {
            this.data = data;
        }
    }
}
