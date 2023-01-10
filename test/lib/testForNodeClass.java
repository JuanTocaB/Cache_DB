package lib;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class testForNodeClass {

    public node<String> testingNode = new node<String>("HelloWorld");
    node<String> nextNode = new node<String>("nextNode");
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
        node<String> nextNodeTestingNode = testingNode.getNextNode();
        assertEquals(nextNode, nextNodeTestingNode);
    }

}
