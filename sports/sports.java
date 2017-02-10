import java.io.*;
public class sports
{
    public void eliminator(String n1[],int points1[],int win1[],int noresult1[],int loss1[],float rate1[],int startvalue1,int stopvalue1,String game1)
    {//function eliminator
        int k=0,i=0,j=0,score1=0,score2=0,m=0,temp=0,o=0;String q;float tempf;
        for (i=startvalue1;i<stopvalue1;i++)
        {//i loop starts
            for (k=0;k<59999999;k++);
            for (j=startvalue1;j<stopvalue1;j++)
            {//j loop starts
                if (j!=i)
                {//simulating matches
                    if (game1.equals("Indian Premier League")||game1.equals("ICC Cricket World Cup"))
                    {
                        score1=(int)(Math.random()*100)+100;//score of team1
                        score2=(int)(Math.random()*100)+100;//score of team2
                    }
                    else
                    {
                        score1=(int)(Math.random()*5);//score of team1
                        score2=(int)(Math.random()*5);//score of team2  
                    }
                    rate1[i]=rate1[i]+score1-score2;
                    rate1[j]=rate1[j]+score2-score1;
                    if (score1>score2)//comparing results of two teams
                    {
                        points1[i]=points1[i]+2;
                        win1[i]=win1[i]+1;
                        loss1[j]=loss1[j]+1;
                    }//if
                    if (score2>score1)//comparing results of two teams
                    {
                        points1[j]=points1[j]+2;
                        win1[j]=win1[j]+1;
                        loss1[i]=loss1[i]+1;
                    }
                    if (score1==score2)//comparing results of two teams
                    {
                        points1[i]=points1[i]+1;
                        noresult1[i]=noresult1[i]+1;
                        points1[j]=points1[j]+1;
                        noresult1[j]=noresult1[j]+1;
                    }//else
                }//if
            }//j
        }//i

        for (k=startvalue1;k<stopvalue1;k++)
        {//sorting scores,teams,wins,losses by using bubble sort
            for (m=startvalue1;m<(stopvalue1-1);m++)
            {
                if ((points1[m]<points1[m+1])||((points1[m]==points1[m+1])&&(rate1[m]<rate1[m+1])))
                {//checking greater scores or if scores are equal goals/runs
                    temp=points1[m];
                    points1[m]=points1[m+1];
                    points1[m+1]=temp;
                    q=n1[m];
                    n1[m]=n1[m+1];
                    n1[m+1]=q;
                    temp=win1[m];
                    win1[m]=win1[m+1];
                    win1[m+1]=temp;
                    temp=loss1[m];
                    loss1[m]=loss1[m+1];
                    loss1[m+1]=temp;
                    temp=noresult1[m];
                    noresult1[m]=noresult1[m+1];
                    noresult1[m+1]=temp;
                    tempf=rate1[m];
                    rate1[m]=rate1[m+1];
                    rate1[m+1]=tempf;
                }//if
            }//m
        }//k//end of sorting scores,teams,wins,losses by using bubble sort
        sports ob=new sports();
        ob.printtable(n1,points1,win1,noresult1,loss1,rate1,startvalue1,stopvalue1,game1);
        //going to function printtable
    }

    public void spaceadder(String g1[],int numberofteams1)
    {//adds space to make teams of equal length
        String h="";int i,z=0,l=0;
        for (i=0;i<numberofteams1;i++)
        {
            l=g1[i].length();
            for (z=1;z<=28-l;z++)
                h=h+" ";
            g1[i]=g1[i]+h;
            h="";
        }
    }

    public void spaceremover(String n1[],int numberofteams1,int stopvalue1)
    {
        int i=0,l=0,j=0;
        for (i=0;i<stopvalue1;i++)
        {
            n1[i]=n1[i].trim();
            l=n1[i].length();
            String teams[]=new String[numberofteams1];
            teams[i]="";
            for (j=0;j<l;j++)
            {
                if (Character.isUpperCase(n1[i].charAt(j)))
                    teams[i]=teams[i]+" ";
                if (Character.isLetter(n1[i].charAt(j)))
                    teams[i]=teams[i]+n1[i].charAt(j);
            }
            n1[i]=teams[i];
        }
    }

