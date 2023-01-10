package lib;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class testForNodeClass {

    public Node<String> testingNode = new Node<String>("HelloWorld");
    Node<String> nextNode = new Node<String>("nextNode");
    @Test
    public void testGetData() {
        String testString = "HelloWorld";
        String testingNodeData = testingNode.getNodeData();
        assertEquals(testString, testingNodeData);
    }
    @Test
    public void testSetData() {
        String newString = "helloWorld";
        testingNode.setNodeData(newString);
        assertEquals(newString, testingNode.getNodeData());
    }

    @Test
    public void testGetAndSetNextNode() {
        testingNode.setNextNode(nextNode);
        Node<String> nextNodeTestingNode = testingNode.getNextNode();
        assertEquals(nextNode, nextNodeTestingNode);
    }

}
