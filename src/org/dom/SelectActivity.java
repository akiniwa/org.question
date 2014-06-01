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
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SelectActivity extends Activity
{
    Globals globals;
    int page;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        globals = (Globals) this.getApplication();

        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setBackgroundColor(0xDFA9DDEE);
        parentLayout.setOrientation(LinearLayout.VERTICAL);

        // Add header, selectView, buttons to mainlayer
        HeaderLayout headerLayout = new HeaderLayout(this, globals);
        SelectLayout selectLayout = new SelectLayout(this, globals);
        ButtonLayout buttonLayout = new ButtonLayout(this);
        
        buttonLayout.next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globals.getNumbers()==-1) {
                    // not filled
                    AlertDialog alertDialog = new AlertDialog.Builder(SelectActivity.this).create();
                    alertDialog.setTitle("未記入です。");
                    alertDialog.setMessage(" 画面をタッチしてください ");
                    alertDialog.show();
                } else if (globals.getPage()==globals.getTotalPage()) {
                    // last page
                    Intent intent = new Intent(SelectActivity.this, Confirmation.class);
                    startActivity(intent); 
                    overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                } else {
                    // nextpage
                    Intent intent = new Intent(SelectActivity.this, SelectActivity.class);
                    globals.nextPage();

                    startActivity(intent); 
                    overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                }
            }
        });

        buttonLayout.back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globals.getPage()==1) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SelectActivity.this).create();
                    alertDialog.setTitle("最初のページです。");
                    alertDialog.setMessage("なにか画面をタッチしてください。");
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(SelectActivity.this, SelectActivity.class);
                    globals.backPage();

                    startActivity(intent); 
                    overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
                }
            }
        });

        parentLayout.addView(headerLayout);
        parentLayout.addView(selectLayout);
        parentLayout.addView(buttonLayout);

        this.setContentView(parentLayout);
    }
}
