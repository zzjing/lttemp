public List<Node> removeNodes(Node root, List<Node> nodesToRemove) {
    List<Node> results = new ArrayList<Node>();
    results.add(root);
    for(Node nodeToRemove : nodesToRemove) {
        for(Node root : results) {
            if (remveNode(root, null, nodeToRemove, results)) {
                break;
            }
        }
    }
    return results;
}


public bool removeNode(Node root, Node parent, Node nodeToRemove, List<Node> results) {
  if (parent == null) {
    return false;
  }
  
  if(root.value == nodeToRemove.value) {
    if (parent != null) {
      if (parent.left == root) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    } else {
      results.remove(root);
    }
    if (root.left != null) {
      results.add(root.left);
    }
    if (root.right != null) {
      results.add(root.right);
    }
    return true;
  }
  return removeNode(root.left, root, nodeToRemove, results) ||  removeNode(root.right, root, nodeToRemove, results);
}
