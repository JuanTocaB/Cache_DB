package Cache_DB.lib;

public class BinaryTreeNode<T extends Comparable<T>> {

    private TreeNode<T> rootNode;

    public BinaryTreeNode(){}

    public boolean isItEmpty() {return rootNode == null;}
    public int treeSize() {
        if (rootNode == null) return 0;
        return getAmountOfNodes(rootNode);

    }

    private int getAmountOfNodes(TreeNode<T> currentNode){
        if (currentNode == null) return 0;
        return getAmountOfNodes(currentNode.getLeftNode()) + getAmountOfNodes(currentNode.getRightNode()) + 1;

    }

    public Object[] listAllNodesData() {
        if (rootNode == null) return new Object[0];
        Object[] result = new Object[getAmountOfNodes(rootNode)];
        getNodeData(rootNode, result, 0);
        return result;

    }

    private int getNodeData(TreeNode<T> currentNode, Object[] arrayToFill, int nodeIndex) {
        if (currentNode == null) return 0;
        int leftNodes = getNodeData(currentNode.getLeftNode(), arrayToFill, nodeIndex);
        arrayToFill[nodeIndex + leftNodes] = currentNode.getNodeData();
        int rightNodes = getNodeData(currentNode.getRightNode(), arrayToFill, nodeIndex + leftNodes + 1);
        return 1 + leftNodes + rightNodes;

    }

    public TreeNode<T> dataSearch(T data) {
        if (rootNode == null) return null;
        return searchDataInTree(rootNode, data);

    }

    private TreeNode<T> searchDataInTree(TreeNode<T> currentNode, T data) {
        if (currentNode == null) return null;
        if (data.compareTo(currentNode.getNodeData()) == 0) return currentNode;
        if (data.compareTo(currentNode.getNodeData()) < 0) return searchDataInTree(currentNode.getLeftNode(), data);
        else return searchDataInTree(currentNode.getRightNode(), data);

    }

    public TreeNode<T> getRootNode(){return rootNode;}

    private void addNode(TreeNode<T> currentNode, TreeNode<T> nodeToAdd) {
        if (nodeToAdd.getNodeData().compareTo(currentNode.getNodeData()) == 0) {
            currentNode.setNodeData(nodeToAdd.getNodeData());

        }
        if(nodeToAdd.getNodeData().compareTo(currentNode.getNodeData()) < 0) {
            if(currentNode.getLeftNode() == null) {
                currentNode.setLeftNode(nodeToAdd);

            } else {addNode(currentNode.getLeftNode(), nodeToAdd);}

        } else {
            if(currentNode.getRightNode() == null) {
                currentNode.setRightNode(nodeToAdd);

            } else {addNode(currentNode.getRightNode(), nodeToAdd);}

        }
    }

    public void add(T data) {
        TreeNode<T> newNodeToAdd = new TreeNode<>(data);
        if(rootNode == null) {rootNode = newNodeToAdd;}
        else {addNode(rootNode, newNodeToAdd);}

    }

    public void removeNode(T data) {
        TreeNode<T> nodeRemove = dataSearch(data);
        if(nodeRemove == null) return;
        TreeNode<T> nodeParent = searchParent(nodeRemove);

        if (nodeRemove.getLeftNode() != null && nodeRemove.getRightNode() != null) {
            removeNodeWithTwoChildren(nodeParent, nodeRemove);

        } else {
            removeNodeWithZeroOrOneChild(nodeParent, nodeRemove);

        }
    }

    private void removeNodeWithZeroOrOneChild(TreeNode<T> parentNode, TreeNode<T> childNode){
        TreeNode<T> replacementChild = childNode.getLeftNode() !=null ?
                childNode.getLeftNode() : childNode.getRightNode();

        if (parentNode != null) {
            if (parentNode.getLeftNode() == childNode) {parentNode.setLeftNode(replacementChild);}
            else if (parentNode.getRightNode() == childNode) {parentNode.setRightNode(replacementChild);}

        } else {rootNode = replacementChild;}

    }

    private void removeNodeWithTwoChildren(TreeNode<T> parentNode, TreeNode<T> childNode) {
        TreeNode<T> replacementChild = findMostLeftNode(childNode.getRightNode());
        removeNodeWithZeroOrOneChild(searchParent(replacementChild), replacementChild);

        replacementChild.setLeftNode(childNode.getLeftNode());
        replacementChild.setRightNode(childNode.getRightNode());

        if (parentNode != null) {
            if (parentNode.getLeftNode() == childNode) {parentNode.setLeftNode(replacementChild);}
            else if (parentNode.getRightNode() == childNode) {parentNode.setRightNode(replacementChild);}

        } else {rootNode = replacementChild;}
    }

    private TreeNode<T> findMostLeftNode(TreeNode<T> currentNode) {
        if (currentNode.getLeftNode() == null) return currentNode;
        return findMostLeftNode(currentNode);

    }

    private TreeNode<T> searchParent(TreeNode<T> childNode) {return searchNodeParent(rootNode, childNode);}

    private TreeNode<T> searchNodeParent(TreeNode<T> currentNode, TreeNode<T> childNode) {
        if (currentNode == null) return null;
        if (currentNode.getRightNode() == childNode || currentNode.getLeftNode() == childNode) return currentNode;
        if (childNode.getNodeData().compareTo(currentNode.getNodeData()) < 0) {
            return searchNodeParent(currentNode.getLeftNode(), childNode);

        } else return searchNodeParent(currentNode.getRightNode(), childNode);

    }

}
