package com.project.projectlevel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class PlayMusicActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private TextView currentDurationTextView;
    private SeekBar seekBar;
    private Timer timer;
    private ImageView playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        ImageView back=findViewById(R.id.back);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
HomePageLoader homePageLoader=new HomePageLoader(PlayMusicActivity.this);
    }
});

        setupMediaPlayer();
    }



    private void setupMediaPlayer() {


        mediaPlayer = new MediaPlayer();


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.partyrockanthem);
        mediaPlayer.start();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                setupViews();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_play, null));
            }
        });


    }



    private void setupViews() {
        playButton = (ImageView) findViewById(R.id.button_play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_play, null));
                } else {
                    mediaPlayer.start();
                    playButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_pause, null));
                }
            }
        });

        TextView duration = (TextView) findViewById(R.id.text_music_duration);
        duration.setText(formatDuration(mediaPlayer.getDuration()));
        currentDurationTextView = (TextView) findViewById(R.id.text_music_current_duration);
        currentDurationTextView.setText(formatDuration(0));

        ImageView forwardButton = (ImageView) findViewById(R.id.button_forward);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
            }
        });
        ImageView rewindButton = (ImageView) findViewById(R.id.button_rewind);
        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timer = new Timer();
        timer.schedule(new MainTimer(), 0, 1000);
    }

    private String formatDuration(long duration) {
        int seconds = (int) (duration / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format(Locale.ENGLISH, "%02d", minutes) + ":" + String.format(Locale.ENGLISH, "%02d", seconds);
    }

    private class MainTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    currentDurationTextView.setText(formatDuration(mediaPlayer.getCurrentPosition()));
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        if (timer != null && mediaPlayer != null) {
            timer.purge();
            timer.cancel();
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}