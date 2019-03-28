package application;

import java.io.File;
import java.util.List;

import entities.Hours;
import services.MenuService;
import services.ReadFileService;
import services.WriteFileService;

public class Program {

	public static void main(String[] args) {
		Hours hours = new Hours();
		WriteFileService write = new WriteFileService();
		ReadFileService read = new ReadFileService();
		String path = "c:\\Users\\Public\\Documents\\horas.txt";
		File file = new File(path);
		int op = 0;
		MenuService menu = new MenuService();
		
		if(!file.exists()) {
			write.newFile(path);
			List<String> list = read.readFile(path);
			menu.printMenu(list, hours, path, op, write, read, file);
			
		}else {
			List<String> list = read.readFile(path);
			menu.printMenu(list, hours, path, op, write, read, file);
			
		}
		
		
	}
}
