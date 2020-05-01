package ads.a3;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoyerMooreTest {


    @Test
    public void testJump() {
        //generate some test values
        System.out.println("----Testing jump()");
        String muster1 = "abad";
        String muster2 = "barab";


        int j1 = BoyerMoore.jump(muster1, "a".charAt(0));
        System.out.println("For " + muster1 + " and character " + "a".charAt(0) + " : " + j1);
        assertTrue("Jump true", j1 == 1);
        int j2 = BoyerMoore.jump(muster1, "b".charAt(0));
        System.out.println("For " + muster1 + " and character " + "b".charAt(0) + " : " + j2);
        assertTrue("Jump true", j2 == 2);
        int j3 = BoyerMoore.jump(muster1, "c".charAt(0));
        System.out.println("For " + muster1 + " and character " + "c".charAt(0) + " : " + j3);
        assertTrue("Jump true", j3 == 4);
        int j4 = BoyerMoore.jump(muster1, "p".charAt(0));
        System.out.println("For " + muster1 + " and character " + "p".charAt(0) + " : " + j4);
        assertTrue("Jump true", j4 == 4);
        int j5 = BoyerMoore.jump(muster1, "d".charAt(0));
        System.out.println("For " + muster1 + " and character " + "d".charAt(0) + " : " + j5);
        assertTrue("Jump true", j5 == 0);

        int j6 = BoyerMoore.jump(muster2, "b".charAt(0));
        System.out.println("For " + muster2 + " and character " + "b".charAt(0) + " : " + j6);
        assertTrue("Jump true", j6 == 0);
        int j7 = BoyerMoore.jump(muster2, "a".charAt(0));
        System.out.println("For " + muster2 + " and character " + "a".charAt(0) + " : " + j7);
        assertTrue("Jump true", j7 == 1);
        int j8 = BoyerMoore.jump(muster2, "p".charAt(0));
        System.out.println("For " + muster2 + " and character " + "p".charAt(0) + " : " + j8);
        assertTrue("Jump true", j8 == 5);
    }

    @Test
    public void testBoyerMoore() {
        String text1 = "oboobbbar";
        String text2 = "po posdaoboobbbar";
        String muster1 = "ar";
        String muster2 = "pos";
        String muster3 = "bar";

        System.out.println("----Testing boyerMoore()");
        int i = BoyerMoore.boyerMoore(muster1, text1);
        System.out.println("index " + i);
        assertTrue("Index true", i == 7);
        i = BoyerMoore.boyerMoore(muster2, text2);
        System.out.println("index " + i);
        assertTrue("Index true", i == 3);
        i = BoyerMoore.boyerMoore(muster3, text2);
        System.out.println("index " + i);
        assertTrue("Index true", i == 14);

    }


}
