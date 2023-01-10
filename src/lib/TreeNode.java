package lib;

public class TreeNode<T> {

    private T NodeData;
    private TreeNode<T> LeftNode;
    private TreeNode<T> RightNode;

    public TreeNode(T nodeData) {NodeData = nodeData;}

    public TreeNode<T> getLeftNode() {return LeftNode;}

    public TreeNode<T> getRightNode() {return RightNode;}

    public void setLeftNode(TreeNode<T> leftNode) {LeftNode = leftNode;}

    public void setRightNode(TreeNode<T> rightNode) {RightNode = rightNode;}

    public T getNodeData() {return NodeData;}

    public void setNodeData(T nodeData) {NodeData = nodeData;}
}
