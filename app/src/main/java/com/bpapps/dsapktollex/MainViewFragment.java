package com.bpapps.dsapktollex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainViewFragment extends Fragment {

    private MainViewViewModel mViewModel;

    private AppCompatEditText mEdNote;
    private AppCompatButton mBtnAddNote;
    private RecyclerView mRvNotes;

    private NotesAdapter mNotesAdapter;

    public static MainViewFragment newInstance() {
        return new MainViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_view_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewViewModel.class);


        mEdNote = view.findViewById(R.id.edNote);

        mBtnAddNote = view.findViewById(R.id.btnAddNote);
        mBtnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEdNote.getText().toString();
//                Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show();

                if (text.length() > 0) {
//                    Toast.makeText(requireContext(), text.length() + "233", Toast.LENGTH_SHORT).show();
                    mViewModel.addNote(new Note(text));
                }
            }
        });

        mRvNotes = view.findViewById(R.id.rvNotes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        mRvNotes.setLayoutManager(layoutManager);
        mRvNotes.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        mNotesAdapter = new NotesAdapter(mViewModel.getAllNotes().getValue(), requireContext());
        mRvNotes.setAdapter(mNotesAdapter);
        mViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                mNotesAdapter.addNotes(notes);
            }
        });
    }
}