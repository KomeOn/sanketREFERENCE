package com.example.dell.mysqlproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dell.mysqlproject.Task;

import java.util.ArrayList;

import static com.example.dell.mysqlproject.db.TableTask.COLUMN_ID;
import static com.example.dell.mysqlproject.db.TableTask.COLUMN_IS_DONE;
import static com.example.dell.mysqlproject.db.TableTask.COLUMN_TASK;
import static com.example.dell.mysqlproject.db.TableTask.COMMA;
import static com.example.dell.mysqlproject.db.TableTask.CREATE;
import static com.example.dell.mysqlproject.db.TableTask.INT_PK_AUTOIC;
import static com.example.dell.mysqlproject.db.TableTask.LBR;
import static com.example.dell.mysqlproject.db.TableTask.RBR;
import static com.example.dell.mysqlproject.db.TableTask.TABLE_NAME;
import static com.example.dell.mysqlproject.db.TableTask.TERMINATE;
import static com.example.dell.mysqlproject.db.TableTask.TYPE_INTEGER;
import static com.example.dell.mysqlproject.db.TableTask.TYPE_TEXT;
import static com.example.dell.mysqlproject.db.TableTask.WHEN_UPGRADING_FROM_1_2;

/**
 * Created by dell on 7/14/2017.
 */

public class ToDoDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="tasks.db";
    public static final int VERSION=1;
    public ToDoDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE= CREATE+TABLE_NAME+LBR+COLUMN_ID+INT_PK_AUTOIC+COMMA+COLUMN_TASK+TYPE_TEXT+COMMA+COLUMN_IS_DONE+TYPE_INTEGER+RBR+TERMINATE;
db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL(WHEN_UPGRADING_FROM_1_2);
    }
    public void insertTask(Task task){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_TASK,task.getTaskName());
        contentValues.put(COLUMN_IS_DONE,task.isDone());
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }
    public ArrayList<Task> getAllTasks(){
        ArrayList<Task> tasks=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor c=database.query(TABLE_NAME,null,null,null,null,null,COLUMN_ID+" DESC ");
        while (c.moveToNext())
        {
            String task;
            int id;
            boolean status;
            int taskColumn=c.getColumnIndex(COLUMN_TASK);
            int idColumn=c.getColumnIndex(COLUMN_ID);
            int isStatus=c.getColumnIndex(COLUMN_IS_DONE);
            task=c.getString(taskColumn);
            id=c.getInt(idColumn);
            status=(1==c.getInt(isStatus));
            tasks.add(new Task(task,id,status));
        }
        c.close();
        return tasks;
    }
    public void update(Task task,String position)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_IS_DONE,task.isDone());
        sqLiteDatabase.update(TABLE_NAME,contentValues,"COLUMN_ID = ?",new String[] {position} );
    }
}
