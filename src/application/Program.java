package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Hours;

public class Program {

	public static void main(String[] args) {
		Hours hours = new Hours();
		String path = "c:\\Users\\Public\\Documents\\horas.txt";
		File file = new File(path);
		
		if(!file.exists()) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				hours.setName(JOptionPane.showInputDialog(null,"Insira seu nome completo"));
				bw.write(hours.getName());
				bw.newLine();
				bw.write("HORAS TOTAIS: ");
				hours.setHorasTotais(Integer.parseInt(JOptionPane.showInputDialog(null,"Insira a quantidade de horas totais")));
				bw.write(hours.getHorasTotais().toString());
				bw.newLine();
				hours.setHorasConcluidas(Integer.parseInt(JOptionPane.showInputDialog(null,"Insira a quantidade de horas concluídas")));
				bw.write("HORAS CONCLUIDAS: ");
				bw.write(hours.getHorasConcluidas().toString());
				bw.newLine();
				bw.write("HORAS RESTANTES: " + hours.horasRestantes(hours.getHorasTotais(), hours.getHorasConcluidas()));
			}
			catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Error creating new archive: " + e.getMessage());
			}
			String[] fields = new String[4];
			JOptionPane.showMessageDialog(null, "Bem vinda, amor");
			int op = 0;
			while(op != 5) {
				op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n"
						+ "[1] Ver mapa de horários completo\n"
						+ "[2] Modificar horas totais\n"
						+ "[3] Modificar horas concluídas\n"
						+ "[4] Deletar arquivo\n"
						+ "[5] Sair "));
				switch(op) {
					case 1:
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
							JOptionPane.showMessageDialog(null, fields[0] + "\n" + fields[1] + "\n" +fields[2] + "\n" + fields[3] + "\n" );
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						break;
					case 2:
						hours.setHorasTotais(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas totais?")));
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						
						try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
							b.write(fields[0]);
							b.newLine();
							b.write("HORAS TOTAIS: ");
							b.write(hours.getHorasTotais().toString());
							b.newLine();
							b.write(fields[2]);
							b.newLine();
							String[] teste2 = fields[2].split(": ");
							b.write("HORAS RESTANTES: " + hours.horasRestantes(hours.getHorasTotais(),Integer.parseInt(teste2[1])));
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
						}
						break;
					case 3:
						hours.setHorasConcluidas(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas concluídas?")));
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						
						try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
							b.write(fields[0]);
							b.newLine();
							b.write(fields[1]);
							b.newLine();
							b.write("HORAS CONCLUIDAS: ");
							b.write(hours.getHorasConcluidas().toString());
							b.newLine();
							String[] teste2 = fields[1].split(": ");
							b.write("HORAS RESTANTES: " + hours.horasRestantes(Integer.parseInt(teste2[1]),hours.getHorasConcluidas()));
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
						}
						break;
					case 4:
						file.delete();
						System.exit(0);
						break;
					default: 
						break;	
				}
			}
		}else {
			String[] fields = new String[4];
			JOptionPane.showMessageDialog(null, "Bem vinda, amor");
			int op = 0;
			while(op != 5) {
				op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n"
						+ "[1] Ver mapa de horários completo\n"
						+ "[2] Modificar horas totais\n"
						+ "[3] Modificar horas concluídas\n"
						+ "[4] Deletar arquivo\n"
						+ "[5] Sair "));
				switch(op) {
					case 1:
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
							JOptionPane.showMessageDialog(null, fields[0] + "\n" + fields[1] + "\n" +fields[2] + "\n" + fields[3] + "\n" );
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						break;
					case 2:
						hours.setHorasTotais(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas totais?")));
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						
						try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
							b.write(fields[0]);
							b.newLine();
							b.write("HORAS TOTAIS: ");
							b.write(hours.getHorasTotais().toString());
							b.newLine();
							b.write(fields[2]);
							b.newLine();
							String[] teste2 = fields[2].split(": ");
							b.write("HORAS RESTANTES: " + hours.horasRestantes(hours.getHorasTotais(),Integer.parseInt(teste2[1])));
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
						}
						break;
					case 3:
						hours.setHorasConcluidas(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas concluídas?")));
						try(BufferedReader br = new BufferedReader(new FileReader(path))){
							fields[0] = br.readLine();
							for(int i=1;i<fields.length;i++) {
								fields[i] = br.readLine();
							}
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error reading archive: " + e.getMessage());
						}
						
						try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
							b.write(fields[0]);
							b.newLine();
							b.write(fields[1]);
							b.newLine();
							b.write("HORAS CONCLUIDAS: ");
							b.write(hours.getHorasConcluidas().toString());
							b.newLine();
							String[] teste2 = fields[1].split(": ");
							b.write("HORAS RESTANTES: " + hours.horasRestantes(Integer.parseInt(teste2[1]),hours.getHorasConcluidas()));
						}
						catch(IOException e) {
							JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
						}
						break;
					case 4:
						file.delete();
						System.exit(0);
						break;
					default: 
						break;	
				}
			}
			
		}
		
		
	}
}
