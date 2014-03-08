package org.dom;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(0xFF00FF00);

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
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                intent.putExtra(
                    "COUNT",
                    1);
                startActivity(intent);
                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
           }
        });

        linearLayout.addView(btn);

		this.setContentView(linearLayout);
   }
}
