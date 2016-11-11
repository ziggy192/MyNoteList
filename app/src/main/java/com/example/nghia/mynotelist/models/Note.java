package com.example.nghia.mynotelist.models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nghia on 11/11/2016.
 */

public class Note {
    public static final Note[] startingContents = new Note[]{
            new Note("First heading \n content"),
            new Note("Second heading \n second content"),
            new Note("Tools for learning Android\n" +
                    " PC or MAC with at least 4GB RAM\n" +
                    "Android Studio\n" +
                    "Genymotion or other simulation tools")
    };


    public static final ArrayList<Note> notes = new ArrayList(Arrays.asList(startingContents));




    private String content;

    public Note(String content) {
        this.content = content;
    }

    public Note() {
        this.content = new String() ;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        int indexOfNextLine = content.indexOf('\n');
        String firstLine;
        if (indexOfNextLine != -1) {

            firstLine = content.substring(0, indexOfNextLine);
        } else {
            firstLine = content;
        }

        return firstLine;
    }
}
