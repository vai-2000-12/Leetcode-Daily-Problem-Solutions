class AuthenticationManager {
    HashMap<String, Integer> map;
    int expireTime;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        this.expireTime = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId)){
            int time = map.get(tokenId);
        
        if(currentTime < time + expireTime){
                map.put(tokenId, currentTime);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
          int count = 0;

        for(int time : map.values()){
            if(currentTime < time + expireTime){
                count++;
            }
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */