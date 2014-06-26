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
import android.view.KeyEvent;

public class SelectActivity extends Activity
{
    Globals globals;
    int page;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.v("hoge", "you can do it5");

        globals = (Globals) this.getApplication();
        Log.v("hoge", "you can do it6ii");

        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setBackgroundColor(0xDFA9DDEE);
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        Log.v("hoge", "you can do it6");
        // Add header, selectView, buttons to mainlayer
        HeaderLayout headerLayout = new HeaderLayout(this, globals);
        Log.v("hoge", "you can do it7");
        SelectLayout selectLayout = new SelectLayout(this, globals);
        Log.v("hoge", "you can do it8");
        ButtonLayout buttonLayout = new ButtonLayout(this);
        Log.v("hoge", "you can do it9");
        
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
        Log.v("hoge", "you can do it7");

        this.setContentView(parentLayout);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                    AlertDialog alertDialog = new AlertDialog.Builder(SelectActivity.this).create();
                    alertDialog.setTitle("戻るボタンは無効です。");
                    alertDialog.setMessage("なにか画面をタッチしてください。");
                    alertDialog.show();
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
