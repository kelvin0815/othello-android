package hk.hku.cs.ass1_othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button start_game = (Button)findViewById(R.id.home_start_game);

        start_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent  = new Intent(view.getContext(), GameActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

