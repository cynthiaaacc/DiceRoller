package cat.itb.diceroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private TextView title_textview;
    private Button roll_button;
    private ImageView result1_imageview;
    private ImageView result2_imageview;
    private Button restart_button;
    private int dado1, dado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll_button= (Button) findViewById(R.id.roll_button);
        restart_button= (Button) findViewById(R.id.restart_button);
        result1_imageview= (ImageView) findViewById(R.id.result1_imageview);
        result2_imageview= (ImageView) findViewById(R.id.result2_imageview);

        final int[] arrayDados={
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
        };

        roll_button.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Random numAleatori = new Random();
                dado1 = numAleatori.nextInt(6);
                result1_imageview.setImageResource(arrayDados[dado1]);

                dado2 = numAleatori.nextInt(6);
                result2_imageview.setImageResource(arrayDados[dado2]);

                if (dado1==dado2 && dado1==5){
                    Toast.makeText(getApplicationContext(),"JACKPOT!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        restart_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.recreate();
            }
        });

        result1_imageview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Random numAleatori = new Random();
                dado1 = numAleatori.nextInt(6);
                result1_imageview.setImageResource(arrayDados[dado1]);


                if (dado1==dado2 && dado1==5){
                    Toast.makeText(getApplicationContext(),"JACKPOT!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        result2_imageview.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Random numAleatori = new Random();

                dado2 = numAleatori.nextInt(6);
                result2_imageview.setImageResource(arrayDados[dado2]);

                if (dado1==dado2 && dado1==5){
                    Toast.makeText(getApplicationContext(),"JACKPOT!!", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}