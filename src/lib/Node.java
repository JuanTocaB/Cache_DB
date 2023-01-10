package lib;

public class Node<T> {

    private T NodeData;
    private Node<T> NextNode;

    public Node(T nodeData) {NodeData = nodeData;}

    public void setNodeData(T newData) {NodeData = newData;}

    public void setNextNode(Node<T> nextNode) {NextNode = nextNode;}

    public Node<T> getNextNode() {return NextNode;}

    public T getNodeData() {return NodeData;}

}
