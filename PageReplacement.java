/*
NAME: VANSHIKA BANSAL
ROLL NO.: 1710110374
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osgla2;

/**
 *
 * @author VANSHIKA
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.SwingConstants;

public class PageReplacement implements ActionListener {
    static JPanel panel,p,ex,p1,p2,p3;
    static JLabel nof,ref;
    static JTextField rs;
    final JComboBox<String> cb ;
    static JButton comp;
    static JFrame frame;
    public PageReplacement(){
    panel =new JPanel();
    p =new JPanel();
    ex=new JPanel();
    p1 =new JPanel();
    p2 =new JPanel();
    p3 =new JPanel();
    panel.setLayout(new GridLayout(3, 2));
    panel.setSize(50, 50);
    p.setLayout(new FlowLayout());
    p.setSize(50, 50);
    ex.setLayout(new FlowLayout());
    ex.setSize(50, 50);
    p1.setLayout(null);
    p1.setSize(1300, 250);
    p2.setLayout(null);
    p2.setSize(1300, 250);
    p3.setLayout(null);
    p3.setSize(1300, 250);
    nof=new JLabel("Number of Frames:");
    String[] choices = { "3","4","5","6","7"};
    cb = new JComboBox<>(choices);
    cb.setVisible(true);
    ref=new JLabel("Reference String:");
    rs=new JTextField(75);
    comp=new JButton("COMPUTE");
    panel.add(nof);
    panel.add(cb);
    panel.add(ref);
    panel.add(rs);
    p.add(comp);
    panel.add(ex);
    panel.add(p);
    comp.addActionListener(this);
}
    public static void main(String[] args){
        
      frame=new JFrame("Page Replacement"); 
      PageReplacement cs=new PageReplacement();
      frame.setLayout(new GridLayout(4,1));
      frame.add(panel);
      frame.add(p1);
      frame.add(p2);
      frame.add(p3);
      frame.setSize(1300,700);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equalsIgnoreCase("COMPUTE")){
           int choice=Integer.parseInt((String) cb.getSelectedItem());
           int frames[]=new int[choice];
           String t1=rs.getText(); 
           String[] r=t1.split(","); 
           int pages[]=new int[r.length];
           ex.removeAll();
           ex.repaint();
           ex.revalidate();
           JLabel l=new JLabel("Initial Frames:");
           l.setBounds(0,0,100,32);
           ex.add(l);
           ex.repaint();
           ex.revalidate();
           JLabel jj=new JLabel("OS");
               jj.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline1 = BorderFactory.createLineBorder(Color.black);
               jj.setBorder(blackline1);
               jj.setOpaque(true);
               jj.setBackground(Color.white);
               jj.setBounds(0,0,30,17);
               ex.add(jj);
           int y=17;
           for(int i=0;i<frames.length;i++){
               JLabel j=new JLabel("Null");
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.white);
               j.setBounds(0,y,30,17);
               ex.add(j);
               y+=17;
           }  
           p1.removeAll();
           p1.repaint();
           p1.revalidate();
           int y1=10;
           try{
           for(int i=0;i<r.length;i++){
               JLabel j=new JLabel(r[i]);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.cyan);
               j.setBounds(y1,25,30,17);
               p1.add(j);
               y1+=45;
               pages[i]=Integer.parseInt(r[i]);
           }
           }
           catch(NumberFormatException ae){
               JOptionPane.showMessageDialog(null,"Enter a valid reference string");
               System.exit(0);
           }
           for(int i=0; i<frames.length; i++)
           {
            frames[i] = -1;
           }
        boolean flag=true; int pageHit=0; int num=0; int x1=10;
        for(int i=0; i<pages.length; i++)
        {
            flag = true;
            int page = pages[i];
            for(int j=0; j<frames.length; j++)
            {
                if(frames[j] == page)
                {
                    flag = false;
                    pageHit++;
                    break;
                }
            }
            if(num == frames.length)
                num = 0;
            if(flag)
            {
                frames[num] = page;
                num++;
            }
            int g1=42; String str="";
            for(int k=0; k<frames.length; k++)
            {
               if(frames[k]==-1)
                 str="Null";
               else
                 str=frames[k]+"";
               JLabel j=new JLabel(str);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.white);
               j.setBounds(x1,g1,30,17);
               p1.add(j);
               g1+=17;
            }
            x1+=45;
        } 
           String title = "FIRST IN FIRST OUT";
           Border border = BorderFactory.createTitledBorder(title);
           p1.setBorder(border);
           JLabel l1=new JLabel("Page Faults = "+(pages.length-pageHit));
           l1.setBounds(600,0,100,32);
           p1.add(l1);
           p1.repaint();
           p1.revalidate();     
           p2.removeAll();
           p2.repaint();
           p2.revalidate();
           int y2=10;
           try{
           for(int i=0;i<r.length;i++){
               JLabel j=new JLabel(r[i]);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.cyan);
               j.setBounds(y2,25,30,17);
               p2.add(j);
               y2+=45;
           }
           }
           catch(NumberFormatException ae){
               JOptionPane.showMessageDialog(null,"Enter a valid reference string");
               System.exit(0);
           }
        int pointer = 0, fault = 0; int x2=10;
        boolean isFull = false;
        int buffer[];
        buffer = new int[frames.length];
        for(int j = 0; j < frames.length; j++)
                buffer[j] = -1;
        for(int i = 0; i < pages.length; i++)
        {
         int search = -1;
         for(int j = 0; j < frames.length; j++)
         {
          if(buffer[j] == pages[i])
          {
           search = j;
           break;
          } 
         }
         if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[frames.length];
           boolean index_flag[] = new boolean[frames.length];
           for(int j = i + 1; j < pages.length; j++)
           {
            for(int k = 0; k < frames.length; k++)
            {
             if((pages[j] == buffer[k]) && (index_flag[k] == false))
             {
              index[k] = j;
              index_flag[k] = true;
              break;
             }
            }
           }
           int max = index[0];
           pointer = 0;
           if(max == 0)
            max = 9999;
           for(int j = 0; j < frames.length; j++)
           {
            if(index[j] == 0)
             index[j] = 9999;
            if(index[j] > max)
            {
             max = index[j];
             pointer = j;
            }
           }
          }
          buffer[pointer] = pages[i];
          fault++;
          if(!isFull)
          {
           pointer++;
              if(pointer == frames.length)
              {
               pointer = 0;
               isFull = true;
              }
          }
         }
            int g2=42; String str2="";
            for(int k=0; k<buffer.length; k++)
            {
               if(buffer[k]==-1)
                 str2="Null";
               else
                 str2=buffer[k]+"";
               JLabel j=new JLabel(str2);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.white);
               j.setBounds(x2,g2,30,17);
               p2.add(j);
               g2+=17;
            }
            x2+=45;
        }  
           String title2 = "OPTIMAL PAGE REPLACEMENT";
           Border border2 = BorderFactory.createTitledBorder(title2);
           p2.setBorder(border2);
           JLabel l2=new JLabel("Page Faults = "+fault);
           l2.setBounds(600,0,100,32);
           p2.add(l2);
           p2.repaint();
           p2.revalidate();   
           p3.removeAll();
           p3.repaint();
           p3.revalidate();
           int y3=10;
           try{
           for(int i=0;i<r.length;i++){
               JLabel j=new JLabel(r[i]);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.cyan);
               j.setBounds(y3,25,30,17);
               p3.add(j);
               y3+=45;
           }
           }
           catch(NumberFormatException ae){
               JOptionPane.showMessageDialog(null,"Enter a valid reference string");
               System.exit(0);
           }
        pointer = 0;fault = 0; int x3=10;
        isFull = false;
        buffer = new int[frames.length];
        for(int j = 0; j < frames.length; j++)
                buffer[j] = -1;
        for(int i = 0; i < pages.length; i++)
        {
         int search = -1;
         for(int j = 0; j < frames.length; j++)
         {
          if(buffer[j] == pages[i])
          {
           search = j;
           break;
          } 
         }
         if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[frames.length];
           boolean index_flag[] = new boolean[frames.length];
           for(int j = i-1; j>=0; j--)
           {
            for(int k = 0; k < frames.length; k++)
            {
             if((pages[j] == buffer[k]) && (index_flag[k] == false))
             {
              index[k] = j;
              index_flag[k] = true;
              break;
             }
            }
           }
           int min = index[0];
           pointer = 0;
           if(min == 0)
            min = -9999;
           for(int j = 0; j < frames.length; j++)
           {
            if(index[j] == 0)
             index[j] = -9999;
            if(index[j] < min)
            {
             min = index[j];
             pointer = j;
            }
           }
          }
          buffer[pointer] = pages[i];
          fault++;
          if(!isFull)
          {
           pointer++;
              if(pointer == frames.length)
              {
               pointer = 0;
               isFull = true;
              }
          }
         }
            int g3=42; String str3="";
            for(int k=0; k<buffer.length; k++)
            {
               if(buffer[k]==-1)
                 str3="Null";
               else
                 str3=buffer[k]+"";
               JLabel j=new JLabel(str3);
               j.setHorizontalAlignment(SwingConstants.CENTER);
               javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
               j.setBorder(blackline);
               j.setOpaque(true);
               j.setBackground(Color.white);
               j.setBounds(x3,g3,30,17);
               p3.add(j);
               g3+=17;
            }
            x3+=45;
        } 
           String title3 = "LEAST RECENTLY USED";
           Border border3 = BorderFactory.createTitledBorder(title3);
           p3.setBorder(border3);
           JLabel l3=new JLabel("Page Faults = "+fault);
           l3.setBounds(600,0,100,32);
           p3.add(l3);
           p3.repaint();
           p3.revalidate();  
       }     
    }
}
