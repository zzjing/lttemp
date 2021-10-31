public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> subdomainToCount = new HashMap<>();
    for (String cpdomain : cpdomains) {
        int spaceIndex = cpdomain.indexOf(' ');
        int visitCount = Integer.valueOf(cpdomain.substring(0, spaceIndex));
        String domainName = cpdomain.substring(spaceIndex + 1);
        for (int i = 0; i < domainName.length(); i++) {
            char current = domainName.charAt(i);
            if (current == '.') {
                String subdomainName = domainName.substring(i + 1);
                if (!subdomainToCount.containsKey(subdomainName)) {
                    subdomainToCount.put(subdomainName, visitCount);
                } else {
                    subdomainToCount.put(subdomainName, subdomainToCount.get(subdomainName) + visitCount);
                }
            }
        }
        if (!subdomainToCount.containsKey(domainName)) {
            subdomainToCount.put(domainName, visitCount);
        } else {
            subdomainToCount.put(domainName, subdomainToCount.get(domainName) + visitCount);
        }
    }
    List<String> visits = new ArrayList<>();
    for (String subdomain : subdomainToCount.keySet()) {
        visits.add(subdomainToCount.get(subdomain) + " " + subdomain);
    }
    return visits;
}

public String longestCommonContinuousSubarray(String[] texts1, String[] texts2) {
    int[][] longestContinuousMemo = new int[texts1.length + 1][text2.length + 1];
    int maxLen = 0;
    String[] maxLenSubarray = "";
    for (int i = 1; i <= texts1.length; i++) {
        for (int j = 1; j <= texts2.length; j++) {
            if (texts1[i - 1].equals(texts2[j - 1])) {
                longestContinuousMemo[i][j] = longestContinuousMemo[i - 1][j - 1] + 1;
                if (longestContinuousMemo[i][j] > maxLen) {
                    maxLen = longestContinuousMemo[i][j];
                    maxLenSubarray = Arrays.asList(texts1).subList(i - maxLen, i).toArray(new String[maxLen]);
                }
            }
        }
    }
    return maxLenSubarray;
}

public int longestCommonSubsequence(String text1, String text2) {
    int[][] memoLCS = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 1; i <= text1.length(); i++) {
        for (int j = 1; j <= text2.length(); j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                memoLCS[i][j] = memoLCS[i - 1][j - 1] + 1;
            } else {
                memoLCS[i][j] = Math.max(memoLCS[i - 1][j], memoLCS[i][j - 1]);
            }
        }
    }
    return memoLCS[text1.length()][text2.length()];
}

public List<String> adsConversionRate(String[] completedPurchaseUsers, String[] adClicks, String[] allUserIPs) {
    Set<String> completedPurchaseIds = new HashSet<>(completedPurchaseUsers);
    Map<String, String[]> adToConversion = new HashMap<>();
    Map<String, String> ipToUserId = new HashMap<>();
    for (String userIpPair : allUserIPs) {
        String[] userAndIp = userIpPair.split(",");
        ipToUserId.put(userAndIp[1], userAndIp[0]);
    }
    for (String clicksInfo : adClicks) {
        String[] parsedClicks = clicksInfo.split(",");
        String ip = parsedClicks[0];
        String ad = parsedClicks[2];
        if (!adToConversion.containsKey(ad)) {
            adToConversion.put(ad, new int[]{0, 1});
        } else {
            adtoConversion.get(ad)[1]++;
        }
        if (ipToUserId.containsKey(ip) && completedPurchaseIds.contains(ipToUserId.get(ip))) {
            adToConversion.get(ad)[0]++;
        }
    }
    List<String> adConvRate = new ArrayList<>();
    for (String ad : adToConversion.keySet()) {
        adConvRate.add(adToConversion.get(ad)[0] + " of " + adToConversion.get(ad)[1] + " " + ad);
    }
    return adConvRate;
}