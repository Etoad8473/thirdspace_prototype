package com.example.switching_tab.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.switching_tab.databinding.FragmentEventBinding;

public class EventFragment extends Fragment {

private FragmentEventBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        EventViewModel eventViewModel =
                new ViewModelProvider(this).get(EventViewModel.class);

    binding = FragmentEventBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textEvent;
        eventViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}