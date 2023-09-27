import java.util.Scanner;
//import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        int i;
        Scanner input = new Scanner(System.in);
        System.out.println("MINESWEEPER\nEnter a number (1-3) to pick the difficulty: ");
        int difficulty = input.nextInt();
        if(difficulty == 1){
            i = 10;
        }else if(difficulty == 2){
            i = 18;
        }else{
            i = 24;
        }
        input.nextLine();
        long startTime = System.currentTimeMillis();
        Minesweeper a = new Minesweeper(difficulty, startTime);
        while(a.getStatus()){
            //System.out.print("\033\143");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            a.printGuesses();
            System.out.println("Enter the coordinates (x,y): ");
            String z = input.nextLine();
            if(z.length() > 2 && !z.contains(" ") && !z.contains("a") && !z.contains("b") && !z.contains("c") && !z.contains("d") && !z.contains("e") && !z.contains("f") && !z.contains("g") && !z.contains("h") && !z.contains("i") && !z.contains("j") && !z.contains("k") && !z.contains("l") && !z.contains("m") && !z.contains("n") && !z.contains("o") && !z.contains("p") && !z.contains("q") && !z.contains("r") && !z.contains("s") && !z.contains("t") && !z.contains("u") && !z.contains("v") && !z.contains("w") && !z.contains("x") && !z.contains("y") && !z.contains("z") && !z.contains("A") && !z.contains("B") && !z.contains("C") && !z.contains("D") && !z.contains("E") && !z.contains("F") && !z.contains("G") && !z.contains("H") && !z.contains("I") && !z.contains("J") && !z.contains("K") && !z.contains("L") && !z.contains("M") && !z.contains("N") && !z.contains("O") && !z.contains("P") && !z.contains("Q") && !z.contains("R") && !z.contains("S") && !z.contains("T") && !z.contains("U") && !z.contains("V") && !z.contains("W") && !z.contains("X") && !z.contains("Y") && !z.contains("Z") && !z.contains("<") && !z.contains(".") && !z.contains(">") && !z.contains("/") && !z.contains("?") && !z.contains(";") && !z.contains(":") && !z.contains("'") && !z.contains("\"") && !z.contains("|") && !z.contains("]") && !z.contains("}") && !z.contains("[") && !z.contains("{") && !z.contains("`") && !z.contains("~") && !z.contains("-") && !z.contains("_") && !z.contains("+") && !z.contains("=") && !z.contains("!") && !z.contains("@") && !z.contains("#") && !z.contains("$") && !z.contains("%") && !z.contains("^") && !z.contains("&") && !z.contains("*") && !z.contains("(") && !z.contains(")") && z.contains(",") && (z.substring(0,1).equals("0") || z.substring(0,1).equals("1") || z.substring(0,1).equals("2") || z.substring(0,1).equals("3") || z.substring(0,1).equals("4") || z.substring(0,1).equals("5") || z.substring(0,1).equals("6") || z.substring(0,1).equals("7") || z.substring(0,1).equals("8") || z.substring(0,1).equals("9")) && (z.substring(z.length()-1).equals("0") || z.substring(z.length()-1).equals("1") || z.substring(z.length()-1).equals("2") || z.substring(z.length()-1).equals("3") || z.substring(z.length()-1).equals("4") || z.substring(z.length()-1).equals("5") || z.substring(z.length()-1).equals("6") || z.substring(z.length()-1).equals("7") || z.substring(z.length()-1).equals("8") || z.substring(z.length()-1).equals("9")) && Integer.parseInt(z.substring(0, z.indexOf(","))) < i && Integer.parseInt(z.substring(z.indexOf(",") + 1)) < i){
                int x = Integer.parseInt(z.substring(0,z.indexOf(",")));
                int y = Integer.parseInt(z.substring(z.indexOf(",") + 1));
                a.guess(x,y);
            }else{
                System.out.print("You entered an invalid value. ");
            }
        }
    }
}