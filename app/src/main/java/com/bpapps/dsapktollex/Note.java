package com.bpapps.dsapktollex;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Note {
    private String text;

    public Note(@NonNull String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
