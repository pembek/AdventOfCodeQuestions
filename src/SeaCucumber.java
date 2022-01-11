import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SeaCucumber {

    public int findStepCount(char [][] a) throws IOException {
        Set<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(true) {
            processStep(a);
            sb.setLength(0);
            count++;
            //System.out.println(count);
            for(char [] s: a) {
                for(char c: s) {
                    //System.out.print(c);
                    sb.append(c);
                }
                //System.out.println();
            }
            if(hs.contains(sb.toString()))
                break;
            hs.add(sb.toString());
        }
        return count;
    }

    public void processStep(char [][] a) {
        int l = a[0].length;
        boolean cycle = false;

        // east-facing sea cucumber herds
        for(int r = 0; r < a.length; r++) {
            if(a[r][0] == '.' && a[r][l-1] == '>') cycle = true;
            else cycle = false;

            for(int i = 0; i < l - 1; i++) {
                if(a[r][i] == '>' && a[r][i + 1] == '.') {
                    a[r][i] = '.';
                    a[r][i + 1] = '>';
                    i++;
                }
            }
            if(cycle) {
                a[r][l-1] = '.';
                a[r][0] = '>';
            }
        }

        // south-facing sea cucumber herds
        for (int i = 0; i < l; i++) {
            if(a[0][i] == '.' && a[a.length - 1][i] == 'v') cycle = true;
            else cycle = false;

            for(int r = 0; r < a.length - 1; r++) {
                if (a[r][i] == 'v' && a[r + 1][i] == '.') {
                    a[r][i] = '.';
                    a[r + 1][i] = 'v';
                    r++;
                }
            }
            if(cycle) {
                a[a.length - 1][i] = '.';
                a[0][i] = 'v';
            }
        }
    }
}
