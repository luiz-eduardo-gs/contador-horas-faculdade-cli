package services;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import entities.Hours;

public class MenuService {
	
	
	public void printMenu(List<String> list, Hours hours, String path, int op, WriteFileService write, ReadFileService read, File file) {
		JOptionPane.showMessageDialog(null, "Bem vinda, amor");
		while(op != 5) {
			op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n"
					+ "[1] Ver mapa de horários completo\n"
					+ "[2] Modificar horas totais\n"
					+ "[3] Modificar horas concluídas\n"
					+ "[4] Deletar arquivo\n"
					+ "[5] Sair "));
			switch(op) {
				case 1:
					list.clear();
					list = read.readFile(path);
					String[] fields = new String[4];
					int i = 0;
					for(String obj : list) {
						fields[i] = obj;
						i++;
					}
					JOptionPane.showMessageDialog(null, fields[0] + "\n" + fields[1] + "\n" + fields[2] + "\n" + fields[3] + "\n");
					break;
				case 2:
					hours.setHorasTotais(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas totais?")));
					list.clear();
					list = read.readFile(path);
					write.newTotalHours(hours.getHorasTotais(), list, path);
					break;
				case 3:
					hours.setHorasConcluidas(Integer.parseInt(JOptionPane.showInputDialog(null,"Qual o novo valor de horas concluídas?")));
					list.clear();
					list = read.readFile(path);
					write.newFinishedHours(hours.getHorasConcluidas(), list, path);
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
