package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Hours;

public class WriteFileService {
	Hours hours = new Hours();
	
	
	
	
	public void newFile(String path) {
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
	}
	
	public void newTotalHours(Integer horasTotais, List<String> list, String path) {
		String[] split;
		try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
			b.write(list.get(0));
			b.newLine();
			b.write("HORAS TOTAIS: ");
			b.write(horasTotais.toString());
			b.newLine();
			b.write(list.get(2));
			b.newLine();
			split = list.get(2).split(": ");
			b.write("HORAS RESTANTES: " + hours.horasRestantes(horasTotais,Integer.parseInt(split[1])));
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
		}
	}
	
	public void newFinishedHours(Integer horasConcluidas, List<String> list, String path) {
		String[] split;
		try(BufferedWriter b = new BufferedWriter(new FileWriter(path))){
			b.write(list.get(0));
			b.newLine();
			b.write(list.get(1));
			b.newLine();
			b.write("HORAS CONCLUIDAS: ");
			b.write(horasConcluidas.toString());
			b.newLine();
			split = list.get(1).split(": ");
			b.write("HORAS RESTANTES: " + hours.horasRestantes(Integer.parseInt(split[1]),horasConcluidas));
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error writting archive: " + e.getMessage());
		}
	}
}
