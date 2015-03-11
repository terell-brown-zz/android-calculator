package tbrown.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import tbrown.com.mycalculator.MathEval;

/**
 * Created by tmast_000 on 3/8/2015.
 */
public class Main extends ActionBarActivity implements View.OnClickListener{

    // Import widgets into Java as Objects;
    EditText etScreen;
    Button bClear,bDiv,bMult,bDel,b0,b1,b2,b3,b4,
            b5,b6,b7,b8,b9,bSub,bAdd,bBrac,bEquals,
            bDec,bSign;

    Button[] buttons;

    MathEval ans = new MathEval();

    /*int[] buttons = {
            R.id.b0, R.id.b1,R.id.b2, R.id.b1,R.id.b3, R.id.b4,
            R.id.b5, R.id.b6,R.id.b7, R.id.b8,R.id.b9, R.id.bClear,
            R.id.bDiv, R.id.bMult,R.id.bDel, R.id.bSub,R.id.bAdd,
            R.id.bEquals, R.id.bBrac,R.id.bDec, R.id.bSign,
    }; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initialize();
        buttonArray();
        setListeners();

    }

    private void setListeners() {
        /*int i;
        System.out.print(buttons);
        for (i = 0; i < buttons.length; i++) {
        try {
                buttons[i].setOnClickListener(this);
            } catch (NullPointerException e){
                System.out.println(buttons);
                System.out.println(buttons[i]);
            }
        } */

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
        bSign.setOnClickListener(this);
        bDel.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bDec.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bMult.setOnClickListener(this);
        bClear.setOnClickListener(this);
    }



    private void initialize(){
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
        bSign = (Button) findViewById(R.id.bSign);

        // create array of buttons:

    }

    @Override
    public void onClick(View v) {
        String currentText = etScreen.getText().toString();
        boolean isLastCharNum = isLastNum(currentText);
        switch (v.getId()) {
            case R.id.bClear:
                etScreen.setText("");
                break;
            case R.id.b0:
                etScreen.setText(currentText + "0");
                break;
            case R.id.b1:
                etScreen.setText(currentText + "1");
                break;
            case R.id.b2:
                etScreen.setText(currentText + "2");
                break;
            case R.id.b3:
                etScreen.setText(currentText + "3");
                break;
            case R.id.b4:
                etScreen.setText(currentText + "4");
                break;
            case R.id.b5:
                etScreen.setText(currentText + "5");
                break;
            case R.id.b6:
                etScreen.setText(currentText + "6");
                break;
            case R.id.b7:
                etScreen.setText(currentText + "7");
                break;
            case R.id.b8:
                etScreen.setText(currentText + "8");
                break;
            case R.id.b9:
                etScreen.setText(currentText + "9");
                break;
            case R.id.bSign:
                etScreen.setText(currentText);
                break;
            case R.id.bDec:
                if (isLastCharNum)
                etScreen.setText(currentText + ".");
                break;
            case R.id.bSub:
                if (isLastCharNum)
                etScreen.setText(currentText + "-");
                break;
            case R.id.bAdd:
                if (isLastCharNum)
                etScreen.setText(currentText + "+");
                break;
            case R.id.bEquals:
                if (isLastCharNum)
                etScreen.setText("" + ans.evaluate(currentText));
                break;
            case R.id.bMult:
                if (isLastCharNum)
                etScreen.setText(currentText + "*");
                break;
            case R.id.bDiv:
                if (isLastCharNum)
                etScreen.setText(currentText + "/");
                break;
            case R.id.bBrac:
                etScreen.setText(currentText + "");
                break;
            case R.id.bDel:
                if (isLastCharNum)
                etScreen.setText(currentText.substring(0,currentText.length() - 1));
                break;
        }

    }

    private boolean isLastNum(String s) {
        // This method returns true if the last character of the string is a number and false
        //   otherwise
        if (s.length() == 0) {
            return true;
        } else {
            char lastChar = s.charAt(s.length() - 1);
            return Character.isDigit(lastChar);
        }
    }


    public void buttonArray() {
        Button[] buttons = {
                b0, b1,b2, b3,b4,b5,b6,b7,b8,b9, bClear,
                bDiv,bMult,bDel,bSub,bAdd,bEquals,bBrac,bDec,bSign
        };
    }

}
