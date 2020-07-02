import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ItineraryRecovery {
    // have to use global variable due to scope/object issues
    private Map<String, PriorityQueue<String>> airGraph;
    private List<String> itinerary;
    public List<String> findItinerary(String[][] tickets) {
        itinerary = new ArrayList<String>();
        if (tickets == null || tickets.length <= 0) {
            return itinerary;
        }
        // construct the graph with the lowest lexical-order 
        airGraph = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            String depart = tickets[i][0];
            String destin = tickets[i][1];
            if (!airGraph.containsKey(depart)) {
                airGraph.put(depart, new PriorityQueue<String>());
                airGraph.get(depart).offer(destin);
            } else {
                airGraph.get(depart).offer(destin);
            }
        }
        dfsGraph("JFK");
        return itinerary;
    }

    private void dfsGraph(String start) {
        PriorityQueue<String> destinations = airGraph.get(start);
        // cases that we should continue to dfs
        while (destinations != null && !destinations.isEmpty()) {
            String current = airGraph.get(start).poll();
            dfsGraph(current);
        } // add to the head for the correct topological order
        itinerary.add(0, start); // be aware *when to add the airport*! 
    }
}
