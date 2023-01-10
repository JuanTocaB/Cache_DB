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
        Object[] result = new Object[getAmountOfNodes()]
    }
}
