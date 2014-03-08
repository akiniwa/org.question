package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.widget.Button;
import android.util.TypedValue;

public class ButtonLayout extends LinearLayout {
    public Button next_button;
    public Button back_button;

  public ButtonLayout(Context context) {
    super(context);

    this.setOrientation(this.VERTICAL);
    this.setBackgroundColor(0xDDA0DDEE);
    this.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    back_button = new Button(context);
    back_button.setLayoutParams(new SelectLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    back_button.setText("back");
    back_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);

    next_button = new Button(context);
    next_button.setLayoutParams(new SelectLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    next_button.setText("next");

    LinearLayout parentLayout = new LinearLayout(context);
    parentLayout.setOrientation(LinearLayout.HORIZONTAL);

    parentLayout.addView(back_button);
    parentLayout.addView(next_button);
    this.addView(parentLayout);
  }
}
