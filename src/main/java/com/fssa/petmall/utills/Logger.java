package com.fssa.petmall.utills;

public class Logger {
public static void error(Exception e) {
	e.printStackTrace();
}
public static void debug(Object e) {
	System.out.print(e);
}
}
