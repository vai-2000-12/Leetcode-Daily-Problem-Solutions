class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        int missingTypes = 0;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasDigit) missingTypes++;

        // Collect lengths of repeating-character runs (length >= 3)
        List<Integer> repeatGroups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && password.charAt(j) == password.charAt(i)) j++;
            int len = j - i;
            if (len >= 3) repeatGroups.add(len);
            i = j;
        }

        if (n < 6) {
            // Insertions can fix both length and missing types simultaneously
            return Math.max(6 - n, missingTypes);
        } else if (n <= 20) {
            int replaceCount = 0;
            for (int len : repeatGroups) replaceCount += len / 3;
            return Math.max(replaceCount, missingTypes);
        } else {
            int deleteCount = n - 20;
            int remainingDelete = deleteCount;

            // Use deletions on groups where len % 3 == 0 first (cheapest: 1 deletion saves 1 replace)
            for (int idx = 0; idx < repeatGroups.size() && remainingDelete > 0; idx++) {
                int len = repeatGroups.get(idx);
                if (len % 3 == 0) {
                    int reduce = Math.min(remainingDelete, 1);
                    repeatGroups.set(idx, len - reduce);
                    remainingDelete -= reduce;
                }
            }
            // Then groups where len % 3 == 1 (2 deletions save 1 replace)
            for (int idx = 0; idx < repeatGroups.size() && remainingDelete > 0; idx++) {
                int len = repeatGroups.get(idx);
                if (len % 3 == 1 && len > 2) {
                    int reduce = Math.min(remainingDelete, 2);
                    repeatGroups.set(idx, len - reduce);
                    remainingDelete -= reduce;
                }
            }
            // Remaining deletions: chip away at any group >=3, 3 deletions save 1 replace
            int replaceCount = 0;
            for (int len : repeatGroups) {
                if (len >= 3 && remainingDelete > 0) {
                    int reduce = Math.min(remainingDelete, len - 2);
                    len -= reduce;
                    remainingDelete -= reduce;
                }
                if (len >= 3) replaceCount += len / 3;
            }

            return deleteCount + Math.max(replaceCount, missingTypes);
        }
    }

    // FIX: this was counting only letters and checking count>=6 && count<=20,
    // but the condition is about total password LENGTH, not letter count.
    public boolean containsCharacterInRange(String s) {
        int n = s.length();
        return n >= 6 && n <= 20;
    }

    public boolean checkHaveAtLeastOneLAndU(String s) {
        int n = s.length();
        int lowercase = 0;
        int uppercase = 0;
        int digit = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                lowercase++;
            } else if (Character.isUpperCase(c)) {
                uppercase++;
            } else if (Character.isDigit(c)) {
                digit++;
            }
        }
        return lowercase >= 1 && uppercase >= 1 && digit >= 1;
    }
}