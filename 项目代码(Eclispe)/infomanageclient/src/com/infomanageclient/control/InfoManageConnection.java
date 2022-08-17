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
			System.out.println("����������ӳɹ�"+clientS);		
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public Message loginValidate(Message ms) {
		OutputStream os;	//���Ż�	
		Message ms2=null;
		try {
			os=clientS.getOutputStream();//�ڵ���
			ObjectOutputStream oos=new ObjectOutputStream(os);//��װ��
			oos.writeObject(ms);//���л�		
			//��������Server�˵���Ϣ
			System.out.println("����");
			ObjectInputStream ois=new ObjectInputStream(clientS.getInputStream());
			ms2=(Message)ois.readObject();
			System.out.println("���سɹ�");
			//if(ms.getMessageType().equals(Message.LOGIN_VALIDATE_SUCCESS)) 
			clientS.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ms2;
	}
	public void changepw(Message ms) {
		OutputStream os;	//���Ż�	
		try {
			os=clientS.getOutputStream();//�ڵ���
			ObjectOutputStream oos=new ObjectOutputStream(os);//��װ��
			oos.writeObject(ms);//���л�		
			clientS.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void updatemove(Message ms) {
		OutputStream os;	//���Ż�	
		try {
			os=clientS.getOutputStream();//�ڵ���
			ObjectOutputStream oos=new ObjectOutputStream(os);//��װ��
			oos.writeObject(ms);//���л�		
			clientS.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
