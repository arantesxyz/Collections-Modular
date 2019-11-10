
public class Monitor {
	private String nome, materia, horario;
	private int matricula;
	
	public Monitor() {
		this.nome = "Sem nome";
		this.materia = "//";
		this.horario = "00:00";
		this.matricula  = 0;
	}
	
	public Monitor(String nome, String materia, String horario, int matricula) {
		this.nome = nome;
		this.materia = materia;
		this.horario = horario;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMateria() {
		return materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String toString() {
        return "||  Monitor: " + nome + "|  Disciplina: " + materia + "|  Horário: " + horario+ "|  Matricula: "+matricula+" ||";
    }
	
	
}

