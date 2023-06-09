package com.sample.kakao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CoffeeMenuDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "coffee_menu.db";
    private static final int DATABASE_VERSION = 1;

    // 커피 메뉴 테이블 정보
    private static final String TABLE_NAME = "coffee_menu";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PRICE = "price";

    public CoffeeMenuDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PRICE + " INTEGER)";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 스키마가 변경되었을 때 필요한 처리를 수행합니다.
        // 여기서는 간단하게 기존 테이블을 삭제하고 다시 생성하는 방식을 사용하였습니다.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

