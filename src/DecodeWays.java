/**
 * Created by jiayanguo on 9/6/16.
 */


/**
 *Sample:
 *
 "11111878787676172120121101212918291829819"
 Output
 2496
 Expected
 6240

 */
public class DecodeWays {

    public int numDecodingsHelper(String s) {
        if (s.length() == 0) return 0;

        if (s.length() == 1) {
            int i = Integer.parseInt(s);
            if (i == 0) return 0;
            else return 1;}
        if (s.length() == 2) {
            int i = Integer.parseInt(s);
            if ( i<= 26 && i != 10 && i!= 20) return 2;
            else return 1;
        }
        int j = Integer.parseInt(s.substring(s.length()-2));
        if (j == 0){
            return 0;
        }
        if (j <= 26 && j > 10 && j != 20){
            return numDecodingsHelper(s.substring(0, s.length()-1)) + numDecodingsHelper(s.substring(0, s.length()-2));
        }else if (j == 10 || j == 20){
            return  numDecodingsHelper(s.substring(0, s.length()-2));
        }else if (j < 10) {
            int k = numDecodingsHelper(s.substring(s.length()-3, s.length()-2));
           if (k == 1 || k == 2){
                return numDecodingsHelper(s.substring(0, s.length()-3)) ;
            }
            else{
                return 0;
            }
        }
        else{
            return numDecodingsHelper(s.substring(0, s.length()-1));
        }
    }

    /*
    * @param s a string,  encoded message
    * @return an integer, the number of ways decoding
    */
    public int numDecodings (String s){
        if (s.length() == 0) return 0;
        char c = s.charAt(0);
        if (c == '0') return 0;
        for( int i =1; i <s.length(); i ++){
            char ch = s.charAt(i);
            if (ch == '0') {
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
                    return 0;
                }
            }
        }
        return numDecodingsHelper(s);
    }

    public static void main(String[] args){
        DecodeWays decodeWays = new DecodeWays();
        int num = decodeWays.numDecodings("123");
        System.out.println(num);

        System.out.println("Encodeing: 2226252724242221201918171615141311108787876761721201211012111989898911918293");
        num = decodeWays.numDecodings("2226252724242221201918171615141311108787876761721201211012111989898911918293");
        System.out.println(num);
    }
}
