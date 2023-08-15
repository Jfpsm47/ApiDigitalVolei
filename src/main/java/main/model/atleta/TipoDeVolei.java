package main.model.atleta;

public enum TipoDeVolei {
	QUADRA("quadra"),PRAIA("praia"),AMBOS("ambos");
	
	private String tipoDeVole;

	private TipoDeVolei(String tipoDeVole) {
		this.tipoDeVole = tipoDeVole;
	}

	public String getTipoDeVole() {
		return tipoDeVole;
	}
}
