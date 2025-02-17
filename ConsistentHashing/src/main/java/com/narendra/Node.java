package com.narendra;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final String id;
    private final Map<String, String> keysMap;

    public Node(String id) {
        this.id = id;
        keysMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void addKey(String key, String value) {
        keysMap.put(key, value);
    }

    public void removeKey(String key) {
        keysMap.remove(key);
    }

    public String get(String key) {
        return keysMap.get(key);
    }

    public Map<String, String> getKeysMap() {
        return keysMap;
    }

    public String toString() {
        return "Node:" + this.id;
    }
}
