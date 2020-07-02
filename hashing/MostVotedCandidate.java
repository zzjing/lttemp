import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVotedCandidate {
    public String findMostVoted(List<Vote> votes, long deadline) {
        if (votes == null || votes.size() == 0) {
            return "";
        }
        Map<String, Integer> pplToVotes = new HashMap<>();
        int mostVoted = -1;
        String winner = "";
        for (Vote vt : votes) {
            String candidate = vt.name;
            double time = vt.timestamp;
            if (!pplToVotes.containsKey(candidate) && time < deadline) {
                pplToVotes.put(candidate, 1);
            } else if (time < deadline) {
                pplToVotes.put(candidate, pplToVotes.get(candidate) + 1);
            }
            if (pplToVotes.get(candidate) > mostVoted) {
                mostVoted = pplToVotes.get(candidate);
                winner = candidate;
            }
        }
        return winner;
    }

    public List<String> findTopKLeaders(List<Vote> votes, long deadline, int k) {
        if (votes == null || votes.size() == 0) {
            return new ArrayList<>();
        }
        List<String> topKleaders = new ArrayList<>();
        Map<String, Integer> leaderToVotes = new HashMap<>();
        for (Vote vt : votes) {
            String candidate = vt.name;
            double time = vt.timestamp;
            if (!leaderToVotes.containsKey(candidate) && time < deadline) {
                pplToVotes.put(candidate, 1);
            }
            if (leaderToVotes.containsKet(candidate) && time < deadline) {
                pplToVotes.put(candidate, leaderToVotes.get(candidate) + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> kMost =
            new PriorityQueue<>(k, (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<String, Integer> leadVote : leaderToVotes) {
            kMost.add(leadVote);
        }
        for (int i = 0; i < k; i++) {
            topKleaders.add(kMost.remove());
        }
        return topKleaders;
    }
}
