package com.example.crybaby;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class listSongs extends AppCompatActivity {
   MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
      final ArrayList<String> songList = getIntent().getStringArrayListExtra("songList");
         Log.i("list",songList.toString());

        songAdapter itemsAdapter = new songAdapter(this, songList);
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                String word = songList.get(position);
                Log.i("songname",word);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = new MediaPlayer();
                try {
                    mMediaPlayer.setDataSource(word);
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mMediaPlayer.start();
                Toast.makeText(listSongs.this, "Recording Playing",
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
