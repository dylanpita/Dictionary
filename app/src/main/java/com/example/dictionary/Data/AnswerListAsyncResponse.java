package com.example.dictionary.Data;

import com.example.dictionary.Model.Word;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {

    void processFinished(ArrayList<Word> wordArrayList);
}
