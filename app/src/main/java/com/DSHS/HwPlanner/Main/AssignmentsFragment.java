package com.DSHS.HwPlanner.Main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class AssignmentsFragment extends Fragment {
    public static final int NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE = 2;

    private AssignmentViewModel mAssignmentViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assignment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // recycler view code
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_assignments);
        final AssignmentListAdapter adapter = new AssignmentListAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mAssignmentViewModel = ViewModelProviders.of(this).get(AssignmentViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.

        mAssignmentViewModel.getmAllAssignments().observe(this, new Observer<List<Assignment>>() {
            @Override
            public void onChanged(@Nullable final List<Assignment> assignments) {
                adapter.setAssignments(assignments);
            }
        });

        // button for adding assignments
        FloatingActionButton fab = view.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewAssignmentActivity.class);
                startActivityForResult(intent, NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    // adding new words to the database
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Assignment assignment = new Assignment(0, data.getStringExtra(NewAssignmentActivity.EXTRA_REPLY),
                    1, 2, 3, "math", "recursion");
            mAssignmentViewModel.insert(assignment);
        } else {
            Toast.makeText(
                    getContext().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }


}


