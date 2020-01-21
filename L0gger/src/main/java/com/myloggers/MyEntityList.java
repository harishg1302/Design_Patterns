package com.myloggers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyEntityList {

	List<String> list = new ArrayList();

	private void process(String path) throws Exception {
		File f1 = new File(path);
		FileReader fr = new FileReader(f1);
		BufferedReader br1 = new BufferedReader(fr);

		String line = null;
		try {
			while ((line = br1.readLine()) != null) {
				if (line.contains("@Table")) {
					String[] str = line.split("\"");
					list.add(str[1]);
					break;
				}
				else if (line.contains("public class")) {
					String[] str = line.split(" ");
					System.out.println(f1);
					list.add(str[2]);
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readDir(String dirPath) throws Exception {
		File dir = new File(dirPath);

		File[] f = dir.listFiles();
		for (File aFile : f) {
			process(aFile.getAbsolutePath());
		}
		FileWriter fw = new FileWriter("/home/harishg/Documents/entitylist_basecomponent.txt");
		PrintWriter pw = new PrintWriter(fw);
		list.forEach(x->{
			pw.println(x);
		}
			);

		pw.close();
		System.out.println("Done");
	}
		
	public static void main(String[] args) throws Exception {
		MyEntityList rl = new MyEntityList();
		rl.readDir("/home/harishg/Documents/entity/entity");
	}

}
