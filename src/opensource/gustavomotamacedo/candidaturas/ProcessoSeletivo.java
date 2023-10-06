package opensource.gustavomotamacedo.candidaturas;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	public static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido)
			System.out.println("Ligar para o candidato.");
		else if(salarioBase == salarioPretendido)
			System.out.println("Ligar para o candidato, com contraproposta.");
		else
			System.out.println("Aguardando demais candidatos ");
	}
	
	public static void imprimirSelecionados(String [] selecionados) {
		String [] candidatos = selecionados;
		System.out.println("Imprimindo lista de candidatos, informando o índicie.");
		for (int i = 0; i < candidatos.length; i++) {
			System.out.println("Candidato de número " + (i + 1) + " é: " + candidatos[i]);
		}
		System.out.println("Imprimindo lista de candidatos, de forma abreviada.");
		for (String candidato : candidatos) {
			System.out.println("Candidato selecionado é: " + candidato);
		}
	}
	
	public static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	public static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato realizado com sucesso.");
		}while(continuarTentando && tentativasRealizadas <= 3);
		if (atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "ª tentativa.");
		}else {
			System.out.println("O candidato " + candidato + " não atendeu.");
		}
	}
	
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "GUSTAVO", "JÕAO", "NATHAN", "NAIANDRA", "VITOR", "RICARDO", "MARCUS", "HUDSON", "MATHEUS"};
		String [] selecionados = new String[5];
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato " + candidato + " solicitou R$" + salarioPretendido + ".");
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
				selecionados[candidatosSelecionados] = candidato;
				++candidatosSelecionados;
			}
			candidatoAtual++;
		}
		imprimirSelecionados(selecionados);
		for (String candidato : selecionados) {
			System.out.println("Ligando para " + candidato + ".");
			entrandoEmContato(candidato);
		}
	}
}
