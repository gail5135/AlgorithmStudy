public class InterestingParty {
    public int bestInvitation(String[] first, String[] second){
        int ans = 0;


        for(int i = 0; i < first.length; ++i){
            int f = 0;
            int s = 0;
            for(int j = 0; j < second.length; ++j){
                if(first[i].equals(first[j])){
                    f++;
                }
                if(first[i].equals(second[j])){
                    f++;
                }
                if(second[i].equals(second[j])){
                    s++;
                }
                if(second[i].equals(first[j])) {
                    s++;
                }
            }
            ans = Math.max(ans, f);
            ans = Math.max(ans, s);
        }

        System.out.println(ans);
        return ans;
    }
}
