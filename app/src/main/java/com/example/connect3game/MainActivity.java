package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    char color;
    boolean isRed;
    Board myBoard = new Board();

    public void playAgain(View view) {
        myBoard.createNewBoard();
    }

    class Board {

        char[][] board;
        boolean isNewBoard = false;

        public void createNewBoard() {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }

            ArrayList<ImageView> imageViews = new ArrayList<>();
            imageViews.add(findViewById(R.id.imageView00));
            imageViews.add(findViewById(R.id.imageView01));
            imageViews.add(findViewById(R.id.imageView02));
            imageViews.add(findViewById(R.id.imageView10));
            imageViews.add(findViewById(R.id.imageView11));
            imageViews.add(findViewById(R.id.imageView12));
            imageViews.add(findViewById(R.id.imageView20));
            imageViews.add(findViewById(R.id.imageView21));
            imageViews.add(findViewById(R.id.imageView22));

            for (ImageView i : imageViews) {
                i.setAlpha(0f);
                i.setImageResource(R.drawable.red);
            }
            TextView whoWon = findViewById(R.id.textView);
            Button myButton = findViewById(R.id.button);
            whoWon.setAlpha(0f);
            myButton.setVisibility(View.INVISIBLE);
            isRed = false;
        }

        public void checkWinner() {
            char winner = ' ';
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                    winner = board[i][0];
                }
            }
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                    winner = board[0][j];
                }
            }
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                winner = board[0][0];
            }
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
                winner = board[2][0];
            }
            if (winner == 'r') {
                showWinnerHeading("Red");
            } else if (winner == 'y') {
                showWinnerHeading("Yellow");
            }
        }

        public void showWinnerHeading(String winner) {
            TextView whoWon = findViewById(R.id.textView);
            Button myButton = findViewById(R.id.button);
            whoWon.setAlpha(1f);
            myButton.setVisibility(View.VISIBLE);
            whoWon.setText(winner + " has won");
        }
    }

    public void imageView00click(View view) {
        ImageView imageView00 = findViewById(R.id.imageView00);
        imageViewClicked(imageView00, 0, 0);
    }

    public void imageView01click(View view) {
        ImageView imageView01 = findViewById(R.id.imageView01);
        imageViewClicked(imageView01, 0, 1);
    }

    public void imageView02click(View view) {
        ImageView imageView02 = findViewById(R.id.imageView02);
        imageViewClicked(imageView02, 0, 2);
    }

    public void imageView10click(View view) {
        ImageView imageView10 = findViewById(R.id.imageView10);
        imageViewClicked(imageView10, 328, 10);
    }

    public void imageView11click(View view) {
        ImageView imageView11 = findViewById(R.id.imageView11);
        imageViewClicked(imageView11, 328, 11);
    }

    public void imageView12click(View view) {
        ImageView imageView12 = findViewById(R.id.imageView12);
        imageViewClicked(imageView12, 328, 12);
    }

    public void imageView20click(View view) {
        ImageView imageView20 = findViewById(R.id.imageView20);
        imageViewClicked(imageView20, 642, 20);
    }

    public void imageView21click(View view) {
        ImageView imageView21 = findViewById(R.id.imageView21);
        imageViewClicked(imageView21, 642, 21);
    }

    public void imageView22click(View view) {
        ImageView imageView22 = findViewById(R.id.imageView22);
        imageViewClicked(imageView22, 642, 22);
    }

    public void imageViewClicked(ImageView imageView, int distance, int space) {

        if (!myBoard.isNewBoard) {
            myBoard.createNewBoard();
            myBoard.isNewBoard = true;
        }

        imageView.setY(-1000);
        imageView.setAlpha(1f);
        imageView.animate().translationYBy(1000 + distance).setDuration(500);
        if (isRed) {
            imageView.setImageResource(R.drawable.yellow);
            color = 'y';
            isRed = false;
        } else {
            imageView.setImageResource(R.drawable.red);
            color = 'r';
            isRed = true;
        }

        switch (space) {
            case 0:
                myBoard.board[0][0] = color;
                break;
            case 1:
                myBoard.board[0][1] = color;
                break;
            case 2:
                myBoard.board[0][2] = color;
                break;
            case 10:
                myBoard.board[1][0] = color;
                break;
            case 11:
                myBoard.board[1][1] = color;
                break;
            case 12:
                myBoard.board[1][2] = color;
                break;
            case 20:
                myBoard.board[2][0] = color;
                break;
            case 21:
                myBoard.board[2][1] = color;
                break;
            case 22:
                myBoard.board[2][2] = color;
                break;
        }
        myBoard.checkWinner();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}