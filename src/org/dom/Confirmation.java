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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Environment;
import java.io.FileFilter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Integer;

public class Confirmation extends Activity
{
    Globals globals;
    private String[] items = { "a10", "a11", "a21", "b10" };

    @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            LinearLayout parentLayout = new LinearLayout(this);
            parentLayout.setOrientation(LinearLayout.VERTICAL);

            HeaderLayout headerLayout = new HeaderLayout(this);
            parentLayout.addView(headerLayout);

            Button exitBtn = new Button(this);

            globals = (Globals) this.getApplication();

            ListView listView = new ListView(this);
            parentLayout.addView(listView);
            parentLayout.addView(exitBtn);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, globals.getAllquestions());
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, new ArrayList<String>(Arrays.toString(globals.getAllnumbers())));
            // アダプターを設定します
            listView.setAdapter(adapter);

            this.setContentView(parentLayout);

            // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                    //ListView listView = (ListView) parent;
                    // クリックされたアイテムを取得します
                    //String item = (String) listView.getItemAtPosition(position);
                    //Toast.makeText(ListViewSampleActivity.this, item, Toast.LENGTH_LONG).show();
                }
            });
            // リストビューのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
            listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                    ListView listView = (ListView) parent;
                    // 選択されたアイテムを取得します
                    //String item = (String) listView.getSelectedItem();
                    //Toast.makeText(ListViewSampleActivity.this, item, Toast.LENGTH_LONG).show();
                }
            @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            exitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                       File sdCard = Environment.getExternalStorageDirectory();
                       File sd_dir = new File (sdCard.getAbsolutePath() + "/dir1/dir2");
                       sd_dir.mkdirs();
                       try {
                           File file = new File(sd_dir, "filename");
                           FileOutputStream f = new FileOutputStream(file);
                           PrintWriter pw = new PrintWriter(f);
                           int s = 1;
                           int[] su = globals.getAllnumbers();
                           for (s=1;s<su.length;s++) {
                               pw.println(su[s]+1);
                           }
                           pw.close();
                       } catch (Exception e) {
                           Log.v("error_hoge", e.getMessage());
                       } finally {

                       }
                }
            });
        }
}
