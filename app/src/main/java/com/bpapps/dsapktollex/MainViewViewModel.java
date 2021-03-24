package com.bpapps.dsapktollex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Note>> notes = new MutableLiveData<>(new ArrayList<>());


    public LiveData<ArrayList<Note>> getAllNotes() {
        return notes;
    }

    public void addNote(Note note) {
        ArrayList<Note> dataSet = notes.getValue();
        dataSet.add(note);
        notes.postValue(dataSet);
    }
}