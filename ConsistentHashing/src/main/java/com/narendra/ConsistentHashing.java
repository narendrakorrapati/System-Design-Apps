package com.narendra;

import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashing {
    private static final int RING_SIZE = Integer.MAX_VALUE;
    private TreeMap<Integer, Node> ring = new TreeMap<>();
    private final int numReplicas;

    public ConsistentHashing(int numReplicas) {
        this.numReplicas = numReplicas;
    }

    public int hash(String key) {
        return Math.abs(key.hashCode()) % RING_SIZE;
    }

    public void addNode(Node node) {
        for(int i = 0; i < numReplicas; i ++) {
            int position = hash(node.getId() + "#" + i);
            ring.put(position, node);
        }
    }

    public void removeNode(Node node) {
        for(int i = 0; i < numReplicas; i ++) {
            int position = hash(node.getId() + "#" + i);
            ring.remove(position);
        }
        //Remap all keys to new Node.
        Map<String, String> keysToReMap = node.getKeysMap();

        for(String key : keysToReMap.keySet()) {
            addKey(key, keysToReMap.get(key));
        }
    }

    public void addKey(String key, String value) {
        Node node = getNodeForKey(key);
        node.addKey(key, value);
    }

    public void removeKey(String key) {
        Node node = getNodeForKey(key);
        node.removeKey(key);
    }

    public Node getNodeForKey(String key) {
        int position = hash(key);
        Map.Entry<Integer, Node> clockwiseNextNode = ring.ceilingEntry(position);

        if(clockwiseNextNode == null) {
            clockwiseNextNode = ring.firstEntry();
        }
        return clockwiseNextNode.getValue();
    }

    public void printRing() {

        for(Map.Entry<Integer, Node> entry : ring.entrySet()) {
            System.out.println("Hash:" + entry.getKey() + " Node:" + entry.getValue().toString() + " keys:" + entry.getValue().getKeysMap());
        }
    }
}
