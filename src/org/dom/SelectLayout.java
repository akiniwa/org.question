package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

public class SelectLayout extends LinearLayout {

  public SelectLayout(Context context, int view_number) {
    super(context);

    this.setOrientation(this.VERTICAL);
    this.setBackgroundColor(0xFF00FF00);
    this.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
        
    LinearLayout parentLayout = new LinearLayout(context);
    parentLayout.setOrientation(LinearLayout.VERTICAL);

    TextView text = new TextView(context);
    text.setText("It causes the Button to disappear from the screen. What am I doing wrong, and what is the correct way to change the background color on any View?");

    LinearLayout questionLayout = new LinearLayout(context);
    questionLayout.setOrientation(LinearLayout.HORIZONTAL);

    TextView[] text_list = new TextView[view_number];
    for (TextView i : text_list) {
        i = new TextView(context);
        i.setText("hoge");
        questionLayout.addView(i);
    }
    parentLayout.addView(text);
    parentLayout.addView(questionLayout);
    this.addView(parentLayout);
  }
} 
