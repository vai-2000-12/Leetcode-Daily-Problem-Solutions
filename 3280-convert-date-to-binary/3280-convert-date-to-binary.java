class Solution {
    public String convertDateToBinary(String date) {
       String[] str = date.trim().split("-");
       ArrayList<String> lst = new ArrayList<>();
        
        for(int i = 0 ; i< str.length ; i++){
            lst.add(Integer.toBinaryString(Integer.parseInt(str[i])));
        }   

     return String.join("-", lst);
    }
}