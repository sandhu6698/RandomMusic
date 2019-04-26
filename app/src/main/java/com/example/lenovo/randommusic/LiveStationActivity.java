package com.example.lenovo.randommusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LiveStationActivity extends AppCompatActivity {
    ArrayList<StationData> data;
    ListView listView;
    StationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_station);
        listView = (ListView)findViewById(R.id.list_station);
        data= new ArrayList<StationData>();
        data.add(new StationData("http://50.7.68.251:7064/stream","Hindi - Bollywood","Bollywood Latest Hits"));
        data.add(new StationData("http://192.240.102.133:11454/stream","Hindi - Evergreen","Listen to Evergreen Hits of Bollywood"));
        data.add(new StationData("http://50.7.68.251:7064/stream","Radio HSL","HSL Top SuperHits"));
        data.add(new StationData("http://64.71.79.181:5124/stream","Retro Radio","Top Indian Retro Hits"));
        data.add(new StationData("http://s2.voscast.com:7016/;?icy=http","Punjabi Radio USA","Punjabi Radio Live from USA"));
        data.add(new StationData("http://s3.voscast.com:7798/;?icy=http","Khalsa FM","Gurbani, Katha, Talk shows, Punjabi Geet"));
        data.add(new StationData("http://192.151.153.234:9988/punjab","Punjab Rocks Radio","Punjabi Music #0098"));
        data.add(new StationData("http://188.166.176.244:8012/stream","Radio Hindi International","Unsung Delights"));
        data.add(new StationData("http://s7.voscast.com:10844/;?icy=http","Radio Hindi International","Unsung Delights"));
        data.add(new StationData("http://streaming.radionomy.com/JamendoLounge?lang=en-US%2cen%3bq%3d0.9%2chi%3bq%3d0.8","Indian Beats Factory","Country Blues - blues"));
        data.add(new StationData("http://66.85.88.174/hot108","Hot 108 JAMS","Hip hop"));
        data.add(new StationData("http://206.190.135.28:8332/stream","Gizmo Groove","Old School - Rap"));
        data.add(new StationData("http://s6.voscast.com:10898/;?icy=http","939.40 AT THAT RADIO ","West Coast - Rap"));
        data.add(new StationData("http://149.202.45.235:8000/stream.mp3","Radio Galaxie","Soft Rock"));



        adapter = new StationAdapter(LiveStationActivity.this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           // StreamActivity object = new StreamActivity(data.get(position).getName(),data.get(position).getInfo(),data.get(position).getUrl());

            Intent i = new Intent(getApplicationContext(),StreamActivity.class);
                 Bundle bundle = new Bundle();
                 bundle.putString("Name",data.get(position).getName());
                 bundle.putString("Info",data.get(position).getInfo());
                 bundle.putString("Url",data.get(position).getUrl());
                 i.putExtras(bundle);
                 startActivity(i);

            }
        });
    }
}
