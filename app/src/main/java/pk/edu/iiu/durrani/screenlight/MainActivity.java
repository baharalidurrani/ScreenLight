package pk.edu.iiu.durrani.screenlight;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private boolean layoutColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.layout);
        constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toggleLayoutColor();
                return false;
            }
        });
        Toast.makeText(this, "Long click to change color", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fullBrightness();
        fullScreen();
    }

    private void fullBrightness() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 1f;
        getWindow().setAttributes(layoutParams);
    }

    private void fullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void toggleLayoutColor() {
        if (layoutColor) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            layoutColor = false;
        } else {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            layoutColor = true;
        }
    }
}
