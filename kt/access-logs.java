public String[][] findInvalidAccess(String[][] records) {
    Map<String, Integer> employeeToState = new HashMap<>(); // 1 - on campus, 0 off
    Set<String> noBadgeEntry = new HashSet<>();
    Set<String> noBadgeExit = new HashSet<>();
    for (String[] record : records) {
        String employee = record[0];
        String action = record[1];
        if (!employeeToState.containsKey(employee)) {
            employeeToState.put(employee, 0);
        }
        if (action.euqals("enter")) {
            if (employeeToState.get(employee) == 1) {
                noBadgeExit.add(employee);
            }
            employeeToState.put(employee, 1);
        } else {
            if (employeeToState.get(employee) == 0) {
                noBadgeEntery.add(employee);
            }
            employeeToState.put(employee, 0);
        }
    }
    return new String[][]{noBadgeEntry.toArray(noBadgeEntry.size()), noBadgeExit.toArray(noBadgeExit.size())};
}

public List<String> frequentAccess(String[][] keycardInfo) {
    Map<String, TreeSet<Integer>> nameToTimes = new HashMap<>();
    for (String[] keycard : keycardInfo) {
        String name = keycard[0];
        String time = keycard[1];
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(2));
        if (!nameToTimes.containsKey(name)) {
            nameToTimes.put(name, new TreeSet<>());
        }
        nameToTimes.get(name).add(hours + minutes);
    }
    Set<String> alertNames = new HashSet<>();
    for (String name : nameToTimes.keySet()) {
        List<Integer> sortedTimes = new ArrayList<>(nameToTimes.get(name));
        for (int i = 2; i < sortedTimes.size(); i++) {
            if (sortedTimes.get(i) - sortedTimes.get(i - 2) <= 60) {
                alertNames.add(name);
                break;
            }
        }
    }
    return new ArrayList<>(alertNames);
}

public Map<String, String[]> logFirstAndLastAccess(String[][] logs) {
    Map<String, String[]> userToAccess = new HashMap<>();
    for (String[] log : logs) {
        String accessTime = log[0];
        String user = log[1];
        if (!userToAccess.containsKey(user)) {
            userToAccess.put(user, new String[2]);
        }
        if (userToAccess.get(user)[0] == null &&
            userToAccess.get(user)[1] == null) {
            userToAccess.get(user)[0] = accessTime;
        } else if (userToAccess.get(user)[1] == null) {
            if (Integer.parseInt(accessTime) > Integer.parseInt(userToAccess.get(user)[0])) {
                userToAccess.get(user)[1] = accessTime;
            } else if (Integer.parseInt(accessTime) < Integer.parseInt(userToAccess.get(user)[0])) {
                userToAccess.get(user)[1] = userToAccess.get(user)[0];
                userToAccess.get(user)[0] = accessTime;
            }
        } else {
            if (Integer.parseInt(accessTime) < Integer.parseInt(userToAccess.get(user)[0])) {
                userToAccess.get(user)[0] = accessTime;
            } else if (Integer.parseInt(accessTime) > Integer.parseInt(userToAccess.get(user)[1])) {
                userToAccess.get(user)[1] = accessTime;
            }
        }
    }
    return userToAccess;
}

public String logMostAccess(String[][] logs) {
    Map<String, TreeSet<Integer>> resourceToTimes = new HashMap<>();
    for (String[] log : logs) {
        String accessTime = log[0];
        String resource = log[2];
        if (!resourceToTimes.containsKey(resource)) {
            resourceToTimes.put(resource, new TreeSet<>());
        }
        resourceToTimes.get(resource).add(Integer.parseInt(accessTime));
    }
    int maxAccess = 0;
    String maxResource = "";
    for (String resourceAccessed : resourceToTimes.keySet()) {
        List<Integer> accessTimes = new ArrayList<>(resourceToTimes.get(resourceAccessed));
        for (int i = 0; i < accessTimes.size(); i++) {
            int accesses = 0;
            int endTime = accessTimes.get(i) + 300;
            int j = i;
            while (accessTimes.get(j) <= endTime && j < accessTimes.size()) {
                accesses++;
                j++;
                if (accesses > maxAccess) {
                    maxResource = resource;
                }
            }
        }
    }
    return maxResource;
}