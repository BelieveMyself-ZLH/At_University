package com.zlh.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Windows extends JFrame {

	private JPanel contentPane;
	private static final int WIDTH=450;
	private static final int HEIGHT=300;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows frame = new Windows();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Windows() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GoldPointGame");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		setLocation(x,y);
		setSize(WIDTH, HEIGHT);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入用户名:");
		JTextField jtf=new JTextField(15);
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout());
		jp1.add(lblNewLabel);
		jp1.add(jtf);
		
		JLabel lblNewLabel1=new JLabel("请输入你的数(小于100):");
		JTextField jtf1=new JTextField(10);
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(lblNewLabel1);
		jp2.add(jtf1);
		
		JButton jb=new JButton("确定");
		JButton jb1=new JButton("取消");
		JButton jb2=new JButton("重置");
		
		jb.addActionListener(new ButtonHandler());
		jb1.addActionListener(new Button1Handler());
		jb2.addActionListener(new Button2Handler());
		
		JPanel jp3=new JPanel();
		jp3.setLayout(new FlowLayout());
		jp3.add(jb);
		jp3.add(jb1);
		jp3.add(jb2);
		
		JPanel jp=new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		
		contentPane.add(jp, BorderLayout.SOUTH);
		
		JScrollPane jsp=new JScrollPane();
		contentPane.add(jsp,BorderLayout.CENTER);
	}

}
