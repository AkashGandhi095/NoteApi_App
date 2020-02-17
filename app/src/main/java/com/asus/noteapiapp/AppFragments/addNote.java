package com.asus.noteapiapp.AppFragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.asus.noteapiapp.R;
import com.asus.noteapiapp.utils.ApiDataConstant;
import com.asus.noteapiapp.utils.ApiUrl;
import com.asus.noteapiapp.utils.SingletonRequest;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class addNote extends Fragment {


    public addNote() {
        // Required empty public constructor
    }

    private EditText noteTitle , noteDesc;
    private MaterialButton addNoteButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        initViews(view);


        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noteTitle.getText().toString().isEmpty() && noteDesc.getText().toString().isEmpty())
                    return;

                PostNotes();
            }
        });
    }

    private void PostNotes() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiUrl.API_POST_URL, getObject(0, noteTitle.getText().toString(), noteDesc.getText().toString()), null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("ERROR", "onErrorResponse: "+error.getMessage());

            }
        });
        SingletonRequest.getInstance(getActivity()).getRequestQueue().add(request);
    }

    private void initViews(View view) {
        noteTitle = view.findViewById(R.id.noteTitle);
        noteDesc = view.findViewById(R.id.noteDesc);
        addNoteButton = view.findViewById(R.id.addNoteButton);
    }

    private JSONObject getObject(int id , String title , String desc)
    {
        JSONObject object = new JSONObject();
        try {
            object.put(ApiDataConstant.TITLE_KEY , title);
            object.put(ApiDataConstant.DESC_KEY , desc);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }
}
