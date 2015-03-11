package tbrown.com.mycalculator;

/**
 * Created by tmast_000 on 3/9/2015.
 */
public class calcSupport {
    // This is a Class with methods that support the construction of the calculator app

    private static char[] opArray = {'+', '-', '/', '*'}; // array of all mathematical operators

    public static int findLastNumIndexBeforeOperator(String s) {
        // This method returns the index of the last number from the right before an operator
        //   including '+','-','*' and '/'. If no such index is found -1 is returned

        int index = -1;
        int i = 0; // index associated with each element of opArray constant
        char opChar;

        for (i = 0; i < 4; i++) {
            opChar = opArray[i];
            index = s.indexOf(opChar);

            if (index != -1)
                return index + 1;
        }
        return index;
    }
}
