package com.iu.t1;

public class TestDAO {
	
	public void selectTest() {
		//4가지 정보
		//1. ID
		String username="";
		//2. PW
		String password = "tiger";
		//3. IP, PORT
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		//4. Driver class
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//driver를 메모리에 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
