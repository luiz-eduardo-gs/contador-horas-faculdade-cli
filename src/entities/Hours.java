package entities;

public class Hours {
	private String name;
	private Integer horasTotais;
	private Integer horasConcluidas;
	private Integer horasRestantes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHorasTotais() {
		return horasTotais;
	}
	public void setHorasTotais(Integer horasTotais) {
		this.horasTotais = horasTotais;
	}
	public Integer getHorasConcluidas() {
		return horasConcluidas;
	}
	public void setHorasConcluidas(Integer horasConcluidas) {
		this.horasConcluidas = horasConcluidas;
	}
	public Integer getHorasRestantes() {
		return horasRestantes;
	}
	public void setHorasRestantes(Integer horasRestantes) {
		this.horasRestantes = horasRestantes;
	}
	
	public int horasRestantes(int horasTotais, int horasConcluidas) {
		horasRestantes = horasTotais - horasConcluidas;
		return horasRestantes;
	}
}
