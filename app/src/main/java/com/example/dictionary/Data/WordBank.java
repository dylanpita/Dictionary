package com.example.dictionary.Data;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.dictionary.AppController;
import com.example.dictionary.Model.Word;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordBank {

    private String url = "https://my-json-server.typicode.com/cgerard321/dictionary/dictionary";

    private ArrayList<Word> wordArrayList = new ArrayList<>();

    public List<Word> getWordList(final AnswerListAsyncResponse callback) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) /*callback method*/ {

                        for (int i = 0; i < response.length(); i++) {
                            Word w = new Word();
                            try {
                                w.setWord(response.getJSONObject(i).getString("word"));
                                w.setPos(response.getJSONObject(i).getString("pos"));
                                w.setDefinition(response.getJSONObject(i).getString("definition"));
                                w.setTranslation(response.getJSONObject(i).getString("french"));

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            wordArrayList.add(w);
                        }
                        if (null != callback) {
                            //Collections.shuffle(questionArrayList);
                            callback.processFinished(wordArrayList);
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return wordArrayList;
    }
}
