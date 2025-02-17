package com.narendra;

public class ConsistentHashingSimulator {

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing(3);

        Node node1 = new Node("127.0.0.1");
        Node node2 = new Node("127.0.0.2");
        Node node3 = new Node("127.0.0.3");

        consistentHashing.addNode(node1);
        consistentHashing.addKey("Name", "Narendra");

        consistentHashing.addNode(node2);
        consistentHashing.addKey("Age", "30");

        consistentHashing.addNode(node3);
        consistentHashing.addKey("gender", "Male");

        consistentHashing.printRing();

        consistentHashing.removeNode(node1);
        consistentHashing.printRing();
    }
}
