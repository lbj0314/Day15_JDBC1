package com.iu.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	
	public void selectTest4(String ename) {
		//
	}
	
	public void selectTest3() {
		//emp 출력
		//부서별, 부서 번호, 급여 총합계, 급여 평균
		
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//연결 준비
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			//연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("LogIn Sueccessed");
			System.out.println("-------------------");
			
//			String sum = "SUM(sal)";
//			String avg = "AVG("
			
			//쿼리
			String sql = "SELECT deptno, SUM(sal) sum, AVG(NVL(sal,0)) avg\r\n" + 
					"FROM EMP\r\n" + 
					"GROUP BY deptno";
			//전송 준비
			st = con.createStatement();
			//전송 및 처리
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int deptno = rs.getInt("deptno");
				Double sumSal = rs.getDouble("sum");
				Double avgSal = rs.getDouble("avg");
				
				System.out.println(deptno);
				System.out.println(sumSal);
				System.out.println(avgSal);
				System.out.println("-------------------");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}//selectTest3
	
	
	public void selectTest2() {
		//emp table에 있는 것 출력
		//ename, sal, comm, job, deptno
		//id
		String user = "scott";
		//pw
		String password = "tiger";
		//ip, port
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		//driver class
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//연결 준비
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			//연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("LogIn Successed");
			System.out.println("-----------------");
			//쿼리 작성
			String sql = "SELECT * FROM emp";
			// sql 전송 준비
			st = con.createStatement();
			//sql 전송 및 처리
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				
				System.out.println(ename);
				System.out.println(sal);
				System.out.println(comm);
				System.out.println(job);
				System.out.println(deptno);
				System.out.println("-----------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//finally
		
	}//selectTest2
	
	public void selectTest() {
			//1. 4가지 정보
		//1) ID
		String user="scott";
		//2) PW
		String password = "tiger";
		//3) IP, PORT
		String url = "jdbc:oracle:thin:@211.238.142.20:1521:xe";
		//4) Driver class
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
			//2. driver를 메모리에 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 완료");
			//3. Connection 정보를 획득
			con = DriverManager.getConnection(url, user, password);
			System.out.println("로그인 및 접속 성공");
			//4. Query 작성
			String sql = "SELECT * FROM dept";
			//5. Query 전송 준비
			st = con.createStatement();
			//6. Query 전송 및 처리
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				System.out.println(num);
				System.out.println(dname);
				System.out.println(loc);
				System.out.println("-----------------");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//selectTest

}//main
