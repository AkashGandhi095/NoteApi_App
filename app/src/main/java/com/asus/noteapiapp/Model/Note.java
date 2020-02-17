package com.asus.noteapiapp.Model;

public class Note {
    private int id;
    private String noteTitle , noteDesc;

    public Note(int id, String noteTitle, String noteDesc) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc;
    }
}
