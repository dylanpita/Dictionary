package com.example.dictionary.Model;

public class Word {
    private String word;
    private String pos;
    private String definition;
    private String translation;

    public Word(String word, String pos, String definition, String translation) {
        this.word = word;
        this.pos = pos;
        this.definition = definition;
        this.translation = translation;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
