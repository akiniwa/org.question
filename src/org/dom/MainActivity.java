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
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity
{
    Globals globals;
    private File file;
    private List<String> myList;

    private void setGlobals() {
        globals = (Globals) this.getApplication();
        globals.GlobalsAllInit();
    }

    @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.main);
            this.setGlobals();

            myList = new ArrayList<String>();   

            String root_sd = Environment.getExternalStorageDirectory().toString();
            File dir = new File(root_sd);
            FileFilter fileFilter = new WildcardFileFilter("*.csv");
            File[] files = dir.listFiles(fileFilter);

            Button btn = (Button)findViewById(R.id.main_btn);

            for( int i=0; i< files.length; i++)
            {
                myList.add( files[i].getName() );
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, myList);
            setListAdapter(adapter);

            //btn.setText(root_sd);
            /*
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               }
            });
            */

        }

    protected void onListItemClick(ListView l, View v, int position, long id) 
    {
        super.onListItemClick(l, v, position, id);

//        Toast.makeText(getApplicationContext(), "hhhe", Toast.LENGTH_LONG).show(); 

     globals.nextPage();
     Intent intent = new Intent(MainActivity.this, SelectActivity.class);
     startActivity(intent);
     overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
 
    }
}
