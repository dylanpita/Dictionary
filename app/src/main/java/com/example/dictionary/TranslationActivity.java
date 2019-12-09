package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dictionary.Model.Word;
import com.google.gson.Gson;

public class TranslationActivity extends AppCompatActivity {

    private TextView eng_text;
    private TextView fre_text;

    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        eng_text = findViewById(R.id.word_text_eng);
        fre_text = findViewById(R.id.word_text_fr);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Gson gson = new Gson();
            String wordAsString = bundle.getString("word");
            word = gson.fromJson(wordAsString, Word.class);
        }

        eng_text.setText(word.getWord());
        fre_text.setText(word.getTranslation());
    }
}
