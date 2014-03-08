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

        /* layout setting */
        this.setOrientation(this.VERTICAL);
        this.setBackgroundColor(0xDDA0DDEE);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    80));
        this.setPadding(5, 5, 5, 5);

        /* parentlayout */
        LinearLayout parentLayout = new LinearLayout(context);
        parentLayout.setOrientation(LinearLayout.HORIZONTAL);

        /* create views */
        back_button = new Button(context);
        LayoutParams backParams = new LayoutParams(100, 70);
        backParams.setMargins(1000, 5, 5, 5);
        back_button.setLayoutParams(backParams);
        back_button.setText("back");
        back_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);

        next_button = new Button(context);
        LayoutParams nextParams = new LayoutParams(100, 70);
        nextParams.setMargins(5, 5, 5, 5);
        next_button.setLayoutParams(nextParams);
        next_button.setText("next");
        next_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);

        /* add views to parentlayout */
        parentLayout.addView(back_button);
        parentLayout.addView(next_button);
        this.addView(parentLayout);
    }
}
