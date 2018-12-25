import java.util.Calendar;

public class DataEHora {
	
	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private int minuto;
	private int segundo;
	
	private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DataEHora(int dia, int mes, int ano) {
		this(dia, mes, ano, 0, 0, 0);
	}
	
	public DataEHora(int dia, int mes, int ano, int hora) {
		this(dia, mes, ano, hora, 0, 0);
	}
	
	public DataEHora(int dia, int mes, int ano, int hora, int minuto) {
		this(dia, mes, ano, hora, minuto, 0);
	}
	
	public DataEHora(int dia, int mes, int ano, int hora, int minuto, int segundo) {
		
		if(hora < 0 || hora >= 24) {
			
			throw new IllegalArgumentException("A hora precisa estar entre 0 e 23");
			
		}
		
		if(minuto < 0 || minuto >= 60) {
			
			throw new IllegalArgumentException("O minuto precisa estar entre 0 e 59");
		}
		
		if(segundo < 0 || segundo >= 60) {
			throw new IllegalArgumentException("O segundo precisa estar entre 0 e 59");
		}
		
		if(mes <= 0 || mes > 12) {
			throw new IllegalArgumentException("mês (" +mes+ ") precisa estar entre 1 e 12.");
		}
		
		if(dia <= 0 || (dia > diasPorMes[mes] && !(mes == 22 && dia ==29))) {
			throw new IllegalArgumentException("dia (" +dia+ ") esta fora dos limies do mês indicado.");
		}
		
		if(mes == 2 && dia == 29 && !(ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0))) {
			throw new IllegalArgumentException("dia (" +dia+ ") esta fora dos limies do dia indicado.");
		}
		
		if(ano < 1900 || ano > Calendar.getInstance().get(Calendar.YEAR)) {
			throw new IllegalArgumentException("ano (" +ano+ ") esta fora dos limies do ano indicado."+Calendar.YEAR);
		}
		
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.mes = mes;
		this.dia = dia;
		this.ano = ano;
		
	}
	
	public DataEHora(DataEHora datahora) {
		
		this(datahora.getDia(), datahora.getMes(), datahora.getAno(), 
				datahora.getHora(), datahora.getMinuto(), datahora.getSegundo());
		
	}
	

	public int getDia() {
		return dia;
	}



	public void setDia(int dia) {
		this.dia = dia;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public static int[] getDiaspormes() {
		return diasPorMes;
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
		
		return String.format("%d/%d/%d\n%02d:%02d:%02d",getDia(), getMes(), getAno(), getHora(), getMinuto(), getSegundo());
		
	}
	
	public String toString() {
		
		return String.format("%d/%d/%d\n%d:%02d:%02d %s", getDia(), getMes(), getAno(), ((getHora() == 0 || getHora() == 12) ? 12 : getHora() % 12), getMinuto(), getSegundo(), (getHora() < 12 ? "AM" : "PM"));
		
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
			proximoDia();
		}else {
			setHora(hora+1);
		}
	}
	
	public void proximoDia() {
		
		System.out.printf("\n\nVirada do dia : %d/%d/%d para o dia ", getDia(), getMes(), getAno());
		
		if(getDia() == 28 && getMes() == 2 && (getAno() % 400 == 0 || (getAno() % 4 == 0 && getAno() % 100 != 0))) {
			
			setDia(getDia() + 1);
			
		}else if(getDia() == diasPorMes[mes] || getMes() == 2 && getDia() == 29) {
			
			setDia(1);
			
			if(getMes() == 12) {
				
				setMes(1);

				setAno(getAno() + 1);
				
			}else {
				
				setMes(getMes() + 1);
				
			}
			
		}else {
			
			setDia(getDia() + 1);
			
		}
		
		System.out.printf("%d/%d/%d\n\n", getDia(), getMes(), getAno());
		
	}

}
