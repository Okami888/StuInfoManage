package com.infomanageserver.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=infomanage;";
	public static final String USERNAME="sa";
	public static final String PASSWORD="123456";
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(URL ,USERNAME,PASSWORD);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean loginValidate(String userName,String passWord) {
		boolean loginSuccess=false;
		Connection conn;	
		String user_Login_Sql="select * from [user] where username=? and password=?";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			ptmt=conn.prepareStatement(user_Login_Sql);
			ptmt.setString(1, userName);
			ptmt.setString(2, passWord);
			ResultSet rs=ptmt.executeQuery();
			
			loginSuccess=rs.next();
			//rs.next();System.out.println(rs.getRow());为0		
			//boolean a=rs.last();为1		
			//boolean b=rs.first();为1
			//closeDB(conn, ptmt, rs);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return loginSuccess;
			
	}
	public static String seekUserType(String userName) {
		String usertype=null;
		Connection conn;	
		String user_Type_Sql="select usertype from [user] where username= ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			ptmt=conn.prepareStatement(user_Type_Sql);
			ptmt.setString(1, userName);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()) {		
				usertype=rs.getString(1);
			}	
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return usertype;
			
	}
	public static void changePw(String userName,String passWord) {

		Connection conn;	
		String user_Change_Sql="update [user] set password= ? where username=? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			ptmt=conn.prepareStatement(user_Change_Sql);
			ptmt.setString(1, passWord);
			ptmt.setString(2, userName);
			ptmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
	public static void updateMove(String id,String state) {

		Connection conn;	
		String move_update_Sql="update move set finalstate= ? where nid= ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			ptmt=conn.prepareStatement(move_update_Sql);
			ptmt.setString(1,state);
			ptmt.setString(2, id);
			ptmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
	
	
	public static String[] seekstu(String userName) {
		String[] stu=new String[16];
		int i ;
		Connection conn;	
		String seek_stu_Sql="select * from stu where number = ?";
		PreparedStatement ptmt;
		try {
			conn=getConnection();	
			ptmt=conn.prepareStatement(seek_stu_Sql);
			ptmt.setString(1,userName);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()) {			
				for(i=0;i<=15;i++) {
					stu[i]=rs.getString(i+1);
				}
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return stu;
	}
	public static String[][] seekmove(String userName) {
		String[][] move = null;
		String[] row=new String[10];
		int i ,ii;int a=0;
		Connection conn;
		Statement stmt;
		String seek_move_Sql="select * from move where sno = ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//可滚动迭代多次结果集
			ptmt=conn.prepareStatement(seek_move_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ptmt.setString(1,userName);
			ResultSet rs=ptmt.executeQuery();
			rs.last();i=rs.getRow();move=new String[i][];rs.beforeFirst();
			while(rs.next()) {		
				for(ii=0;ii<=9;ii++) {
					row[ii]=rs.getString(ii+1);
				}
				move[a]=row;
				a++;
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return move;
	}
	public static String[][] seekmove() {
		String[][] move = null;
		String[] row=new String[10];
		int i ,ii;int a=0;
		Connection conn;
		Statement stmt;
		String seek_move_Sql="select * from move where finalstate='待审'";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//可滚动迭代多次结果集
			ptmt=conn.prepareStatement(seek_move_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=ptmt.executeQuery();
			rs.last();i=rs.getRow();move=new String[i][];rs.beforeFirst();
			while(rs.next()) {		
				for(ii=0;ii<=9;ii++) {
					row[ii]=rs.getString(ii+1);
				}
				move[a]=row;
				a++;
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return move;
	}
	public static String[][] seekaward(String userName) {
		String[][] award = null;
		String[] row=new String[4];
		int i ,ii;int a=0;
		Connection conn;
		Statement stmt;
		String seek_award_Sql="select * from award where sno = ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//可滚动迭代多次结果集
			ptmt=conn.prepareStatement(seek_award_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ptmt.setString(1,userName);
			ResultSet rs=ptmt.executeQuery();
			rs.last();i=rs.getRow();award=new String[i][];rs.beforeFirst();
			while(rs.next()) {		
				for(ii=0;ii<=3;ii++) {
					row[ii]=rs.getString(ii+1);
				}
				award[a]=row;
				a++;
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return award;
	}
	public static String[][] seeksc(String userName) {
		String[][] sc = null;
		String[] row=new String[6];
		int i ,ii;int a=0;
		Connection conn;
		Statement stmt;
		String seek_sc_Sql="select * from sc where sno = ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//可滚动迭代多次结果集
			ptmt=conn.prepareStatement(seek_sc_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ptmt.setString(1,userName);
			ResultSet rs=ptmt.executeQuery();
			rs.last();i=rs.getRow();sc=new String[i][];rs.beforeFirst();
			while(rs.next()) {		
				for(ii=0;ii<=5;ii++) {
					row[ii]=rs.getString(ii+1);
				}
				sc[a]=row;
				a++;
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return sc;
	}
	public static String[][] seekts(String userName) {
		String[][] ts = null;
		String[] row=new String[4];//4列
		int i ,ii;int a=0;
		Connection conn;
		Statement stmt;
		String seek_ts_Sql="select * from ts where tno = ? ";
		PreparedStatement ptmt;
		try {
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//可滚动迭代多次结果集
			ptmt=conn.prepareStatement(seek_ts_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ptmt.setString(1,userName);
			ResultSet rs=ptmt.executeQuery();
			rs.last();i=rs.getRow();ts=new String[i][];rs.beforeFirst();
			while(rs.next()) {		
				for(ii=0;ii<=3;ii++) {
					row[ii]=rs.getString(ii+1);
				}
				ts[a]=row;
				a++;
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return ts;
	}
	
}
