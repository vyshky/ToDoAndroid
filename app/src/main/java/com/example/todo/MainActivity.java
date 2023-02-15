package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> task = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RefreshTasks();

        TextView enterTextView = findViewById(R.id.enterText);
        Button addTaskView = findViewById(R.id.addTask);

        addTaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskText = String.valueOf(enterTextView.getText()).trim();
                if (!taskText.equals("")) {
                    enterTextView.setText(new String());
                    task.add(1 + task.size()+". " + taskText);
                    RefreshTasks();
                }
            }
        });

    }

    public void RefreshTasks() {
        ListView taskListView = findViewById(R.id.taskList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, task);
        taskListView.setAdapter(adapter);
    }
}