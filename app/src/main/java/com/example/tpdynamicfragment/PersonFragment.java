package com.example.tpdynamicfragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpdynamicfragment.model.Person;
import com.example.tpdynamicfragment.model.PersonDao;

public class PersonFragment extends Fragment implements Communication {

    private PersonViewModel mViewModel;
    RecyclerView recyclerView;
    Communication parentContext;

    public static PersonFragment newInstance() {
        return new PersonFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PersonViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.person_fragment, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            PersonRecyclerViewAdapter adapter = new PersonRecyclerViewAdapter(PersonDao.getPersons(), this);
            recyclerView.setAdapter(adapter);
        }

        return root;
    }

    @Override
    public void onSend(View source, int selectedIndex) {
        parentContext.onSend(source, selectedIndex);
    }

    @Override
    public void onReceived(View source, int selectedIndex, String nom, String prenom, String date) {
        // nothing
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Communication) {
            parentContext = (Communication) context;
        }
    }
}