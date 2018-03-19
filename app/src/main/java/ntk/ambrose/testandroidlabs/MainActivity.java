package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animRotate;
    ImageView imagePokeball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        animRotate= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate_anim);
        animRotate.setDuration(3000);
        animRotate.setRepeatMode(Animation.RESTART);
        animRotate.setRepeatCount(Animation.INFINITE);

        animRotate.setAnimationListener(this);

        imagePokeball = findViewById(R.id.imgPokeball);
        imagePokeball.setAnimation(animRotate);

        //animRotate.start();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
