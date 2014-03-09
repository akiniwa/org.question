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
import android.widget.Toast;
import android.graphics.Color;

public class SelectActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        final int pageNumber = i.getIntExtra("COUNT", 0);

        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setBackgroundColor(0xDFA9DDEE);
        parentLayout.setOrientation(LinearLayout.VERTICAL);

        HeaderLayout headerLayout = new HeaderLayout(this, pageNumber);
        SelectLayout selectLayout = new SelectLayout(this, 4, pageNumber);
        ButtonLayout buttonLayout = new ButtonLayout(this);
        
        buttonLayout.next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, SelectActivity.class);
                intent.putExtra(
                    "COUNT",
                    pageNumber+1);
                startActivity(intent); 
                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
            }
        });

        parentLayout.addView(headerLayout);
        parentLayout.addView(selectLayout);
        parentLayout.addView(buttonLayout);

		this.setContentView(parentLayout);
   }
}
