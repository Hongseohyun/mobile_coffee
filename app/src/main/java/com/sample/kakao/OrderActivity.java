package com.sample.kakao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "coffee_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MENU = "menu";
    private static final String COLUMN_SIZE = "size";

    private SQLiteDatabase database;
    private ListView orderListView;
    private ArrayAdapter<String> orderListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        OrderDatabaseHelper dbHelper = new OrderDatabaseHelper(this);
        database = dbHelper.getReadableDatabase();

        orderListView = findViewById(R.id.orderListView);
        orderListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        orderListView.setAdapter(orderListAdapter);

        loadOrders();
        Button btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료하여 이전 액티비티로 돌아감
            }
        });
    }

    private void loadOrders() {
        List<String> orders = getAllOrders();
        orderListAdapter.clear();
        orderListAdapter.addAll(orders);
        orderListAdapter.notifyDataSetChanged();
    }

    private List<String> getAllOrders() {
        List<String> orders = new ArrayList<>();

        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, COLUMN_ID + " DESC");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String menu = cursor.getString(cursor.getColumnIndex(COLUMN_MENU));
            String size = cursor.getString(cursor.getColumnIndex(COLUMN_SIZE));

            String order = "ID: " + id + ", Menu: " + menu + ", Size: " + size;
            orders.add(order);
        }
        cursor.close();

        return orders;
    }

    private class OrderDatabaseHelper extends SQLiteOpenHelper {

        public OrderDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // 테이블 생성 등 초기 설정
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 업그레이드 시 필요한 작업 수행
        }
    }
}
