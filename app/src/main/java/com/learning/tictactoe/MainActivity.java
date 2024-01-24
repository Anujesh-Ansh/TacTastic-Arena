package com.learning.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flag=0; // to check whether its an odd move or even move
    int count=0; // to count the no. of moves
    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9; // object creation
    String b1, b2, b3, b4, b5, b6, b7, b8, b9; // used to store the value of the buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        // initializing
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
    }

    public void Check(View view) {
        AppCompatButton btnCurrent = (AppCompatButton) view;
        String bCurrent = btnCurrent.getText().toString();

        if (bCurrent.equals("")) {
            count++;

            if (flag == 0) {
                btnCurrent.setText("X");
                flag=1;
            } else if (flag == 1) {
                btnCurrent.setText("O");
                flag=0;
            }

            if (count >= 5) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // Check for a winner
                if (checkForWinner()) {
                    bCurrent = btnCurrent.getText().toString();
                    Toast.makeText(getApplicationContext(), "Winner is: " + bCurrent, Toast.LENGTH_LONG).show();
                    reset(flag);
                }
                else if (count == 9) {
                    Toast.makeText(getApplicationContext(), "It's a draw!", Toast.LENGTH_SHORT).show();
                    reset(2);
                    // You might want to reset the game or perform other actions here
                }
            }
        }
    }

    private boolean checkForWinner(){
        return
                        // Horizontal
                        b1.equals(b2) && b2.equals(b3) && !b1.equals("") ||
                        b4.equals(b5) && b5.equals(b6) && !b4.equals("") ||
                        b7.equals(b8) && b8.equals(b9) && !b7.equals("") ||

                        // Vertical
                        b1.equals(b4) && b4.equals(b7) && !b1.equals("") ||
                        b2.equals(b5) && b5.equals(b8) && !b2.equals("") ||
                        b3.equals(b6) && b6.equals(b9) && !b3.equals("") ||

                        // Diagonal
                        b1.equals(b5) && b5.equals(b9) && !b1.equals("") ||
                        b3.equals(b5) && b5.equals(b7) && !b3.equals("");
    }

    public void reset(int f){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        if(f==1 || f==2){
            flag=0;
        }
        else{
            flag=1;
        }
        count=0;
    }

}