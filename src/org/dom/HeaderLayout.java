package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

public class HeaderLayout extends LinearLayout {

  public HeaderLayout(Context context, int view_number) {
    super(context);

    this.setOrientation(this.VERTICAL);
    this.setBackgroundColor(0xDDA0DDEE);
    this.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    LinearLayout parentLayout = new LinearLayout(context);
    parentLayout.setOrientation(LinearLayout.HORIZONTAL);

    TextView titleView = new TextView(context);
    titleView.setText("Questionnaire title");

    TextView countView = new TextView(context);
    countView.setText("no. " + view_number);

    parentLayout.addView(titleView);
    parentLayout.addView(countView);
    this.addView(parentLayout);
  }
}
