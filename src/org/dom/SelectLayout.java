package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.util.TypedValue;
import android.view.LayoutInflater;

public class SelectLayout extends LinearLayout {

    public SelectLayout(Context context, int textNumber, int pageNumber) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.select_layout, this, true);

        /* create views */
        TextView textView = (TextView)findViewById(R.id.select_textview);
        textView.setText(pageNumber + ". It causes the Button to disappear from the screen. What am I doing wrong, and what is the correct way to change the background color on any View?");
        textView.setTextColor(Color.rgb(20,20,20));

        LinearLayout buttonsLayout = (LinearLayout)findViewById(R.id.select_button_layout);
        LinearLayout answersLayout = (LinearLayout)findViewById(R.id.select_answer_layout);
 
        /* buttons, answers */
        Button[] buttons = new Button[textNumber];
        TextView[] answers = new TextView[textNumber];

        int i = 0;
        for (i = 0; i < textNumber; i++) {
            buttons[i] = new Button(context);
            buttons[i].setText(""+i);
            buttons[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            buttons[i].setBackgroundResource(R.drawable.shape);
            LayoutParams buttonParams = new LayoutParams(40, 40);
            buttonParams.setMargins(200, 0, 0, 0);
            buttons[i].setLayoutParams(buttonParams);
            if (i==1) {
                buttons[i].setPressed(true);
            }
            buttonsLayout.addView(buttons[i]);
            
            answers[i] = new TextView(context);
            answers[i].setText("hh");
            answers[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            answers[i].setTextColor(Color.rgb(20,20,20));
            LayoutParams answerParams = new LayoutParams(240, 40);
            if (i==0) {
                answerParams.setMargins(200, 0, 0, 0);
            }
            answers[i].setLayoutParams(answerParams);
            answersLayout.addView(answers[i]);
       }
    }

    public void manageButton() {
    }
} 
