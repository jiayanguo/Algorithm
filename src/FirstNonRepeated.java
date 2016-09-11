import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jiayanguo on 9/11/16.
 */
public class FirstNonRepeated {

    public static void main(String[] args){
        System.out.print("Please enter your input string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.print("First Non Repeated String is "+  firstNonRepeatedCharacter(str));
    }

    public static Character firstNonRepeatedCharacter(String s){
        char c;
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i<s.length(); i ++){
            c= s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        for (int i =0; i<s.length(); i ++){
            c= s.charAt(i);
            if (map.get(c) == 1) return c;
        }
        return null;
    }
}
