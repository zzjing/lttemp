
Map<Userid, Map<Job, List<Step>>> userToJobs;

// Add step
public void addStep(Userid id, Job job, Step step) {
    if (userToJobs.containsKey(id)) {
        Map<Job, List<Step>> jobToSteps = userToJobs.get(id);
        if (jobToSteps.containsKey(job)) {
            jobToSteps.get(job).add(step);
        } else {
            // add job, step to Map
        }
    } else {
        // add id, job, step to Map
    }
}

public void complete(Userid id, Job job) {
    if (userToJobs.containsKey(id)) {
        Map<Job, List<Step>> jobToSteps = userToJobs.get(id);
        if (jobToSteps.containsKey(job)) {
            jobToSteps.get(job).remove(0);
            if (jobToSteps.get(job).size() == 0) {
                jobToSteps.delete(job);
            }
        }
    }
}

public void expire(Job job) {
    for (Userid user : userToJobs.keySet()) {
        Map<Job, List<Step>> jobToSteps = userToJobs.get(user);
        if (!jobToSteps.containsKey(job)) {
            return;
        } else {
            jobToSteps.delete(job); // jobToSteps.get(job) = new ArrayList<>();
        }
    }
}
