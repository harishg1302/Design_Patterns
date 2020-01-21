package com.myloggers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class BuildSingleList {
	
	static Set<String> set = new HashSet();

	public static void main(String[] args) throws Exception {
		File f1 = new File("/home/harishg/Documents/entitylist.txt");
		FileReader fr = new FileReader(f1);
		BufferedReader br1 = new BufferedReader(fr);
		String line = null;
		while ((line = br1.readLine()) != null) {
			set.add(line);
			}
		f1 = new File("/home/harishg/Documents/entitylist_basecomponent.txt");
		fr = new FileReader(f1);
		br1 = new BufferedReader(fr);
		while ((line = br1.readLine()) != null) {
			set.add(line);
			}
		
		FileWriter fw = new FileWriter("/home/harishg/Documents/entitylist_Final.txt");
		PrintWriter pw = new PrintWriter(fw);
		set.forEach(x->{
			pw.println(x);
		}
			);

		pw.close();
		System.out.println("Done");
		
		
		}
	}

