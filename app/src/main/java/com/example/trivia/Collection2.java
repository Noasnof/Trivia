package com.example.trivia;

import java.util.ArrayList;
import java.util.Collections;

public class Collection2 {
    private ArrayList<Question> arr;
    private int index;

    public Collection2() {
        arr = new ArrayList<>();
        Question q1 = new Question("1+10", "7", "11", "3", "100", 2);
        Question q2 = new Question("1+2", "8", "2", "3", "100", 3);
        Question q3 = new Question("1+3", "6", "2", "4", "100", 3);
        Question q4 = new Question("1+4", "5", "2", "3", "100", 1);
        Question q5 = new Question("1+0", "1", "2", "3", "100", 1);
        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        arr.add(q5);

        shuffleQuestions(); // ערבוב השאלות
    }


    public void shuffleQuestions() {
        Collections.shuffle(arr);
    }

    public void initQuestion() {
        index = 0;
    }

    public Question getNextQuestion() {
        // הפעולה מחזירה הפנייה לשאלה הבאה
        Question q = arr.get(index);
        index++;
        return q;
    }

    public boolean isNotLastQuestion() {
        // הפעולה מחזירה אמת אם אנחנו בשאלה האחרונה
        return (index < arr.size()); // אם לא הגענו לשאלה האחרונה
    }

    public int getIndex() {
        return index;
    }
}
