package com.singltonpattern.multiplethreads;

import com.singltonpattern.MySingltonPattern;

public class Thread1 extends Thread {

	public void run() {
		MySingltonPattern instance = MySingltonPattern.getInstance("Thread1");
		System.out.print(instance.value);
		System.out.print(MySingltonPattern.getInstance("Thread12").value);
	}
}
