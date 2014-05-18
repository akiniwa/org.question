package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.util.TypedValue;
import android.view.View;
import android.view.LayoutInflater;
import java.util.*;
import android.util.Log;
import android.view.MotionEvent;
import java.lang.Integer;


public class SelectLayout extends LinearLayout {
    public Button[] buttons;
    //private void getAllButtonOff();
    Globals globals;

    public SelectLayout(Context context, ArrayList<String> answers, String text, int pageNumber, int ans_num, Globals g) {
        super(context);
        //this.answers = answers;
        this.globals = g;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.select_layout, this, true);

        /* create views */
        TextView textView = (TextView)findViewById(R.id.select_textview);
        textView.setText(pageNumber + ". " + text);
        textView.setTextColor(Color.rgb(20,20,20));

        LinearLayout buttonsLayout = (LinearLayout)findViewById(R.id.select_button_layout);
        LinearLayout answersLayout = (LinearLayout)findViewById(R.id.select_answer_layout);
 
        /* buttons, answers */
        buttons = new Button[answers.size()];
        TextView[] answersView = new TextView[answers.size()];

        int i = 0;
        for (i = 0; i < answers.size(); i++) {
            buttons[i] = new Button(context);
            buttons[i].setText(""+i);
            buttons[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            buttons[i].setBackgroundResource(R.drawable.shape);
            if (i==ans_num) {
                buttons[i].setPressed(true);
            }

            buttons[i].setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // show interest in events resulting from ACTION_DOWN
                    if(event.getAction()==MotionEvent.ACTION_DOWN) return true;
                    // don't handle event unless its ACTION_UP so "doSomething()" only runs once.
                    if(event.getAction()!=MotionEvent.ACTION_UP) return false;
                    // $BB>$N%\%?%s$O%*%U$K$9$k!#(B
                    int i = 0;
                    for (i = 0; i < buttons.length; i++) {
                        buttons[i].setPressed(false);
                    }
                    Button b = (Button)v;
                    globals.setNumbers(Integer.parseInt(b.getText().toString()));
                    b.setPressed(true);
                    return true;
                }
            });

            LayoutParams buttonParams = new LayoutParams(40, 40);
            buttonParams.setMargins(200, 0, 0, 0);
            buttons[i].setLayoutParams(buttonParams);
            buttonsLayout.addView(buttons[i]);
            //mizuho $B;M9f!!IaDL!!(B1630595 $B3t<02q<R$/$l(B

            //32392(J\(B
            
            answersView[i] = new TextView(context);
            answersView[i].setText(answers.get(i));
            answersView[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            answersView[i].setTextColor(Color.rgb(20,20,20));
            LayoutParams answerParams = new LayoutParams(240, 40);
            if (i==0) {
                answerParams.setMargins(200, 0, 0, 0);
            }
            answersView[i].setLayoutParams(answerParams);
            answersLayout.addView(answersView[i]);
        }
    }

    public int getButtonNumber() {
        return 2;
    }

    public void setButtonNumber(int num) {
        /*
        for (i = 0; i < answers.size(); i++) {
            if (i==num) {
                buttons[i].setPressed(true);
            } else {
                buttons[i].setPressed(false);
            }
        }
        */
    }

    public void manageButton() {
    }
} 
