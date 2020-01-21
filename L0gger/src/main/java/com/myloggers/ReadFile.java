package com.myloggers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
	ReadFile rl;
	private static final Pattern lgrPattern = Pattern.compile("import\\s+org\\.apache\\.logging\\.log4j\\.Logger;");
	private static final Pattern lgMgrPattern = Pattern
			.compile("import\\s+org\\.apache\\.logging\\.log4j\\.LogManager;");
	private static final Pattern varPattern = Pattern
			.compile("^\\s*(private\\s+)?((final|static)\\s+)?((final|static)\\s+)?"
					+ "Logger\\s+([a-zA-Z]+)\\s*=\\s*LogManager\\.getLogger\\s*\\((.+?)\\).+$");
	private static final String String = null;
	private List<String> code = new ArrayList<>();
	private String inFile;

	private final String replacedLogger = "import org.slf4j.Loggerlogger;";
	private final String replacedLoggerFactory = "import org.slf4j.LoggerFactory;";
	private final String replacedVar = "    private Logger logger = LoggerFactory.getLogger({});";

	public ReadFile(String inFile) {
		this.inFile = inFile;
	}

	public void process(String path) throws IOException {
		// rl = new ReadFile("");
		String result = null;
		// open inFile for reading
		File f1 = new File(path);
		FileReader fr = new FileReader(f1);
		BufferedReader br1 = new BufferedReader(fr);
		// read file line by line
		String line = null;
		try {
			while ((line = br1.readLine()) != null)

			{
				if ((rl.lgrPattern.matcher(line).find()) && (rl.lgMgrPattern.matcher(line).find())) {
					String[] arsp = line.split(";");
					String l = replaceLogger(arsp[0] + ";");
					code.add(l);
					l = replaceLogManager(arsp[1] + ";");
					code.add(l);
				}

				else if (rl.lgrPattern.matcher(line).find())

				// replaceLogger()
				{
					String l = replaceLogger(line);
					code.add(l);

				} else if (rl.lgMgrPattern.matcher(line).find()) {
					// replaceLogManager()
					String l1 = replaceLogManager(line);
					code.add(l1);

				} else if (rl.varPattern.matcher(line).matches()) { // replaceVariable()
					result = replaceVariable(line);
					code.add(result);

				} else {
					code.add(line);

				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		fr.close();
		br1.close();

		PrintWriter pw = new PrintWriter(path);
		code.forEach(x -> {
			pw.println(x);

		});
		code.clear();
		pw.close();

	}

	private String replaceLogger(String line) {
		return lgrPattern.matcher(line).replaceAll(replacedLogger);
	}

	private String replaceLogManager(String line) {
		return lgMgrPattern.matcher(line).replaceAll(replacedLoggerFactory);
	}

	private String replaceVariable(String line) {
		Matcher matcher = varPattern.matcher(line);
		// if not matches
		if (!rl.varPattern.matcher(line).matches()) {
			return varPattern.matcher(line).toString();
		}
		// if matches
		if (rl.varPattern.matcher(line).matches())
		// find the group value for actual value inside getLogger
		{
			if (matcher.find()) {
				String ui = (matcher.group(7));

				String newval = replacedVar.replace("{}", ui);
				return varPattern.matcher(line).replaceAll(newval);

			}

		}
		return null;

	}

	public void readDir(String dirPath) throws Exception {
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			// String[] files = dir.list();
			
			File[] f = dir.listFiles();
			if (f.length == 0) {
				System.out.println("The directory is empty");
			} else {
				for (File aFile : f) {
					if(aFile.isDirectory()) {
						readDir(aFile.getAbsolutePath());
					}
					
					if (getFileExtension(aFile).equalsIgnoreCase("java"))
						process(aFile.getAbsolutePath());
				}
			}
		} else if (dir.isFile()) {
			process(dir.getAbsolutePath());
		}

	}

	private String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static void main(String[] args) throws Exception {

		ReadFile rl = new ReadFile("");
		rl.readDir("/home/harishg/Backup_Hg/newui");
		System.out.print("Done");
	}
}