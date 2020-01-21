package com.abstractfactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestMessage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		String EQUALs = "=";
		try {
			fis = new FileInputStream(new File("/home/harishg/Pictures/messages_en.properties"));
			Set<String> set = new TreeSet<String>();
			Map<String, Integer> map = new TreeMap<String, Integer>();

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String strLine;
			String keyValuePair[] = null;
			System.out.println("Unparsed or commented Lines:");
			while ((strLine = br.readLine()) != null) {
				if (!strLine.contains("==")) {
					if (strLine.contains(EQUALs)) {
						keyValuePair = strLine.split(EQUALs);
						String key = keyValuePair[0];

						if (!set.add(key)) {
							// System.out.println(key);
							if (map.containsKey(key)) {
								map.put(key, map.get(key).intValue() + 1);
							} else {
								map.put(key, 2);
							}
						}

					} else {
					}
				}
			}

			System.out.println("Print duplicate entry with duplication count:");
			map.forEach((x,y)->{
				System.out.println(x+"="+y);
			});

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				// do nothing
			}
		}

	}

}
