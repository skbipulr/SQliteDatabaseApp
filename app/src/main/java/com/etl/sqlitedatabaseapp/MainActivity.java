package com.etl.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.etl.sqlitedatabaseapp.database.EmployeeDatabaseSource;
import com.etl.sqlitedatabaseapp.model.Employee;

public class MainActivity extends AppCompatActivity {


    //SQLiteOpenHelper--->Create Database , Table
    //SQLiteDatabase --->CRUD--->insert,delete,update, query
    //ContentValue ---->insert,update
    //Cursor-->put query data

    private EditText employeeNameET,employeeDesignationET;
    private EmployeeDatabaseSource  databaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        employeeNameET = findViewById(R.id.employeeDesignationET);
        employeeDesignationET = findViewById(R.id.employeeDesignationET);
        databaseSource = new EmployeeDatabaseSource(this);
    }

    public void insertDataSave(View view) {
        String name,designation;
        name = employeeNameET.getText().toString();
        designation = employeeDesignationET.getText().toString();

        Employee employee = new Employee(name,designation);
        boolean status  = databaseSource.insertEmployee(employee);

        if (status){
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Failed to Save", Toast.LENGTH_SHORT).show();
        }
    }
}
