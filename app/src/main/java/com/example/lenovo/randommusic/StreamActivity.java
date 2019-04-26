package com.example.lenovo.randommusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class StreamActivity extends AppCompatActivity {
    String mName="Hrllo";
    String mInfo="21321";
    String mUrl="fdsfds";
    TextView name,info;
 //   ArrayList<StationData> arrayList;
    MediaPlayer mediaPlayer;

   @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        releaseMediaplayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        name=(TextView)findViewById(R.id.station_name);
        info=(TextView)findViewById(R.id.station_info);
        Bundle bundle = getIntent().getExtras();
        mName=bundle.getString("Name");
        mInfo=bundle.getString("Info");
        mUrl=bundle.getString("Url");
        Log.v("UR:",  mUrl);
        info.setText(mInfo);
        name.setText(mName);

        releaseMediaplayer();
        mediaPlayer = new MediaPlayer();

        try{
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(mUrl);
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

            mediaPlayer.prepare(); }
        catch (Exception e){
            e.printStackTrace();
        }// might take long! (for buffering, etc)
        mediaPlayer.start();




    }
    public void releaseMediaplayer(){ if (mediaPlayer != null){
        mediaPlayer.stop();
        mediaPlayer.release();

        mediaPlayer=null;
    }}
}
