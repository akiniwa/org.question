package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.widget.Button;
import android.util.TypedValue;
import android.view.LayoutInflater;

public class ButtonLayout extends LinearLayout {
    public Button next_button;
    public Button back_button;

    public ButtonLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_layout, this, true);

        /* create views */
        back_button = (Button)findViewById(R.id.button_back_layout);
        next_button = (Button)findViewById(R.id.button_next_layout);
    }
}
