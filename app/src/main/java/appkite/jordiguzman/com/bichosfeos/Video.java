package appkite.jordiguzman.com.bichosfeos;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    String url[] = {
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F01_pulga_gato.mp4?alt=media&token=a7f51f96-d8a0-4dd3-b4d0-10a0252ef4f1",
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F02_piojo.mp4?alt=media&token=c17ef249-144c-4ae9-afd5-bd74629287c2",
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F03_mosca_fruta.mp4?alt=media&token=886cc58e-6125-4543-94bc-66fd3d31ae87",
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F04_ojo_mosquito.mp4?alt=media&token=8ccb2232-0430-4b2b-9963-573e631841ac",
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F05_variadas1.mp4?alt=media&token=d2d5446b-a9cb-4921-a52f-3933562d9797",
            "https://firebasestorage.googleapis.com/v0/b/xatentresol-87375.appspot.com/o/videos%2F06_variadas2.mp4?alt=media&token=e120500b-6c0b-40bb-a8f3-0cbca3de21fb"
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


        try{
            mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);


            uriPath = url[MenuVideo.video];
            uri2 = Uri.parse(uriPath);
            videoView.setVideoURI(uri2);
            videoView.requestFocus();


            videoView.setMediaController(mediaController);
            progressBar.setVisibility(View.VISIBLE);

        }catch (Exception e){
            Log.d("Error", e.getCause().toString());
        }
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
               videoView.start();
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        progressBar.setVisibility(View.GONE);
                        videoView.start();
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
