package alf.api.sys;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.filechooser.FileSystemView;

public class fileSystem {

	public static List<String> sysDrives() {
		List<String> drivesList = new ArrayList<String>();

		FileSystemView fsv = FileSystemView.getFileSystemView();

		File[] drives = File.listRoots();
		if (drives != null && drives.length > 0) {
			for (File aDrive : drives) {
				if (fsv.getSystemTypeDescription(aDrive).contains("CD"))
					continue;
				drivesList.add(aDrive.toString());
			}
		}
		return drivesList;
	}

	public static Boolean createDirector(String path) {
		Boolean found = false;
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdir();
			return true;
		}
		return found;
	}

	public static Boolean createDirectors(String path) {
		Boolean found = false;
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
			return true;
		}
		return found;
	}

	public String getCurrentPathFile(String fileName) throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");

		fullPath = pathArr[0];
		String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + fileName;
		return reponsePath;
	}

	public static void WriteNote(String path, String content) {
		File file = new File(path);
		FileWriter fr = null;
		PrintWriter outPut = null;
		try {
			fr = new FileWriter(file, true);
			outPut = new PrintWriter(fr);
			outPut.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close resources
			try {
				fr.close();
				outPut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
