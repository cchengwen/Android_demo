package com.android_ch47_sqlite;


import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;


//public class MainActivity extends AppCompatActivity {
public class MainActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    private Button btn;
    private EditText name, sex;

    private MySql mySql;
    private SQLiteDatabase dbRead, dbWrite;
    //  是系统专门用来适配数据库的适配器
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.sure);
        name = findViewById(R.id.ed_name);
        sex = findViewById(R.id.ed_sex);

        mySql = new MySql(this);

        btn.setOnClickListener(this);

        //  实现数据库的读写
        dbRead = mySql.getReadableDatabase();
        dbWrite = mySql.getWritableDatabase();

        adapter = new SimpleCursorAdapter(this, R.layout.cell, null, new String[]{MySql.NAME, MySql.SEX}, new int[]{R.id.name, R.id.sex});
        // 邦定适配器
        setListAdapter(adapter);
        getListView().setOnItemLongClickListener(this);

        //  添加数据
//        ContentValues cv = new ContentValues();
//        cv.put("name", "张三");
//        cv.put("sex", "男");
//        dbWrite.insert(MySql.TABLE_NAME, null, cv);

        //  查询数据
        select();
    }

    //  查询数据库的方法
    public void select() {
        // 读取数据
        Cursor cursor = dbRead.query(MySql.TABLE_NAME, null, null, null, null, null, null);

        // 刷新UI
        adapter.changeCursor(cursor);
    }

    //  点击添加方法
    @Override
    public void onClick(View v) {
        System.out.println("======================================================");
        switch (v.getId()) {
            case R.id.sure:
                //  添加数据
                ContentValues cv = new ContentValues();
                cv.put(MySql.NAME, name.getText().toString());
                cv.put(MySql.SEX, sex.getText().toString());
                System.out.println(name.getText().toString()+"    "+sex.getText().toString());
                dbWrite.insert(MySql.TABLE_NAME, null, cv);

                //  查询数据
                select();
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("=========================545555555");
        return false;
    }
}
