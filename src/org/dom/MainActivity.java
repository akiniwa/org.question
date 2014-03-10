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
import android.graphics.Color;
import android.view.Window;

public class MainActivity extends Activity
{
    private void setGlobals() {
        Globals globals = (Globals) this.getApplication();
        globals.GlobalsAllInit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.setGlobals();

        Button btn = (Button)findViewById(R.id.main_btn);
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

   }
}
