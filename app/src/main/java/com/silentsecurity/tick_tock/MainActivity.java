package com.silentsecurity.tick_tock;

import android.graphics.Color;
import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buclick(View view) {
        Button buSelected = (Button) view;
        buSelected.setBackgroundColor(Color.RED);
        int CellID = 0;
        switch ((buSelected.getId())) {
            case R.id.bu1:
                CellID = 1;
                break;
            case R.id.bu2:
                CellID = 2;
                break;
            case R.id.bu3:
                CellID = 3;
                break;
            case R.id.bu4:
                CellID = 4;
                break;
            case R.id.bu5:
                CellID = 5;
                break;
            case R.id.bu6:
                CellID = 6;
                break;
            case R.id.bu7:
                CellID = 7;
                break;
            case R.id.bu8:
                CellID = 8;
                break;
            case R.id.bu9:
                CellID = 9;
                break;
        }
        PlayGame(CellID, buSelected);
    }

    int ActivePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();

    void PlayGame(int CellID, Button button) {
        Log.d("Player:", String.valueOf(CellID));


        if (ActivePlayer == 1) {
            button.setText("X");
            button.setBackgroundColor(Color.GREEN);
            Player1.add(CellID);
            ActivePlayer = 2;
            AutoPlay();

        }
        else if (ActivePlayer == 2) {
            button.setText("O");
            button.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer = 1;
        }
        button.setEnabled(false);
        Checkwiner();
    }


    void Checkwiner() {
        int winer=-1;
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winer=1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winer=2;
        }
        //row2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winer=1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winer=2;
        }
        //row=3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winer=1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winer=2;
        }
        // colm=1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winer=1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winer=2;
        }

        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winer=1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winer=2;
        }

        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winer=1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winer=2;
        }
        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winer=1;
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winer=2;
        }
        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {
            winer=1;
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)) {
            winer=2;
        }
        if (winer !=-1) {
            if (winer==1) {
                Toast.makeText(this, "Player1 is winer", Toast.LENGTH_LONG).show();
            }

            if (winer==2) {
                Toast.makeText(this, "Player2 is winer", Toast.LENGTH_LONG).show();
            }
        }
    }
    void AutoPlay(){
      ArrayList<Integer> EmptyCell= new  ArrayList<Integer>();
        //find empty cell
        Integer cellID=0;
        for(cellID=0; cellID<10; cellID++){
            if(!(Player1.contains(cellID) || Player2.contains(cellID))) {
                    EmptyCell.add(cellID);
                }
        }
        Random r= new Random();
        int RandIndex=r.nextInt(EmptyCell.size()-0)+0;
        int CellID=EmptyCell.get(RandIndex);
        Button buSelected;
        switch (CellID) {
            case 1:
                buSelected=(Button)findViewById(R.id.bu1);
                break;
            case 2:
                buSelected=(Button)findViewById(R.id.bu2);
                break;
            case 3:
                buSelected=(Button)findViewById(R.id.bu3);
                break;
            case 4:
                buSelected=(Button)findViewById(R.id.bu4);
                break;
            case 5:
                buSelected=(Button)findViewById(R.id.bu5);
                break;
            case 6:
                buSelected=(Button)findViewById(R.id.bu6);
                break;
            case 7:
                buSelected=(Button)findViewById(R.id.bu7);
                break;
            case 8:
                buSelected=(Button)findViewById(R.id.bu8);
                break;
            case 9:
                buSelected=(Button)findViewById(R.id.bu9);
                break;
                default:
                    buSelected=(Button)findViewById(R.id.bu1);
                    break;

        }
        PlayGame(CellID, buSelected);

        }
    }

