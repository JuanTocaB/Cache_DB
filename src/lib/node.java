package lib;

public class node<dt> {

    private dt NodeData;
    private node<dt> NextNode;

    public node(dt nodeData) {NodeData = nodeData;}

    public void setNodeData(dt newData) {NodeData = newData;}

    public void setNextNode(node<dt> nextNode) {NextNode = nextNode;}

    public node<dt> getNextNode() {return NextNode;}

    public dt getNodeData() {return NodeData;}

}
