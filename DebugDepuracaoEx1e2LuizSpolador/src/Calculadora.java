public class Calculadora {
	public float calcular(float a, float b, char operacao) {
		float resultado = 0;

		switch (operacao) {
			case '+': {
				resultado = a + b;
				break;
			}
			case '-': {
				if(a > b || a == b){
					resultado = a - b;
				} else if (b > a){
					float k = a;
					a = b;
					b = k;
					System.out.println("B era maior que A");
					resultado = a - b;
				}
				break;
			}
			case '/': {
				if(b != 0){
					resultado = a / b;
				} else{
					System.out.println("não podemos dividir por zero");
					break;
				}
				break;
			}
			case '*': {
				resultado = a * b;
				break;
			}
		}
		return resultado;
	}
}







