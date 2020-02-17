package com.asus.noteapiapp.AppFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asus.noteapiapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class displayNote extends Fragment {


    public displayNote() {
        // Required empty public constructor
    }


    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_note, container, false);
        initRecyclerView(view);

        view.findViewById(R.id.AddNoteFab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavHostFragment.findNavController(displayNote.this).navigate(R.id.action_displayNote_to_addNote);

            }
        });

        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView noteView = view.findViewById(R.id.noteRecyclerView);


    }

}
