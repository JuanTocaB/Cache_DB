package lib;

public class binaryTreeNodes <dt extends Comparable<dt>> {

    private nodeForTree<dt> rootNode;

    public binaryTreeNodes(){}

    public boolean isItEmpty() {return rootNode == null;}
    public int treeSize() {
        if (rootNode == null) return 0;
        return getAmountOfNodes(rootNode);

    }

    public int getAmountOfNodes(nodeForTree<dt> currentNode){
        if (currentNode == null) return 0;
        return getAmountOfNodes(currentNode.getLeftNode()) + getAmountOfNodes(currentNode.getRightNode()) + 1;

    }

    public Object[] listAllNodesData() {
        if (rootNode == null) return new Object[0];
        Object[] result = new Object[getAmountOfNodes(rootNode)];
        getNodeData(rootNode, result, 0);
        return result;

    }

    private int getNodeData(nodeForTree<dt> currentNode, Object[] arrayToFill, int nodeIndex) {
        if (currentNode == null) return 0;
        int leftNodes = getNodeData(currentNode.getLeftNode(), arrayToFill, nodeIndex);
        arrayToFill[nodeIndex + leftNodes] = currentNode.getNodeData();
        int rightNodes = getNodeData(currentNode.getRightNode(), arrayToFill, nodeIndex + leftNodes + 1);
        return 1 + leftNodes + rightNodes;

    }

    public nodeForTree<dt> dataSearch(dt data) {
        if (rootNode == null) return null;
        return searchDataInTree(rootNode, data);

    }

    private nodeForTree<dt> searchDataInTree(nodeForTree<dt> currentNode, dt data) {
        if (currentNode == null) return null;
        if (data.compareTo(currentNode.getNodeData()) == 0) return currentNode;
        if (data.compareTo(currentNode.getNodeData()) < 0) return searchDataInTree(currentNode.getLeftNode(), data);
        else return searchDataInTree(currentNode.getRightNode(), data);

    }

    public nodeForTree<dt> getRootNode(){return rootNode;}

    private void addNode(nodeForTree<dt> currentNode, nodeForTree<dt> nodeToAdd) {
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

    public void add(dt data) {
        nodeForTree<dt> newNodeToAdd = new nodeForTree<>(data);
        if(rootNode == null) {rootNode = newNodeToAdd;}
        else {addNode(rootNode, newNodeToAdd);}

    }

    public void removeNode(dt data) {
        nodeForTree<dt> nodeRemove = dataSearch(data);
        if(nodeRemove == null) return;
        nodeForTree<dt> nodeParent = searchParent(nodeRemove);

        if (nodeRemove.getLeftNode() != null && nodeRemove.getRightNode() != null) {
            removeNodeWithTwoChildren(nodeParent, nodeRemove);

        } else {
            removeNodeWithZeroOrOneChild(nodeParent, nodeRemove);

        }
    }

    private void removeNodeWithZeroOrOneChild(nodeForTree<dt> parentNode, nodeForTree<dt> childNode){
        nodeForTree<dt> replacementChild = childNode.getLeftNode() !=null ?
                childNode.getLeftNode() : childNode.getRightNode();

        if (parentNode != null) {
            if (parentNode.getLeftNode() == childNode) {parentNode.setLeftNode(replacementChild);}
            else if (parentNode.getRightNode() == childNode) {parentNode.setRightNode(replacementChild);}

        } else {rootNode = replacementChild;}

    }

    private void removeNodeWithTwoChildren(nodeForTree<dt> parentNode, nodeForTree<dt> childNode) {
        nodeForTree<dt> replacementChild = findMostLeftNode(childNode.getRightNode());
        removeNodeWithZeroOrOneChild(searchParent(replacementChild), replacementChild);

        replacementChild.setLeftNode(childNode.getLeftNode());
        replacementChild.setRightNode(childNode.getRightNode());

        if (parentNode != null) {
            if (parentNode.getLeftNode() == childNode) {parentNode.setLeftNode(replacementChild);}
            else if (parentNode.getRightNode() == childNode) {parentNode.setRightNode(replacementChild);}

        } else {rootNode = replacementChild;}
    }

    private nodeForTree<dt> findMostLeftNode(nodeForTree<dt> currentNode) {
        if (currentNode.getLeftNode() == null) return currentNode;
        return findMostLeftNode(currentNode);

    }

    private nodeForTree<dt> searchParent(nodeForTree<dt> childNode) {return searchNodeParent(rootNode, childNode);}

    private nodeForTree<dt> searchNodeParent(nodeForTree<dt> currentNode, nodeForTree<dt> childNode) {
        if (currentNode == null) return null;
        if (currentNode.getRightNode() == childNode || currentNode.getLeftNode() == childNode) return currentNode;
        if (childNode.getNodeData().compareTo(currentNode.getNodeData()) < 0) {
            return searchNodeParent(currentNode.getLeftNode(), childNode);

        } else return searchNodeParent(currentNode.getRightNode(), childNode);

    }
    
}