    public static void printtable(String n2[],int points2[],int win2[],int noresult2[],int loss2[],float rate2[],int startvalue2,int stopvalue2, String game2)
    {        //function printtable
        int numberofmatches=(stopvalue2-startvalue2-1)*2,z,y;
        System.out.println("__________________________________________________________________________________________________");
        System.out.print("| Rank   |            Team               | Played|  Won  |  Lost | Draw  | Points|");
        if (game2.equals("Indian Premier League")||game2.equals("ICC Cricket World Cup"))
            System.out.println(" Net Run Rate |");
        else
            System.out.println(" Goals |");
        System.out.println("_________________________________________________________________________________________________");
        for (z=startvalue2;z<stopvalue2;z++)
        {//printing score table
            for (y=0;y<59999999;y++);
            if (game2.equals("Indian Premier League")||game2.equals("ICC Cricket World Cup"))
                rate2[z]=rate2[z]/(float)numberofmatches/20;
            System.out.print((z+1)+"\t | "+n2[z]+"\t | "+numberofmatches+"\t | "+win2[z]+"\t | "+loss2[z]+"\t | "+noresult2[z]+"\t | "+points2[z]+"\t | "+rate2[z]+"\t|");
            System.out.println();
            if (game2.equals("Indian Premier League"))
            {
                if (z==3)
                    System.out.println("-----------------------------------------Not qualified------------------------------------------------");
            }
            else
            {
                if ((z+1)%4==2)
                    System.out.println("-----------------------------------------Not qualified------------------------------------------------");
            }
        }//z - end of printing score table
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void trophy(String fwinners1,String runnersup1,String runnersup2,String players1[],String game1)
    {//printing trophy
        int mot=(int)(Math.random()*5);
        System.out.println("  __          __");
        System.out.println(" *  )|******|(  *                "+game1);
        System.out.println("(   )|******|(   )");
        System.out.println("(   )|******|(   )        Winners - "+fwinners1);
        System.out.println(" *  )********(  *         First Runnersup - "+runnersup1);
        System.out.println("  *_) ****** (_*          Second Runnersup - "+runnersup2);
        System.out.println("       ||||");
        System.out.println("       /||\\              Man Of The Tournament - "+players1[mot]);
        System.out.println("     ========");
        System.out.println("     ||||||||");
        System.out.println("     ========");
    }

    public String cricsim(String s1, String s2)
    {//cricket simulation
        int y=0;int sc1,sc2,sc=0;String winners="",losers;
        System.out.println(s1 +" vs " +s2);
        for (y=0;y<59999999;y++);
        do
        {
            sc1=(int)(Math.random()*20*10)+1;//score of team1
            sc2=(int)(Math.random()*20*10)+1;//score of team2
            if (sc1>sc2)
            {
                winners=s1;
                sc=sc1-sc2;
                System.out.println(winners+" wins by "+sc+" runs");
                return(winners);
            }
            if (sc2>sc1)
            {
                winners=s2;
                sc=sc2-sc1;
                System.out.println(winners+" wins by "+sc+" runs");
                return(winners);
            }
        }
        while (sc1==sc2);//end of simulating cricket
        return (winners);
    }

    public String footballhockey(String team1,String team2,String game1)throws IOException
    {//football or hockey
        int a=0,b=0,y=0,chetp=0;String et="";
        sports ob=new sports();
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader (read);
        System.out.println(team1 +" vs " +team2);
        a=(int)(Math.random()*5.0+1);//score of team1
        b=(int)(Math.random()*5.0+1);//score of team2
        System.out.println("Scores after full time : ");
        for (y=0;y<59999999;y++);
        System.out.println(team1 +" - "+a);
        System.out.println(team2 +" - "+b);
        if (a>b)
        {
            System.out.println(team1+" wins by "+(a-b)+" goals");
            return(team1);//winner team1
        }
        else if (b>a)
        {
            System.out.println(team2+" wins by "+(b-a)+" goals");
            return(team2);//winner team2
        }
        else
        {//scores level
            System.out.println("Scores are level");
            if (game1.compareTo("Football Friendly")==0||game1.compareTo("Hockey World Cup")==1)
            {
                System.out.println();
                System.out.println("Do you want only penalties or extra time + penalties");
                System.out.println("         **********************************");
                System.out.println("         *Select your code & press <ENTER>*");
                System.out.println("         *--------------------------------*");
                System.out.println("         *  Code |         Choice         *");
                System.out.println("         *-------|------------------------*");
                System.out.println("         *  1    |    Penalty shootout    *");
                System.out.println("         *  2    |   Extra time + penalty *");
                System.out.println("         **********************************");
                chetp=Integer.parseInt(in.readLine());
            }
            else
                chetp=2;
            if (chetp==1)
                et=ob.penalty(team1,team2);//going to penalty
            else if (chetp==2)
                et=ob.extratime(team1,team2,a,b);//going to extratime
            return(et);
        }
    }//footballhockey
    public String extratime(String etteam1,String etteam2,int etscore1,int etscore2)
    {//extratime
        String penalty;int y;
        sports ob=new sports();
        System.out.println(" Extra Time");
        System.out.println(etteam1 +" vs " +etteam2);
        System.out.println();
        for (y=0;y<59999999;y++);
        etscore1 = etscore1 + (int)(Math.random()*2.0);//score of team1
        etscore2 = etscore2 + (int)(Math.random()*2.0);//score of team2
        System.out.println("Scores after extra time : ");
        System.out.println();
        System.out.println(etteam1 +" - "+ etscore1);
        System.out.println(etteam2 +" - "+ etscore2);
        if (etscore1>etscore2)
            return(etteam1);
        if (etscore2>etscore1)
            return(etteam2);
        else
        {
            penalty=ob.penalty(etteam1,etteam2);
            return (penalty);//going to penalty
        }
    }//extratime
    public String penalty(String pteam1,String pteam2)
    {
        int pscore1=0,pscore2=0,y;
        sports ob=new sports();
        System.out.println(" Penalty Shootout");
        System.out.println(pteam1 +" vs " +pteam2);
        for (y=0;y<59999999;y++);
        do
        {
            pscore1 = pscore1 + (int)(Math.random()*2.0);//score of team1
            pscore2 = pscore2 + (int)(Math.random()*2.0);//score of team2
        }
        while (Math.abs(pscore1-pscore2)!=2);
        System.out.println("Scores after penalty shootout : ");
        System.out.println();
        System.out.println(pteam1 +" - "+ pscore1);
        System.out.println(pteam2 +" - "+ pscore2);
        if(pscore1>pscore2)
            return(pteam1);
        else
            return(pteam2);
    }//penalty

    public static void main(String args[])throws IOException
    {//main
        System.out.println("    ������          ���������                 �����            ���������        ����������������      ������");
        System.out.println("  ���     ���       ������������           �����������         ������������     ����������������    ���    ���");
        System.out.println(" ���       ���      ����        ���      ���          ���      ����       ���         ����         ���       ���");
        System.out.println("���                 ����         ���    ���            ���     ����        ���        ����        ���");
        System.out.println("���                 ����         ���   ���              ���    ����        ���        ����        ���");
        System.out.println("  ���               ����        ���   ���                ���   ����        ���        ����         ���");
        System.out.println("    ���             �������������     ���                ���   �������������          ����           ���");
        System.out.println("        ���         �����������       ���                ���   �����������            ����              ���");
        System.out.println("          ���       ����              ���                ���   ��������               ����                 ���");
        System.out.println("            ���     ����              ���                ���   ����   ����            ����                  ���");
        System.out.println("            ���     ����              ���                ���   ����    ����           ����                   ���");
        System.out.println("            ���     ����               ���              ���    ����     ����          ����                   ���");
        System.out.println("           ���      ����                ���            ���     ����      ����         ����                 ���");
        System.out.println(" ���     ���        ����                   ������������        ����       ����        ����         ���     ���");
        System.out.println("   �������          ����                      �����            ����        ����       ����           �������"); 
        //initialising starts
        int i,j,k,m,z,temp=0,d,y,r=0,toss,batbowlch=0,score1=0,score2=0,score3,score4,lead=0,trail=0,ch1,ch,numberofteams=16,l=0,startvalue,stopvalue;
        String winqf="",winners1="",winners2="",runnersup1="",runnersup2,fwinners,losers1,losers2,losers3,yourteam,temps,game="";
        float tempf=0;char groupnumber;
        String n[]=new String [numberofteams];
        String mot[]=new String [5];
        char c[]={'S','I','M','U','L','A','T','I','N','G','.','.','.'};
        sports ob=new sports();
        //initialising ends
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("         *******************************************         ");
        System.out.println("         * Welcome to EA Sports Pack Pro Edition 3 *         ");
        for (y=0;y<59999999;y++);//delay
        System.out.println("         *******************************************         ");
        System.out.println("         *  Play 11 different games in one pack    *       ");
        for (y=0;y<59999999;y++);//delay
        System.out.println("         *******************************************         ");
        System.out.println("         *         So, let's get started !!        *       ");
        for (y=0;y<59999999;y++);//delay
        System.out.println("         *******************************************         ");
        System.out.println();
        System.out.println();
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader (read);
        do
        {
            do
            {
                lead=0;trail=0;
                System.out.println("         **********************************");
                System.out.println("         *Select your code & press <ENTER>*");
                System.out.println("         *--------------------------------*");
                System.out.println("         *  Code |    Sports  Choice      *");
                System.out.println("         *-------|------------------------*");
                System.out.println("         *  1    |          Cricket       *");
                System.out.println("         *  2    |         Football       *");
                System.out.println("         *  3    |          Hockey        *");
                System.out.println("         **********************************");
                ch1=Integer.parseInt(in.readLine());//taking sports choice
                ch=5;
                switch (ch1)
                {
                    case 1:
                    {//cricket menu
                        System.out.println("         **********************************       ");
                        System.out.println("         *Select your code & press <ENTER>*       ========");
                        System.out.println("         *--------------------------------*       || || ||");
                        System.out.println("         *  Code |     Cricket  Choice    *       || || ||");
                        System.out.println("         *-------|------------------------*       || || ||");
                        System.out.println("         *  1    | Indian Premier League  *       || || ||");
                        System.out.println("         *  2    |    Cricket World Cup   *       || || ||");
                        System.out.println("         *  3    |  One Day International *       || || ||");
                        System.out.println("         *  4    |       Test Cricket     *       || || ||");
                        System.out.println("         **********************************       || || ||    �");
                        System.out.println();
                        ch=Integer.parseInt(in.readLine());//taking cricket choice
                        numberofteams=(ch==1)? 9:16;
                    }
                    break;
                    case 2:
                    {//football menu
                        System.out.println("         **********************************");
                        System.out.println("         *Select your code & press <ENTER>*");
                        System.out.println("         *--------------------------------*");
                        System.out.println("         *  Code |    Football Choice     *        =========================");
                        System.out.println("         *-------|------------------------*        ||                     ||");
                        System.out.println("         *  1    |Barclays Premier League *        ||     goal !!!!       ||");
                        System.out.println("         *  2    |     FIFA World Cup     *        ||                     ||");
                        System.out.println("         *  3    |  UEFA Champions League *        ||         �           ||");
                        System.out.println("         *  4    |         Euro Cup       *");
                        System.out.println("         *  5    |     Friendly Match     *");
                        System.out.println("         **********************************");
                        ch=Integer.parseInt(in.readLine());//taking football choice
                        numberofteams=16;
                    }
                    break;
                    case 3:
                    {//hockey menu
                        System.out.println("         **********************************");
                        System.out.println("         *Select your code & press <ENTER>*         =========================");
                        System.out.println("         *--------------------------------*         ||                     ||");
                        System.out.println("         *  Code |     Hockey Choice      *         ||     goal !!!!       ||");
                        System.out.println("         *-------|------------------------*         ||                     ||");
                        System.out.println("         *  1    |    Hockey World Cup    *         ||         �           ||");
                        System.out.println("         *  2    |     Friendly Match     *");
                        System.out.println("         **********************************");
                        ch=Integer.parseInt(in.readLine());//taking hockey choice
                        numberofteams=16;                       
                    }
                    break;
                    default:
                    {//wrong choice
                        ch=5;
                        System.out.println("Enter again");
                    }
                }//switch
            }//do
            while (ch>=6);
            System.out.println();
            System.out.println();
            for (d=0;d<13;d++)
            {
                for (y=0;y<59999999;y++);//delay
                System.out.print(c[d]);
            }//d
            {
                //storing international hockey teams
                String g[]={"Australia","Korea","New Zealand","England","Belgium","Germany","Malayasia","South Africa","Netherlands","Pakistan","Argentina","Ireland","Canada","Spain","India","Japan"}; 
                String players[]= {"Rehan Butt","Karan Bhaskaran","Casey Henwood","Llyod Stephenson","Vikram Pillay"};
                if ((ch1==3)&&(ch==1))
                    game="Hockey World Cup";
                if ((ch1==3)&&(ch==2))
                    game="Hockey Friendly";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==1&&ch==1)
            {//storing sports teams
                String g[]={"Mumbai Indians","Chennai Super Kings","Kolkata Knight Riders","Pune Warriors India","Dehli Daredevils","Royal Challengers Bangalore","Kings XI Punjab","Deccan Chargers","Rajasthan Royals"};
                game="Indian Premier League";
                String players[]= {"Chris Gayle","Mahendra Singh Dhoni","Yousuf Pathan","Sachin Tendulkar","Adam Gilchrist"};
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==1&&ch!=1)
            {//storing international cricket teams
                String g[]={"India","England","Australia","South Africa","Pakistan","Sri Lanka","Bangladesh","West Indies","New Zealand","Ireland","Kenya","Netherlands","Bermuda","Zimbabwe","Scotland","Canada"};
                String players[]= {"Sachin Tendulkar","Kumara Sangakkara","Shahid Afridi","Chris Gayle","Andrew Flintoff"};
                game=(ch==2)?"ICC Cricket World Cup":(ch==3)?"One Day International":"Test Cricket";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==2&&ch==1)
            {//storing barclays teams
                String g[]={"Arsenal","Chelsea","Liverpool","Manchester City","Manchester United","Aston Villa","Blackburn Rovers","Tottenham Hotspur","Sunderland","Everton","Newcastle United","Stroke City","Swansea City","Wigan Athletic","Norwich city","Arsenal"};
                String players[]= {"Wayne Rooney","Frank Lampard","Didier Drogba","Suarez","Sergio Ramos"};
                game="Barclays Premier League";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==2&&(((ch==2)||(ch==5))))
            {//storing international football teams
                String g[]={"Spain","Germany","Switzerland","Brazil","Argentina","Portugal","England","Uruguay","Netherlands","Croatia","Denmark","Italy","Russia","Chile","Greece","France"};
                String players[]= {"Wayne Rooney","Lionel Messi","Christiano Ronaldo","Miroslav Klose","Ronaldo"};
                game=(ch==2)?"FIFA World Cup":"Football Friendly";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==2&&(ch==3))
            {//storing uefa teams
                String g[]={"FC Barcelona","Manchester City","Manchester United","Arsenal","Real Madrid","AC Milan","Chelsea","Bayern Munchen","Napoli","Ajax","Benefica","Juventus","Hamburg","Aston Villa","Valencia","Arsenal"};
                String players[]= {"Sergio Ramos","Lionel Messi","Christiano Ronaldo","Miroslav Klose","David Villa"};
                game="UEFA Champions League";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            if (ch1==2&&ch==4)
            {//storing euro teams
                String g[]={"Croatia","Czech Republic","Denmark","England","France","Germany","Greece","Italy","Netherlands","Poland","Portugal","Republic of Ireland","Russia","Spain","Sweden","Ukraine"};
                String players[]= {"Wayne Rooney","Miroslav Klose","Arjen Roben","David Villa","Ronaldo"};
                game="Euro Cup";
                ob.spaceadder(g,numberofteams);
                //function spacereadder
                for (i=0;i<numberofteams;i++)
                    n[i]=g[i];//storing teams in array n
                for (i=0;i<5;i++)
                    mot[i]=players[i];
            }
            System.out.println();
            System.out.println();
            if (((ch1==1)&&((ch==1)||(ch==2)))||((ch1==2)&&(ch!=5))||((ch1==3&&ch==1)&&(ch1==3)&&(ch!=2)))
            {//not test cricket,ODI and friendlies
                float rate[]=new float[numberofteams];
                int points[]=new int [numberofteams];
                int win[]=new int [numberofteams];
                int loss[]=new int [numberofteams];
                int noresult[]=new int [numberofteams];
                System.out.println("Simulating Playoffs");
                System.out.println();
                startvalue=0;
                System.out.println("*************************************");
                System.out.println("*         Teams participating       *");
                System.out.println("*************************************");
                if (ch1==1&&ch==1)
                {
                    stopvalue=9;
                    for(i=0;i<9;i++)
                        System.out.println("*  "+(i+1)+" | "+n[i]+" *");
                    System.out.println("*************************************");
                    System.out.println("Press enter to continue");
                    in.readLine();
                    ob.eliminator(n,points,win,noresult,loss,rate,startvalue,stopvalue,game);
                    //function eliminator
                }//9 teams in ipl
                else 
                {//code for tournaments except ipl
                    groupnumber='A';
                    for(j=0;j<16;j+=4)
                    {
                        System.out.println("Group "+groupnumber);
                        System.out.println("-------");
                        for (y=0;y<59999999;y++);
                        System.out.println("*************************************");
                        for(i=j;i<j+4;i++)
                            System.out.println("*  "+(i+1)+" | "+n[i]+" *");
                        System.out.println("*************************************");
                        groupnumber++;
                        System.out.println();
                    }
                    System.out.println("Press enter to continue");
                    in.readLine();
                    groupnumber='A';
                    for(z=0;z<16;z+=4)
                    {//printing results of each group
                        System.out.println("Group "+groupnumber);
                        System.out.println("-------");
                        System.out.println();
                        startvalue=z;
                        stopvalue=z+4;
                        ob.eliminator(n,points,win,noresult,loss,rate,startvalue,stopvalue,game);
                        //function eliminator
                        for (y=0;y<59999999;y++);
                        groupnumber++;
                    }//i
                    groupnumber='A';
                    for(i=0;i<16;i+=4)
                    {
                        System.out.println("Teams qualified from Group "+groupnumber);
                        System.out.println(n[i]);
                        System.out.println(n[i+1]);
                        groupnumber++;
                        System.out.println();
                    }//i
                }
                stopvalue=(ch==1&&ch1==1)?9:16;
                ob.spaceremover(n,numberofteams,stopvalue);
                //function spaceremover
                String winners[]=new String[4];
                if (game.compareTo("Indian Premier League")==0)
                {
                    for (i=0;i<4;i++)
                        winners[i]=n[i];
                }
                else
                {
                    for (i=0;i<16;i+=4)
                    {//simulating quarter final
                        System.out.println("Quarter-Final number "+((i+4)/4));
                        System.out.println("----------------------");
                        for (y=0;y<59999999;y++);
                        if (ch1==1)
                            winqf=ob.cricsim(n[i],n[i+1]);
                        //function cricsim
                        else
                            winqf=ob.footballhockey(n[i],n[i+1],game);
                        //function footbalhockey
                        winners[i/4]=winqf;
                        System.out.println("Winners of Quarter-Final number "+((i+4)/4)+ " is "+winqf);
                        System.out.println();
                    }//end of simulating quarter final
                }
                System.out.println();
                System.out.println("First semi-final");
                System.out.println("----------------");
                for (y=0;y<59999999;y++);
                if (ch1==1)
                    winners1=ob.cricsim(winners[2],winners[3]);
                //function cricsim
                else
                    winners1=ob.footballhockey(winners[2],winners[3],game);
                //function footbalhockey
                if (winners[2].equals(winners1))
                    losers1=winners[3];
                else
                    losers1=winners[2];
                System.out.println(winners1+" qualifies for finals after defeating "+losers1);
                System.out.println();
                System.out.println("Second semi-finals");
                System.out.println("----------------");
                for (y=0;y<59999999;y++);
                if (ch1==1)
                    winners2=ob.cricsim(winners[0],winners[1]);
                //function cricsim
                else
                    winners2=ob.footballhockey(winners[0],winners[1],game);
                //function footbalhockey
                if (winners[0].equals(winners2))
                    losers2=winners[1];
                else
                    losers2=winners[0];
                System.out.println(winners2+" qualifies for finals after defeating "+losers2);
                System.out.println();
                System.out.println("Third place");
                System.out.println("-----------");
                for (y=0;y<59999999;y++);
                if (ch1==1)
                    runnersup2=ob.cricsim(losers1,losers2);
                //function cricsim
                else
                    runnersup2=ob.footballhockey(losers1,losers2,game);
                //function footbalhockey
                if (losers1.equals(runnersup2))
                    losers3=losers2;
                else
                    losers3=losers1;
                System.out.println(runnersup2+" become second runners up after defeating "+losers3);
                System.out.println();
                System.out.println("Finals");
                System.out.println("------");
                for (y=0;y<59999999;y++);
                if (ch1==1)
                    fwinners=ob.cricsim(winners1,winners2);
                //function cricsim
                else
                    fwinners=ob.footballhockey(winners1,winners2,game);
                //function footbalhockey
                if (winners1.equals(fwinners))
                    runnersup1=winners2;
                else
                    runnersup1=winners1;
                System.out.println(fwinners+" wins finals after defeating "+runnersup1);
                ob.trophy(fwinners,runnersup1,runnersup2,mot,game);//printing trophy
                System.out.println("Congratulations "+fwinners+" !!!!");
                System.out.println();
            }//end of not test cricket,ODI and friendlies
            if (ch1==1)
            {//cricket
                if ((ch==3)||(ch==4))
                {//ODI,test cricket
                    String g[]={"India","England","Australia","South Africa","Pakistan","Sri Lanka","Bangladesh","West Indies","New Zealand","Ireland","Kenya","Netherlands","Bermuda","Zimbabwe","Scotland","Canada"};
                    System.out.println("         ****************************************");
                    System.out.println("         *   Select your code & press <ENTER>   *");
                    System.out.println("         *--------------------------------------*");
                    System.out.println("         *  Code |    Football Teams  Choice    *");
                    System.out.println("         *-------|------------------------------*");
                    for (i=0;i<16;i++)
                    {
                        ob.spaceadder(g,16);
                        //function spaceadder
                        System.out.println("         * "+(i+1)+"\t| "+g[i]+" *");
                    }
                    System.out.println("         ****************************************");
                    ob.spaceremover(g,numberofteams,16);
                    //function spaceremover
                    String team[]=new String [2];
                    System.out.println();
                    System.out.println("Select your team");
                    team[0]=g[Integer.parseInt(in.readLine())-1];//your team
                    System.out.println();
                    System.out.println("Select opponent team");
                    team[1]=g[Integer.parseInt(in.readLine())-1];//my team
                    System.out.println();
                    System.out.println("Toss");
                    System.out.println("Enter 1 for heads, 2 for tails");
                    toss=Integer.parseInt(in.readLine());
                    for (y=0;y<59999999;y++);//delay
                    batbowlch=(int)((Math.random()*2.0)+1);
                    if (batbowlch==toss)
                    {//toss
                        System.out.println("You win toss");
                        System.out.println();
                        System.out.println("Do you want to bat or bowl first?");
                        System.out.println("Enter 1 to bat");
                        System.out.println("Enter 2 to bowl");
                        batbowlch=Integer.parseInt(in.readLine());//bat or bowl?
                    }//end of toss
                    else
                    {//toss
                        System.out.println("You lose toss");
                        System.out.println(team[1]+" elects to bat first");
                        batbowlch=2;
                    }//end of toss
                    if (ch==3)
                    {//ODI
                        if (batbowlch==1)
                        {//batting first
                            for (y=0;y<59999999;y++);
                            System.out.println();
                            System.out.println("Score is");
                            score1=(int)((Math.random()*200)+100);//team1 score
                            System.out.println(team[0]+" - "+score1+"/"+(int)((Math.random()*10)+1));
                            score2=(int)((Math.random()*200)+100);//team1 score
                            if (score2>score1)
                            {//comparing score
                                System.out.println(team[0]+" - "+(score1+1)+"/"+(int)(Math.random()*10));
                                for (y=0;y<59999999;y++);
                                System.out.println("You lose");
                            }
                            if (score1>score2)
                            {//comparing score
                                System.out.println(team[1]+" - "+(score2)+" all out");
                                for (y=0;y<59999999;y++);
                                System.out.println("You win by "+(score1-score2)+" runs");
                            }
                        }//end of batting first
                        if (batbowlch==2)
                        {//batting secong
                            System.out.println();
                            for (y=0;y<59999999;y++);
                            System.out.println("Score is");
                            score2=(int)((Math.random()*200)+100);
                            System.out.println(team[1]+" - "+score2+"/"+(int)((Math.random()*10)+1));
                            score1=(int)((Math.random()*200)+100);
                            if (score1>score2)
                            {//comparing score
                                System.out.println(team[0]+" - "+(score2+1)+"/"+(int)(Math.random()*10));
                                for (y=0;y<59999999;y++);
                                System.out.println("You win");
                            }
                            if (score2>score1)
                            {//comparing score
                                System.out.println(team[0]+" - "+(score1)+" all out");
                                for (y=0;y<59999999;y++);
                                System.out.println("You lose");
                            }
                        }//end of batting second
                    }
                    yourteam=team[0];
                    if (ch==4)
                    {//test cricket
                        if (batbowlch==2)
                        {
                            temps=team[0];
                            team[0]=team[1];
                            team[1]=temps;
                        }//sorting team in order of batting
                        System.out.println();
                        for (y=0;y<59999999;y++);//delay
                        System.out.println();
                        System.out.println("First innings scores");
                        System.out.println();
                        score1=(int)((Math.random()*250)+250);//first innings score team1
                        System.out.println(team[0]+" - "+score1+" all out");
                        for (y=0;y<59999999;y++);//delay
                        score2=(int)((Math.random()*250)+250);//first innings score team2
                        System.out.println(team[1]+" - "+score2+" all out");
                        lead=Math.abs(score1-score2);//calculating lead
                        if (score1>score2)
                            System.out.println(team[0]+" leads "+team[1]+" by "+lead);
                        else
                            System.out.println(team[1]+" leads "+team[0]+" by "+lead);
                        for (y=0;y<59999999;y++);//delay
                        System.out.println();
                        System.out.println("Second innings scores ");
                        for (y=0;y<59999999;y++);//delay
                        System.out.println();
                        score3=(int)((Math.random()*250)+250);//second innings score team1
                        System.out.println(team[0]+" - "+score3+" all out");
                        for (y=0;y<59999999;y++);//delay
                        System.out.println(team[1] +" needs "+(score1+score3-score2+1)+" to win");
                        score4=(int)((Math.random()*250)+250);//second innings score team2
                        if (score4>(score1+score3-score2))
                        {//comparing score
                            System.out.println(team[1]+" - "+(score1+score3-score2+1)+"/"+(int)(Math.random()*10));
                            if (team[1].equals(yourteam))
                                System.out.println("You win");
                            else
                                System.out.println("You lose");
                        }
                        else
                        {//comparing score
                            System.out.println(team[1]+" - "+(score4)+" all out");
                            System.out.println();
                            if (team[1].equals(yourteam))
                                System.out.println("You lose");
                            else
                                System.out.println("You win");
                        }
                    }//testcricket
                }//ODI, cricket
            }//cricket
            if ((ch1==2)&&(ch==5)||(ch1==3)&&(ch==2))
            {//football or hockey friendlies
                String team[]=new String[2];
                if ((ch1==2)&&(ch==5))
                {//football friendly
                    String g[]={"Spain","Germany","Switzerland","Brazil","Argentina","Portugal","England","Uruguay","Netherlands","Croatia","Denmark","Italy","Russia","Chile","Greece","France"};
                    System.out.println("         ****************************************");
                    System.out.println("         *   Select your code & press <ENTER>   *");
                    System.out.println("         *--------------------------------------*");
                    System.out.println("         *  Code |    Football Teams  Choice    *");
                    System.out.println("         *-------|------------------------------*");
                    for (i=0;i<16;i++)
                    {
                        ob.spaceadder(g,16);
                        //function spaceadder
                        System.out.println("         * "+(i+1)+"\t| "+g[i]+" *");
                    }
                    System.out.println("         ****************************************");
                    ob.spaceremover(g,numberofteams,16);
                    //function spaceremover
                    System.out.println();
                    System.out.println("Select your team");
                    team[0]=g[Integer.parseInt(in.readLine())-1];//team1
                    System.out.println();
                    System.out.println("Select opponent team");
                    team[1]=g[Integer.parseInt(in.readLine())-1];//team2
                    fwinners=ob.footballhockey(team[0],team[1],game);
                    //function footballhockey
                }//football friendly
                if ((ch1==3)&&(ch==2))
                {//hockey friendly
                    String g[]={"Australia","Korea","New Zealand","England","Belgium","Germany","Malayasia","South Africa","Netherlands","Pakistan","Argentina","Ireland","Canada","Spain","India","Japan"};
                    System.out.println("         ****************************************");
                    System.out.println("         *   Select your code & press <ENTER>   *");
                    System.out.println("         *--------------------------------------*");
                    System.out.println("         *  Code |      Hockey Teams  Choice    *");
                    System.out.println("         *-------|------------------------------*");
                    for (i=0;i<16;i++)
                    {
                        ob.spaceadder(g,16);
                        //function spaceadder
                        System.out.println("         * "+(i+1)+"\t| "+g[i]+" *");
                    }
                    System.out.println("         ****************************************");
                    ob.spaceremover(g,numberofteams,16);
                    //function spaceremover
                    System.out.println();
                    System.out.println("Select your team");
                    team[0]=g[Integer.parseInt(in.readLine())-1];
                    System.out.println();
                    System.out.println("Select opponent team");
                    team[1]=g[Integer.parseInt(in.readLine())-1];
                    fwinners=ob.footballhockey(team[0],team[1],game);
                }//hockey friendly
            }//football or hockey friendly
            System.out.println();//end of one game
            System.out.println("         *****************************************************************************************************************************");
            System.out.println();
            System.out.println();
            System.out.println("Do you want to play again? - Enter 1 for yes, 2 for no");
            r=Integer.parseInt(in.readLine());//play again?
        }//do
        while (r==1);
        {//thaking sponsors
            System.out.println();
            System.out.println("Thanks to our sports partners -");
            System.out.println();
            System.out.println("Cricket Sponsors - ");
            System.out.println("-------------------");
            System.out.println();
            System.out.println("DLF IPL �");
            System.out.println("ICC �");
            System.out.println();
            System.out.println("Football Sponsors - ");
            System.out.println("--------------------");
            System.out.println();
            System.out.println("FIFA �");
            System.out.println("Barclays �");
            System.out.println("UEFA �");
            System.out.println();
            System.out.println("Hockey Sponsors -");
            System.out.println("-----------------");
            System.out.println("International Hockey �");
            System.out.println();
            System.out.println("Kit Sponsors - ");
            System.out.println("---------------");
            System.out.println("REEBOK �");
            System.out.println("NIKE �");
            System.out.println("ADIDAS �");
            System.out.println("PEPSI �");
            System.out.println();
            System.out.println("Game developed by Aditya Pal");
            System.out.println();
            System.out.println("Thank You");
        }//thaking sponsors
    }//main
}//class