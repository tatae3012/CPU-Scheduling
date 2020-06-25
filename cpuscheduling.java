/*
* Add your package name
*/

/**
 *
 * @author VANSHIKA
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author VANSHIKA
 */
public class cpuscheduling implements ActionListener{
    static JPanel panel,p,p1,p2,p3,p4,p5,p6; 
    static JLabel bt1,at1,pt1,tq1,b1;
    static JTextField bt,at,pt,tq;
    static JCheckBox g4,g2,g1,g3,g5,g6;
    final JComboBox<String> cb ;
    static JButton comp;
     
    public cpuscheduling() {
    panel =new JPanel();
    p =new JPanel();
    p1 =new JPanel();
    p2 =new JPanel();
    p3 =new JPanel();
    p4 =new JPanel();
    p5 =new JPanel();
    p6 =new JPanel();
    panel.setLayout(new GridLayout(9, 2));
    panel.setSize(700, 800);
    p.setLayout(new FlowLayout());
    p.setSize(50, 50);
    p1.setLayout(null);
    p1.setSize(112, 700);
    p2.setLayout(null);
    p2.setSize(112, 700);
    p3.setLayout(null);
    p3.setSize(112, 700);
    p4.setLayout(null);
    p4.setSize(112, 700);
    p5.setLayout(null);
    p5.setSize(112, 700);
    p6.setLayout(null);
    p6.setSize(112, 700);
    b1=new JLabel("No. of Procedures");
    String[] choices = { "1","2", "3","4","5","6"};
    cb = new JComboBox<>(choices);
    cb.setVisible(true);
    bt1=new JLabel("Burst Time");
    bt=new JTextField(50);
    at1=new JLabel("Arrival Time");
    at=new JTextField(50); 
    pt1=new JLabel("Priority");
    pt=new JTextField("low number means high priority",50);
    tq1=new JLabel("Time Quantum");
    tq=new JTextField(50);
    g1=new JCheckBox("First Come First Serve"); 
    g2=new JCheckBox("Round Robin"); 
    g3=new JCheckBox("Preemptive Shortest Job First");  
    g4=new JCheckBox("Non-Preemptive Shortest Job First");
    g5=new JCheckBox("Preemptive Priority");
    g6=new JCheckBox("Non-Preemptive Priority");
    comp=new JButton("COMPUTE");
    panel.add(b1);
    panel.add(cb);
    panel.add(bt1);
    panel.add(bt);
    panel.add(at1);
    panel.add(at);
    panel.add(pt1);
    panel.add(pt);
    panel.add(tq1);
    panel.add(tq);
    panel.add(g1);
    panel.add(g2);
    panel.add(g3);
    panel.add(g4);
    panel.add(g5);
    panel.add(g6);
    p.add(comp);
    comp.addActionListener(this);  //any action will be performed by clicking COMPUTE
    }

