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

public class FillOutActivity extends Activity
{
    //Globals globals;
    final Context context = this;
    @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fillout);

            Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
            EditText editName = (EditText) findViewById(R.id.editName);
            EditText editAge = (EditText) findViewById(R.id.editAge);

            btnSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    // set title
                    alertDialogBuilder.setTitle("入力内容確認");
                    // set dialog message
                    alertDialogBuilder.setMessage("こちらでよろしいですか？")
                                      .setCancelable(false)
                                      .setPositiveButton("はい",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                                          }
                                      })
                                      .setNegativeButton("No",new DialogInterface.OnClickListener() {
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
                            // Do something in response to button click
                    }
            });
        }
}
