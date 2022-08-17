package com.infomanage.model;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
public class CardModel {
	private JLabel bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15;
	private JLabel bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23,bt24,bt25,bt26,bt27,bt28,bt29,bt30;
	private JPanel panel;
	
	public CardModel(String[] s) {
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Color color1=new Color(250,225,218);//桂红
		Color color2=Color.WHITE;
		
		panel = new JPanel();
		
		bt0=new JLabel("学  籍  卡  片",SwingConstants.CENTER);
		bt1=new JLabel("单位："+s[0]);
		bt2=new JLabel("专业："+s[1]);
		bt3=new JLabel("学制："+s[2]);
		bt4=new JLabel("班级："+s[3]);
		bt5=new JLabel("学号："+s[4]);
		bt6=new JLabel("姓名",SwingConstants.CENTER);
		bt7=new JLabel(s[5]);
		bt8=new JLabel("性别",SwingConstants.CENTER);
		bt9=new JLabel(s[6]);
		bt10=new JLabel("姓名拼音",SwingConstants.CENTER);
		bt11=new JLabel(s[7]);
		//bt12=new JLabel("照片处");
		bt12=new JLabel(new ImageIcon("src/images/zhaopian.jpg"),SwingConstants.CENTER);
		bt13=new JLabel("出生日期",SwingConstants.CENTER);
		bt14=new JLabel(s[8]);
		bt15=new JLabel("婚否",SwingConstants.CENTER);
		bt16=new JLabel(s[9]);
		bt17=new JLabel("本人电话",SwingConstants.CENTER);
		bt18=new JLabel(s[10]);
		bt19=new JLabel("学习层次",SwingConstants.CENTER);
		bt20=new JLabel(s[11]);
		bt21=new JLabel("政治面貌",SwingConstants.CENTER);
		bt22=new JLabel(s[12]);
		bt23=new JLabel("籍贯",SwingConstants.CENTER);
		bt24=new JLabel(s[13]);
		bt25=new JLabel("民族",SwingConstants.CENTER);
		bt26=new JLabel(s[14]);
		bt27=new JLabel("家庭电话",SwingConstants.CENTER);
		bt28=new JLabel(s[15]);
		bt29=new JLabel("家庭住址",SwingConstants.CENTER);
		bt30=new JLabel(" ");
		
		bt6.setBorder(blackline);bt6.setOpaque(true);bt6.setBackground(color1);
		bt7.setBorder(blackline);bt7.setOpaque(true);bt7.setBackground(color2);
		bt8.setBorder(blackline);bt8.setOpaque(true);bt8.setBackground(color1);
		bt9.setBorder(blackline);bt9.setOpaque(true);bt9.setBackground(color2);
		bt10.setBorder(blackline);bt10.setOpaque(true);bt10.setBackground(color1);
		bt11.setBorder(blackline);bt11.setOpaque(true);bt11.setBackground(color2);
		bt12.setBorder(blackline);bt12.setOpaque(true);bt12.setBackground(color2);	
		bt13.setBorder(blackline);bt13.setOpaque(true);bt13.setBackground(color1);
		bt14.setBorder(blackline);bt14.setOpaque(true);bt14.setBackground(color2);		
		bt15.setBorder(blackline);bt15.setOpaque(true);bt15.setBackground(color1);
		bt16.setBorder(blackline);bt16.setOpaque(true);bt16.setBackground(color2);		
		bt17.setBorder(blackline);bt17.setOpaque(true);bt17.setBackground(color1);
		bt18.setBorder(blackline);bt18.setOpaque(true);bt18.setBackground(color2);
		bt19.setBorder(blackline);bt19.setOpaque(true);bt19.setBackground(color1);
		bt20.setBorder(blackline);bt20.setOpaque(true);bt20.setBackground(color2);
		bt21.setBorder(blackline);bt21.setOpaque(true);bt21.setBackground(color1);
		bt22.setBorder(blackline);bt22.setOpaque(true);bt22.setBackground(color2);
		bt23.setBorder(blackline);bt23.setOpaque(true);bt23.setBackground(color1);
		bt24.setBorder(blackline);bt24.setOpaque(true);bt24.setBackground(color2);
		bt25.setBorder(blackline);bt25.setOpaque(true);bt25.setBackground(color1);
		bt26.setBorder(blackline);bt26.setOpaque(true);bt26.setBackground(color2);
		bt27.setBorder(blackline);bt27.setOpaque(true);bt27.setBackground(color1);
		bt28.setBorder(blackline);bt28.setOpaque(true);bt28.setBackground(color2);
		bt29.setBorder(blackline);bt29.setOpaque(true);bt29.setBackground(color1);
		bt30.setBorder(blackline);bt30.setOpaque(true);bt30.setBackground(color2);
		
		bt0.setFont(new Font("黑体", Font.BOLD, 20));
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbs = new GridBagConstraints();
		panel.setLayout(gbl);
		
		panel.add(bt0);
		panel.add(bt1); panel.add(bt2); panel.add(bt3); panel.add(bt4); panel.add(bt5);
		panel.add(bt6); panel.add(bt7); panel.add(bt8); panel.add(bt9); panel.add(bt10);panel.add(bt11);panel.add(bt12);
		panel.add(bt13);panel.add(bt14);panel.add(bt15);panel.add(bt16);panel.add(bt17);panel.add(bt18);
		panel.add(bt19);panel.add(bt20);panel.add(bt21);panel.add(bt22);
		panel.add(bt23);panel.add(bt24);panel.add(bt25);panel.add(bt26);panel.add(bt27);panel.add(bt28);
		panel.add(bt29);panel.add(bt30);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=11;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=0;
		gbl.setConstraints(bt0, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=1;
		gbl.setConstraints(bt1, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=2;gbs.gridy=1;
		gbl.setConstraints(bt2, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=4;gbs.gridy=1;
		gbl.setConstraints(bt3, gbs);	
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=6;gbs.gridy=1;
		gbl.setConstraints(bt4, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=3;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=8;gbs.gridy=1;
		gbl.setConstraints(bt5, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=2;
		gbl.setConstraints(bt6, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=1;gbs.gridy=2;
		gbl.setConstraints(bt7, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=2;gbs.gridy=2;
		gbl.setConstraints(bt8, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=3;gbs.gridy=2;
		gbl.setConstraints(bt9, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=4;gbs.gridy=2;
		gbl.setConstraints(bt10, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=6;gbs.gridy=2;
		gbl.setConstraints(bt11, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=3;gbs.gridheight=4;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=8;gbs.gridy=2;
		gbl.setConstraints(bt12, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=3;
		gbl.setConstraints(bt13, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=1;gbs.gridy=3;
		gbl.setConstraints(bt14, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=2;gbs.gridy=3;
		gbl.setConstraints(bt15, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=3;gbs.gridy=3;
		gbl.setConstraints(bt16, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=4;gbs.gridy=3;
		gbl.setConstraints(bt17, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=6;gbs.gridy=3;
		gbl.setConstraints(bt18, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=4;
		gbl.setConstraints(bt19, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=1;gbs.gridy=4;
		gbl.setConstraints(bt20, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=3;gbs.gridy=4;
		gbl.setConstraints(bt21, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=4;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=4;gbs.gridy=4;
		gbl.setConstraints(bt22, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=5;
		gbl.setConstraints(bt23, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=1;gbs.gridy=5;
		gbl.setConstraints(bt24, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=2;gbs.gridy=5;
		gbl.setConstraints(bt25, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=3;gbs.gridy=5;
		gbl.setConstraints(bt26, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=4;gbs.gridy=5;
		gbl.setConstraints(bt27, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=6;gbs.gridy=5;
		gbl.setConstraints(bt28, gbs);
		//
		//
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=0;gbs.gridy=6;
		gbl.setConstraints(bt29, gbs);
		
		gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=9;gbs.gridheight=1;
		gbs.weightx=1;gbs.weighty=1;
		gbs.gridx=2;gbs.gridy=6;
		gbl.setConstraints(bt30, gbs);	

	}
	public JPanel getpanel() {
		return panel;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
