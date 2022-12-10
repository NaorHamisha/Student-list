package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.studentlist.BL.StudentsBL;
import com.example.studentlist.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    private StudentsBL studentsBL;
    private String currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Student std = (Student) getIntent().getSerializableExtra("student");

        currentId  = std.id;
        studentsBL =  StudentsBL.instance();

        EditText nameEt = findViewById(R.id.edit_student_name_et);
        EditText idEt = findViewById(R.id.edit_student_id_et);
        EditText phoneEt = findViewById(R.id.edit_student_phone_et);
        EditText addressEt = findViewById(R.id.edit_student_address_et);
        CheckBox checkedCb = findViewById(R.id.edit_student_checked_cb);
        ImageView imageView = findViewById(R.id.edit_student_img);
        Button cancelBtn = findViewById(R.id.edit_student_cancel_btn);
        Button saveBtn = findViewById(R.id.edit_student_save_btn);
        Button deleteBtn = findViewById(R.id.edit_student_delete_btn);

        imageView.setImageResource(R.drawable.avatar);
        nameEt.setText(std.name);
        idEt.setText(std.id);
        phoneEt.setText(std.phone);
        addressEt.setText(std.address);
        checkedCb.setChecked(std.cb);

        cancelBtn.setOnClickListener(view ->{
            Intent studentIntent = new Intent(this, StudentDetailsActivity.class);
            studentIntent.putExtra("student", std);
            startActivity(studentIntent);
            finish();
        });
        deleteBtn.setOnClickListener(view ->  {
            studentsBL.deleteStudentByID(currentId);
            Intent studentIntent = new Intent(this, MainActivity.class);
            startActivity(studentIntent);
            finish();
        });
        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            Boolean checked = checkedCb.isChecked();

            Student st = new Student(name, id, address, phone, checked);
            studentsBL.editStudent(currentId, st);
            currentId = id;
            Intent studentIntent = new Intent(this, StudentDetailsActivity.class);
            studentIntent.putExtra("student", st);
            startActivity(studentIntent);
            finish();
        });


    }
}