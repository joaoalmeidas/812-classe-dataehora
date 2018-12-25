
public class DataEHoraTeste {

	public static void main(String[] args) {
		
		DataEHora data = new DataEHora(25, 12, 2018, 23, 59, 0);
		
		System.out.printf("Data e Hora inicial do teste:\n%s\n", data.toString());
		
		
		for(int i = 0; i < 61; i++) {
			
			System.out.println(data.toString());
			
			data.tick();
		}

	}

}
