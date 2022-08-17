package com.infomanageclient.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.infomanage.model.Message;


public class InfoManageConnection {
	public static Socket clientS;
	public InfoManageConnection() {
		try {		
			clientS = new Socket("127.0.0.1",3456);
			System.out.println("与服务器连接成功"+clientS);		
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public Message loginValidate(Message ms) {
		OutputStream os;	//可优化	
		Message ms2=null;
		try {
			os=clientS.getOutputStream();//节点流
			ObjectOutputStream oos=new ObjectOutputStream(os);//封装流
			oos.writeObject(ms);//序列化		
			//接受来自Server端的信息
			System.out.println("返回");
			ObjectInputStream ois=new ObjectInputStream(clientS.getInputStream());
			ms2=(Message)ois.readObject();
			System.out.println("返回成功");
			//if(ms.getMessageType().equals(Message.LOGIN_VALIDATE_SUCCESS)) 
			clientS.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ms2;
	}
	public void changepw(Message ms) {
		OutputStream os;	//可优化	
		try {
			os=clientS.getOutputStream();//节点流
			ObjectOutputStream oos=new ObjectOutputStream(os);//封装流
			oos.writeObject(ms);//序列化		
			clientS.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void updatemove(Message ms) {
		OutputStream os;	//可优化	
		try {
			os=clientS.getOutputStream();//节点流
			ObjectOutputStream oos=new ObjectOutputStream(os);//封装流
			oos.writeObject(ms);//序列化		
			clientS.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
