package enums;

public enum Sports {
	NATACAO("Natacao"),
	FUTEBOL("Futebol"),
	CORRIDA("Corrida"),
	KARATE("Karate"),
	O_QUE_E_ESPORTE("O que eh esporte?");

	private String nome;

	Sports(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
