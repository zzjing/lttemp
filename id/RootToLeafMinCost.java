// Given a tree,(binary tree possibily) every tree edge has a cost， find the least
// cost or find the leaf node that the cost of path that from root to leaf is the least.

class Edge {
    Node2 node; // where this edge's tails points (destination)
    int cost;
    public Edge(Node2 n, int cost) {
        this.node = n;
        this.cost = cost;
    }
}
class Node2 {
    List<Edge> edges; // all edges originating from Node2
    public Node2() {
        this.edges = new ArrayList<>();
    }
}

public class RootToLeftMinCost {
    int minCost = Integer.MAX_VALUE;
    // Map<Node2, Integer> distance = new HashMap<>();
    // gets all edges from the minCost path
    public List<Edge> getMinPath(Node2 root) {
        List<Edge> minPaths = new ArrayList<>();
        List<Edge> temp = new ArrayList<>();
        dfs(minPaths, temp, root, 0); // root - start point
        return minPaths;
    }

    // dfs with backtracking
    private void dfs(List<Edge> minPaths, List<Edges> temp, Node2 root, int currentCost) {
        if (root == null) {
            return;
        }
        if (root.edges.size() == 0) { // reaches the end
            if (currentCost < minCost) {
                minCost = currentCost;
                minPaths.clear();
                minPaths.addAll(temp);
                return;
            }
        }
        for (Edge e : root.edges) {
            Node2 next = e.node;
            temp.add(e);
            dfs(minPaths, temp, next, currentCost + e.cost);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    // gets only the min cost, same DFS
    public int getMinCost(Node2 root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return minCost;
    }
    private void helper(Node2 root, int currentCost) {
        if (root.edges.size() == 0) { // reaches the end
            minCost = Math.min(minCost, currentCost);
            return;
        }
        for (Edge e : root.edges) {
            Node2 next = e.node;
            helper(next, currentCost + e.cost);
        }
    }

    // followup: tree becomes DAG
    int minCost = Integer.MAX_VALUE;
    Map<Node2, Integer> dist = new HashMap<>();
    public List<Edge> getMinPathInGraph(Node2 root){
        List<Edge> res = new ArrayList<>();
        List<Edge> temp = new ArrayList<>();
        dfsInGraph(res, temp, root, 0);
        return res;
    } O(V + E)
    public void dfsInGraph(List<Edge> res, List<Edge> temp, Node2 node, int curCost){
        if (node == null) {
            return;
        }
        if (dist.containsKey(node) && curCost >= dist.get(node)) {
            return;
        }
        dist.put(node, curCost);
        if (node.edges.size() == 0) {
            if (curCost < minCost) {
                minCost = curCost;
                res.clear();
                res.addAll(temp);
            }
            return;
        }

        for (Edge e : node.edges) {
            Node2 next = e.node;
            temp.add(e);
            dfsInGraph(res, temp, next, curCost + e.cost);
            temp.remove(temp.size() - 1);
        }
    }
}

    public List<Edge> getMinPathInGraph(Node2 root){
        int minCost = Integer.MAX_VALUE;
        Node2 resNode = null;
        List<Edge> res = new ArrayList<>();
        Map<Node2, Integer> dist = new HashMap<>();
        Map<Node2, Node2> findPar = new HashMap<>();
        PriorityQueue<Node2> pq = new PriorityQueue<>(new Comparator<Node2>() {
            @Override
            public int compare(Node2 o1, Node2 o2) {
                return dist.get(o1) - dist.get(o2);
            }
        });

        dist.put(root, 0);
        findPar.put(root, null);
        pq.offer(root);
        while (!pq.isEmpty()){
            Node2 cur = pq.poll();
            int d = dist.get(cur);
            if (cur.edges.size() == 0){
                int curCost = dist.get(cur);
                if (curCost < minCost){
                    minCost = curCost;
                    resNode = cur;
                }
            }
            for (Edge e : cur.edges) {
                Node2 next = e.node;
                int tempD = e.cost + d;
                if (!dist.containsKey(next)){
                    dist.put(next, tempD);
                    findPar.put(next, cur);
                    pq.offer(next);
                }
                else {
                    if (tempD < dist.get(next)){
                        pq.remove(next);
                        dist.put(next, tempD);
                        findPar.put(next, cur);
                        pq.offer(next);
                    }
                }
            }
        }

       //下面都是为了输出所有的边才写的，就是把所有的node都抓出来，然后去找连接的边
        List<Node2> tempList = new ArrayList<>();
        while (resNode != null){
            tempList.add(0, resNode);
            resNode = findPar.get(resNode);
        }
        for (int i = 0; i < tempList.size()-1; i++){
            Node2 cur = tempList.get(i);
            for (Edge e : cur.edges) {
                if (e.node.equals(tempList.get(i+1))){
                    res.add(e);
                }
            }
        }
        return res;
    }
