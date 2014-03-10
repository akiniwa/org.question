package org.dom;

import android.app.Application;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Globals extends Application {
    int currentPage;
    String titles;
    String[] answers;
    ArrayList<String> questions;

    public int getPage() {
        return currentPage;
    }

    public String getQuestion() {
        return questions[currentPage];
    }

    public String getAnswers() {
        return answers[currentPage];
    }

    public void GlobalsAllInit() {
        currentPage = 0;

        InputStream input = null;
        String next[] = {};
        questions = new ArrayList<String>();
        try {
            input = new FileInputStream("/sdcard/hoge.csv");
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',0);
            questions = reader.readAll();
            /*
            for(;;) {
                next = reader.readNext();
                if(next != null) {
                    questions.add(next);
                } else {
                    break;
                }
            }
            */
        } catch (IOException e) {
            // error
        } finally {
            try {
                if( input != null )
                {
                    input.close();
                }
            } catch (IOException e) {
                // error
            }
        }
    }
}
