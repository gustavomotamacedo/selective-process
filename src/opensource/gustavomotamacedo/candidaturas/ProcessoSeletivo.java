package opensource.gustavomotamacedo.candidaturas;

public class ProcessoSeletivo {
	public static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido)
			System.out.println("Ligar para o candidato.");
		else if(salarioBase == salarioPretendido)
			System.out.println("Ligar para o candidato, com contraproposta.");
		else
			System.out.println("Aguardando demais candidatos ");
	}
	
	public static void main(String[] args) {
		analisarCandidato(2000.0);
		analisarCandidato(1900.0);
		analisarCandidato(1200.0);
	}
}
