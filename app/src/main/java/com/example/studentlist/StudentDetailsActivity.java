package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentlist.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Student std = (Student) getIntent().getSerializableExtra("student");

        TextView nameTv = findViewById(R.id.student_details_name_tv);
        TextView idTt = findViewById(R.id.student_details_id_tv);
        TextView phoneTt = findViewById(R.id.student_details_phone_tv);
        TextView addressTt = findViewById(R.id.student_details_address_tv);
        CheckBox checkedCb = findViewById(R.id.student_details_checked_cb);
        ImageView imgView = findViewById(R.id.student_details_img);
        Button editBtn = findViewById(R.id.student_details_edit_btn);

        nameTv.setText(std.name);
        idTt.setText(std.id);
        phoneTt.setText(std.phone);
        addressTt.setText(std.address);
        checkedCb.setChecked(std.cb);
        imgView.setImageResource(R.drawable.avatar);

        editBtn.setOnClickListener(view -> {
            Intent studentIntent = new Intent(this, EditStudentActivity.class);
            studentIntent.putExtra("student", std);
            startActivity(studentIntent);
            finish();
        });
    }
}