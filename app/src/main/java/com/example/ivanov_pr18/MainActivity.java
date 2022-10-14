package com.example.ivanov_pr18;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    //Создаём массив разделов:
    private String titles[] = {
            "00. Введение",
            "01. Процессор",
            "02. Материнская плата",
            "03. Оперативная память",
            "04. Жёсткий диск (HDD) и SSD",
            "05. Видеокарта",
            "06. Блок питания (БП)",
            "07. Корпус компьютера",
            "08. Монитор",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);

                intent.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
}
