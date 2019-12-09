package com.example.dictionary.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.DefinitionActivity;
import com.example.dictionary.Model.Word;
import com.example.dictionary.R;
import com.example.dictionary.TranslationActivity;
import com.google.gson.Gson;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Word> wordList;

    public RecyclerViewAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = wordList.get(position);

        holder.wordText.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView wordText;
        private Button define_btn;
        private Button translate_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wordText = itemView.findViewById(R.id.word_text);
            define_btn = itemView.findViewById(R.id.define_btn);
            translate_btn = itemView.findViewById(R.id.translate_btn);

            define_btn.setOnClickListener(this);
            translate_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.define_btn:
                    int position = getAdapterPosition();
                    Word word = wordList.get(position);

                    Gson gson = new Gson();
                    String wordAsString = gson.toJson(word);

                    Intent i = new Intent(v.getContext(), DefinitionActivity.class);
                    i.putExtra("word", wordAsString);

                    v.getContext().startActivity(i);
                    break;
                case R.id.translate_btn:
                    int position2 = getAdapterPosition();
                    Word word2 = wordList.get(position2);

                    Gson gson2 = new Gson();
                    String wordAsString2 = gson2.toJson(word2);

                    Intent i2 = new Intent(v.getContext(), TranslationActivity.class);
                    i2.putExtra("word", wordAsString2);

                    v.getContext().startActivity(i2);
                    break;
            }

        }
    }
}
