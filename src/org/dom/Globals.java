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
    String content;
    ArrayList<String> answers;
    ArrayList<String> questions;
    int[] numbers;
    String name;
    String date;
    String age;

    public void setDate(String d) {
        this.date = d;
    }
    public String getDate() {
        return this.date;
    }
    // numbersは回答した番号
    public void setName(String n) {
        this.name = n;
    }
    public String getName() {
        return name;
    }

    public void setAge(String a) {
        this.age = a;
    }
    public String getAge() {
        return this.age;
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
        // ページは0から始まるけど、表記の問題上、+1する.
        return currentPage+1;
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
        return questions.size();
    }

    public void GlobalsAllInit(String filename) {
        // ファイル名、質問、質問文、選択項目
        currentPage = 0;

        InputStream input = null;
        String next[] = {};
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();

        try {
            input = new FileInputStream("sdcard/question/"+filename);
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',0);
            // 一行目は,カンマ区切りに読み込む.
            String[] firstline = reader.readNext();
            for (String col : firstline) {
                Log.d("hogedom:col:", col);
                answers.add(col);
            }
            // 二行目は,本文を読む.
            String[] secondline = reader.readNext();
            content = secondline[0];
            // 三行目以降は,questionsに追加していく
            while ((next = reader.readNext()) != null) {
                questions.add(next[0]);
                Log.d("hogedom", next[0]);
            }
            numbers = new int[questions.size()];
            for (int i=0;i<numbers.length;i++) {
                numbers[i] = -1;
            }
            title = filename;
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
