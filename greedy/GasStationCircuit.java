
public class GasStationCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            return -1;
        }
        int start = 0;
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += (gas[i] - cost[i]); // gas left if we move
            // cannot reach the next station, move on to the next
            if (tank < 0) {
                start = i + 1;
                tank = 0; // start over
            }
        }
        // attempt to visit all stations, no gas left
        if (sumGas < sumCost) {
            return -1;
        } else { // there is a station exists (but where?)
            return start;
        }
    }
}
