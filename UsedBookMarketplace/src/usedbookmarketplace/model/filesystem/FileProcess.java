package usedbookmarketplace.model.filesystem;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

import usedbookmarketplace.model.data.Book;
import usedbookmarketplace.model.data.user.GeneralUser;
import usedbookmarketplace.model.database.Database;

public class FileProcess {

	// read a bookDB file
	public Vector<Book> readBookFile(String fileName) {
		Vector<Book> bookList = new Vector<Book>();

		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {
				String line = scan.nextLine();

				if (!line.startsWith("//") && !line.isEmpty()) {
					String[] tokens = line.split(":");
					bookList.add(new Book(tokens));
				}
			}
			scan.close();

			return bookList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	// read an accountDB file
	public Vector<GeneralUser> readAccountFile(String fileName) {
		Vector<GeneralUser> accountList = new Vector<GeneralUser>();

		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {
				String line = scan.nextLine();

				if (!line.startsWith("//") && !line.isEmpty()) {
					String[] tokens = line.split(":");
					accountList.add(new GeneralUser(tokens));
				}
			}
			scan.close();

			return accountList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	// write all accounts to the file
	public void writeFile(Vector<GeneralUser> accountDB, String fileName) {
		try {
			File file = new File(fileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			if (file.isFile() && file.canWrite()) {

				for (int i = 0; i < accountDB.size() - 1; i++) {
					String[] userInfo = accountDB.get(i).getGeneralUserInfo();
					bw.write(userInfo[0] + ":" + userInfo[1] + ":" + userInfo[2] + ":" + userInfo[3] + ":" + userInfo[4]);
					if (i != accountDB.size())
						bw.newLine();
				}
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// write the added account to the file
	public void writeFile(String[] info, String fileName) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));

			pw.write("\n");
			for (int i = 0; i < info.length - 1; i++)
				pw.write(info[i] + ":");
			pw.write(info[info.length - 1]);

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}