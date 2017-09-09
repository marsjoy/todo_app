package mars_williams.codepathtodoapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mars_williams.codepathtodoapp.R;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 42;

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView toDoTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toDoTasks = (ListView)findViewById(R.id.toDoTasks);
        readItems();

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        toDoTasks.setAdapter(itemsAdapter);

        setupListViewListener();
    }

    public void addNewToDoTasks(View v) {
        EditText newToDoTask = (EditText)findViewById(R.id.newToDoTask);
        String toDoTaskDescription = newToDoTask.getText().toString();
        itemsAdapter.add(toDoTaskDescription);
        newToDoTask.setText("");
        writeItems();
    }

    public void updateToDoTask(int editedToDoTaskPosition, String editedToDoTaskDescription) {
        items.set(editedToDoTaskPosition, editedToDoTaskDescription);
        itemsAdapter.notifyDataSetChanged();
        writeItems();
    }

    private void setupListViewListener() {
        toDoTasks.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }

                }
        );
        toDoTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedToDoTaskDescription = items.get(position);
                launchEditItemActivity(selectedToDoTaskDescription, position);
            }
        });
    }

    public void launchEditItemActivity(String selectedToDoTaskDescription, int position) {
        // create intent for edit task activity
        Intent intent = EditToDoTaskActivity
                .intentForEditItem(
                        MainActivity.this,
                        selectedToDoTaskDescription,
                        position);

        // start edit task activity
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

            // Extract name value from result extras
            int editedToDoTaskPosition = data.getExtras().getInt("result_extra_edited_todo_task_position");
            String editedToDoTaskDescription = data.getExtras().getString("result_extra_edited_todo_task_description");
            updateToDoTask(editedToDoTaskPosition, editedToDoTaskDescription);
        }
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
