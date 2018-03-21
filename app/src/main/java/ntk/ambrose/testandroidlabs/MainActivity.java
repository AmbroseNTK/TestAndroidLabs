package ntk.ambrose.testandroidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animRotate;
    ImageView imagePokeball;
    Button btViewPokemon;
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

        btViewPokemon=findViewById(R.id.btShowAll);

        btViewPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowListPokemonActivity.class);
                startActivity(intent);

            }
        });

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
