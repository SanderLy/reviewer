package com.example.androidstudio.gawaranl;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.StringWriter;
import java.util.regex.Pattern;

public class activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        final ImageView imgTouch;
        final TextView lblx1, lbly1, lblx2, lbly2, lbldiffx, lbldiffy, lblmotion, lblquadrant;



        imgTouch = (ImageView) findViewById(R.id.imgAndroid);
        lblx1 = (TextView) findViewById(R.id.txtX1);
        lbly1 = (TextView) findViewById(R.id.txtY1);
        lblx2 = (TextView) findViewById(R.id.txtX2);
        lbly2 = (TextView) findViewById(R.id.txtY2);
        lbldiffx = (TextView) findViewById(R.id.txtdiffX);
        lbldiffy = (TextView) findViewById(R.id.txtdiffY);
        lblmotion = (TextView) findViewById(R.id.txtmotion);
        lblquadrant = (TextView) findViewById(R.id.txtquadrant);


        imgTouch.setOnTouchListener(new View.OnTouchListener(){
            String x1="";
            String y1="";
            String x2="";
            String y2="";
            String diffx=""; String diffy = ""; String quad = "";
            float cursorX=0;
            float cursorY=0;
            float cursorX2=0;
            float cursorY2=0;
            String message="";
            public boolean onTouch(View v, MotionEvent motion){

                switch(motion.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        cursorX = motion.getX(); cursorY = motion.getY();
                        x1+=cursorX;
                        y1+=cursorY;
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        cursorX2 = motion.getX(); cursorY2 = motion.getY();
                        x2+=cursorX2;
                        y2+=cursorY2;
                        if (cursorX < cursorX2){

                            message = message+"Swiped Right ";
                        }
                        if (cursorX2 < cursorX){
                            message = message+"Swiped Left ";
                        }

                        if (cursorY < cursorY2){

                            message = message+"Swiped Down ";
                        }
                        if (cursorY2 < cursorY){
                            message = message+"Swiped Up ";
                        }

                        if (cursorX<=cursorX2){
                            diffx+= cursorX2 - cursorX;
                        }
                        else if (cursorX2<cursorX){
                            diffx+= cursorX - cursorX2;
                        }

                        if (cursorY<=cursorY2){
                            diffy += cursorY2 - cursorY;
                        }else if (cursorY2<cursorY){
                            diffy+= cursorY -cursorY2;
                        }

                        if (imgTouch.getWidth()/2>cursorX2 && imgTouch.getHeight()/2>cursorY2){
                            quad+="quadrant 2";
                        }else if (imgTouch.getWidth()/2>cursorX2 && imgTouch.getHeight()/2<cursorY2) {
                            quad += "quadrant 3";
                        }else if (imgTouch.getWidth()/2<cursorX2 && imgTouch.getHeight()/2>cursorY2){
                            quad+="quadrant 1";
                        }else if (imgTouch.getWidth()/2<cursorX2 && imgTouch.getHeight()/2<cursorY2){
                            quad+= "quadrant 4";
                        }else if (imgTouch.getWidth()/2==cursorX2 && imgTouch.getHeight()/2==cursorY2){
                            quad+= "center";
                        }


                        lblx1.setText(x1);
                        lbly1.setText(y1);

                        lblx2.setText(x2);
                        lbly2.setText(y2);

                        lbldiffx.setText(diffx);
                        lbldiffy.setText(diffy);
                        lblquadrant.setText(quad);

                        lblmotion.setText(message);
                        message= "";
                        x1 = ""; y1 = ""; x2 = ""; y2 = ""; diffx = "";diffy=""; quad = "";

                        break;
                    }
                }


                return true;
            }

        });


    }
}
