class Stream {
    Iterator<Integer> iterator;
    public Stream(List<Integer> list) {
        this.iterator = list.iterator();
    }

    public boolean move() {
        return iterator.hasNext();
    }

    public int getValue() {
        return iterator.next();
    }
}

class Num {
    int value;
    Stream stream; // keeps track of which stream it comes from
    public Num(Stream stream) {
        this.stream = stream;
        this.value = stream.getValue(); // next value in the stream
    }
}

// iterator version - optional
class Data {
    int value;
    Iterator iterator;
    public Data(Iterator iterator) {
        this.iterator = iterator;
        this.value = iterator.next();
    }
}

class MergeKSortedStreams {
    public List<Integer> getNumberInAtLeastKStreams(List<Stream> streamList, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Num> minHeap = new PriorityQueue<>((a, b) -> (a.value - b.value));
        for (Stream oneStream : streamList) {
            if (oneStream.move()) {
                minHeap.offer(new Num(oneStream));
            }
        }

        while (!minHeap.isEmpty()) {
            Num current = minHeap.poll();
            int currentValue = current.value;
            int freqCount = 1; // for current min: wants to calculate whether it occurs at least k times
            // check duplicates and skip them, dedup
            while (current.stream.move()) {
                int nextValue = current.stream.getValue();
                if (nextValue == currentValue) {
                    continue; // skips all duplicate values since only last one occurence in a stream counts
                } else {
                    current.value = nextValue; // updates current.value field but keeps smallest current
                    minHeap.offer(current);
                    break;
                }
            }
            // checks other streams, since sorted, can count frequency
            // or minHeap.size() < k, can exit immediately, dedup
            while (!minHeap.isEmpty() && currentValue == minHeap.peek().value) {
                freqCount++; // finish counting and remove
                Num headNum = minHeap.poll(); // serves as a head which equals to smallest current
                while (headNum.stream.move()) {
                    int headNextValue = headNum.stream.getValue();
                    if (currentValue == headNextValue) {
                        continue;
                    } else {
                        headNum.val = headNextValue;
                        minHead.offer(headNum);
                        break;
                    }
                }
            }
            if (freqCount >= k) {
                result.add(currentValue);
            }
        }
        return result;
    }
}
// Time O(n logm) m = list number, n total number of nodes; Space O(m) m number of streams
