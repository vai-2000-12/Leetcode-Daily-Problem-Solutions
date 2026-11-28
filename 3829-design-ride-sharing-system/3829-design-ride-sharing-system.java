
import java.util.*;

class RideSharingSystem {

    TreeMap<Integer, Integer> riderMap;
    TreeMap<Integer, Integer> driverMap;

    int driverID;
    int rID;

    public RideSharingSystem() {

        riderMap = new TreeMap<>();
        driverMap = new TreeMap<>();

        driverID = 0;
        rID = 0;
    }

    public void addRider(int riderId) {

        riderMap.put(rID, riderId);
        rID++;
    }

    public void addDriver(int driverId) {

        driverMap.put(driverID, driverId);
        driverID++;
    }

    public int[] matchDriverWithRider() {

        if (riderMap.isEmpty() || driverMap.isEmpty()) {
            return new int[]{-1, -1};
        }

        int driver = driverMap.firstEntry().getValue();
        int rider = riderMap.firstEntry().getValue();

        driverMap.pollFirstEntry();
        riderMap.pollFirstEntry();

        return new int[]{driver, rider};
    }

    public void cancelRider(int riderId) {

        for (Integer key : riderMap.keySet()) {

            if (riderMap.get(key) == riderId) {
                riderMap.remove(key);
                return;
            }
        }
    }
}
