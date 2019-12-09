package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dictionary.Adapter.RecyclerViewAdapter;
import com.example.dictionary.Data.AnswerListAsyncResponse;
import com.example.dictionary.Data.WordBank;
import com.example.dictionary.Model.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Word> wordList;

    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordList = new WordBank().getWordList(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Word> wordArrayList) {
                recyclerView = findViewById(R.id.word_recycler);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, wordArrayList);

                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });

    }
}
