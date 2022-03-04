package tictactoe;
import java.util.Scanner;

public class Main {
    public static int nrx=0,nro=0;
    public static boolean ok=false;
    public static void main(String[] args) {
        int k=0;
        char[][] tabel=new char[10][10];
        afisTab(tabel);
        while(!ok)
        {
            xPosition(tabel,k);
            afisTab(tabel);
            gameStage(tabel);
            k++;
        }
    }
    //Input pt urm mutare
    public static void xPosition(char[][] tabel, int k)
    {
        int x=0,y=0;
        boolean ok;
        do{
            do{
                System.out.print("Enter the coordinates: ");
                Scanner scanner=new Scanner(System.in);
                ok=true;
                if(scanner.hasNextInt())
                {
                    x=scanner.nextInt();
                    if(scanner.hasNextInt())
                    {
                        y=scanner.nextInt();
                    }
                    else
                    {
                        ok=false;
                        System.out.println("You should enter numbers!");
                    }
                }
                else
                {
                    ok=false;
                    System.out.println("You should enter numbers!");
                }
            }while(!ok);
            if(x>3||x<1||y>3||y<1) {
                ok=false;
                System.out.println("Coordinates should be from 1 to 3!");
            }
            else if(tabel[x-1][y-1]!=0){
                ok=false;
                System.out.println("This cell is occupied! Choose another one!");
            }
        }while(!ok);
        if(k%2==0){
            tabel[x-1][y-1] = 'X';
            nrx++;
        }
        else{
            tabel[x-1][y-1] = 'O';
            nro++;
        }
    }
    //afisare tabla de joc
    public static void afisTab(char[][] tabel)
    {
        int i,j;
        System.out.println("---------");
        for(i=0;i<3;i++)
        {
            System.out.print("| ");
            for(j=0;j<3;j++)
            {
                if(tabel[i][j]!=0)
                    System.out.print(tabel[i][j]+" ");
                else
                    System.out.print("  ");
            }
                System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void gameStage(char[][] tabel)
    {
        boolean winx=false,wino=false;
        if(tabel[0][0]==tabel[0][1]&&tabel[0][1]==tabel[0][2])
        {
            if(tabel[0][0]=='O')
                wino=true;
            else if(tabel[0][0]=='X')
                winx=true;
        }
        else if(tabel[1][0]==tabel[1][1]&&tabel[1][1]==tabel[1][2])
        {
            if(tabel[1][0]=='O')
                wino=true;
            else if(tabel[1][0]=='X')
                winx=true;
        }
        else if(tabel[2][0]==tabel[2][1]&&tabel[2][1]==tabel[2][2])
        {
            if(tabel[2][0]=='O')
                wino=true;
            else if(tabel[2][0]=='X')
                winx=true;
        }
        else if(tabel[0][0]==tabel[1][0]&&tabel[1][0]==tabel[2][0])
        {
            if(tabel[0][0]=='O')
                wino=true;
            else if(tabel[0][0]=='X')
                winx=true;
        }
        else if(tabel[0][1]==tabel[1][1]&&tabel[1][1]==tabel[2][1])
        {
            if(tabel[1][1]=='O')
                wino=true;
            else if(tabel[1][1]=='X')
                winx=true;
        }
        else if(tabel[1][2]==tabel[0][2]&&tabel[0][2]==tabel[2][2])
        {
            if(tabel[1][2]=='O')
                wino=true;
            else if(tabel[1][2]=='X')
                winx=true;
        }
        else if(tabel[0][0]==tabel[1][1]&&tabel[1][1]==tabel[2][2])
        {
            if(tabel[0][0]=='O')
                wino=true;
            else if(tabel[0][0]=='X')
                winx=true;
        }
        else if(tabel[0][2]==tabel[1][1]&&tabel[1][1]==tabel[2][0])
        {
            if(tabel[0][2]=='O')
                wino=true;
            else if(tabel[0][2]=='X')
                winx=true;
        }
        if(wino) {
            System.out.println("O wins");
            ok=true;
        }
        else if(winx) {
            System.out.println("X wins");
            ok=true;
        }
        else if(nrx+nro==9){
            System.out.println("Draw");
            ok=true;
        }
    }
}
