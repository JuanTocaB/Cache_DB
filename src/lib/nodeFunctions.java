package lib;

public class nodeFunctions {
    public nodeFunctions(){}

    public <dt> node<dt> getbottomNode(node<dt> firstNode) {
        return getSelectedNode(getAmountOfNodes(firstNode),firstNode);
    }

    public <dt> int getAmountOfNodes(node<dt> firstNode) {
        int numberOfNodes = 0;
        while (firstNode != null) {
            firstNode = firstNode.getNextNode();
            numberOfNodes++;
        }
        return numberOfNodes;
    }

    public <dt> node<dt> getSelectedNode(int nodeNumber, node<dt> firstNode) {
        if (nodeNumber < 0) throw new IndexOutOfBoundsException();
        int numberOfNodes = 0;
        while(numberOfNodes < nodeNumber) {
            firstNode = firstNode.getNextNode();
            if (firstNode == null) throw new IndexOutOfBoundsException();
            numberOfNodes++;
        }
        return firstNode;
    }

    public <dt> Object[] getDataFromAllNodes(node<dt> firstNode) {
        int size = getAmountOfNodes(firstNode);
        Object[] nodeDataList = new Object[size];
        int nodeNumber = 0;
        while (firstNode != null) {
            nodeDataList[nodeNumber] = firstNode.getNodeData();
            firstNode = firstNode.getNextNode();
            nodeNumber++;
        }
        return nodeDataList;
    }
}
