package com.singltonpattern.multiplethreads;

import com.singltonpattern.MySingltonPattern;

public class Thread2 extends Thread{
	
	public void run() {
		MySingltonPattern instance = MySingltonPattern.getInstance("Thread2");
		System.out.print(instance.value);
		System.out.print(MySingltonPattern.getInstance("Thread11").value);
		
	}

}
