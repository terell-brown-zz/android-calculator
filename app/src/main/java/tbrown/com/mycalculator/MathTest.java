package tbrown.com.mycalculator;

import tbrown.com.mycalculator.MathEval;

/**
 * Created by tmast_000 on 3/8/2015.
 */
public class MathTest {

    public static void main(String[] args ){
        MathEval test = new MathEval();

        System.out.println(test.evaluate("3+4*(9+3)"));
    }

}
