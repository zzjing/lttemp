public List<Integer> findNodesWithZeroOrOneParent(int[][] edges) {
    Map<Integer, List<Integer>> childToParents = new HashMap<>();
    for (int[] edge : edges) {
        int parentNode = edge[0];
        int childNode = edge[1];
        if (!childToParents.containsKey(childNode)) {
            childToParents.put(childNode, new ArrayList<>());
        }
        if (!childToParents.containsKey(parentNode)) {
            childToParents.put(parentNode, new ArrayList<>());
        }
        childToParents.get(childNode).add(parentNode);
    }
    List<Integer> nodesWithZeroOrOneParent = new ArrayList<>();
    for (Integer child : childToParents.keySet()) {
        if (childToParent.get(child).size() <= 1) {
            nodesWithZeroOrOneParent.add(child);
        }
    }
    return nodesWithZeroOrOneParent;
}

public boolean hasCommonAncestor(int[][] edges, int p, int q) {
    Map<Integer, List<Integer>> childToParents = new HashMap<>();
    for (int[] edge : edges) {
        int parentNode = edge[0];
        int childNode = edge[1];
        if (!childToParents.containsKey(childNode)) {
            childToParents.put(childNode, new ArrayList<>());
        }
        if (!childToParents.containsKey(parentNode)) {
            childToParents.put(parentNode, new ArrayList<>());
        }
        childToParents.get(childNode).add(parentNode);
    }
    Set<Integer> commonAncestors = new HashSet<>();
    for (Integer child : childToParents.keySet()) {
        if (child == p || child == q) {
            for (Integer parent : childToParents.get(child)) {
                if (!commonAncestors.add(parent)) {
                    return true;
                }
            }
        }
    }
    return false;
}

