package com.github.jumpbyte.practice.tree;

/**
 * @author yuanjinan
 */
public class AVLTree01<T extends Comparable<T>> {

    private AVLTreeNode<T> root;  //根节点

    //获取树的高度
    private int height(AVLTreeNode node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    public int height() {
        return height(root);
    }

    //比较两个节点的值的大小
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    //LL的旋转代码
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;
        //把根节点的左子节点保存下来
        k1 = k2.left;
        //把左子节点的右子树放到原先根节点的左子节点
        k2.left = k1.right;
        //随后 将原先的根节点放在其左子节点的右子节点  将其变成根节点
        k1.right = k2;
        //改变两个节点的高度的值
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    //RR的旋转代码
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2;
        //把根节点的右子节点保存下来
        k2 = k1.right;
        //把右子节点的左子树放到原先根节点的右子节点
        k1.right = k2.left;
        //随后  将原先的根节点放在其左子节点的右子节点  将其变成根节点
        k2.left = k1;
        //改变两个节点的高度的值
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        return k2;
    }

    //LR的旋转代码
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        //首先对根节点的左子树进行RR的旋转
        k3.left = rightRightRotation(k3.left);
        //然后对根节点k3进行LL的旋转
        return leftLeftRotation(k3);
    }

    //RL的旋转代码
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k3) {
        //首先对根节点的右子树进行LL的旋转
        k3.left = leftLeftRotation(k3.right);
        //然后对根节点k3进行RR的旋转
        return rightRightRotation(k3);
    }

    //插入节点
    private AVLTreeNode<T> insert(AVLTreeNode<T> node, T value) {
        if (node == null) {
            //新建节点
            node = new AVLTreeNode<T>(value, null, null);
        } else {
            int cmp = value.compareTo(node.value);
            if (cmp < 0) { //应该将value插入到左子树的情况
                node.left = insert(node.left, value);
                //插入节点后  若AVL树失去平衡 则进行相应的调节
                if (height(node.left) - height(node.right) > 1) {
                    //然后递归退回到当某个节点的左右子树的高度不平衡的那个节点
                    //因为插入操作是在之前执行的  所以 该插入节点一定位于高度不平衡的节点的左子节点内
                    if (value.compareTo(node.left.value) < 0) {
                        //说明应该进行LL旋转
                        node = leftLeftRotation(node);
                    } else {
                        node = leftRightRotation(node);
                    }
                }
            } else if (cmp > 0) { //应该添加到右子树的情况
                node.right = insert(node.right, value);
                //插入节点后  若AVL树失去平衡  则进行相应的调节
                if (height(node.right) - height(node.left) > 1) {
                    if (value.compareTo(node.right.value) > 0) {
                        node = rightRightRotation(node);
                    } else {
                        node = rightLeftRotation(node);
                    }
                }
            } else {  //cmp=0
                System.out.println("添加失败  不允许添加相同的节点");
            }
        }
        node.height = max(height(node.left), height(node.right));
        return node;
    }

    //对添加方法进行重载
    public void insert(T value) {
        root = insert(root, value);
    }

    /**
     * 删除AVL树中的节点
     *
     * @param node    AVL树的根节点
     * @param delNode 待删除的节点
     * @return 删除以后的根节点
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> node, AVLTreeNode delNode) {
        //如果根节点为空  或者没有要删除的节点 直接返回null
        if (node == null || delNode == null) {
            return null;
        }
        //判断要删除的节点位于左子树还是右子树
        int cmp = delNode.value.compareTo(node.value);
        if (cmp < 0) { //说明待删除的节点在左子树
            node.left = remove(node.left, delNode); //递归进行删除
            //删除节点后 若AVL树失去平衡 则进行相应的调节
            if (height(node.right) - height(node.left) > 1) {
                //这里要进行判断是进行哪一种旋转  因为我们不确定现在这个节点的右子树的子节点哪个高度高使得不平衡
                AVLTreeNode<T> r = node.right;
                if (height(r.left) > height(r.right)) {
                    node = rightLeftRotation(node);
                } else {
                    node = rightRightRotation(node);
                }
            }
        } else if (cmp > 0) { //说明待删除的节点在右子树
            node.right = remove(node.right, delNode);
            //删除节点后 若AVL树失去平衡  则进行相应的调节
            if (height(node.right) - height(node.left) > 1) {
                AVLTreeNode r = node.right;
                if (height(r.left) > height(r.right)) {
                    node = leftLeftRotation(node);
                } else {
                    node = leftRightRotation(node);
                }
            }
        } else { //当前节点就是要删除的节点
            //tree的左右孩子都非空
            if (node.left != null && node.right != null) {
                if (height(node.left) > height(node.right)) {
                    //如果tree的左子树比右子树高
                    //则找出当前节点所对应的树的右子树的最小节点
                    //将该节点的值赋值给当前节点  删除该最小节点
                    AVLTreeNode<T> min = delRightTreeMin(node.right);
                    node.value = min.value;
                    node.right = remove(node.right, min);
                }
            } else {
                AVLTreeNode<T> temp = node;
                node = (node.left != null) ? node.left : node.right;
                temp = null;
            }
        }
        return node;
    }

    //重载一下删除方法
    public void remove(T value) {
        AVLTreeNode<T> node;
        //这里最好进行一下判断  先去查找  如果查找不为空  则在进行删除
        if ((node = search(root, value)) != null) {
            root = remove(root, node);
        }
    }

    /**
     * @param node 传入的节点(当作树的根节点) 这里传入的应该是要删除节点的右子节点
     * @return 返回以node为根节点的树的最小节点的值
     */
    public AVLTreeNode delRightTreeMin(AVLTreeNode node) {
        AVLTreeNode target = node;
        //循环的查找左子节点 就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        return target;

    }

    //前序遍历AVL树
    private void prreOrder(AVLTreeNode node) {
        System.out.println(node.value);
        if (node.left != null) {
            prreOrder(node.left);
        }
        if (node.right != null) {
            prreOrder(node.right);
        }
    }

    //中序遍历AVL树
    private void infixOrder(AVLTreeNode node) {
        if (node.left != null) {
            infixOrder(node.left);
        }
        System.out.println(node);
        if (node.right != null) {
            infixOrder(node.right);
        }
    }

    //对中序进行重载
    public void infixOrder() {
        if (root != null) {
            infixOrder(root);
        } else {
            System.out.println("当前AVL树为空 无法遍历");
        }
    }

    //对前序进行重载
    public void preOrder() {
        if (root != null) {
            prreOrder(root);
        } else {
            System.out.println("当前AVL树为空 无法遍历");
        }
    }

    /**
     * 递归实现查找AVL树中值为key的节点
     *
     * @param node
     * @param value
     * @return
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            return search(node.left, value);
        } else if (cmp > 0) {
            return search(node.right, value);
        } else {
            return node;
        }
    }

    //对查找进行重载
    public AVLTreeNode<T> search(T value) {
        return search(root, value);
    }
}
