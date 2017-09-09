package mars_williams.codepathtodoapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import mars_williams.codepathtodoapp.R;

public class EditToDoTaskActivity extends AppCompatActivity {

    private static final String EXTRA_SELECTED_TODO_TASK_DESCRIPTION = "extra_selected_todo_task_description";
    private static final String EXTRA_SELECTED_TODO_TASK_POSITION = "extra_selected_todo_task_position";

    public static final String RESULT_EXTRA_EDITED_TODO_TASK_DESCRIPTION = "result_extra_edited_todo_task_description";
    public static final String RESULT_EXTRA_EDITED_TODO_TASK_POSITION = "result_extra_edited_todo_task_position";

    private EditText selectedTodoTask;
    private String selectedToDoTaskDescription;
    private int selectedToDoTaskPosition;

    public static Intent intent(Context context) {
        return new Intent(context, EditToDoTaskActivity.class);
    }

    public static Intent intentForEditItem(
            Context context,
            String selectedToDoTaskDescription,
            int selectedToDoTaskPosition) {
        return intent(context)
                .putExtra(EXTRA_SELECTED_TODO_TASK_DESCRIPTION, selectedToDoTaskDescription)
                .putExtra(EXTRA_SELECTED_TODO_TASK_POSITION, selectedToDoTaskPosition);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do_list);

        // retrieve intent extras
        Intent intent = getIntent();
        selectedToDoTaskDescription = intent.getStringExtra("extra_selected_todo_task_description");
        selectedToDoTaskPosition = intent.getIntExtra("extra_selected_todo_task_position", -1);

        // set up view references
        selectedTodoTask = (EditText) findViewById(R.id.editTask);

        selectedTodoTask.setText(selectedToDoTaskDescription);
    }

    public void onSaveTask(View v) {
        // prepare the data
        Intent data = new Intent();
        data.putExtra(RESULT_EXTRA_EDITED_TODO_TASK_POSITION, selectedToDoTaskPosition);
        data.putExtra(RESULT_EXTRA_EDITED_TODO_TASK_DESCRIPTION, selectedTodoTask.getText().toString());

        // return the result data
        // set result code and bundle data for response
        // close the activity, pass data to parent
        setResult(RESULT_OK, data);
        finish();
    }
}
