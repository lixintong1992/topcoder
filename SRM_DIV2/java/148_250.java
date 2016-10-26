public class DivisorDigits {
    public int howMany(int number) {
        int result = 0, temp = number;
        while ( temp != 0){
            if ( temp % 10 != 0 ){
                if ( number % ( temp % 10) == 0) result++;
            }
            temp /= 10;
        }
        return result;
    }
}
