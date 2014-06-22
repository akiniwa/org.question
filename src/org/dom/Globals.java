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
    // numbers$B$O2sEz$7$?HV9f(B
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
        // $B%Z!<%8$O(B0$B$+$i;O$^$k$1$I!"I=5-$NLdBj>e!"(B+1$B$9$k(B.
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
        // 1$B9TL\$O%?%$%H%k$@$+$i(B-1$B$9$k(B
        return questions.size();
    }

    public void GlobalsAllInit(String filename) {
        // $B%U%!%$%kL>!"<ALd!"<ALdJ8!"A*Br9`L\(B
        currentPage = 0;

        InputStream input = null;
        String next[] = {};
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();

        try {
            input = new FileInputStream("sdcard/question/"+filename);
            InputStreamReader ireader=new InputStreamReader(input, "UTF-8");
            CSVReader reader = new CSVReader(ireader,',','"',0);
            // $B0l9TL\$O(B,$B%+%s%^6h@Z$j$KFI$_9~$`(B.
            String[] firstline = reader.readNext();
            for (String col : firstline) {
                Log.d("hogedom:col:", col);
                answers.add(col);
            }
            // $BFs9TL\$O(B,$BK\J8$rFI$`(B.
            String[] secondline = reader.readNext();
            content = secondline[0];
            // $B;09TL\0J9_$O(B,questions$B$KDI2C$7$F$$$/(B
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
