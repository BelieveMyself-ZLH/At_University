<<<<<<< HEAD
package com.zlh;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.*;

public class SnakeDemo extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3794762291171148906L;
	
	private JLabel label = new JLabel("��ǰ���ȣ�");
	private JLabel label2 = new JLabel("����ʱ�䣺");
	private JLabel label3 = new JLabel("˵  	    ����");
	private JTextArea explain = new JTextArea("����Ϸ��һ��̰����Demo�汾��ʵ�ּ򵥵��ƶ����÷֣��ж�ײǽ��ײ�Լ��Ĺ��ܣ�"
			+ "��ʼ����Ϊ6��ͷ��Ϊ��ɫ���������ɫ���䡣��Ϸ�������ֻ��300�У�����һЩ��ʾ����ʱ����Ч����˼����С�\n"
			+ "��Ϸ���水�������Ҽ�ʵ���ƶ�����ESC���¿�ʼ�����ո������ʵ����ͣ�Ϳ�ʼ");
	private JLabel Score = new JLabel("1");
	private JLabel Time = new JLabel("");
	private Font f = new Font("΢���ź�",Font.PLAIN,15);
	private Font f2 = new Font("΢���ź�",Font.PLAIN,13);
	private JPanel p = new JPanel();
	
	private final int MAX_SIZE = 400;//�������Ϊ400��
	private Tile temp = new Tile(0,0);
	private Tile temp2 = new Tile(0,0);
	private Tile head;
	private Tile[] body = new Tile[MAX_SIZE];
	
	private String direction = "R";//Ĭ��������
	private String current_direction = "R";//��ǰ����
	private boolean first_launch = false;
	private boolean iseaten = false;
	private boolean isrun = true;
	private int randomx,randomy;
	private int body_length = 0;//���峤�ȳ�ʼ��Ϊ0
	private Thread run;
	
	private int hour =0;
	private int min =0;
	private int sec =0 ;
	
	private boolean pause = false;
	
	private long millis = 500;//ÿ��500����ˢ��һ��
	private boolean speed = true;
	private Calendar Cld;
	private int MI,MI2,MI3;
	private int SS,SS2,SS3;
	
	public SnakeDemo(){
		
		String lookAndFeel =UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
		//����
		add(label);
	    label.setBounds(500, 10, 80, 20);
	    label.setFont(f);
	    add(Score);
	    Score.setBounds(500, 35, 80, 20);
	    Score.setFont(f);
	    add(label2);
	    label2.setBounds(500, 60, 80, 20);
	    label2.setFont(f);
	    add(Time);
	    Time.setBounds(500, 85, 80, 20);
	    Time.setFont(f);
	    add(p);
	    p.setBounds(498, 110, 93, 1);
	    p.setBorder(BorderFactory.createLineBorder(Color.black));    
	    add(label3);
	    label3.setBounds(500, 115, 80, 20);
	    label3.setFont(f);
	    add(explain);
	    explain.setBounds(498, 138, 100, 350);
	    explain.setFont(f2);
	    explain.setLineWrap(true);
	    explain.setOpaque(false); 
	    
	    //��ʼ��ͷ������
	    ProduceRandom();
	    head = new Tile(randomx,randomy);
	    
	    //��ʼ���������нڵ�
		for(int i = 0; i < MAX_SIZE;i++)
		{
			body[i] = new Tile(0,0);
		}
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		super.keyPressed(e);
	    		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	    		{
	    			if(isrun && current_direction != "L")
	    			{
	    				direction = "R";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_LEFT)
	    		{
	    			if(isrun && current_direction != "R")
	    			{
	    				direction = "L";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_UP)
	    		{
	    			if(isrun && current_direction != "D")
	    			{
	    				direction = "U";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_DOWN)
	    		{
	    			if(isrun && current_direction != "U")
	    			{
	    				direction = "D";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)//�������б�����ʼֵ
	    		{
	    			//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
	    		}
	    		
	    		if(e.getKeyCode() == KeyEvent.VK_SPACE)//���ո����ʼ����ͣ��ʱû��������˼����
	    		{
	    			if(!pause)//��ͣ
	    			{
	    				pause = true;
	    				isrun = false;
	    			}
	    			else//��ʼ
	    			{
	    				pause = false;
	    				isrun = true;
	    			}
	    		}
	    	}
		});
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		int key = e.getKeyCode();
	    		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
	    		{
	    			if(speed)
	    			{
	    				Cld = Calendar.getInstance();
		    			int YY = Cld.get(Calendar.YEAR) ;
		    	        int MM = Cld.get(Calendar.MONTH)+1;
		    	        int DD = Cld.get(Calendar.DATE);
		    	        int HH = Cld.get(Calendar.HOUR_OF_DAY);
		    	        int mm = Cld.get(Calendar.MINUTE);
		    	        SS = Cld.get(Calendar.SECOND);
		    	        MI = Cld.get(Calendar.MILLISECOND); 
		    	        System.out.println("Pressed time  " + YY + "/" + MM + "/" + DD + "-" + HH
		    	        		+ ":" + mm + ":" + SS + ":" + MI);
		    	        
		    	        speed = false;
	    			}
	    			
	    			Cld = Calendar.getInstance();
	    			SS3 = Cld.get(Calendar.SECOND);
	    	        MI3 = Cld.get(Calendar.MILLISECOND); 
	    	        int x = SS3 * 1000 + MI3 - ( SS * 1000 + MI);
	    	        if(x > 400)//��һ����ť��ʱ������400����ʶ��Ϊ����
	    	        {
	    	        	millis = 100;
	    	        	System.out.println("Long Pressed");
	    	        }
	    		}
	    	}
		});
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyReleased(KeyEvent e) {
	    		int key = e.getKeyCode();
	    		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
	    		{
	    			Cld = Calendar.getInstance();
	    			int YY2 = Cld.get(Calendar.YEAR) ;
	    	        int MM2 = Cld.get(Calendar.MONTH)+1;
	    	        int DD2 = Cld.get(Calendar.DATE);
	    	        int HH2 = Cld.get(Calendar.HOUR_OF_DAY);
	    	        int mm2 = Cld.get(Calendar.MINUTE);
	    	        SS2 = Cld.get(Calendar.SECOND);
	    	        MI2 = Cld.get(Calendar.MILLISECOND); 
	    	        System.out.println("Released time " + YY2 + "/" + MM2 + "/" + DD2 + "-" + HH2 
	    	        		+ ":" + mm2 + ":" + SS2 + ":" + MI2 + "\n" );

	    	        speed = true;
	    	        millis = 500;
	    		}
	    	}
		});
		
		//��ʼ��ʱ
		new Timer();
		
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g1){
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_NORMALIZE);
		
		//��ͷ��
		g.setColor(Color.red);
		g.fillRoundRect(head.x, head.y, 20, 20, 10, 10);
		
		g.setPaint(new GradientPaint(115,135,Color.CYAN,230,135,Color.MAGENTA,true));
		if(!first_launch)
		{
			//��ʼ������
			int x = head.x;
			for(int i = 0;i < body_length;i++)
			{
				x -= 22;//������������ļ��Ϊ2�����أ������ȶ�Ϊ20����
				body[i].x = x;
				body[i].y = head.y;
				g.fillRoundRect(body[i].x, body[i].y, 20, 20, 10, 10);
			}
			//��ʼ��ʳ��λ��
			ProduceRandom();
			g.fillOval(randomx, randomy, 19, 19);
		}
		else
		{
			//ÿ��ˢ������
			for(int i = 0;i < body_length;i++)
			{
				g.fillRoundRect(body[i].x, body[i].y, 20, 20, 10, 10);
			}
			
			if(EatFood())//���������²���ʳ��
			{
				ProduceRandom();
				g.fillOval(randomx, randomy, 19, 19);
				iseaten = false;
			}
			else
			{
				g.fillOval(randomx, randomy, 19, 19);
			}
		}
		first_launch = true;
		
		//ǽ
		g.setStroke( new BasicStroke(4,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g.setBackground(Color.black);
		g.drawRect(2, 7, 491, 469);
		
		//������
		for(int i = 1;i < 22;i++)
		{
			g.setStroke( new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
			g.setColor(Color.black);
			g.drawLine(5+i*22,9,5+i*22,472);
			if(i <= 20)
			{
				g.drawLine(4,10+i*22,491,10+i*22);
			}
		}
	}
	
	public void ProduceRandom(){
		boolean flag = true;
		Random rand = new Random();
		randomx = (rand.nextInt(21) + 1) * 22 + 7;
		randomy = (rand.nextInt(20) + 1) *22 + 12;
		while(flag)
		{
			if(body_length == 0)
			{
				flag = false;
			}
			else
			{
				for(int i = 0;i < body_length; i++)
				{
					if(body[i].x == randomx && body[i].y == randomy)
					{
						randomx = (rand.nextInt(21) + 1) * 22 + 7;
						randomy = (rand.nextInt(20) + 1) *22 + 12;
						flag = true;
						break;
					}
					else
					{
						if(i == body_length - 1)
						{
							flag = false;
						}
					}
				}
			}
		}
	}
	
	public void HitWall(){//�ж��Ƿ�ײǽ
		if(current_direction == "L")
		{
			if(head.x < 7)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}		
			}
		}
		if(current_direction == "R")
		{
			if(head.x > 489)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
		if(current_direction == "U")
		{
			if(head.y < 12)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
		if(current_direction == "D")
		{
			if(head.y > 472)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
	}
	
	public void HitSelf(){//�ж��Ƿ�ײ���Լ�����
		for(int i = 0;i < body_length; i++)
		{
			if(body[i].x == head.x && body[i].y == head.y)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int j = 0; j < MAX_SIZE;j++)
	    			{
	    				body[j].x = 0;
	    				body[j].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
				break;
			}
		}
	}
	
	public boolean  EatFood(){
		if(head.x == randomx && head.y == randomy)
		{
			iseaten = true;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Thread(){
//		millis = 500;//ÿ��500����ˢ��һ��
		run = new Thread() {
			public void run() {
				while (true) 
				{
					try {
						Thread.sleep(millis);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					
					if(!pause)
					{	
						temp.x = head.x;
						temp.y = head.y;
						//ͷ���ƶ�
						if(direction == "L")
						{
							head.x -= 22;
						}
						if(direction == "R")
						{
							head.x += 22;
						}
						if(direction == "U")
						{
							head.y -= 22;
						}
						if(direction == "D")
						{
							head.y += 22;
						}
						current_direction = direction;//ˢ�µ�ǰǰ������
						//�����ƶ�
						for(int i = 0;i < body_length;i++)
						{
							temp2.x = body[i].x;
							temp2.y = body[i].y;
							body[i].x = temp.x;
							body[i].y = temp.y;
							temp.x = temp2.x;
							temp.y = temp2.y;
						}
						
						if(EatFood())
						{
							body_length ++;
							body[body_length-1].x = temp.x;
							body[body_length-1].y = temp.y;
							Score.setText("" + (body_length+1) );
							new AePlayWave("eat.wav").start();
						}
						
						repaint();
						//ˢ�����ж��Ƿ�ײǽ��ײ�Լ�������
						HitWall();
						HitSelf();
					}
				}
			}
		};
		
		run.start();
	}
	
	public static void main(String[] args) {
		SnakeDemo snake = new SnakeDemo();
		snake.Thread();
		
		JFrame game = new JFrame();
		Image img = Toolkit.getDefaultToolkit().getImage("title.png");//����ͼ��
		game.setIconImage(img);
	    game.setTitle("Snake By ZLH");
	    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    game.setSize(502, 507);
	    game.setSize(602, 507);
	    game.setResizable(false);
	    game.setLocationRelativeTo(null);
	   
	    game.add(snake);
	    System.out.println("OK");
	    game.setVisible(true);
	}
	
	//��ʱ����
	class Timer extends Thread{  
		    public Timer(){
		        this.start();
		    }
		    @Override
		    public void run() {
		        // TODO Auto-generated method stub
		        while(true){
		            if(isrun){
		                sec +=1 ;
		                if(sec >= 60){
		                    sec = 0;
		                    min +=1 ;
		                }
		                if(min>=60){
		                    min=0;
		                    hour+=1;
		                }
		                showTime();
		            }
		 
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		             
		        }
		    }

		    private void showTime(){
		        String strTime ="" ;
		        if(hour < 10)
		            strTime = "0"+hour+":";
		        else
		            strTime = ""+hour+":";
		         
		        if(min < 10)
		            strTime = strTime+"0"+min+":";
		        else
		            strTime =strTime+ ""+min+":";
		         
		        if(sec < 10)
		            strTime = strTime+"0"+sec;
		        else
		            strTime = strTime+""+sec;
		         
		        //�ڴ�����������ʾʱ��
		        Time.setText(strTime);
		    }
		}	
}
=======
package com.zlh;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.*;

public class SnakeDemo extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3794762291171148906L;
	
	private JLabel label = new JLabel("��ǰ���ȣ�");
	private JLabel label2 = new JLabel("����ʱ�䣺");
	private JLabel label3 = new JLabel("˵  	    ����");
	private JTextArea explain = new JTextArea("����Ϸ��һ��̰����Demo�汾��ʵ�ּ򵥵��ƶ����÷֣��ж�ײǽ��ײ�Լ��Ĺ��ܣ�"
			+ "��ʼ����Ϊ6��ͷ��Ϊ��ɫ���������ɫ���䡣��Ϸ�������ֻ��300�У�����һЩ��ʾ����ʱ����Ч����˼����С�\n"
			+ "��Ϸ���水�������Ҽ�ʵ���ƶ�����ESC���¿�ʼ�����ո������ʵ����ͣ�Ϳ�ʼ");
	private JLabel Score = new JLabel("1");
	private JLabel Time = new JLabel("");
	private Font f = new Font("΢���ź�",Font.PLAIN,15);
	private Font f2 = new Font("΢���ź�",Font.PLAIN,13);
	private JPanel p = new JPanel();
	
	private final int MAX_SIZE = 400;//�������Ϊ400��
	private Tile temp = new Tile(0,0);
	private Tile temp2 = new Tile(0,0);
	private Tile head;
	private Tile[] body = new Tile[MAX_SIZE];
	
	private String direction = "R";//Ĭ��������
	private String current_direction = "R";//��ǰ����
	private boolean first_launch = false;
	private boolean iseaten = false;
	private boolean isrun = true;
	private int randomx,randomy;
	private int body_length = 0;//���峤�ȳ�ʼ��Ϊ0
	private Thread run;
	
	private int hour =0;
	private int min =0;
	private int sec =0 ;
	
	private boolean pause = false;
	
	private long millis = 500;//ÿ��500����ˢ��һ��
	private boolean speed = true;
	private Calendar Cld;
	private int MI,MI2,MI3;
	private int SS,SS2,SS3;
	
	public SnakeDemo(){
		
		String lookAndFeel =UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
		//����
		add(label);
	    label.setBounds(500, 10, 80, 20);
	    label.setFont(f);
	    add(Score);
	    Score.setBounds(500, 35, 80, 20);
	    Score.setFont(f);
	    add(label2);
	    label2.setBounds(500, 60, 80, 20);
	    label2.setFont(f);
	    add(Time);
	    Time.setBounds(500, 85, 80, 20);
	    Time.setFont(f);
	    add(p);
	    p.setBounds(498, 110, 93, 1);
	    p.setBorder(BorderFactory.createLineBorder(Color.black));    
	    add(label3);
	    label3.setBounds(500, 115, 80, 20);
	    label3.setFont(f);
	    add(explain);
	    explain.setBounds(498, 138, 100, 350);
	    explain.setFont(f2);
	    explain.setLineWrap(true);
	    explain.setOpaque(false); 
	    
	    //��ʼ��ͷ������
	    ProduceRandom();
	    head = new Tile(randomx,randomy);
	    
	    //��ʼ���������нڵ�
		for(int i = 0; i < MAX_SIZE;i++)
		{
			body[i] = new Tile(0,0);
		}
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		super.keyPressed(e);
	    		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	    		{
	    			if(isrun && current_direction != "L")
	    			{
	    				direction = "R";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_LEFT)
	    		{
	    			if(isrun && current_direction != "R")
	    			{
	    				direction = "L";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_UP)
	    		{
	    			if(isrun && current_direction != "D")
	    			{
	    				direction = "U";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_DOWN)
	    		{
	    			if(isrun && current_direction != "U")
	    			{
	    				direction = "D";
	    			}
	    		}
	    		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)//�������б�����ʼֵ
	    		{
	    			//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
	    		}
	    		
	    		if(e.getKeyCode() == KeyEvent.VK_SPACE)//���ո����ʼ����ͣ��ʱû��������˼����
	    		{
	    			if(!pause)//��ͣ
	    			{
	    				pause = true;
	    				isrun = false;
	    			}
	    			else//��ʼ
	    			{
	    				pause = false;
	    				isrun = true;
	    			}
	    		}
	    	}
		});
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		int key = e.getKeyCode();
	    		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
	    		{
	    			if(speed)
	    			{
	    				Cld = Calendar.getInstance();
		    			int YY = Cld.get(Calendar.YEAR) ;
		    	        int MM = Cld.get(Calendar.MONTH)+1;
		    	        int DD = Cld.get(Calendar.DATE);
		    	        int HH = Cld.get(Calendar.HOUR_OF_DAY);
		    	        int mm = Cld.get(Calendar.MINUTE);
		    	        SS = Cld.get(Calendar.SECOND);
		    	        MI = Cld.get(Calendar.MILLISECOND); 
		    	        System.out.println("Pressed time  " + YY + "/" + MM + "/" + DD + "-" + HH
		    	        		+ ":" + mm + ":" + SS + ":" + MI);
		    	        
		    	        speed = false;
	    			}
	    			
	    			Cld = Calendar.getInstance();
	    			SS3 = Cld.get(Calendar.SECOND);
	    	        MI3 = Cld.get(Calendar.MILLISECOND); 
	    	        int x = SS3 * 1000 + MI3 - ( SS * 1000 + MI);
	    	        if(x > 400)//��һ����ť��ʱ������400����ʶ��Ϊ����
	    	        {
	    	        	millis = 100;
	    	        	System.out.println("Long Pressed");
	    	        }
	    		}
	    	}
		});
		
		this.addKeyListener(new KeyAdapter() {
	    	public void keyReleased(KeyEvent e) {
	    		int key = e.getKeyCode();
	    		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
	    		{
	    			Cld = Calendar.getInstance();
	    			int YY2 = Cld.get(Calendar.YEAR) ;
	    	        int MM2 = Cld.get(Calendar.MONTH)+1;
	    	        int DD2 = Cld.get(Calendar.DATE);
	    	        int HH2 = Cld.get(Calendar.HOUR_OF_DAY);
	    	        int mm2 = Cld.get(Calendar.MINUTE);
	    	        SS2 = Cld.get(Calendar.SECOND);
	    	        MI2 = Cld.get(Calendar.MILLISECOND); 
	    	        System.out.println("Released time " + YY2 + "/" + MM2 + "/" + DD2 + "-" + HH2 
	    	        		+ ":" + mm2 + ":" + SS2 + ":" + MI2 + "\n" );

	    	        speed = true;
	    	        millis = 500;
	    		}
	    	}
		});
		
		//��ʼ��ʱ
		new Timer();
		
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g1){
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_NORMALIZE);
		
		//��ͷ��
		g.setColor(Color.red);
		g.fillRoundRect(head.x, head.y, 20, 20, 10, 10);
		
		g.setPaint(new GradientPaint(115,135,Color.CYAN,230,135,Color.MAGENTA,true));
		if(!first_launch)
		{
			//��ʼ������
			int x = head.x;
			for(int i = 0;i < body_length;i++)
			{
				x -= 22;//������������ļ��Ϊ2�����أ������ȶ�Ϊ20����
				body[i].x = x;
				body[i].y = head.y;
				g.fillRoundRect(body[i].x, body[i].y, 20, 20, 10, 10);
			}
			//��ʼ��ʳ��λ��
			ProduceRandom();
			g.fillOval(randomx, randomy, 19, 19);
		}
		else
		{
			//ÿ��ˢ������
			for(int i = 0;i < body_length;i++)
			{
				g.fillRoundRect(body[i].x, body[i].y, 20, 20, 10, 10);
			}
			
			if(EatFood())//���������²���ʳ��
			{
				ProduceRandom();
				g.fillOval(randomx, randomy, 19, 19);
				iseaten = false;
			}
			else
			{
				g.fillOval(randomx, randomy, 19, 19);
			}
		}
		first_launch = true;
		
		//ǽ
		g.setStroke( new BasicStroke(4,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g.setBackground(Color.black);
		g.drawRect(2, 7, 491, 469);
		
		//������
		for(int i = 1;i < 22;i++)
		{
			g.setStroke( new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
			g.setColor(Color.black);
			g.drawLine(5+i*22,9,5+i*22,472);
			if(i <= 20)
			{
				g.drawLine(4,10+i*22,491,10+i*22);
			}
		}
	}
	
	public void ProduceRandom(){
		boolean flag = true;
		Random rand = new Random();
		randomx = (rand.nextInt(21) + 1) * 22 + 7;
		randomy = (rand.nextInt(20) + 1) *22 + 12;
		while(flag)
		{
			if(body_length == 0)
			{
				flag = false;
			}
			else
			{
				for(int i = 0;i < body_length; i++)
				{
					if(body[i].x == randomx && body[i].y == randomy)
					{
						randomx = (rand.nextInt(21) + 1) * 22 + 7;
						randomy = (rand.nextInt(20) + 1) *22 + 12;
						flag = true;
						break;
					}
					else
					{
						if(i == body_length - 1)
						{
							flag = false;
						}
					}
				}
			}
		}
	}
	
	public void HitWall(){//�ж��Ƿ�ײǽ
		if(current_direction == "L")
		{
			if(head.x < 7)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}		
			}
		}
		if(current_direction == "R")
		{
			if(head.x > 489)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
		if(current_direction == "U")
		{
			if(head.y < 12)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
		if(current_direction == "D")
		{
			if(head.y > 472)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int i = 0; i < MAX_SIZE;i++)
	    			{
	    				body[i].x = 0;
	    				body[i].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
			}
		}
	}
	
	public void HitSelf(){//�ж��Ƿ�ײ���Լ�����
		for(int i = 0;i < body_length; i++)
		{
			if(body[i].x == head.x && body[i].y == head.y)
			{
				new AePlayWave("over.wav").start();
				isrun = false;
				int result=JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION)
				{
					//��ʼ��ͷ������
	    		    ProduceRandom();
	    		    head = new Tile(randomx,randomy);
	    		    //��ʼ������ڵ㲿����
	    		    for(int j = 0; j < MAX_SIZE;j++)
	    			{
	    				body[j].x = 0;
	    				body[j].y = 0;
	    			}
	    		    
	    			hour =0;
	    			min =0;
	    			sec =0 ;
	    			direction = "R";//Ĭ��������
	    			current_direction = "R";//��ǰ����
	    			first_launch = false;
	    			iseaten = false;
	    			isrun = true;
	    			pause = false;
	    			millis = 500;//ÿ��500����ˢ��һ��
	    			speed = true;
	    			body_length = 0;
	    			Score.setText("1");
	    			
	    			run = new Thread();
	    			run.start();
	    			System.out.println("Start again");
				}
				else
				{
					run.stop();
				}
				break;
			}
		}
	}
	
	public boolean  EatFood(){
		if(head.x == randomx && head.y == randomy)
		{
			iseaten = true;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Thread(){
//		millis = 500;//ÿ��500����ˢ��һ��
		run = new Thread() {
			public void run() {
				while (true) 
				{
					try {
						Thread.sleep(millis);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					
					if(!pause)
					{	
						temp.x = head.x;
						temp.y = head.y;
						//ͷ���ƶ�
						if(direction == "L")
						{
							head.x -= 22;
						}
						if(direction == "R")
						{
							head.x += 22;
						}
						if(direction == "U")
						{
							head.y -= 22;
						}
						if(direction == "D")
						{
							head.y += 22;
						}
						current_direction = direction;//ˢ�µ�ǰǰ������
						//�����ƶ�
						for(int i = 0;i < body_length;i++)
						{
							temp2.x = body[i].x;
							temp2.y = body[i].y;
							body[i].x = temp.x;
							body[i].y = temp.y;
							temp.x = temp2.x;
							temp.y = temp2.y;
						}
						
						if(EatFood())
						{
							body_length ++;
							body[body_length-1].x = temp.x;
							body[body_length-1].y = temp.y;
							Score.setText("" + (body_length+1) );
							new AePlayWave("eat.wav").start();
						}
						
						repaint();
						//ˢ�����ж��Ƿ�ײǽ��ײ�Լ�������
						HitWall();
						HitSelf();
					}
				}
			}
		};
		
		run.start();
	}
	
	public static void main(String[] args) {
		SnakeDemo snake = new SnakeDemo();
		snake.Thread();
		
		JFrame game = new JFrame();
		Image img = Toolkit.getDefaultToolkit().getImage("title.png");//����ͼ��
		game.setIconImage(img);
	    game.setTitle("Snake By ZLH");
	    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    game.setSize(502, 507);
	    game.setSize(602, 507);
	    game.setResizable(false);
	    game.setLocationRelativeTo(null);
	   
	    game.add(snake);
	    System.out.println("OK");
	    game.setVisible(true);
	}
	
	//��ʱ����
	class Timer extends Thread{  
		    public Timer(){
		        this.start();
		    }
		    @Override
		    public void run() {
		        // TODO Auto-generated method stub
		        while(true){
		            if(isrun){
		                sec +=1 ;
		                if(sec >= 60){
		                    sec = 0;
		                    min +=1 ;
		                }
		                if(min>=60){
		                    min=0;
		                    hour+=1;
		                }
		                showTime();
		            }
		 
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		             
		        }
		    }

		    private void showTime(){
		        String strTime ="" ;
		        if(hour < 10)
		            strTime = "0"+hour+":";
		        else
		            strTime = ""+hour+":";
		         
		        if(min < 10)
		            strTime = strTime+"0"+min+":";
		        else
		            strTime =strTime+ ""+min+":";
		         
		        if(sec < 10)
		            strTime = strTime+"0"+sec;
		        else
		            strTime = strTime+""+sec;
		         
		        //�ڴ�����������ʾʱ��
		        Time.setText(strTime);
		    }
		}	
}
>>>>>>> second commit
