package org.dom;

import android.app.Application;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import android.util.Log;

public class Globals extends Application {
    int currentPage;
    String title;
    ArrayList<String> answers;
    ArrayList<String> questions;
    int[] numbers;
    String name;
    String date;
    public void setDate(String d) {
        date = d;
    }
    public String getDate() {
        return date;
    }
    // numbersは回答した番号
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAllquestions() {
        return questions;
    }

    public int[] getAllnumbers() {
        return numbers;
    }

    public int getNumbers() {
        int n = 0;
        try{
            n = numbers[currentPage];
        } catch(ArrayIndexOutOfBoundsException e) {
            Log.d("hogedom", "2");
        }
        return n;
    }

    public void setNumbers(int num) {
        try{
            numbers[currentPage] = num;
        } catch(ArrayIndexOutOfBoundsException e) {
            Log.d("hogedom", "3");
        }
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
        String s = new String();
        try{
            s = questions.get(currentPage);
        } catch(ArrayIndexOutOfBoundsException e) {
            Log.d("hogedom", "4");
        }
        return s;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getTotalPage() {
        // 1行目はタイトルだから-1する
        return questions.size() - 1;
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
            numbers = new int[questions.size()];
            for (int i=0;i<numbers.length;i++) {
                numbers[i] = -1;
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
