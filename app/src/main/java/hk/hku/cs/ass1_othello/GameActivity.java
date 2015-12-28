package hk.hku.cs.ass1_othello;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements View.OnClickListener {
    private Board b = new Board();

    public Button newGame;
    public Button hint;
    public int hint_button = 0; // Default turn-off

    public ImageButton current;
    public TextView whiteCount;
    public TextView blackCount;
    public ImageButton[][] imageButtons = new ImageButton[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        whiteCount = (TextView)findViewById(R.id.whiteNum);
        blackCount = (TextView)findViewById(R.id.blackNum);

        newGame = (Button)findViewById(R.id.newGame);
        newGame.setOnClickListener(this);

        hint = (Button)findViewById(R.id.hint);
        hint.setOnClickListener(this);

        current = (ImageButton)findViewById(R.id.current);

        imageButtons[0][0] = (ImageButton)findViewById(R.id.board11);
        imageButtons[0][1] = (ImageButton)findViewById(R.id.board12);
        imageButtons[0][2] = (ImageButton)findViewById(R.id.board13);
        imageButtons[0][3] = (ImageButton)findViewById(R.id.board14);
        imageButtons[0][4] = (ImageButton)findViewById(R.id.board15);
        imageButtons[0][5] = (ImageButton)findViewById(R.id.board16);
        imageButtons[0][6] = (ImageButton)findViewById(R.id.board17);
        imageButtons[0][7] = (ImageButton)findViewById(R.id.board18);
        imageButtons[1][0] = (ImageButton)findViewById(R.id.board21);
        imageButtons[1][1] = (ImageButton)findViewById(R.id.board22);
        imageButtons[1][2] = (ImageButton)findViewById(R.id.board23);
        imageButtons[1][3] = (ImageButton)findViewById(R.id.board24);
        imageButtons[1][4] = (ImageButton)findViewById(R.id.board25);
        imageButtons[1][5] = (ImageButton)findViewById(R.id.board26);
        imageButtons[1][6] = (ImageButton)findViewById(R.id.board27);
        imageButtons[1][7] = (ImageButton)findViewById(R.id.board28);
        imageButtons[2][0] = (ImageButton)findViewById(R.id.board31);
        imageButtons[2][1] = (ImageButton)findViewById(R.id.board32);
        imageButtons[2][2] = (ImageButton)findViewById(R.id.board33);
        imageButtons[2][3] = (ImageButton)findViewById(R.id.board34);
        imageButtons[2][4] = (ImageButton)findViewById(R.id.board35);
        imageButtons[2][5] = (ImageButton)findViewById(R.id.board36);
        imageButtons[2][6] = (ImageButton)findViewById(R.id.board37);
        imageButtons[2][7] = (ImageButton)findViewById(R.id.board38);
        imageButtons[3][0] = (ImageButton)findViewById(R.id.board41);
        imageButtons[3][1] = (ImageButton)findViewById(R.id.board42);
        imageButtons[3][2] = (ImageButton)findViewById(R.id.board43);
        imageButtons[3][3] = (ImageButton)findViewById(R.id.board44);
        imageButtons[3][4] = (ImageButton)findViewById(R.id.board45);
        imageButtons[3][5] = (ImageButton)findViewById(R.id.board46);
        imageButtons[3][6] = (ImageButton)findViewById(R.id.board47);
        imageButtons[3][7] = (ImageButton)findViewById(R.id.board48);
        imageButtons[4][0] = (ImageButton)findViewById(R.id.board51);
        imageButtons[4][1] = (ImageButton)findViewById(R.id.board52);
        imageButtons[4][2] = (ImageButton)findViewById(R.id.board53);
        imageButtons[4][3] = (ImageButton)findViewById(R.id.board54);
        imageButtons[4][4] = (ImageButton)findViewById(R.id.board55);
        imageButtons[4][5] = (ImageButton)findViewById(R.id.board56);
        imageButtons[4][6] = (ImageButton)findViewById(R.id.board57);
        imageButtons[4][7] = (ImageButton)findViewById(R.id.board58);
        imageButtons[5][0] = (ImageButton)findViewById(R.id.board61);
        imageButtons[5][1] = (ImageButton)findViewById(R.id.board62);
        imageButtons[5][2] = (ImageButton)findViewById(R.id.board63);
        imageButtons[5][3] = (ImageButton)findViewById(R.id.board64);
        imageButtons[5][4] = (ImageButton)findViewById(R.id.board65);
        imageButtons[5][5] = (ImageButton)findViewById(R.id.board66);
        imageButtons[5][6] = (ImageButton)findViewById(R.id.board67);
        imageButtons[5][7] = (ImageButton)findViewById(R.id.board68);
        imageButtons[6][0] = (ImageButton)findViewById(R.id.board71);
        imageButtons[6][1] = (ImageButton)findViewById(R.id.board72);
        imageButtons[6][2] = (ImageButton)findViewById(R.id.board73);
        imageButtons[6][3] = (ImageButton)findViewById(R.id.board74);
        imageButtons[6][4] = (ImageButton)findViewById(R.id.board75);
        imageButtons[6][5] = (ImageButton)findViewById(R.id.board76);
        imageButtons[6][6] = (ImageButton)findViewById(R.id.board77);
        imageButtons[6][7] = (ImageButton)findViewById(R.id.board78);
        imageButtons[7][0] = (ImageButton)findViewById(R.id.board81);
        imageButtons[7][1] = (ImageButton)findViewById(R.id.board82);
        imageButtons[7][2] = (ImageButton)findViewById(R.id.board83);
        imageButtons[7][3] = (ImageButton)findViewById(R.id.board84);
        imageButtons[7][4] = (ImageButton)findViewById(R.id.board85);
        imageButtons[7][5] = (ImageButton)findViewById(R.id.board86);
        imageButtons[7][6] = (ImageButton)findViewById(R.id.board87);
        imageButtons[7][7] = (ImageButton)findViewById(R.id.board88);

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                imageButtons[i][j].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newGame:

                b.startGame();
                printBoard();
                current.setImageResource(R.drawable.black_chess);

                whiteCount.setText("WHITE : " + b.count(COLOR.WHITE));
                blackCount.setText("BLACK : " + b.count(COLOR.BLACK));

                // Reset hint parameter
                hint_button = 0;

                break;

            case R.id.hint:
                hint_button = (this.hint_button == 1) ? 0 : 1; //Turn on/off once the hint button is clicked

                if(hint_button == 1) {
                    showPossibleMove();
                } else {
                    NotShowPossibleMove();
                }
                break;

            case R.id.board11:
                chessAction(0, 0);
                break;

            case R.id.board12:
                chessAction(0, 1);
                break;

            case R.id.board13:
                chessAction(0, 2);
                break;

            case R.id.board14:
                chessAction(0, 3);
                break;

            case R.id.board15:
                chessAction(0, 4);
                break;

            case R.id.board16:
                chessAction(0, 5);
                break;

            case R.id.board17:
                chessAction(0, 6);
                break;

            case R.id.board18:
                chessAction(0, 7);
                break;

            case R.id.board21:
                chessAction(1, 0);
                break;

            case R.id.board22:
                chessAction(1, 1);
                break;

            case R.id.board23:
                chessAction(1, 2);
                break;

            case R.id.board24:
                chessAction(1, 3);
                break;

            case R.id.board25:
                chessAction(1, 4);
                break;

            case R.id.board26:
                chessAction(1, 5);
                break;

            case R.id.board27:
                chessAction(1, 6);
                break;

            case R.id.board28:
                chessAction(1, 7);
                break;

            case R.id.board31:
                chessAction(2, 0);
                break;

            case R.id.board32:
                chessAction(2, 1);
                break;

            case R.id.board33:
                chessAction(2, 2);
                break;

            case R.id.board34:
                chessAction(2, 3);
                break;

            case R.id.board35:
                chessAction(2, 4);
                break;

            case R.id.board36:
                chessAction(2, 5);
                break;

            case R.id.board37:
                chessAction(2, 6);
                break;

            case R.id.board38:
                chessAction(2, 7);
                break;

            case R.id.board41:
                chessAction(3, 0);
                break;

            case R.id.board42:
                chessAction(3, 1);
                break;

            case R.id.board43:
                chessAction(3, 2);
                break;

            case R.id.board44:
                chessAction(3, 3);
                break;

            case R.id.board45:
                chessAction(3, 4);
                break;

            case R.id.board46:
                chessAction(3, 5);
                break;

            case R.id.board47:
                chessAction(3, 6);
                break;

            case R.id.board48:
                chessAction(3, 7);
                break;

            case R.id.board51:
                chessAction(4, 0);
                break;

            case R.id.board52:
                chessAction(4, 1);
                break;

            case R.id.board53:
                chessAction(4, 2);
                break;

            case R.id.board54:
                chessAction(4, 3);
                break;

            case R.id.board55:
                chessAction(4, 4);
                break;

            case R.id.board56:
                chessAction(4, 5);
                break;

            case R.id.board57:
                chessAction(4, 6);
                break;

            case R.id.board58:
                chessAction(4, 7);
                break;

            case R.id.board61:
                chessAction(5, 0);
                break;

            case R.id.board62:
                chessAction(5, 1);
                break;

            case R.id.board63:
                chessAction(5, 2);
                break;

            case R.id.board64:
                chessAction(5, 3);
                break;

            case R.id.board65:
                chessAction(5, 4);
                break;

            case R.id.board66:
                chessAction(5, 5);
                break;

            case R.id.board67:
                chessAction(5, 6);
                break;

            case R.id.board68:
                chessAction(5, 7);
                break;

            case R.id.board71:
                chessAction(6, 0);
                break;

            case R.id.board72:
                chessAction(6, 1);
                break;

            case R.id.board73:
                chessAction(6, 2);
                break;

            case R.id.board74:
                chessAction(6, 3);
                break;

            case R.id.board75:
                chessAction(6, 4);
                break;

            case R.id.board76:
                chessAction(6, 5);
                break;

            case R.id.board77:
                chessAction(6, 6);
                break;

            case R.id.board78:
                chessAction(6, 7);
                break;

            case R.id.board81:
                chessAction(7, 0);
                break;

            case R.id.board82:
                chessAction(7, 1);
                break;

            case R.id.board83:
                chessAction(7, 2);
                break;

            case R.id.board84:
                chessAction(7, 3);
                break;

            case R.id.board85:
                chessAction(7, 4);
                break;

            case R.id.board86:
                chessAction(7, 5);
                break;

            case R.id.board87:
                chessAction(7, 6);
                break;

            case R.id.board88:
                chessAction(7, 7);
                break;
        }
    }

    public void chessAction(int row, int col) {

        if(b.checkEnd() != 0 && HasPossibleMove()) {
            if(b.chkSlot(row, col)) {
                // Flip chess
                b.flip(row, col);
                b.placeChess(row, col);
                printBoard();

                // Update white and black number
                whiteCount.setText("WHITE : " + b.count(COLOR.WHITE));
                blackCount.setText("BLACK : " + b.count(COLOR.BLACK));

                // Change turn and check if the next player has possible move
                if(b.checkEnd() != 0) {
                    b.nextTurn();
                    buttonChange(current);

                    if(!HasPossibleMove()) {
                        Toast.makeText(GameActivity.this, R.string.no_move, Toast.LENGTH_LONG).show();
                        b.nextTurn();
                        buttonChange(current);
                        if(!HasPossibleMove()) {
                            showWinMessage();
                        }
                    }

                    //Update hint
                    if(hint_button == 1) {
                        showPossibleMove();
                    } else {
                        NotShowPossibleMove();
                    }

                }

                // Show win message for the last play
                if(b.checkEnd() == 0) {
                    showWinMessage();
                }

            }
        } else if(b.checkEnd() == 0) {
            Toast.makeText(GameActivity.this, R.string.restart, Toast.LENGTH_SHORT).show();
        }

    }

    public void buttonChange(ImageButton img_button) {
        if (b.getCurrentPlayer().getColor() == COLOR.BLACK) {
            img_button.setImageResource(R.drawable.black_chess);
        } else if (b.getCurrentPlayer().getColor() == COLOR.WHITE) {
            img_button.setImageResource(R.drawable.white_chess);
        } else {
            img_button.setImageResource(R.drawable.transparent);
        }
    }

    public void printBoard() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(b.getBoard()[i][j] == COLOR.BLACK) {
                    imageButtons[i][j].setImageResource(R.drawable.black_chess);
                } else if(b.getBoard()[i][j] == COLOR.WHITE) {
                    imageButtons[i][j].setImageResource(R.drawable.white_chess);
                } else if(b.getBoard()[i][j] == COLOR.EMPTY) {
                    imageButtons[i][j].setImageResource(R.drawable.transparent);
                }
            }
        }
    }

    public boolean HasPossibleMove() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(b.chkSlot(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void showPossibleMove() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if(b.getBoard()[row][col] == COLOR.EMPTY && b.chkSlot(row, col)) {
                    if(b.getCurrentPlayer().getColor() == COLOR.BLACK) {
                        imageButtons[row][col].setImageResource(R.drawable.black_chess_t);
                    } else if(b.getCurrentPlayer().getColor() == COLOR.WHITE) {
                        imageButtons[row][col].setImageResource(R.drawable.white_chess_t);
                    }
                }
            }
        }
    }

    public void NotShowPossibleMove() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if(b.getBoard()[row][col] == COLOR.EMPTY && b.chkSlot(row, col)) {
                    if(b.getCurrentPlayer().getColor() == COLOR.BLACK) {
                        imageButtons[row][col].setImageResource(R.drawable.transparent);
                    } else if(b.getCurrentPlayer().getColor() == COLOR.WHITE) {
                        imageButtons[row][col].setImageResource(R.drawable.transparent);
                    }
                }
            }
        }
    }

    public void showWinMessage() {
        if (b.count(COLOR.BLACK) > b.count(COLOR.WHITE)) {
            Toast.makeText(GameActivity.this, R.string.black_wins, Toast.LENGTH_LONG).show();
        } else if (b.count(COLOR.BLACK) < b.count(COLOR.WHITE)) {
            Toast.makeText(GameActivity.this, R.string.white_wins, Toast.LENGTH_LONG).show();
        } else if (b.count(COLOR.BLACK) == b.count(COLOR.WHITE)) {
            Toast.makeText(GameActivity.this, R.string.ties, Toast.LENGTH_LONG).show();
        }
    }


}
