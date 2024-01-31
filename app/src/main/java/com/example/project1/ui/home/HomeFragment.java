package com.example.project1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.databinding.FragmentHomeBinding;
import com.google.android.material.textfield.TextInputLayout;

import com.example.project1.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<String> inputList = new ArrayList<>();

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Update the TextView with the list of inputs
        final TextView inputListTextView = binding.inputListTextView; // assuming this is the ID of your TextView
        homeViewModel.getInputListText().observe(getViewLifecycleOwner(), inputListTextView::setText);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputLayout textInputLayout = view.findViewById(R.id.input);
                if (textInputLayout != null && textInputLayout.getEditText() != null) {
                    String text = textInputLayout.getEditText().getText().toString();
                    homeViewModel.addInput(text);
                    Toast.makeText(getActivity(), "Input saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Rest of your onCreateView code

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
