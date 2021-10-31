public boolean canSchedule(int[][] meetings, int start, int end) {
    int[] newMeeting = new int[]{start, end};
    for (int[] meeting : meetings) {
        if (checkOverlap(newMeeting, meeting)) {
            return false;
        }
    }
    return true;
}

private boolean checkOverlap(int[] meetingA, int[] meetingB) {
    int lateStart = Math.max(meetingA[0], meetingB[0]);
    int earlyEnd = Math.min(meetingA[1], meetingB[1]);
    return lateStart < earlyEnd;
}

public List<int[]> getAvailableSlots(List<int[]> meetings) {
    List<int[]> freeTimes = new ArrayList<>();
    Collections.sort(meetings, (a, b) -> (a.get(0) - b.get(0)));
    int[] previous = meetings.get(0);
    freeTimes.add(new int[]{0, previous[0]});
    for (int i = 1; i < meetings.size(); i++) {
        int[] current = meetings.get(i);
        if (!checkOverlap(previous, current)) {
            freeTimes.add(new int[]{previous[1], current[0]});
            previous = current;
        } else {
            previous[1] = Math.max(previous[1], current[1]);
            meetings.remove(i);
            i--;
        }
    }
    return freeTimes;
}

private boolean checkOverlap(int[] meetingA, int[] meetingB) {
    int lateStart = Math.max(meetingA[0], meetingB[0]);
    int earlyEnd = Math.min(meetingA[1], meetingB[1]);
    return lateStart <= earlyEnd;
}