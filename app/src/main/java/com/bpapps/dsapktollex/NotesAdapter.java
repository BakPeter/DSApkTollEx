package com.bpapps.dsapktollex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> mDataSet;
    private Context mContext;

    public NotesAdapter(@NonNull List<Note> mDataSet, @NonNull Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    public void addNote(Note note) {
        mDataSet.add(note);

        notifyDataSetChanged();
    }

    public void addNotes(List<Note> notes) {
        mDataSet = notes;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
//        View view = parent.inflate(mContext, R.layout.item_note, parent);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvNote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNote = itemView.findViewById(R.id.tvNote);
        }

        public void bind(Note note) {
            tvNote.setText(note.getText());
        }
    }
}
