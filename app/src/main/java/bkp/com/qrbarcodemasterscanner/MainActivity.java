package bkp.com.qrbarcodemasterscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Constant time delay (2.5 seconds)
    private final int SPLASH_DELAY = 2500;

    // Fields(Widget)
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawable(null);

        initializeView();
        animateLogo();
        goToMainActivity();

    }

    private void goToMainActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }, SPLASH_DELAY);

    }

    private void animateLogo() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this,R.anim.fade_in_without_duration);
        fadingInAnimation.setDuration(SPLASH_DELAY);
        imageView.startAnimation(fadingInAnimation);
    }

    private void initializeView() {
        imageView = findViewById(R.id.imageView);
    }
}