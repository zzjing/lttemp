// implement expire(long jobid)
// isExpired(long jobid)
// c.f. parking lot leetcode

class JobStorage {
    Set<Long> validJobs;
    // Map<Long, Boolean> record;
    public JobIdStorage(List<Long> jobids) {
        validJobs = new HashSet<>(); // or can pass jobids in
        // record = new HashMap<>();
        for (Long id : jobids) {
            validJobs.add(jobids);
            // record.put(id, true);
        }
    }

    public void expire(long jobid) {
        if (validJobs.contains(jobid)) {
            validJobs.remove(jobid);
            // record.put(jobid, false);
        }
    }

    public boolean isExpired(long jobid) {
        return validJobs.contains(jobid);
        // return record.get(jobid);
    }
} // Time O(n); Space O(n)
