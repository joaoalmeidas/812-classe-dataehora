import java.util.Calendar;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Data(int dia, int mes, int ano) {
		
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
		
		
		this.mes = mes;
		this.dia = dia;
		this.ano = ano;
		
		
		
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



	public String toString() {
		return String.format("%d/%d/%d", dia, mes, ano);
	}
	
	public void proximoDia() {
		
		System.out.println(toString());
		
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
		
	}
}
