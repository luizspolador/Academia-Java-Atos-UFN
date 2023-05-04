import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Principal {

	public static void main(String[] args) throws IOException {
		// Instanciando o Logger
		Log meuLog = new Log("Log.txt");
		try{
			meuLog.logger.setLevel(Level.FINE);
			meuLog.logger.info("Log de informação");
			meuLog.logger.warning("Log de aviso");
			meuLog.logger.severe("Log severo");
		} catch (Exception e){
			meuLog.logger.info("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		meuLog.logger.info("\n O programa iniciou a Calculadora!");

		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			if (operador.contains("-")){
				if(b > a){
					float k = a;
					a = b;
					b = k;
				}
			}

			System.out.println("O resultado de " + a + " " + operador + " " + b + " é: " + resultado);

			System.out.printf("\n");

			//Mensagens escritas no Log
			meuLog.logger.info("\n O programa terminou as operações da calculadora com Resultado igual a "+resultado);
		}

	}

}
