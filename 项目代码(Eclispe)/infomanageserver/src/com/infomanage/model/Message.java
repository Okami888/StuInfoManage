package com.infomanage.model;

import java.io.Serializable;


public class Message implements Serializable,MessageType{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String messageType;
	String userName;
	String passWord;
	String userType;
	String updatemove;
	String[] Table1;	
	String[][] Table2;
	String[][] Table3;
	String[][] Table4;
	String[][] teaTable;
	public String getUpdatemove() {
		return updatemove;
	}

	public void setUpdatemove(String updatemove) {
		this.updatemove = updatemove;
	}
	public String[][] getTeaTable() {
		return teaTable;
	}

	public void setTeaTable(String[][] teaTable) {
		this.teaTable = teaTable;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String[] getTable1() {
		return Table1;
	}

	public void setTable1(String[] table1) {
		Table1 = table1;
	}

	public String[][] getTable2() {
		return Table2;
	}

	public void setTable2(String[][] table2) {
		Table2 = table2;
	}

	public String[][] getTable3() {
		return Table3;
	}

	public void setTable3(String[][] table3) {
		Table3 = table3;
	}

	public String[][] getTable4() {
		return Table4;
	}

	public void setTable4(String[][] table4) {
		Table4 = table4;
	}
	
	
	
	
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

}
