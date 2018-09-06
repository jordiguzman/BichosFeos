package appkite.jordiguzman.com.bichosfeos;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    String url[] = {
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F01_pulga_gato.mp4?alt=media&token=3df4dd53-fefd-4d20-ae7d-8faefc39ff04",
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F02_piojo.mp4?alt=media&token=8a3005dc-833a-4747-97a2-5a8dd27c2487",
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F03_mosca_fruta.mp4?alt=media&token=95cca4bb-ea2e-4528-baaf-cc9ed3ebe13b",
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F04_ojo_mosquito.mp4?alt=media&token=16a45b42-0fda-4dab-bc1f-c2da2b626cb6",
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F05_variadas1.mp4?alt=media&token=741ef166-f998-4fcf-a840-e93e70763501",
            "https://firebasestorage.googleapis.com/v0/b/friendychat-1e0b0.appspot." +
                    "com/o/video%2F06_variadas2.mp4?alt=media&token=9face498-5872-4f4d-8af5-aa8f8fe7719e"
    };

    VideoView videoView;
    String uriPath;
    Uri uri2;
    Toolbar toolbar;
    MediaController mediaController;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        try {
            getSupportActionBar().hide();
        }catch (Exception e){
            e.printStackTrace();
        }

        getWindow().setFormat(PixelFormat.UNKNOWN);

        videoView = (VideoView) findViewById(R.id.vv_video);
        progressBar = (ProgressBar) findViewById(R.id.pb_video);


        switch (MenuVideo.video) {
            case 0:
                repVideo();
                break;
            case 1:
                repVideo();
                break;
            case 2:
                repVideo();
                break;
            case 3:
                repVideo();
                break;
            case 4:
                repVideo();
                break;
            case 5:
                repVideo();
                break;
        }


    }

    public void repVideo() {



        uriPath = url[MenuVideo.video];
        uri2 = Uri.parse(uriPath);
        videoView.setVideoURI(uri2);
        videoView.requestFocus();

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        progressBar.setVisibility(View.VISIBLE);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        progressBar.setVisibility(View.GONE);
                        mp.start();
                    }
                });
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int time = videoView.getCurrentPosition();
        outState.putInt("cont", time);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int cont = savedInstanceState.getInt("cont");
        videoView.seekTo(cont);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent in= new Intent(Video.this, MenuVideo.class);
        startActivity(in);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}
