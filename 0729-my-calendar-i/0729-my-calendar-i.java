class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {

        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int count = 0;

        for (int val : map.values()) {
            count += val;

            if (count > 1) {
                map.put(startTime, map.get(startTime) - 1);
                map.put(endTime, map.get(endTime) + 1);

                return false;
            }
        }

        return true;
    }
}