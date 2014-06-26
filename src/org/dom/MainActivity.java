package org.dom;

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
import android.os.Environment;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import java.io.FileFilter;
import java.io.File;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.ResourceCursorAdapter;
import android.widget.AdapterView;
import android.content.Context;

public class MainActivity extends Activity
{
    Globals globals;
    private File file;
    private List<Item> myList;
    final Context context = this;

    final private void setGlobals(String filename) {
        globals = (Globals) this.getApplication();
        globals.GlobalsAllInit(filename);
    }

    @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.main);

            myList = new ArrayList<Item>();   

            String root_sd = Environment.getExternalStorageDirectory().toString();
            File dir = new File(root_sd+"/questions");
            FileFilter fileFilter = new WildcardFileFilter("*.csv");
            File[] files = dir.listFiles(fileFilter);

            // *.csvファイルを表示
            for( int i=0; i< files.length; i++)
            {
                Item item = new Item(files[i].getName());
                myList.add( item );
            }

            ListAdapter mListAdapter = new ListAdapter(this, R.layout.itemlistrow, myList);
            final ListView listView = (ListView)findViewById(R.id.list_in_main);
            listView.setAdapter(mListAdapter);

            Button okBtn = (Button)findViewById(R.id.button_in_main);

            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ボタンがクリックされた時に呼び出されます
                    final List<String> fileList = new ArrayList<String>();
                    for (int i=0;i<myList.size();i++) {
                        //ListView listView = (ListView) parent;
                        Item item = (Item)listView.getItemAtPosition(i);
                        if (item.getChecked()) {
                            fileList.add(item.getText());
                        }
                    }
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    if (fileList.size()==0) {
                        alertDialogBuilder.setTitle("ファイルが選択されていません。");
                        alertDialogBuilder.setMessage("画面を触ってください。");
                    } else {
                        String files = "";
                        for (String s : fileList) {
                            files = files +"\n"+ s;
                        }
                        alertDialogBuilder.setTitle("選択したファイルはこちらでよろしいですか?");
                        alertDialogBuilder.setMessage(files);
                        alertDialogBuilder.setPositiveButton("はい",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                setGlobals(fileList.get(0));
                                Intent intent = new Intent(MainActivity.this, FillOutActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                            }
                        });
                    }
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }
            });

            /*
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                   }
                    ListView listView = (ListView) parent;
                    
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
            });
            */
        }

    /*
    protected void onListItemClick(ListView l, View v, int position, long id) 
    {
        super.onListItemClick(l, v, position, id);
        Log.v("hoge", "you can do it");
        // ここで、選択したファイル名をGlobalsに送り、ファイルから情報を取得する
        // ファイル名、質問、質問文、選択項目
        this.setGlobals(((TextView)v).getText().toString());

        //globals.nextPage();
        Intent intent = new Intent(MainActivity.this, FillOutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
    }
    */
}
