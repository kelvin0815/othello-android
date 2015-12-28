package hk.hku.cs.ass1_othello;

public class Board {

    private COLOR[][] board = new COLOR[8][8]; // 8x8 array storing COLOR
    private Player player1 = new Player(COLOR.BLACK); // Black player
    private Player player2 = new Player(COLOR.WHITE); // White player
    private Player currentPlayer = player1;

    public Board() {
        startGame();
    }

    // Initialize the board
    public void startGame() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
              board[i][j] = COLOR.EMPTY;
            }
        }

        // Reset currentPlayer
        currentPlayer = player1;

        // Chess at center
        placeChess(3, 4);
        nextTurn();
        placeChess(3, 3);
        nextTurn();
        placeChess(4, 3);
        nextTurn();
        placeChess(4, 4);
        nextTurn();
    }

    // Place chess at board[row][col]
    public void placeChess(int row, int col) {
        if(board[row][col] == COLOR.EMPTY) {
            if(currentPlayer.getColor() == COLOR.WHITE) {
                board[row][col] = COLOR.WHITE;
            }else if(currentPlayer.getColor() == COLOR.BLACK) {
                board[row][col] = COLOR.BLACK;
            }
        }
    }

    //Change currentPlayer
    public void nextTurn() {
        this.currentPlayer = (this.currentPlayer == player1) ? player2 : player1;
    }

    // Check the slot if it is a possible move
    public boolean chkSlot(int currentRow, int currentCol) {
        boolean flippable = false;

        //Check emptiness
        if(board[currentRow][currentCol] != COLOR.EMPTY) {
            return flippable;
        }

        // Scan the board in eight directions
        for (int dirRow = -1; dirRow < 2; dirRow++) {
            for (int dirCol = -1; dirCol < 2; dirCol++) {

                // Ignore zero direction (current position)
                if(dirRow == 0 && dirCol == 0) {
                    continue;
                }

                // board[newRow][newCol] are slots nearby current slot
                int newRow = currentRow + dirRow;
                int newCol = currentCol + dirCol;

                // Check board[newRow][newCol] in the board
                if (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7) {

                    // Check if board[newRow][newCol] is opposite color to currentPlayer
                    if (board[newRow][newCol] == (this.currentPlayer.getColor() == COLOR.WHITE ? COLOR.BLACK : COLOR.WHITE)) {
                        for (int range = 1; range < 8; range++) {

                            int nRow = currentRow + range * dirRow;
                            int nCol = currentCol + range * dirCol;

                            // Skip the case outside the board
                            if(nRow < 0 || nRow > 7 || nCol < 0 || nCol > 7) {
                                continue;
                            }

                            // break if we scan the empty slot before the closest slot with current player colour
                            if(board[nRow][nCol] == COLOR.EMPTY) {
                                break;
                            }

                            if(board[nRow][nCol] == this.currentPlayer.getColor()) {
                                flippable = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return flippable;
    }

    // Flip Chess
    public boolean flip(int currentRow, int currentCol) {
        boolean isValid = false;

        // Eight directions
        for(int dirRow = -1; dirRow < 2; dirRow++) {
            for(int dirCol = -1; dirCol < 2; dirCol++) {

                // Ignore zero direction (current position)
                if(dirRow == 0 && dirCol == 0) {
                    continue;
                }

                // board[newRow][newCol] is the slot nearby current slot
                int newRow = currentRow + dirRow;
                int newCol = currentCol + dirCol;

                // Check board[newRow][newCol] in the board
                if(newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7) {

                    // return true if board[newRow][newCol] is opposite color to currentPlayer
                    if(board[newRow][newCol] == (this.currentPlayer.getColor() == COLOR.BLACK ? COLOR.WHITE : COLOR.BLACK)) {
                        for(int range = 0; range < 8; range++) {

                            int nRow = currentRow + range * dirRow;
                            int nCol = currentCol + range * dirCol;

                            // Skip the case outside the board
                            if(nRow < 0 || nRow > 7 || nCol < 0 || nCol > 7) {
                                continue;
                            }

                            // Check if we can flip in this direction
                            if(board[nRow][nCol] == this.currentPlayer.getColor()) {
                                boolean canFlip = true;
                                for (int dist = 1; dist < range; dist++) {

                                    int testRow = currentRow + dist * dirRow;
                                    int testCol = currentCol + dist * dirCol;

                                    if (board[testRow][testCol] != (this.currentPlayer.getColor() == COLOR.BLACK ? COLOR.WHITE : COLOR.BLACK)) {
                                        canFlip = false;
                                    }
                                }

                                // Flip
                                if(canFlip) {
                                    for(int flipDist = 1; flipDist < range; flipDist++) {

                                        int finalRow = currentRow + flipDist * dirRow;
                                        int finalCol = currentCol + flipDist * dirCol;

                                        if(board[finalRow][finalCol] == (this.currentPlayer.getColor() == COLOR.BLACK ? COLOR.WHITE : COLOR.BLACK)) {
                                            board[finalRow][finalCol] = this.currentPlayer.getColor();
                                        }
                                    }
                                }
                                isValid = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isValid;
    }

    // Return the number of empty slots on board
    public int checkEnd() {
        int slotsLeft = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == COLOR.EMPTY) {
                    slotsLeft++;
                }
            }
        }
        return slotsLeft;
    }

    // getBoard
    public COLOR[][] getBoard() {
        return board;
    }

    // getCurrentPlayer
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Count chess
    public int count(COLOR color) {
        int num = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(board[row][col] == color) {
                    num++;
                }
            }
        }
        return num;
    }

}