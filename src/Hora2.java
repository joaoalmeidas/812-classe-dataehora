
public class Hora2 {
	
	private int hora;
	private int minuto;
	private int segundo;
	
	public Hora2() {
		this(0, 0, 0);
	}
	
	public Hora2(int hora) {
		this(hora, 0, 0);
	}
	
	public Hora2(int hora, int minuto) {
		this(hora, minuto, 0);
	}
	
	public Hora2(int hora, int minuto, int segundo) {
		
		if(hora < 0 || hora >= 24) {
			
			throw new IllegalArgumentException("A hora precisa estar entre 0 e 23");
			
		}
		
		if(minuto < 0 || minuto >= 60) {
			
			throw new IllegalArgumentException("O minuto precisa estar entre 0 e 59");
		}
		
		if(segundo < 0 || segundo >= 60) {
			throw new IllegalArgumentException("O segundo precisa estar entre 0 e 59");
		}
		
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		
	}
	
	
	public Hora2(Hora2 hora) {
		this(hora.getHora(), hora.getMinuto(), hora.getSegundo());
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		
		if(hora < 0 || hora > 23) {
			throw new IllegalArgumentException("A hora precisa estar entre 0 e 23");
		}
		
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		
		if(minuto < 0 || minuto > 59) {
			throw new IllegalArgumentException("O minuto precisa estar entre 0 e 59");
		}
		
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		
		if(segundo < 0 || segundo > 59) {
			throw new IllegalArgumentException("O segundo precisa estar entre 0 e 59");
		}
		
		this.segundo = segundo;
	}
	
	public String paraFormatoUniversalString() {
		
		return String.format("%02d:%02d:%02d", getHora(), getMinuto(), getSegundo());
		
	}
	
	public String toString() {
		
		return String.format("%d:%02d:%02d %s", ((getHora() == 0 || getHora() == 12) ? 12 : getHora() % 12), getMinuto(), getSegundo(), (getHora() < 12 ? "AM" : "PM"));
		
	}
	
	public void tick() {
		if(getSegundo() == 59) {
			setSegundo(0);
			incrementaMinuto();
		}else {
			setSegundo(segundo+1);
		}
	}
	
	public void incrementaMinuto() {
		if(getMinuto() == 59) {
			setMinuto(0);
			incrementaHora();
		}else{
			setMinuto(minuto+1);
		}
		
	}
	
	public void incrementaHora() {
		if(getHora() == 23) {
			setHora(0);
		}else {
			setHora(hora+1);
		}
	}
	
	
	
}
