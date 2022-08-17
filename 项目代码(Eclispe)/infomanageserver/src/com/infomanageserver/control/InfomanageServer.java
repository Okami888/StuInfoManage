package com.infomanageserver.control;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Closeable;
import java.net.ServerSocket;
import java.net.Socket;

import com.infomanage.model.Message;

import com.infomanageserver.control.DBUtil;

public class InfomanageServer implements Runnable {
	private ServerSocket ss;
	public Socket getServerS() {
		return serverS;
	}
	Socket serverS;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public InfomanageServer() {
		 new Thread(this).start();
	}
	@Override
	public void run() {
		try {
			ss=new ServerSocket(3456);
			while(true) {
				serverS=ss.accept();
				System.out.println("一个客户端建立连接成功"+serverS);
				InputStream is=serverS.getInputStream();
				ois=new ObjectInputStream(is);
				
				Message ms=(Message) ois.readObject();
				String passWord=ms.getPassWord();
				String userName=ms.getUserName();
				String userType=ms.getMessageType();
				
				//Message ms =new Message();
				
				if(userType.equals(Message.LOGIN_VALIDATE)) {
					System.out.println("正在验证");
						if(DBUtil.loginValidate(userName,passWord)) {
							System.out.println("验证成功");
							String usertype=DBUtil.seekUserType(userName);
							if(usertype.equals("1")) {						
								System.out.println("是学生");
								String[] table1=DBUtil.seekstu(userName);
								String[][] table2=DBUtil.seekmove(userName);
								String[][] table3=DBUtil.seekaward(userName);
								String[][] table4=DBUtil.seeksc(userName);
								ms.setTable1(table1);
								ms.setTable2(table2);
								ms.setTable3(table3);
								ms.setTable4(table4);
								ms.setUserType(usertype);
								ms.setMessageType(Message.LOGIN_VALIDATE_SUCCESS);
							}else {
								System.out.println("是老师");
								String[][] teaTable=DBUtil.seekts(userName);
								String[][] table2=DBUtil.seekmove();
								ms.setTeaTable(teaTable);
								ms.setTable2(table2);
								ms.setUserType(usertype);
								ms.setMessageType(Message.LOGIN_VALIDATE_SUCCESS);
							}				

						}else {
							ms.setMessageType(Message.LOGIN_VALIDATE_FAILURE);
						}
						oos =new ObjectOutputStream(serverS.getOutputStream());
						oos.writeObject(ms);
					}
				if(userType.equals(Message.CHANGE_PW)) {
						DBUtil.changePw(userName, passWord);
					}
				if(userType.equals(Message.UPDATE_MOVE)) {
					DBUtil.updateMove(userName, ms.getUpdatemove());
				}
				}			
		} catch ( IOException e) {
			close(oos,ois,serverS,ss);
		}catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	public void close(Closeable... ios) {//可变长参数
        for(Closeable io: ios) {
            try {
                if(null != io)
                    io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
