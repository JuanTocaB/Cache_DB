package lib;

public class nodeForTree<dt> {

    private dt NodeData;
    private nodeForTree<dt> LeftNode;
    private nodeForTree<dt> RightNode;

    public nodeForTree(dt nodeData) {NodeData = nodeData;}

    public nodeForTree<dt> getLeftNode() {return LeftNode;}

    public nodeForTree<dt> getRightNode() {return RightNode;}

    public void setLeftNode(nodeForTree<dt> leftNode) {LeftNode = leftNode;}

    public void setRightNode(nodeForTree<dt> rightNode) {RightNode = rightNode;}

    public dt getNodeData() {return NodeData;}

    public void setNodeData(dt nodeData) {NodeData = nodeData;}
}
