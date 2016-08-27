import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayanguo on 8/27/16.
 */

/*
Description:
Given number n. Print number from 1 to n. But:

when number is divided by 3, print "fizz".
when number is divided by 5, print "buzz".
when number is divided by both 3 and 5, print "fizz buzz".
 */
public class FizzBuzz {

    private static final String FIZZ_BUZZ = "fizz buzz";
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public List<String> getResult() {
        return result;
    }

    private List<String> result = new ArrayList<>();

    public void print(int num){
        for (int i =1; i<=num; i ++ ){
            if(i%15 == 0){
                result.add(FIZZ_BUZZ);
            }else if ( i % 3 == 0) {
                result.add(FIZZ);
            }else if (i % 5 == 0) {
                result.add(BUZZ);
            }else {
                result.add(i+"");
            }
        }
    }

    public static void main (String args[]) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.getResult());
        fizzBuzz.print(50);
        System.out.println(fizzBuzz.getResult());
    }
}
