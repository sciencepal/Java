import java.io.*;
public class tictactoeeasy
{
    static char tic[]=new char[9];
    static char code[]=new char[9];
    public static int ttt(int a,int l)
    {
        if (l%2==0)
            tic[a-1]='X';
        else
            tic[a-1]='0';
        code[a-1]=' ';
        System.out.println();
        System.out.println("Cells left             Cell codes");
        System.out.println();
        System.out.println(" "+tic[0]+" | "+tic[1]+" | "+tic[2]+"             "+code[0]+" | "+code[1]+" | "+code[2]+" ");
        System.out.println(" "+tic[3]+" | "+tic[4]+" | "+tic[5]+"             "+code[3]+" | "+code[4]+" | "+code[5]+" ");
        System.out.println(" "+tic[6]+" | "+tic[7]+" | "+tic[8]+"             "+code[6]+" | "+code[7]+" | "+code[8]+" ");
        System.out.println();
        if ((tic[0]==tic[1]&&tic[1]==tic[2]&&tic[2]!=' ')||(tic[3]==tic[4]&&tic[4]==tic[5]&&tic[5]!=' ')||(tic[6]==tic[7]&&tic[7]==tic[8]&&tic[8]!=' ')||(tic[0]==tic[4]&&tic[4]==tic[8]&&tic[8]!=' ')||(tic[6]==tic[4]&&tic[4]==tic[2]&&tic[2]!=' ')||(tic[0]==tic[3]&&tic[3]==tic[6]&&tic[6]!=' ')||(tic[1]==tic[4]&&tic[4]==tic[7]&&tic[7]!=' ')||(tic[2]==tic[5]&&tic[5]==tic[8]&&tic[8]!=' '))
            return(1);
        else
            return(0);
    }

    public static void main (String args[])throws IOException
    {
        int t;int resp=0;
        String p[]=new String[2];
        do
        {
            for (t=0;t<9;t++)
            {
                tic[t]=' ';
                code[t]=(char)(t+49);
            }
            int n,l=0,i,k;String s,temp;char c;
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("Enter your name player1");
            p[0]=in.readLine();
            System.out.println();
            System.out.println("Enter your name player2");
            p[1]=in.readLine();
            System.out.println();
            System.out.println("Toss");
            for (i=0;i<=1000000;i++);
            System.out.println();
            if ((int)(Math.random()*2)+1==1)
            {
                System.out.println(p[0] +" wins toss and gets X");
                System.out.println(p[1] +" loses toss and gets 0");
            }
            else
            {
                System.out.println(p[1] +" wins toss and gets X");
                System.out.println(p[0] +" loses toss and gets 0");
                temp=p[0];
                p[0]=p[1];
                p[1]=temp;
            }
            System.out.println();
            System.out.println("TicTacToe");
            System.out.println();
            System.out.println();
            System.out.println(" 1 | 2 | 3 ");
            System.out.println(" 4 | 5 | 6 ");
            System.out.println(" 7 | 8 | 9 ");
            for (i=0;i<9;i++)
            {
                if (i%2==0)
                {
                    System.out.println(p[0]+" Enter your cell code");
                    n=Integer.parseInt(in.readLine());
                    k=ttt(n,i);
                    if (k==1)
                    {
                        System.out.println(p[0]+" wins");
                        break;
                    }
                }
                else
                {
                    System.out.println(p[1]+" Enter your cell code");
                    n=Integer.parseInt(in.readLine());
                    k=ttt(n,i);
                    if (k==1)
                    {
                        System.out.println(p[1]+" wins");
                        break;
                    }
                }
                if (k==1)
                    break;
                if (k==0&&i==8)
                    System.out.println("It is a draw");
            }
            System.out.println("Enter 0 to play again, any other number to exit");
            resp =Integer.parseInt(in.readLine());
        }
        while(resp==0);
    }
}