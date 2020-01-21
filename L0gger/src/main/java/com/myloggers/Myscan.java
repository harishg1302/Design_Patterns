package com.myloggers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Myscan {
	static List<String> list = new ArrayList();

	public static void main(String[] args) throws Exception {
		File f1 = new File("/home/harishg/Documents/entity/Account.java");
		FileReader fr = new FileReader(f1);
		BufferedReader br1 = new BufferedReader(fr);
		
		String line = null;
		try {
			while ((line = br1.readLine()) != null) {
				if(line.contains("@Table")) {
					String[] str = line.split("\"");
					System.out.print(str[1]);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
