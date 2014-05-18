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
    String title;
    ArrayList<String> answers;
    ArrayList<String> questions;

    int[] numbers;
    // numbersは回答した番号

    public int getNumbers() {
        return numbers[currentPage];
    }

    public void setNumbers(int num) {
        numbers[currentPage] = num;
    }

    public int getPage() {
        return currentPage;
    }

    public void nextPage() {
        currentPage += 1;
    }

    public void backPage() {
        currentPage -= 1;
    }

    public String getQuestion() {
        return questions.get(currentPage);
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void GlobalsAllInit() {
        currentPage = 0;

        InputStream input = null;
        String next[] = {};
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        try {
            input = new FileInputStream("/sdcard/hoge.csv");
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',0);
            while ((next = reader.readNext()) != null) {
                answers.add(next[0]);
            }
            numbers = new int[answers.size()];

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

        try {
            input = new FileInputStream("/sdcard/questions.csv");
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',0);
            while ((next = reader.readNext()) != null) {
                questions.add(next[0]);
            }
            title = questions.get(0);
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
