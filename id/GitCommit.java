class GitNode {
    int id;
    List<GitNode> parents;
    public GitNode(int id) {
        this.id = id;
        parents = new ArrayList<>();
    }
}

public class GitCommit {
    public List<GitNode> findAllCommits(GitNode start) {
        List<GitNode> allCommits = new ArrayList<>();
        Queue<GitNode> bfsBuffer = new LinkedList<>();
        Set<GitNode> visited = new HashSet<>();
        bfsBuffer.offer(start);
        visited.add(start);
        // bfs by layers
        while (!bfsBuffer.isEmpty()) {
            GitNode current = bfsBuffer.poll();
            allCommits.add(current);
            for (GitNode next : current.parents) {
                if (!visited.contains(next) {
                    bfsBuffer.add(next);
                    visited.add(next);
                }
            }
        }
        return allCommits;
    }

    public GitNode findLCA(GitNode commit1, GitNode commit2) {
        if (commit1 == null || commit2 == null) {
            return null;
        }
        Queue<GitNode> bfsBuffer1 = new LinkedList<>();
        Set<GitNode> visited1 = new HashSet<>();
        Queue<GitNode> bfsBuffer2 = new LinkedList<>();
        Set<GitNode> visited2 = new HashSet<>();
        // int length1 = 1;
        // int length2 = 1;
        bfsBuffer1.offer(commit1);
        visited1.add(commit1);
        bfsBuffer2.offer(commit2);
        visited2.add(commit2);
        while (!bfsBuffer1.isEmpty() && !bfsBuffer2.isEmpty()) {
            int layerSize1 = bfsBuffer1.size();
            for (int i = 0; i < layerSize1; i++) {
                GitNode current1 = bfsBuffer1.poll();
                for (GitNode next1 : current1.parents) {
                    if (visited2.contains(next1)) {
                        return next1;
                    }
                    if (!visited1.contains(next1)) {
                        bfsBuffer1.offer(next1);
                        visited1.add(next1);
                    }
                }
            }
            int layerSize2 = bfsBuffer2.size();
            for (int j = 0; j < layerSize2; j++) {
                GitNode current2 = bfsBuffer2.poll();
                for (GitNode next2 : current2.parents) {
                    if (visited1.contains(next2)) {
                        return next2;
                    }
                    if (!visited2.contains(next2)) {
                        bfsBuffer2.offer(next2);
                        visited2.add(next2);
                    }
                }
            }
        }
        return null;
    }
}
