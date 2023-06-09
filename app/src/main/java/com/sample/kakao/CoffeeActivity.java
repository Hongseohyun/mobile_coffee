package com.sample.kakao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CoffeeActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "coffee_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MENU = "menu";
    private static final String COLUMN_SIZE = "size";

    private SQLiteDatabase database;
    private RadioGroup radioGroup;
    private Spinner spinnerSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        CoffeeDatabaseHelper dbHelper = new CoffeeDatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        radioGroup = findViewById(R.id.radioGroup);
        spinnerSize = findViewById(R.id.spinnerSize);

        // 스피너에 옵션 추가
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.size_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(adapter);

        Button btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton checkedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String selectedMenu = checkedRadioButton.getText().toString();

                String selectedSize = spinnerSize.getSelectedItem().toString();
                addOrder(selectedMenu, selectedSize);

                Intent intent = new Intent(CoffeeActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        Button btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료하여 이전 액티비티로 돌아감
            }
        });
    }

    private void addOrder(String menu, String size) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MENU, menu);
        values.put(COLUMN_SIZE, size);
        database.insert(TABLE_NAME, null, values);
    }

    private class CoffeeDatabaseHelper extends SQLiteOpenHelper {

        public CoffeeDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_MENU + " TEXT, " +
                    COLUMN_SIZE + " TEXT)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
            db.execSQL(dropTableQuery);
            onCreate(db);
        }
    }
}
