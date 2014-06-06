package org.dom;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class FillOutActivity extends Activity
{
    Globals globals;
    final Context context = this;
    EditText editAge;
    EditText editName;
    RadioGroup radioSexGroup;
    RadioButton radioSexButton;

    @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fillout);
            globals = (Globals) this.getApplication();

            Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
            editName = (EditText) findViewById(R.id.editName);
            editAge = (EditText) findViewById(R.id.editAge);
            radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

            btnSubmit.setOnClickListener(new View.OnClickListener() {
                private void launchIntent() {
                    Intent intent = new Intent(FillOutActivity.this, SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
                    startActivity(intent); 
                    overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                }

                public void onClick(View v) {
                    int selectedId = radioSexGroup.getCheckedRadioButtonId();
                    if (editAge.getText().toString().equals("")||editName.getText().toString().equals("")) {
                        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                        alertDialog.setTitle("氏名、性別、年齢を入力してください");
                        alertDialog.setMessage("なにか画面をタッチしてください。");
                        alertDialog.show();
                    } else {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle("入力内容確認");
                        // find the radiobutton by returned id
                        radioSexButton = (RadioButton) findViewById(selectedId);
                        alertDialogBuilder.setMessage("氏名："+editName.getText().toString()+"\n性別："+radioSexButton.getText()+"\n年齢："+editAge.getText().toString() +"\nこちらでよろしいですか？")
                            .setCancelable(false)
                            .setPositiveButton("はい",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    globals.setAge(editAge.getText().toString());
                                    globals.setName(editName.getText().toString());

                                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                                    Date date = new Date();
                                    globals.setDate(df.format(date));
                                    dialog.cancel();
                                    launchIntent();
                                }
                            })
                        .setNegativeButton("いいえ",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        // show it
                        alertDialog.show();
                    }
                }
            });
        }
}
