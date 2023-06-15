package com.coding404.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
	//1. 나자신의 객체를 스태틱으로 선언
	private static UserDAO instance = new UserDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
		
	}
	//3. getter를 통해서 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	//데이터베이스 연결 주소
	//+오라클 커넥터
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";	
	
	/**
	 * 
	 * @author 20230608 홍길동 중복검사
	 */
	public int idCheck(String id) {
		
		int result = 1;
		
		String sql = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			//1. Connector - 디비연결
			conn = DriverManager.getConnection(url, uid, upw);
			//2. Pstmt - sql을 실행하기 위한 클래스
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, id);
			//3. ResultSet
			rs = pstmt.executeQuery(); //select문
			
			if(rs.next()) { //중복 o
				result = 1;
			} else { //중복 x
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		
		return result; 
	}
	
	//회원가입
	public void join(UserVO vo) {
		
		String sql = "insert into users(id, pw, name, email, gender) values(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getPw() );
			pstmt.setString(3, vo.getName() );
			pstmt.setString(4, vo.getEmail() );
			pstmt.setString(5, vo.getGender() );
			
			pstmt.executeUpdate(); //성공시 1, 실패시 0
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	//로그인
	public int login(String id, String pw) {
		
		int result = 0;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				//???..
				
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
