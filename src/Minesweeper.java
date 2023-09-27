public class Minesweeper {
    private String[][] board;
    private String[][] guesses;
    private int mines;
    private boolean status = true;
    long time;

    //Creates the board and randomly places the mines on it
    //Difficulty 1 = 10x10 board, 10 mines
    //Difficulty 2 = 18x18 board, 40 mines
    //Difficulty 2 = 24x24 board, 99 mines
    public Minesweeper(int size, long startTime){
        time = startTime;
        if(size == 1){
            board = new String[10][10];
            guesses = new String[10][10];
            mines = 10;
        }else if(size == 2){
            board = new String[18][18];
            guesses = new String[18][18];
            mines = 40;
        }else{
            board = new String[24][24];
            guesses = new String[24][24];
            mines = 99;
        }
        for(int a = 0; a < board.length; a++){
            for(int b = 0; b < board.length; b++){
                board[a][b] = " ";
                guesses[a][b] = " ";
            }
        }
        for(int i = 0; i < mines; i++){
            int x = (int)(Math.random() * board.length);
            int y = (int)(Math.random() * board.length);
            if(board[x][y].equals("X")){
                i--;
            }else{
                board[x][y] = "X";
            }
        }
    }

    //Prints the board with the mines, mines are red, and the mine the player hits is bold
    public void printBoard(){
        int ii = 0;
        if(board.length == 10){
            System.out.println("\u001B[31m" + "  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |" + "\u001B[0m");
            System.out.println("\u001B[31m__\u001B[0m" + "_________________________________________");
            for(String[] a : board){
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m__\u001B[0m" + "_________________________________________");
            }
        }else if(board.length == 18){
            System.out.println("\u001B[31m" + "   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14| 15| 16| 17|" + "\u001B[0m");
            System.out.println("\u001B[31m___\u001B[0m" + "_________________________________________________________________________");
            for(String[] a : board){
                if(ii<10){
                    System.out.print(" ");
                }
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m___\u001B[0m" + "_________________________________________________________________________");
            }
        }else if(board.length == 24){
            System.out.println("\u001B[31m" + "   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14| 15| 16| 17| 18| 19| 20| 21| 22| 23|" + "\u001B[0m");
            System.out.println("\u001B[31m___\u001B[0m" + "_________________________________________________________________________________________________");
            for(String[] a : board){
                if(ii<10){
                    System.out.print(" ");
                }
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m___\u001B[0m" + "_________________________________________________________________________________________________");
            }
        }
    }

    //Prints the board with the players guesses, mines are red, and the mine the player hits is bold
    public void printGuesses(){
        int ii = 0;
        if(board.length == 10){
            System.out.println("\u001B[31m" + "  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |" + "\u001B[0m");
            System.out.println("\u001B[31m__\u001B[0m" + "_________________________________________");
            for(String[] a : guesses){
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m__\u001B[0m" + "_________________________________________");
            }
        }else if(board.length == 18){
            System.out.println("\u001B[31m" + "   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14| 15| 16| 17|" + "\u001B[0m");
            System.out.println("\u001B[31m___\u001B[0m" + "_________________________________________________________________________");
            for(String[] a : guesses){
                if(ii<10){
                    System.out.print(" ");
                }
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m___\u001B[0m" + "_________________________________________________________________________");
            }
        }else if(board.length == 24){
            System.out.println("\u001B[31m" + "   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14| 15| 16| 17| 18| 19| 20| 21| 22| 23|" + "\u001B[0m");
            System.out.println("\u001B[31m___\u001B[0m" + "_________________________________________________________________________________________________");
            for(String[] a : guesses){
                if(ii<10){
                    System.out.print(" ");
                }
                System.out.print("\u001B[31m" + ii + "\u001B[0m" + " | ");
                ii++;
                for(String b : a){
                    if(b.equals("!")){
                        System.out.print("\u001B[1m\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else if(b.equals("X")){
                        System.out.print("\u001B[31m" + "X" + "\u001B[0m" + " | ");
                    }else{
                        System.out.print(b + " | ");
                    }
                }
                System.out.println("\n\u001B[31m___\u001B[0m" + "_________________________________________________________________________________________________");
            }
        }
    }

    //Places the user's guess on the guess board
    //If the user hits the mine, it ends the game and prints the end message
    //If the user doesn't hit a mine, it changes the value of the square to the number of mines around that square
    //If there are no mines around that square, then zeros() is called
    //Then the program checks if the user has won by counting the squares that aren't blank in the guesses array
    //if the number of empty squares is greater than or equal to the amount of squares minus the amount of mines,
    //then the player won and the final board is printed showing where the mines are
    public void guess(int x, int y){
        if(board[x][y].equals("X")){
            long elapsed = System.currentTimeMillis() - time;
            //System.out.print("\033\143");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("YOU LOSE. Elapsed time: ");
            if(elapsed/1000/60 < 10){
                System.out.print("0" + elapsed/1000/60 + ":");
            }else{
                System.out.print(elapsed/1000/60 + ":");
            }
            if(elapsed/1000%60 < 10){
                System.out.println("0" + elapsed/1000%60);
            }else{
                System.out.println(elapsed/1000%60);
            }
            for(int a = 0; a < board.length; a++){
                for(int b = 0; b < board.length; b++){
                    if(!guesses[a][b].equals(" ")){
                        board[a][b] = guesses[a][b];
                    }
                }
            }
            board[x][y] = "!";
            this.printBoard();
            status = false;
        }else if(board[x][y].equals(" ")){
            int count = 0;
            if(x > 0 && y > 0 && board[x - 1][y - 1].equals("X")){
                count++;
            }
            if(x > 0 && board[x - 1][y].equals("X")){
                count++;
            }
            if(x > 0 && y < board.length - 1 && board[x - 1][y + 1].equals("X")){
                count++;
            }
            if(y > 0 && board[x][y - 1].equals("X")){
                count++;
            }
            if(y < board.length - 1 && board[x][y + 1].equals("X")){
                count++;
            }
            if(x < board.length - 1 && y > 0 && board[x + 1][y - 1].equals("X")){
                count++;
            }
            if(x < board.length - 1 && board[x + 1][y].equals("X")){
                count++;
            }
            if(x < board.length - 1 && y < board.length - 1 && board[x + 1][y + 1].equals("X")){
                count++;
            }
            guesses[x][y] = Integer.toString(count);
            if(count == 0){
                this.zeros(x,y);
            }
            if(this.checkWin()){
                long elapsed = System.currentTimeMillis() - time;
                for(int a = 0; a < board.length; a++){
                    for(int b = 0; b < board.length; b++){
                        if(guesses[a][b].equals(" ")){
                            guesses[a][b] = board[a][b];
                        }
                    }
                }
                //System.out.print("\033\143");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("YOU WIN. Elapsed time: ");
                if(elapsed/1000/60 < 10){
                    System.out.print("0" + elapsed/1000/60 + ":");
                }else{
                    System.out.print(elapsed/1000/60 + ":");
                }
                if(elapsed/1000%60 < 10){
                    System.out.println("0" + elapsed/1000%60);
                }else{
                    System.out.println(elapsed/1000%60);
                }
                this.printGuesses();
                status = false;
            }
        }
    }

    //If a square has zero mines around it, this method runs the guess method for the squares that are
    //to the left, right, bottom, and top of the original square.
    //The parts that are commented out do the same thing except they run the guess method on  the corners
    //of the original square.
    public void zeros(int x, int y){
        if(x > 0 && guesses[x - 1][y].equals(" ")){
            this.guess(x - 1, y);
        }
        if(y > 0 && guesses[x][y - 1].equals(" ")){
            this.guess(x, y - 1);
        }
        if(y < board.length - 1 && guesses[x][y + 1].equals(" ")){
            this.guess(x, y + 1);
        }
        if(x < board.length - 1 && guesses[x + 1][y].equals(" ")){
            this.guess(x + 1, y);
        }
        //if(x > 0 && y > 0 && guesses[x - 1][y - 1].equals(" ")){
        //    this.guess(x - 1, y - 1);
        //}
        //if(x > 0 && y < board.length - 1 && guesses[x - 1][y + 1].equals(" ")){
        //    this.guess(x - 1, y + 1);
        //}
        //if(x < board.length - 1 && y > 0 && guesses[x + 1][y - 1].equals(" ")){
        //    this.guess(x + 1, y - 1);
        //}
        //if(x < board.length - 1 && y < board.length - 1 && guesses[x + 1][y + 1].equals(" ")){
        //    this.guess(x + 1, y + 1);
        //}
    }

    //This method checks if the user has won by counting the squares that aren't blank in the guesses array
    //if the number of empty squares is greater than or equal to the amount of squares minus the amount of
    //mines, then the player won and the method returns 'true'.
    public boolean checkWin(){
        int count = 0;
        for(String[] a : guesses){
            for(String b : a){
                if(!b.equals(" ")){
                    count++;
                }
            }
        }
        return count >= board.length * board.length - mines;
    }

    //Returns whether the same is over.
    public boolean getStatus(){
        return status;
    }
}