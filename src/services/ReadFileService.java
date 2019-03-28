package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ReadFileService {
	List<String> list = new ArrayList<>();
	
	
	public List<String> readFile(String path) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			list.add(br.readLine());
			for(int i=1;i<4;i++) {
				list.add(br.readLine());
			}
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
		}
		
		return list;
	}
}
