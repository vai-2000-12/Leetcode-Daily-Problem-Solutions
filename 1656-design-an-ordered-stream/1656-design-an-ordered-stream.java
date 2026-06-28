class OrderedStream {
    HashMap<Integer, String> map;
    int ptr;

    public OrderedStream(int n) {
        map = new HashMap<>();
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);

        List<String> result = new ArrayList<>();

        while (map.containsKey(ptr)) {
            result.add(map.get(ptr));
            ptr++;
        }

        return result;
    }
}