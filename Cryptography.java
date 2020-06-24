public class Cryptography {
    public long encrypt(int[] numbers){
        long ans = 0;
        long temp = 1;

        for(int i=0; i < numbers.length; ++i){
            numbers[i] += 1;

            for(int j=0; j < numbers.length; ++j) {
                temp *= numbers[j];

            }

            numbers[i] -= 1;

            ans = Math.max(ans, temp);
            temp = 1;
        }

        System.out.println(ans);
        return ans;
    }
}
