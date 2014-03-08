package org.dom;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Button;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);

		TextView textView = new TextView(this);
		textView.setText("select");
		linearLayout.addView(textView);

        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText("btn");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                //      Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                //startActivity(intent);
                button.setText("hello");
                /*  
                    Toast.makeText(
                    MainActivity.this, 
                    button.getText(),
                    Toast.LENGTH_SHORT).show();
                    */
            }
        });

        linearLayout.addView(btn);

		this.setContentView(linearLayout);
   }
}
