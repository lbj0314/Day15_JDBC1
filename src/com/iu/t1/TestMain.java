package com.iu.t1;

public class TestMain {

	public static void main(String[] args) {
		TestDAO testDAO = new TestDAO();
		testDAO.selectTest();
//		testDAO.selectTest2();
//		testDAO.selectTest3();
		testDAO.selectTest4("SMITH");
	}

}
