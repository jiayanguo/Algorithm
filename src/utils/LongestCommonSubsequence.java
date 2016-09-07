package utils;

/**
 * Created by jiayanguo on 8/28/16.
 *
 * Longest Common subsequence.
 */
public class LongestCommonSubsequence {

    public char[] lcs (char[] c1, char[] c2){
        if(c1 == null || c2 == null) return null;
        if (c1.length ==0 || c2.length==0) return new char[0];

        int[][] count = new int[c1.length+1][c2.length+1];

        for (int i =0; i< c1.length+1; i ++){
            count[i][0] =0;
        }
        for (int j=0; j < c2.length+1; j++) {
            count[0][j] = 0;
        }

        if (c1[0] == c2[0]) count[0][0] = 1;

        int index1= 0;
        int largest = 0;
        for (int i =1; i <= c1.length; i ++) {
            for (int j=1; j<= c2.length; j++){
                if (c1[i-1] == c2[j-1]) {
                    count[i][j] = count [i-1][j-1]+1;
                    if (count[i][j]> largest) {
                        largest =count[i][j];
                        index1 = i-1;
                    }
                }
            }
        }

        System.out.println( "longest common subsequence: "+ largest);
        char[] result = new char[largest];
         for (int i= result.length-1; i >= 0; i --) {
             result[i]= c1[index1--];
         }
        return result;

    }

    public static void main (String[] args){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        char[] c1 = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] c2 = {'B', 'D', 'C', 'A', 'B', 'A'};
        char[] result = lcs.lcs(c1, c2);

        for (char c: result)
            System.out.println(c);
    }
}
