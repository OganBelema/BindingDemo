package com.anushka.androidtutz.bindingdemo1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anushka.androidtutz.bindingdemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;

    private MainActivityClickHandlers mMainActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.setStudent(getCurrentStudent());

        mMainActivityClickHandlers = new MainActivityClickHandlers(this);
        mActivityMainBinding.setClickHandler(mMainActivityClickHandlers);
    }

    private Student getCurrentStudent(){

        Student student = new Student();
        student.setStudentName("Alex");
        student.setStudentEmail("alex@gmail.com");
        return student;

    }

    public class MainActivityClickHandlers {
        final Context mContext;

        public MainActivityClickHandlers(Context context) {
            mContext = context;
        }

        public void onEnrollButtonClicked(View view){
            Toast.makeText(mContext, "Enroll clicked!", Toast.LENGTH_LONG)
                    .show();
        }

        public void onCancelButtonClicked(View view){
            Toast.makeText(mContext, "Cancel clicked", Toast.LENGTH_LONG)
                    .show();
        }


    }
}
