package com.example.nextandprevios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NextAndPrevious extends AppCompatActivity {

    ImageView imageView2;
    Button previous,next;
    int i=0;
    private int[] textureArrayWin = {R.drawable.one,R.drawable.two, R.drawable.three,R.drawable.four,R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_and_previous);

        imageView2 = (ImageView)findViewById(R.id.imageView2);
        previous  = (Button)findViewById(R.id.previous);
        next = (Button)findViewById(R.id.next);
        /*if(i==0){
            previous.setVisibility(View.GONE);
        }
        if (i==2){
            next.setVisibility(View.GONE);
        }*/

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i > 0)
                    i--;

                imageView2.setImageResource(textureArrayWin[i]);
                /*imageView2.setImageResource(textureArrayWin[i]);
                i--;*/
                /*if(i==0){
                    previous.setVisibility(View.GONE);} else{ previous.setVisibility(View.VISIBLE);}
                if (i==2){
                    next.setVisibility(View.GONE);
                } else{
                    next.setVisibility(View.VISIBLE);
                }*/
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if you are loading from bitmap

                if(i < 4 )
                    i++;

                imageView2.setImageResource(textureArrayWin[i]);
                /*imageView2.setImageResource(textureArrayWin[i]);
                i++;*/
                /*if(i==0){
                    previous.setVisibility(View.GONE); } else {previous.setVisibility(View.VISIBLE); }
                if (i==2){
                    next.setVisibility(View.GONE);
                } else{
                    next.setVisibility(View.VISIBLE);
                }*/
            }
        });
    }
}