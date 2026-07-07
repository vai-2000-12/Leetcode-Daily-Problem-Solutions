class ParkingSystem {
    ArrayList<Integer> lst;
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        lst = new ArrayList<>();
        lst.add(big);        
        lst.add(medium);        
        lst.add(small);        
    }
    
    public boolean addCar(int carType) {
       int index = carType-1;
        if (lst.get(index) > 0) {
            lst.set(index, lst.get(index) - 1);
            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */