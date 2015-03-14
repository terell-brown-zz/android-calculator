package tbrown.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Main extends ActionBarActivity implements View.OnClickListener {

    // Import widgets into Java as Objects;
    EditText etScreen;
    Button bClear, bDiv, bMult, bDel, b0, b1, b2, b3, b4,
            b5, b6, b7, b8, b9, bSub, bAdd, bBrac, bEquals,
            bDec;

    // Imported object from downloaded library supports evaluation of math expressions  as strings
    MathEval ans = new MathEval();

    /* The following two variables show important characteristics of the text currently
    *    on the screen. These variables are used to determine what should be displayed
    *    when each button is pressed.
    */

    int NoOpenBrackets = 0; // Number of open brackets that have yet to be closed
    String typeLastChar = null;
    // Possible values include: "OPEN_BRACKET", "CLOSED_BRACKET,"NUM","PLUS_MINUS_DEC", "MULT_DIV"



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeAllWidgets();
        setAllListeners();
    }

    private void initializeAllWidgets() {
        // This method imports and initializes all widgets from the xml layout

        etScreen = (EditText) findViewById(R.id.etScreen);
        etScreen.requestFocus();
        etScreen.setSelection(0);
        bClear = (Button) findViewById(R.id.bClear);
        bDiv = (Button) findViewById(R.id.bDiv);
        bMult = (Button) findViewById(R.id.bMult);
        bDel = (Button) findViewById(R.id.bDel);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        bSub = (Button) findViewById(R.id.bSub);
        bAdd = (Button) findViewById(R.id.bAdd);
        bBrac = (Button) findViewById(R.id.bBrac);
        bEquals = (Button) findViewById(R.id.bEquals);
        bDec = (Button) findViewById(R.id.bDec);
    }

    private void setAllListeners() {
        // This method sets the onClick Listeners for all imported widgets

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bEquals.setOnClickListener(this);
        bBrac.setOnClickListener(this);
        bDel.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bDec.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bMult.setOnClickListener(this);
        bClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /* This method specifies the resulting action character added to the screen of the calculator
              when each button is clicked 
         */


        String textOnScreen = etScreen.getText().toString();
        boolean isEmpty = textOnScreen.isEmpty();
        String typeLastChar = findLastCharType(textOnScreen);
        switch (v.getId()) {
            case R.id.bClear:
                etScreen.setText("");
                typeLastChar = null;
                break;

            case R.id.b0:
                etScreen.append("0");
                break;
            case R.id.b1:
                etScreen.append("1");
                break;
            case R.id.b2:
                etScreen.append("2");
                break;
            case R.id.b3:
                etScreen.append("3");
                break;
            case R.id.b4:
                etScreen.append("4");
                break;
            case R.id.b5:
                etScreen.append("5");
                break;
            case R.id.b6:
                etScreen.append("6");
                break;
            case R.id.b7:
                etScreen.append("7");
                break;
            case R.id.b8:
                etScreen.append("8");
                break;
            case R.id.b9:
                etScreen.append("9");
                break;
            case R.id.bDec:
                if (typeLastChar == "NUM")
                    etScreen.setText(textOnScreen + ".");
                break;
            case R.id.bSub:
                if (typeLastChar == "NUM" || typeLastChar == "CLOSED_BRACKET")
                    etScreen.setText(textOnScreen + "-");
                    break;
            case R.id.bAdd:
                if (typeLastChar == "NUM" || typeLastChar == "CLOSED_BRACKET")
                    etScreen.setText(textOnScreen + "+");
                break;
            case R.id.bEquals:
                if ((typeLastChar == "NUM" || typeLastChar == "CLOSED_BRACKET")
                        && NoOpenBrackets == 0) {
                    etScreen.setText("" + ans.evaluate(textOnScreen));
                }
                break;
            case R.id.bMult:
                if ((typeLastChar == "NUM" || typeLastChar == "CLOSED_BRACKET")
                        && NoOpenBrackets == 0) {
                    etScreen.setText(textOnScreen + "*");
                }
                break;
            case R.id.bDiv:
                if ((typeLastChar == "NUM" || typeLastChar == "CLOSED_BRACKET")
                        && NoOpenBrackets == 0) {
                    etScreen.setText(textOnScreen + "/");
                }
                break;
            case R.id.bBrac:
                etScreen.setText(textOnScreen + addBrackets(typeLastChar, NoOpenBrackets));
                break;
            case R.id.bDel:
                // if there is text on the calculator screen then delete the last character
                if (!isEmpty) {
                    etScreen.setText(textOnScreen.substring(0, textOnScreen.length() - 1));
                    break;
                } else {
                    break;
                }
        }
    }

    private String findLastCharType(String text) {
        /* This method returns a String specifying the type of the last character of the
         *    text on the calculator screen(etScreen). Possible results include:
         *    Possible values include: "OPEN_BRACKET", "CLOSED_BRACKET,"NUM",
         *    "PLUS_MINUS_DEC", "MULT_DIV", OR "NONE"
         */

        // the case when there is no text on the screen
        if (text.length() == 0) {
            return "NONE";
        } else {

            char lastChar = text.charAt(text.length() - 1);
            String type;

            switch (lastChar) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    type = "NUM";
                    break;
                case '+':
                case '-':
                case '.':
                    type = "PLUS_MINUS_DEC";
                    break;
                case '*':
                case '/':
                    type = "MULT_DIV";
                    break;
                case '(':
                    type = "OPEN_BRACKET";
                    break;
                case ')':
                    type = "CLOSED_BRACKET";
                    break;
                default:
                    type = "NONE";

            }
            return type;
        }
    }


    public String addBrackets(String typeLastChar, int noOpenBrackets) {
        /* This method returns a string containing the desired result when the bracket button is
        *    is pressed depending on the type of the last character on the calculator screen
        *    (textOnScreen) and the number of open brackets
        */

         switch (typeLastChar) {

             case "OPEN_BRACKET":
                 NoOpenBrackets ++;
                 return "(";
             case "NUM":
             case "CLOSED_BRACKET":
                 if (noOpenBrackets > 0 ){
                     NoOpenBrackets --;
                     return ")";
                 } else {
                     NoOpenBrackets ++;
                     return "*(";
                 }
             case "PLUS_MINUS_DEC":
                 return "";
             case "NONE":
             case "MULT_DIV":
                 NoOpenBrackets ++;
                 return "(";
             default:
                 return null;

         }
    }
}