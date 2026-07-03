class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

       for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = Character.toLowerCase(word.charAt(0));

            if (isVowel(first)) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }

            sb.append("ma");

            // Add 'a' i+1 times
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
    public boolean isVowel(char c){
        if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
            return true;
        }
        return false;
    }
}