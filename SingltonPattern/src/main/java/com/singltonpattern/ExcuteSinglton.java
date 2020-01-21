package com.singltonpattern;

import com.singltonpattern.multiplethreads.Thread1;
import com.singltonpattern.multiplethreads.Thread2;

public class ExcuteSinglton {
	
	public static void main(String str[]) {
		System.out.println(MySingltonPattern.getInstance("Thread4").value);
		System.out.println(MySingltonPattern.getInstance("Thread5").value);
		System.out.println(MySingltonPattern.getInstance("Thread6").value);
		Thread1  thread1 = new Thread1();
		System.out.println(MySingltonPattern.getInstance("Thread7").value);
		Thread2  thread2 = new Thread2();
		thread1.start();
		System.out.println(MySingltonPattern.getInstance("Thread8").value);
		thread2.start();
		System.out.println(MySingltonPattern.getInstance("Thread9").value);
		System.out.println(MySingltonPattern.getInstance("Thread10").value);
	}

}
