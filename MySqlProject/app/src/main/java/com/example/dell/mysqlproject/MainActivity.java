package com.example.dell.mysqlproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.mysqlproject.db.ToDoDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText task;
    Button add;
    ArrayList<Task> taskArrayList=new ArrayList<>();
    ToDoDatabase tb;
    Task newTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task=(EditText)findViewById(R.id.eTask);
        add=(Button)findViewById(R.id.addbtn);
        final TaskAdapter taskAdapter=new TaskAdapter(this);
        /*RecyclerView rvTasks=(RecyclerView)findViewById(R.id.recyclerView);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(taskAdapter);*/
        ListView rvTasks=(ListView)findViewById(R.id.list_view);
        rvTasks.setAdapter(taskAdapter);
        newTask=new Task(task.getText().toString(),false);
        tb=new ToDoDatabase(MainActivity.this);
        taskArrayList.addAll(tb.getAllTasks());
        taskAdapter.notifyDataSetChanged();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTask=new Task(task.getText().toString(),false);
                tb=new ToDoDatabase(MainActivity.this);
                tb.insertTask(newTask);
                taskArrayList.clear();
                taskArrayList.addAll(tb.getAllTasks());
                taskAdapter.notifyDataSetChanged();
            }
        });
        rvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* if(newTask.isDone()==false){
                    newTask.setDone(true);
                }
                if(newTask.isDone()==true){
                    newTask.setDone(false);
                }*/
                newTask.setDone(newTask.isDone()?false:true);
             taskArrayList.get(position).setDone(newTask.isDone());
                //newTask.setDone(!newTask.isDone());
                tb.update(newTask,String.valueOf(position));
                taskAdapter.notifyDataSetChanged();
            }
        });
        rvTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                taskArrayList.remove(position);
                taskAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
   /* public class TaskHolder extends RecyclerView.ViewHolder{
TextView taskName,status;
        public TaskHolder(View itemView) {
            super(itemView);
            taskName=(TextView)itemView.findViewById(R.id.tvTask);
            status=(TextView)itemView.findViewById(R.id.tvStatus);

        }
    }
    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder>
    {
        ArrayList<Task> taskArrayList;

        public TaskAdapter(ArrayList<Task> taskArrayList) {
            this.taskArrayList = taskArrayList;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v;
            v=getLayoutInflater().inflate(R.layout.single_list_item,parent,false);
            TaskHolder taskHolder=new TaskHolder(v);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
Task task=taskArrayList.get(position);
            holder.taskName.setText(task.getTaskName());
            holder.status.setText(task.isDone()?"Complete":"Pending");
        }
        @Override
        public int getItemCount() {
            return taskArrayList.size();
        }
    }*/
   public class TaskAdapter extends BaseAdapter {
       Context c;
       public TaskAdapter( Context context) {
           this.c=context;
       }

       @Override
       public int getCount() {

           return taskArrayList.size();
       }

       @Override
       public Object getItem(int position) {
           return null;
       }

       @Override
       public long getItemId(int position) {
           return 0;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           LayoutInflater l= LayoutInflater.from(c);
           View v;
           ViewHolder viewHolder;
           if(convertView==null) {
               v = l.inflate(R.layout.single_list_item, parent, false);
               viewHolder=new ViewHolder();
               viewHolder.taskName=(TextView)v.findViewById(R.id.tvTask);
               viewHolder.status=(TextView)v.findViewById(R.id.tvStatus);
               v.setTag(viewHolder);
           }
           else {
               v=convertView;
               viewHolder=(ViewHolder)v.getTag();
           }
           Task task=  taskArrayList.get(position);
           viewHolder.taskName.setText(task.getTaskName());
           viewHolder.status.setText(task.isDone()?"Complete":"Pending");
           return v;

       }
       class ViewHolder{
           TextView taskName,status;
       }
   }
}