     public static void sortbyColumn(int arr[][], int col) //function to sort array based on specified column
    {  
        Arrays.sort(arr, new Comparator<int[]>() {            
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else if (entry1[col] == entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
    public static void main(String[] args){
        
      JFrame frame=new JFrame("Input Screen"); 
      cpuscheduling cs=new cpuscheduling();
      frame.setLayout(new GridLayout(2, 1));
      frame.add(panel);
      frame.add(p);
      frame.setSize(700, 700);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame2=new JFrame("Output Screen");
        frame2.setLayout(new GridLayout(6, 1));
        frame2.setSize(700, 700);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(e.getActionCommand().equalsIgnoreCase("COMPUTE")){
             int choice=Integer.parseInt((String) cb.getSelectedItem());
             String t1=bt.getText();  //enter values in the range of 1-20 for a better view
             String[] burst=t1.split(",");
             String t2=at.getText();
             String[] arrive=t2.split(",");
             String t3=pt.getText();
             String[] priority=t3.split(",");
             int ol=burst.length;
             int ola=arrive.length;
             int olay=priority.length;
             if(choice==ol || choice ==ola || choice==olay)  // if the number of processors do not match with other data then no action
             {
             if(g1.isSelected()){ //FCFS
                 p1.removeAll();
                 frame2.add(p1);
                 p1.repaint();
                 p1.revalidate();
                 int c=1;
                 int[][] ar=new int[burst.length][3];
                 int[][] ar1=new int[burst.length][3];
                 try{
                 for(int i=0;i<burst.length;i++){
                         ar[i][0]=Integer.parseInt(burst[i]);
                         ar[i][1]=c++;
                         ar[i][2]=Integer.parseInt(arrive[i]);   
                 }}
                 catch(NumberFormatException ae){
                     JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for First Come First Serve Scheduling");   
                 }
                 int wt[] = new int[burst.length], tat[] = new int[burst.length]; 
                 double tn=0,tm=0;
                 wt[0] = 0; 
                 String title = "FIRST COME FIRST SERVE";
                 Border border = BorderFactory.createTitledBorder(title);
                 p1.setBorder(border);
                 sortbyColumn(ar,2);
                int service_time[]=new int[burst.length]; 
                service_time[0] = ar[0][2];
                
                for (int i = 1; i < burst.length ; i++) 
                { 
                  service_time[i] = service_time[i-1] + ar[i-1][0]; 
                  wt[i] = service_time[i] - ar[i][2]; 
                  if (wt[i] < 0) 
                   wt[i] = 0; 
                  tn+=wt[i];
                }

              for (int i = 0; i < burst.length ; i++) 
                 {    
                     tat[i] = ar[i][0] + wt[i];
                     tm+=tat[i];
                 }
              for (int i = 0; i < burst.length ; i++) { 
                    ar1[i][0]=ar[i][1];
                    ar1[i][1]=wt[i];
                    ar1[i][2]=tat[i];
                }
              sortbyColumn(ar1,0);
                 tn=tn/burst.length;
                 String result = String.format("%.2f", tn);
                  tm=tm/burst.length;
                 String result1 = String.format("%.2f", tm);
                 JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p1.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p1.add(l1);
                 JLabel k=new JLabel("Turn Around Time ");
                 k.setBounds(5, 70, 120, 30);
                 p1.add(k);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p1.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p1.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p1.add(m1);
                 int y1=5; String str=""; String s=""; int y2=130; String s1=""; int y3=130; 
                 String ck=""; String str2="";
                 int cnt=0;
                 int cot=ar[0][2];
                 
                 for(int i1=0;i1<burst.length;i1++){
                     str="P"+Integer.toString(ar[i1][1]);
                     str2="P"+ar1[i1][0]; 
                     JLabel j=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     j.setBorder(blackline);
                     j.setOpaque(true);
                     j.setBackground(Color.white);
                     j.setBounds(y1,18,ar[i1][0]*18, 28);
                     p1.add(j);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setForeground(Color.blue);
                     u.setBounds(cnt*18, 47,23,10);
                     p1.add(u);
                     s=str2+" = "+ar1[i1][1]+" ";
                     s1=str2+" = "+ar1[i1][2]+" ";
                     JLabel h=new JLabel(s);
                     h.setBounds(y2, 55, 70, 30);
                     y2=y2+70;
                     p1.add(h);
                     JLabel p=new JLabel(s1);
                     p.setBounds(y3, 70, 70, 30);
                     y3=y3+70;
                     p1.add(p);
                     cnt=cnt+(ar[i1][0]);
                     cot=cot+(ar[i1][0]);
                     y1=y1+(ar[i1][0]*18);
                     p1.repaint();
                     p1.revalidate();
                 }
                 ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 47,23,10);
                     u1.setForeground(Color.blue);
                     p1.add(u1);
           
            }
             
            if(g2.isSelected()){ //Round robin
                 p2.removeAll();
                 frame2.add(p2);
                 p2.repaint();
                 p2.revalidate();
          // result of average times 
        int q=0;  String str="";
        // for sequence storage 
        String seq = "";  int sum=0;
        int n=burst.length;
        
        String title = "ROUND ROBIN";
                 Border border = BorderFactory.createTitledBorder(title);
                 p2.setBorder(border);
                 
        int[][] ar=new int[burst.length][3];
        int[][] ar1=new int[burst.length][3];
        int c=1; int total=0;
        try{
        for(int i=0;i<burst.length;i++){
                     
                         ar[i][0]=Integer.parseInt(burst[i]);
                         total=total+Integer.parseInt(burst[i]);
                         ar[i][1]=c++;
                         ar[i][2]=Integer.parseInt(arrive[i]);
                     
         }
        q=Integer.parseInt(tq.getText());
        }
        
        catch(NumberFormatException ae){
                     JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for Round Robin Scheduling");
                    
        }
        
        sortbyColumn(ar,2);
        int[] bt=new int[n]; double tn=0,tm=0;
        for(int i=0;i<n;i++){
           bt[i]=ar[i][0]; 
        }
        int[] wt=new int[n]; int[] tat=new int[n];
        for(int i=0;i<n;i++)
         wt[i]=0;
        do
        {
         for(int i=0;i<n;i++)
         {
            if(bt[i]>q)
            {
             bt[i]-=q;
             for(int j=0;j<n;j++)
             {
              if((j!=i)&&(bt[j]!=0))
              wt[j]+=q;
             }
            }
            else
            {
             for(int j=0;j<n;j++)
             {
              if((j!=i)&&(bt[j]!=0))
               wt[j]+=bt[i];
             }
              bt[i]=0;
            }
          }
          sum=0;
          for(int k=0;k<n;k++)
           sum=sum+bt[k];
         }while(sum!=0);
        for(int i=0;i<n;i++){
        wt[i]=wt[i]-ar[i][2]+ar[0][2];
        tn=tn+wt[i];
        }
        for(int i=0;i<n;i++){
        tat[i]=wt[i]+ar[i][0];
        tm=tm+tat[i];
        }
      
        for (int i = 0; i < burst.length ; i++) { 
                    ar1[i][0]=ar[i][1];
                    ar1[i][1]=wt[i];
                    ar1[i][2]=tat[i];
                }
                 tn=tn/burst.length;
                 String result = String.format("%.2f", tn);
                  tm=tm/burst.length;
                 String result1 = String.format("%.2f", tm);
              sortbyColumn(ar1,0);
              JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p2.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p2.add(l1);
                 JLabel k=new JLabel("Turn Around Time ");
                 k.setBounds(5, 70, 120, 30);
                 p2.add(k);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p2.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p2.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p2.add(m1);
        int t=ar[0][2]; int y1=5; 
        String ck="";  String str2=""; String s=""; String s1=""; 
                 int cnt=0; int y2=130,y3=130;
                 int cot=ar[0][2];
                 for(int i=0;i<burst.length;i++){
                     str2="P"+ar1[i][0];
                     s=str2+" = "+ar1[i][1]+" ";
                     s1=str2+" = "+ar1[i][2]+" ";
                     JLabel h=new JLabel(s);
                     h.setBounds(y2, 55, 70, 30);
                     y2=y2+70;
                     p2.add(h);
                     JLabel p=new JLabel(s1);
                     p.setBounds(y3, 70, 70, 30);
                     y3=y3+70;
                     p2.add(p);
                 }
        while(t<total){
            for(int i=0;i<burst.length;i++){
                if(ar[i][2]<=t && ar[i][0]>0){
                    if(ar[i][0]>=q){
                        t=t+q;
                        str="P"+Integer.toString(ar[i][1]);
                        JLabel j=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     j.setBorder(blackline);
                     j.setOpaque(true);
                     j.setBackground(Color.white);
                     j.setBounds(y1,18,q*18, 28);
                     p2.add(j);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setForeground(Color.blue);
                     u.setBounds(cnt*18, 47,23,10);
                     p2.add(u);
                     cnt=cnt+q;
                     cot=cot+q;
                     y1=y1+(q*18);
                     p2.repaint();
                     p2.revalidate();
                        ar[i][0]-=q;
                    }
                    else{
                        t=t+ar[i][0];
                        str="P"+Integer.toString(ar[i][1]);
                        JLabel j=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     j.setBorder(blackline);
                     j.setOpaque(true);
                     j.setBackground(Color.white);
                     j.setBounds(y1,18,ar[i][0]*18, 28);
                     p2.add(j);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setForeground(Color.blue);
                     u.setBounds(cnt*18, 47,23,10);
                     p2.add(u);
                     cnt=cnt+ar[i][0];
                     cot=cot+ar[i][0];
                     y1=y1+(ar[i][0]*18);
                     p2.repaint();
                     p2.revalidate();
                        ar[i][0]=0;
                    }
                    ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 47,23,10);
                     u1.setForeground(Color.blue);
                     p2.add(u1);
                } 
            }
        }
        
     }
            
            
        if(g3.isSelected()){ //P SJF
              p3.removeAll();
              frame2.add(p3);
                 p3.repaint();
                 p3.revalidate();
                 int n;
         n = burst.length;
         int proc[][] = new int[n + 1][4];
         try{
         for(int i = 1; i <= n; i++)
         {
           proc[i][0] = Integer.parseInt(arrive[i-1]);
           proc[i][1] = Integer.parseInt(burst[i-1]);
         }}
         catch(NumberFormatException ae){
             JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for Preemptive Shortest Job First");
                     
         }
         int total_time = 0;
         for(int i = 1; i <= n; i++)
         {
          total_time += proc[i][1];
         }
         int time_chart[] = new int[total_time];
         int g[]=new int[99999]; 
         int g1[]=new int[99999];
         int gk[]=new int[99999];
         int ch=0; int ch2=0; int ch1=0;
         for(int i = proc[1][0]; i < total_time+proc[1][0]; i++)
         {
           int sel_proc = 0;
           int min = 999999;
           for(int j = 1; j <= n; j++)
          {
          if(proc[j][0] <= i)//Condition to check if Process has arrived
          {
           if(proc[j][1] < min && proc[j][1] != 0)
           {
            min = proc[j][1];
            sel_proc = j;
           }
          }
         }

         time_chart[(i-proc[1][0])] = sel_proc;
         proc[sel_proc][1]--;

         for(int j = 1; j <= n; j++)
         {
          if(proc[j][0] <= i)
          {
           if(proc[j][1] != 0)
           {
            proc[j][3]++;
            if(j != sel_proc)
             proc[j][2]++;
           }
           else if(j == sel_proc)
           proc[j][3]++;
          }
         }
        int y1=5; String str=""; 
        if((i-proc[1][0])==0){
          if(sel_proc!=0){
              g[ch++]=i-proc[1][0];
              gk[ch2++]=sel_proc;
          }
        }
        if((i-proc[1][0]) != 0 && (i-proc[1][0])<total_time-1)
        {
        if(sel_proc != time_chart[(i-proc[1][0]) - 1]) 
        {
        g[ch]=(i-proc[1][0]);
        ch++;
        gk[ch2++]=sel_proc;
       }
      }
      
      if((i-proc[1][0]) == total_time - 1)
      g[ch]=(i-proc[1][0])+1;  
      }
     int wt[]=new int[n];
     int tat[]=new int[n];
     double WT = 0,TT = 0;
     for(int i = 0; i < n; i++)
     {
         wt[i]=proc[i+1][2];
         tat[i]=proc[i+1][3];
         WT += proc[i+1][2];
         TT += proc[i+1][3];
     }
     
     WT /= n;
     TT /= n;
     String result = String.format("%.2f", WT);
     String result1 = String.format("%.2f", TT);
                 JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p3.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p3.add(l1);
                 JLabel kk=new JLabel("Turn Around Time ");
                 kk.setBounds(5, 70, 120, 30);
                 p3.add(kk);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p3.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p3.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p3.add(m1);
                String title = "PREEMPTIVE SHORTEST JOB FIRST";
                 Border border = BorderFactory.createTitledBorder(title);
                 p3.setBorder(border);
                String str=""; int y1=5; String s=""; int y2=130; String s1=""; int y3=130; 
                 String ck=""; String str1=""; int y21=130;  int y31=130;
                 int cnt=0; int min=Integer.parseInt(arrive[0]);
                 for(int i=0;i<n;i++){
                     if(min>Integer.parseInt(arrive[i])){
                         min=Integer.parseInt(arrive[i]);
                     }
                 }
                 int cot=min;    
                 for(int i=0;i<n;i++){
                     str1="P"+(i+1);
                     s=str1+" = "+wt[i]+" ";
                     s1=str1+" = "+tat[i]+" ";
                     JLabel h=new JLabel(s);
                     h.setBounds(y21, 55, 70, 30);
                     y21=y21+70;
                     p3.add(h);
                     JLabel pp=new JLabel(s1);
                     pp.setBounds(y31, 70, 70, 30);
                     y31=y31+70;
                     p3.add(pp); 
     }
                for(int i=0;i<ch2;i++){
                     str="P"+gk[i];
                     int jk=g[i+1]-g[i];
                     JLabel jj=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     jj.setBorder(blackline);
                     jj.setOpaque(true);
                     jj.setBackground(Color.white);
                     jj.setBounds(y1,18,jk*18, 28);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setBounds(cnt*18, 47,23,10);
                     u.setForeground(Color.blue);
                     p3.add(u);
                     cnt=cnt+jk;
                     cot=cot+jk;
                     y1=y1+(jk*18);
                     p3.add(jj);
                     p3.repaint();
                     p3.revalidate();
     }
                 ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 45,23,10);
                     u1.setForeground(Color.blue);
                     p3.add(u1);
     }

     if(g4.isSelected()){  //NP SJF
              p4.removeAll();
               frame2.add(p4);
               p4.repaint();
               p4.revalidate();
               int i,n,j,min;
               n=burst.length;
               int[] line=new int[n]; 
               int[] line1=new int[n];
               int[] p={1,2,3,4,5,6};
               int B_T[] =new int[100];
               int A_V_T[]=new int[100];
               int W_T[]=new int[100];
               int temp;
               int T_A_T[]=new int[n];
               int bt=0,k=1;
               double AVR_W_T=0,AVR_T_A_T=0,T_A_T_SUM=0,W_T_SUM=0;
               int[][] ar1=new int[burst.length][3];
               try{
               for(i=0;i<n;i++)
               {
                   A_V_T[i]=Integer.parseInt(arrive[i]);
                   B_T[i]=Integer.parseInt(burst[i]);

                }}
               catch(NumberFormatException ae){
                   JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for Non-Preemptive Shortest Job First");
                     
               }
               for(i=0;i<n;i++)
               {
               for(j=0;j<n;j++)
               {
               if(A_V_T[i]<A_V_T[j])
               {
                temp=p[j];
                p[j]=p[i];
                p[i]=temp;
                temp=A_V_T[j];
                A_V_T[j]=A_V_T[i];
                A_V_T[i]=temp;
                temp=B_T[j];
                B_T[j]=B_T[i];
                B_T[i]=temp;
               }
             }
           }
               
            if(n==2 && A_V_T[0]==A_V_T[1]){
            if(B_T[1]<B_T[0]){
            temp=p[0];
                p[0]=p[1];
                p[1]=temp;
                temp=A_V_T[0];
                A_V_T[0]=A_V_T[1];
                A_V_T[1]=temp;
                temp=B_T[0];
                B_T[0]=B_T[1];
                B_T[1]=temp; 
        }
            
    }
    else{
    for(j=0;j<n;j++)
    {
        bt=bt+B_T[j];
        min=B_T[k];
    for(i=k;i<n;i++)
    {
        if (bt>=A_V_T[i] && B_T[i]<min)
            {
                temp=p[k];
                p[k]=p[i];
                p[i]=temp;
                temp=A_V_T[k];
                A_V_T[k]=A_V_T[i];
                A_V_T[i]=temp;
                temp=B_T[k];
                B_T[k]=B_T[i];
                B_T[i]=temp;
            }
    }
    k++;
    }}
    W_T[0]=0; int sum=A_V_T[0]; int ta=A_V_T[0];
    for(i=1;i<n;i++)
    {
        sum=sum+B_T[i-1];
        W_T[i]=sum-A_V_T[i];
        line[i]=W_T[i];
        W_T_SUM=W_T_SUM+W_T[i];
    }
                                              
    String result = String.format("%.2f", AVR_W_T);
    for(i=0;i<n;i++)
    {
        ta=ta+B_T[i];
        T_A_T[i]=ta-A_V_T[i];
        line1[i]=T_A_T[i];
        T_A_T_SUM=T_A_T_SUM+T_A_T[i];
    }
    AVR_T_A_T=(T_A_T_SUM/n);
    for (int i2 = 0; i2 < burst.length ; i2++) { 
                    ar1[i2][0]=p[i2];
                    ar1[i2][1]=W_T[i2];
                    ar1[i2][2]=T_A_T[i2];
                }
              sortbyColumn(ar1,0);
    String result1 = String.format("%.2f", AVR_T_A_T);
                 JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p4.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p4.add(l1);
                 JLabel kk=new JLabel("Turn Around Time ");
                 kk.setBounds(5, 70, 120, 30);
                 p4.add(kk);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p4.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p4.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p4.add(m1);

                 int y1=5; String str=""; String s=""; int y2=130; String s1=""; int y3=130; 
                 String ck=""; String str2="";
                 int cnt=0;
                 int cot=A_V_T[0];
                 String title = "NON-PREEMPTIVE SHORTEST JOB FIRST";
                 
                 Border border = BorderFactory.createTitledBorder(title);
                 p4.setBorder(border);
                 for(int i1=0;i1<n;i1++){
                     str="P"+Integer.toString(p[i1]);
                     str2="P"+ar1[i1][0]; 
                     JLabel jj=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     jj.setBorder(blackline);
                     jj.setBounds(y1, 18,B_T[i1]*18, 28);
                     jj.setOpaque(true);
                     jj.setBackground(Color.white);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setBounds(cnt*18, 47,23,10);
                     u.setForeground(Color.blue);
                     p4.add(u);
                     cnt=cnt+B_T[i1];
                     cot=cot+B_T[i1];
                     y1=y1+(B_T[i1]*18);
                     s=str2+" = "+ar1[i1][1]+" ";
                     s1=str2+" = "+ar1[i1][2]+" ";
                     JLabel h=new JLabel(s);
                     h.setBounds(y2, 55, 70, 30);
                     y2=y2+70;
                     p4.add(h);
                     JLabel pp=new JLabel(s1);
                     pp.setBounds(y3, 70, 70, 30);
                     y3=y3+70;
                     p4.add(pp);
                     p4.add(jj);
                     p4.repaint();
                     p4.revalidate();
                 }
                 ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 47,23,10);
                     u1.setForeground(Color.blue);
                     p4.add(u1);
    }
      if(g5.isSelected()){ //P Priority
                 p5.removeAll();
                 frame2.add(p5);
                 p5.repaint();
                 p5.revalidate();
                 int n;
          n = burst.length;
          int proc[][] = new int[n + 1][5];
          try{
           for(int i = 1; i <= n; i++)
           {
            proc[i][0] = Integer.parseInt(arrive[i-1]);
            proc[i][1] = Integer.parseInt(burst[i-1]);
            proc[i][4]=Integer.parseInt(priority[i-1]);
           }}
           catch(NumberFormatException ae){
           JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for Preemptive Priority Scheduling (Remove the default text from PRIORITY if not done already)");
                     
           }

       int total_time = 0;
       for(int i = 1; i <= n; i++)
       {
        total_time += proc[i][1];
       }
       int time_chart[] = new int[total_time];
       int g[]=new int[99999]; 
       int g1[]=new int[99999];
       int gk[]=new int[99999];
       int ch=0; int ch2=0; int ch1=0;
       for(int i = proc[1][0]; i < total_time+proc[1][0]; i++)
       {
        int sel_proc = 0;
        int min = 999999;
        for(int j = 1; j <= n; j++)
        {
        if(proc[j][0] <= i)
         {
         if(proc[j][4] < min && proc[j][1] != 0)
         {
          min = proc[j][4];
          sel_proc = j;
        }
       }
      }
      time_chart[i-proc[1][0]] = sel_proc;
      proc[sel_proc][1]--;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;
            if(j != sel_proc)
             proc[j][2]++;
        }
        else if(j == sel_proc)
         proc[j][3]++;
       }
      }
      int y1=5; String str=""; 
      if((i-proc[1][0])==0){
          if(sel_proc!=0){
              g[ch++]=i-proc[1][0];
              gk[ch2++]=sel_proc;
          }
      }
      if((i-proc[1][0]) != 0 && (i-proc[1][0])<total_time-1)
      {
        if(sel_proc != time_chart[(i-proc[1][0]) - 1]) 
       {
        g[ch]=(i-proc[1][0]);
        ch++;
        gk[ch2++]=sel_proc;
       }
      }
      if((i-proc[1][0]) == total_time - 1)
      g[ch]=(i-proc[1][0])+1;
      }   
     int wt[]=new int[n];
     int tat[]=new int[n];
     double WT = 0,TT = 0;
     for(int i = 0; i < n; i++)
     {
         wt[i]=proc[i+1][2];
         tat[i]=proc[i+1][3];
         WT += proc[i+1][2];
         TT += proc[i+1][3];
     }
     
     WT /= n;
     TT /= n;
     String result = String.format("%.2f", WT);
     String result1 = String.format("%.2f", TT);
                 JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p5.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p5.add(l1);
                 JLabel kk=new JLabel("Turn Around Time ");
                 kk.setBounds(5, 70, 120, 30);
                 p5.add(kk);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p5.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p5.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p5.add(m1);
                 
                 String title = "PREEMPTIVE PRIORITY";
                 Border border = BorderFactory.createTitledBorder(title);
                 p5.setBorder(border);

                 String str=""; int y1=5; String s=""; int y2=130; String s1=""; int y3=130; 
                 String ck=""; String str1=""; int y21=130;  int y31=130;
                 int cnt=0;  int min=Integer.parseInt(arrive[0]);
                 for(int i=0;i<n;i++){
                     if(min>Integer.parseInt(arrive[i])){
                         min=Integer.parseInt(arrive[i]);
                     }
                 }
                 int cot=min;  
                 for(int i=0;i<n;i++){
                     str1="P"+(i+1);
                     s=str1+" = "+wt[i]+" ";
                     s1=str1+" = "+tat[i]+" ";
                     JLabel h=new JLabel(s);
                     h.setBounds(y21, 55, 70, 30);
                     y21=y21+70;
                     p5.add(h);
                     JLabel pp=new JLabel(s1);
                     pp.setBounds(y31, 70, 70, 30);
                     y31=y31+70;
                     p5.add(pp); 
      }   
                 
                  for(int i=0;i<ch2;i++){
                     str="P"+gk[i];
                     int jk=g[i+1]-g[i];
                     
                     JLabel jj=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     jj.setBorder(blackline);
                     jj.setBounds(y1, 18,jk*18, 28);
                     jj.setOpaque(true);
                     jj.setBackground(Color.white);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setBounds(cnt*18, 47,23,10);
                     u.setForeground(Color.blue);
                     p5.add(u);
                     cnt=cnt+jk;
                     cot=cot+jk;
                     y1=y1+(jk*18);
                     p5.add(jj);
                     p5.repaint();
                     p5.revalidate();
     }
                 ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 47,23,10);
                     u1.setForeground(Color.blue);
                     p5.add(u1);
            
     }
     if(g6.isSelected()){ //NP Priority
                 p6.removeAll();
                 frame2.add(p6);
                 p6.repaint();
                 p6.revalidate();
                 int i,n,j,min;
                  n=burst.length;
             int[] line=new int[n]; 
             int[] line1=new int[n];
             int[] p={1,2,3,4,5,6};
             int B_T[] =new int[100];
             int P[]=new int[100];
             int A_V_T[]=new int[100];
             int W_T[]=new int[100];
             int temp;
             int T_A_T[]=new int[n];
             int bt=0,k=1;
             int[][] ar1=new int[burst.length][3];
             double AVR_W_T=0,AVR_T_A_T=0,T_A_T_SUM=0,W_T_SUM=0;
        try{
        for(i=0;i<n;i++)
        {
         A_V_T[i]=Integer.parseInt(arrive[i]);
         B_T[i]=Integer.parseInt(burst[i]);
         P[i]=Integer.parseInt(priority[i]);

        }}
        catch(NumberFormatException ae){
        JOptionPane.showMessageDialog(null,"Please Enter Valid Processor Information for Non-Preemptive Priority (Remove the default text from PRIORITY if not done already)");
                     
        }
        for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
        {
            if(A_V_T[i]<A_V_T[j])
            {
                temp=p[j];
                p[j]=p[i];
                p[i]=temp;
                temp=A_V_T[j];
                A_V_T[j]=A_V_T[i];
                A_V_T[i]=temp;
                temp=B_T[j];
                B_T[j]=B_T[i];
                B_T[i]=temp;
                temp=P[j];
                P[j]=P[i];
                P[i]=temp;
            }
        }
    }
       if(n==2 && A_V_T[0]==A_V_T[1]){
        if(P[1]<P[0]){
            temp=p[0];
                p[0]=p[1];
                p[1]=temp;
                temp=A_V_T[0];
                A_V_T[0]=A_V_T[1];
                A_V_T[1]=temp;
                temp=B_T[0];
                B_T[0]=B_T[1];
                B_T[1]=temp; 
                temp=P[0];
                P[0]=P[1];
                P[1]=temp;
        }
    }
       else{
       for(j=0;j<n;j++)
       {
        bt=bt+B_T[j];
        min=P[k];
       for(i=k;i<n;i++)
       {
        if (bt>=A_V_T[i] && P[i]<min)
            { 
                temp=p[k];
                p[k]=p[i];
                p[i]=temp;
                temp=A_V_T[k];
                A_V_T[k]=A_V_T[i];
                A_V_T[i]=temp;
                temp=B_T[k];
                B_T[k]=B_T[i];
                B_T[i]=temp;
                temp=P[k];
                P[k]=P[i];
                P[i]=temp;
            }
       }
       k++;
     }}
       int s=0;  int lbl[]=new int[n];
       for(i=0;i<n;i++){
        s=s+B_T[i];
        lbl[i]=s;
       }
       W_T[0]=0; int ta=A_V_T[0]; int sum=A_V_T[0];
       for(i=1;i<n;i++)
       {
        sum=sum+B_T[i-1];
        W_T[i]=sum-A_V_T[i];
        line[i]=W_T[i];
        W_T_SUM=W_T_SUM+W_T[i];
       }

       AVR_W_T=(W_T_SUM/n);
       for(i=0;i<n;i++)
       {
        ta=ta+B_T[i];
        T_A_T[i]=ta-A_V_T[i];
        line1[i]=T_A_T[i];
        T_A_T_SUM=T_A_T_SUM+T_A_T[i];
       }
       for (int i2 = 0; i2 < burst.length ; i2++) { 
                    ar1[i2][0]=p[i2];
                    ar1[i2][1]=W_T[i2];
                    ar1[i2][2]=T_A_T[i2];
                }
              sortbyColumn(ar1,0);
       AVR_T_A_T=(T_A_T_SUM/n);
       String result = String.format("%.2f", AVR_W_T);
       String result1 = String.format("%.2f", AVR_T_A_T);
                 JLabel l=new JLabel("Waiting Time");
                 l.setBounds(5, 55, 120, 30);
                 p6.add(l);
                 JLabel l1=new JLabel(":");
                 l1.setBounds(120, 55, 5, 30);
                 p6.add(l1);
                 JLabel kk=new JLabel("Turn Around Time ");
                 kk.setBounds(5, 70, 120, 30);
                 p6.add(kk);
                 JLabel k1=new JLabel(":");
                 k1.setBounds(120, 70, 5, 30);
                 p6.add(k1);
                 JLabel m=new JLabel("Avg Waiting Time");
                 m.setBounds(5, 85, 120, 30);
                 p6.add(m);
                 JLabel m1=new JLabel(":   "+result+"     &     Avg Turn Around Time    :   "+result1);
                 m1.setBounds(120, 85, 600, 30);
                 p6.add(m1);
                 
                 
                 String title = "NON-PREEMPTIVE PRIORITY";
                 Border border = BorderFactory.createTitledBorder(title);
                 p6.setBorder(border);

                 int y1=5; String str=""; String str2="";
                 String ss=""; int y2=130; String s1=""; int y3=130; 
                 String ck="";
                 int cnt=0;
                 int cot=A_V_T[0];
                 for(int i1=0;i1<n;i1++){
                     str="P"+Integer.toString(p[i1]);
                     str2="P"+ar1[i1][0]; 
                     JLabel jj=new JLabel(str);
                     javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                     jj.setBorder(blackline);
                     jj.setOpaque(true);
                     jj.setBackground(Color.white);
                     jj.setBounds(y1, 18,B_T[i1]*18, 28);
                     ck=Integer.toString(cnt);
                     ck=""+cot;
                     JLabel u=new JLabel(ck);
                     u.setBounds(cnt*18, 47,23,10);
                     u.setForeground(Color.blue);
                     p6.add(u);
                     cnt=cnt+B_T[i1];
                     cot=cot+B_T[i1];
                     ss=str2+" = "+ar1[i1][1]+" ";
                     s1=str2+" = "+ar1[i1][2]+" ";
                     JLabel h=new JLabel(ss);
                     h.setBounds(y2, 55, 70, 30);
                     y2=y2+70;
                     p6.add(h);
                     JLabel pp=new JLabel(s1);
                     pp.setBounds(y3, 70, 70, 30);
                     y3=y3+70;
                     p6.add(pp);
                     y1=y1+(B_T[i1]*18);
                     p6.add(jj);
                     p6.repaint();
                     p6.revalidate();
                     
                 }
                 ck=""+cot;
                 JLabel u1=new JLabel(ck);
                     u1.setBounds(cnt*18, 47,23,10);
                     u1.setForeground(Color.blue);
                     p6.add(u1);
              }
        }
             else{
                 JOptionPane.showMessageDialog(null,"The Number of Processors Does Not Match With Other Inputs");   
             }
        }
    } //end of actionPerformed
}//end
