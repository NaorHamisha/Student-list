package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.studentlist.BL.StudentsBL;

public class NewStudentActivity extends AppCompatActivity {

    private StudentsBL studentsBL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        studentsBL =  StudentsBL.instance();

        EditText nameEt = findViewById(R.id.new_student_name_et);
        EditText idEt = findViewById(R.id.new_student_id_et);
        EditText phoneEt = findViewById(R.id.new_student_phone_et);
        EditText addressEt = findViewById(R.id.new_student_address_et);
        CheckBox checkedCb = findViewById(R.id.new_student_checked_cb);
        Button cancelBtn = findViewById(R.id.new_student_cancel_btn);
        ImageView imageView = findViewById(R.id.new_student_img);
        Button saveBtn = findViewById(R.id.new_student_save_btn);

        imageView.setImageResource(R.drawable.avatar);

        cancelBtn.setOnClickListener(view -> finish());
        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            Boolean checked = checkedCb.isChecked();

            studentsBL.addStudent(name, id, address, phone, checked);
            finish();
        });
    }
}