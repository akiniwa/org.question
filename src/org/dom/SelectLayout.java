package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.util.TypedValue;

public class SelectLayout extends LinearLayout {

    public SelectLayout(Context context, int textNumber) {
        super(context);

        /* layout setting */
        this.setOrientation(this.VERTICAL);
        this.setBackgroundColor(Color.rgb(255, 255, 255));
        this.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    600));
        this.setPadding(20, 20, 20, 20);

        /* parentlayout */
        LinearLayout parentLayout = new LinearLayout(context);
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
 
        /* create views */
        TextView textView = new TextView(context);
        textView.setText("It causes the Button to disappear from the screen. What am I doing wrong, and what is the correct way to change the background color on any View?");
        textView.setTextColor(Color.rgb(20,20,20));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        LayoutParams textParams = new LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    220);
        textParams.setMargins(100, 100, 100, 0);
        textView.setLayoutParams(textParams);

        LinearLayout buttonsLayout = new LinearLayout(context);
        buttonsLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonsLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    50));

        LinearLayout answersLayout = new LinearLayout(context);
        answersLayout.setOrientation(LinearLayout.HORIZONTAL);
        answersLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    50));
 
                /* buttons, answers */
        Button[] buttons = new Button[textNumber];
        TextView[] answers = new TextView[textNumber];

        int i = 0;
        for (i = 0; i < textNumber; i++) {
            buttons[i] = new Button(context);
            buttons[i].setText(""+i);
            buttons[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            buttons[i].setBackgroundResource(R.drawable.shape);
            LayoutParams params = new LayoutParams(40, 40);
            params.setMargins(200, 0, 0, 0);
            buttons[i].setLayoutParams(params);
            if (i==1) {
                buttons[i].setPressed(true);
            }
            buttonsLayout.addView(buttons[i]);
            
            answers[i] = new TextView(context);
            answers[i].setText("hoge");
            answers[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            answers[i].setTextColor(Color.rgb(20,20,20));
            answers[i].setLayoutParams(params);
            answersLayout.addView(answers[i]);
       }

        /* add views to parentlayout */
        parentLayout.addView(textView);
        parentLayout.addView(buttonsLayout);
        parentLayout.addView(answersLayout);
        this.addView(parentLayout);
    }

    public void manageButton() {
    }
} 
