package com.example.switching_tab.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.switching_tab.EditProfileWindows;
import com.example.switching_tab.R;
import com.example.switching_tab.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment implements View.OnClickListener {

private FragmentProfileBinding binding;
private Button editProfileBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);


    binding = FragmentProfileBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    editProfileBtn = (Button) root.findViewById(R.id.editProfileButton);

    editProfileBtn.setOnClickListener(this);
        final TextView textView = binding.textProfile;
        profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.editProfileButton:
                startActivity(new Intent(getActivity(), EditProfileWindows.class));
                break;
            default:
                break;
        }
    }
}