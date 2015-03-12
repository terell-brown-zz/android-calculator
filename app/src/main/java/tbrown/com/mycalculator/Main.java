package tbrown.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Main extends ActionBarActivity implements View.OnClickListener{

    // Import widgets into Java as Objects;
    EditText etScreen;
    Button bClear,bDiv,bMult,bDel,b0,b1,b2,b3,b4,
            b5,b6,b7,b8,b9,bSub,bAdd,bBrac,bEquals,
            bDec,bSign;

    // Imported object from downloaded library supports evaluation of math expressions  as strings
    MathEval ans = new MathEval();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeAllWidgets();
        setAllListeners();
    }

    private void initializeAllWidgets(){
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
        bSign = (Button) findViewById(R.id.bSign);
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
        bSign.setOnClickListener(this);
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
        /* This method specifies the resulting action applied to the screen of the calculator
              when each button is clicked 
         */
        
        
        String textOnScreen = etScreen.getText().toString();
        boolean isEmpty = textOnScreen.isEmpty();
        boolean isLastCharNum = isLastNum(textOnScreen);
        switch (v.getId()) {
            case R.id.bClear:
                etScreen.setText("");
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
            case R.id.bSign:
                etScreen.setText(textOnScreen);
                break;
            case R.id.bDec:
                if (isLastCharNum)
                etScreen.setText(textOnScreen + ".");
                break;
            case R.id.bSub:
                if (isLastCharNum)
                etScreen.append("-");
                break;
            case R.id.bAdd:
                if (isLastCharNum)
                etScreen.append("+");
                break;
            case R.id.bEquals:
                if (isLastCharNum && (!isEmpty))
                etScreen.setText("" + ans.evaluate(textOnScreen));
                break;
            case R.id.bMult:
                if (isLastCharNum && (!isEmpty))
                etScreen.setText(textOnScreen + "*");
                break;
            case R.id.bDiv:
                if (isLastCharNum && (!isEmpty))
                etScreen.append("/");
                break;
            case R.id.bBrac:
                etScreen.append("");
                break;
            case R.id.bDel:
                // if there is text on the calculator screen then delete the last character
                if (!isEmpty) {
                    etScreen.setText(textOnScreen.substring(0, textOnScreen.length() - 1));
                    break;
                } else { break; }
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
}
