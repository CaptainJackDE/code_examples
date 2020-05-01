/**
 *
 */
package ads.a3;

/**
 * Implementation of Boyer Moore search.
 *
 * @author you
 */
public class BoyerMoore {

    public static int jump(String muster, char c) {
        char[] m = muster.toCharArray();
        int l = muster.length();
        int p = 0;
        
        for(int i = 0; i < l;i++){
        	if(m[i] == c) {
        		p = i + 1;
        	}
        }
        return l-p;
    }

    public static int boyerMoore(String muster, String text) {
    	char[] m = muster.toCharArray();
        char[] t = text.toCharArray();
    	int x = m.length;
        int y = t.length;
        int i = 0, j = 0;
         
        while ((i + x) <= y) {
            j = x - 1;
            while (t[i + j] == m[j]) {
                j--;
                if (j < 0) return i;
            }
            i++;
        }
        return -1;
    }
}
