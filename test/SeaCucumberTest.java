import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SeaCucumberTest {

    private static SeaCucumber seaCucumber;

    @BeforeClass
    public static void instantiate(){
        seaCucumber = new SeaCucumber();
    }

    /* @Before
    public void cleanData(){
        seaCucumber.clean();
    } */

    @Test
    public void findSingleStepBasicInputTest() throws IOException {
        String file = "resources/input1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> l = new ArrayList<>();
        String s = reader.readLine();

        while(s != null) {
            l.add(s);
            s = reader.readLine();
        }
        reader.close();

        char [][] a = new char[l.size()][l.get(0).length()];
        for(int i = 0; i < l.size(); i++) {
            for(int j = 0; j < l.get(0).length(); j++) {
                a[i][j] = l.get(i).toCharArray()[j];
            }
        }

        seaCucumber.processStep(a);

        int i = 0;
        for(char c: "....>.>v.>".toCharArray()) { assertEquals(c, a[0][i++]); }
        i = 0;
        for(char c: "v.v>.>v.v.".toCharArray()) { assertEquals(c, a[1][i++]); }
        i = 0;
        for(char c: ">v>>..>v..".toCharArray()) { assertEquals(c, a[2][i++]); }
        i = 0;
        for(char c: ">>v>v>.>.v".toCharArray()) { assertEquals(c, a[3][i++]); }
        i = 0;
        for(char c: ".>v.v...v.".toCharArray()) { assertEquals(c, a[4][i++]); }
        i = 0;
        for(char c: "v>>.>vvv..".toCharArray()) { assertEquals(c, a[5][i++]); }
        i = 0;
        for(char c: "..v...>>..".toCharArray()) { assertEquals(c, a[6][i++]); }
        i = 0;
        for(char c: "vv...>>vv.".toCharArray()) { assertEquals(c, a[7][i++]); }
        i = 0;
        for(char c: ">.v.v..v.v".toCharArray()) { assertEquals(c, a[8][i++]); }
    }


    @Test
    public void find57StepBasicInputTest() throws IOException {
        String file = "resources/input1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> l = new ArrayList<>();
        String s = reader.readLine();

        while(s != null) {
            l.add(s);
            s = reader.readLine();
        }
        reader.close();

        char [][] a = new char[l.size()][l.get(0).length()];
        for(int i = 0; i < l.size(); i++) {
            for(int j = 0; j < l.get(0).length(); j++) {
                a[i][j] = l.get(i).toCharArray()[j];
            }
        }

        for(int i = 0; i < 57; i++) {
            seaCucumber.processStep(a);
        }
        for(char [] zz: a) {
            for(char c: zz) {  System.out.print(c);  }
            System.out.println();
        }

        int i = 0;
        for(char c: "..>>v>vv..".toCharArray()) { assertEquals(c, a[0][i++]); }
        i = 0;
        for(char c: "..v.>>vv..".toCharArray()) { assertEquals(c, a[1][i++]); }
        i = 0;
        for(char c: "..>>v>>vv.".toCharArray()) { assertEquals(c, a[2][i++]); }
        i = 0;
        for(char c: "..>>>>>vv.".toCharArray()) { assertEquals(c, a[3][i++]); }
        i = 0;
        for(char c: "v......>vv".toCharArray()) { assertEquals(c, a[4][i++]); }
        i = 0;
        for(char c: "v>v....>>v".toCharArray()) { assertEquals(c, a[5][i++]); }
        i = 0;
        for(char c: "vvv.....>>".toCharArray()) { assertEquals(c, a[6][i++]); }
        i = 0;
        for(char c: ">vv......>".toCharArray()) { assertEquals(c, a[7][i++]); }
        i = 0;
        for(char c: ".>v.vv.v..".toCharArray()) { assertEquals(c, a[8][i++]); }
    }

    @Test
    public void findStepCountInputTest() throws IOException {
        String file = "resources/input1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> l = new ArrayList<>();
        String s = reader.readLine();

        while(s != null) {
            l.add(s);
            s = reader.readLine();
        }
        reader.close();

        char [][] a = new char[l.size()][l.get(0).length()];
        for(int i = 0; i < l.size(); i++) {
            for(int j = 0; j < l.get(0).length(); j++) {
                a[i][j] = l.get(i).toCharArray()[j];
            }
        }

        assertEquals(58, seaCucumber.findStepCount(a));
    }

    @Test
    public void findStepCountHugeInputTest() throws IOException {
        String file = "resources/input2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> l = new ArrayList<>();
        String s = reader.readLine();

        while(s != null) {
            l.add(s);
            s = reader.readLine();
        }
        reader.close();

        char [][] a = new char[l.size()][l.get(0).length()];
        for(int i = 0; i < l.size(); i++) {
            for(int j = 0; j < l.get(0).length(); j++) {
                a[i][j] = l.get(i).toCharArray()[j];
            }
        }

        assertEquals(308, seaCucumber.findStepCount(a));
    }
}
