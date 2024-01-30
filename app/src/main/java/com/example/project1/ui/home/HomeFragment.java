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
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.FragmentHomeBinding;
import com.google.android.material.textfield.TextInputLayout;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TextInputLayout textInputLayout = view.findViewById(R.id.input);
//                if (textInputLayout != null && textInputLayout.getEditText() != null) {
//                    String text = String.valueOf(textInputLayout.getEditText().getText());
//                    // Rest of your code
//                }

                Toast myToast = Toast.makeText(getActivity(), "Hellow world", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView textView1 = binding.textView2;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        homeViewModel.getText2().observe(getViewLifecycleOwner(), textView1::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}