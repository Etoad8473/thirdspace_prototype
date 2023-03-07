package com.example.switching_tab;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileWindows extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofilewindows);
    }
    /*
    public void showPopupWindow(final View view){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = (View) inflater.inflate(R.layout.editprofilewindows, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        boolean focusable = true;

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionevent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

     */


}
