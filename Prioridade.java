import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Prioridade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, entrada, tempoAtual, execucao, idProcessoAtual, qteProcessos;
		ArrayList entrada_1, burst, prioridades, processos, cpEntrada;
		int[] temposFinais, temposIniciais;
		String ordemExecucao;
		int contTeste = 0;
		String formato, saida;
		DecimalFormat decimal = new DecimalFormat("0.00");

		System.out.println("quantos processadores deseja armazenar?");
		n = scanner.nextInt();
               
		while(n!= 0) {
			contTeste++;
                        processos = new ArrayList();
                        entrada_1 = new ArrayList();
                        burst = new ArrayList();
                        prioridades = new ArrayList();
			
                for(int i = 0; i < n; i++ ) {
			System.out.println("Entrada do processo p" + (i + 1));
                        entrada = scanner.nextInt();
                        entrada_1.add(entrada);
                        System.out.println("Qual o burst de p" + (i +1));
                        entrada = scanner.nextInt();
                        burst.add(entrada);
                        System.out.println("Qual a prioridade de p" + (i +1));
                        entrada =scanner.nextInt();
                        prioridades.add(entrada);
			
            }
			temposIniciais = new int[n];
			temposFinais = new int[n];
			cpEntrada = (ArrayList) entrada_1.clone();
			ordemExecucao = "";
			tempoAtual = (int) entrada_1.get(0);
			qteProcessos = n;
			
			while(qteProcessos > 0) {
			processos = new ArrayList(0);
			for (int i =0; i< n;i++) {
			if((int)entrada_1.get(i) != -1 && (int)entrada_1.get(i)<=tempoAtual) {
			processos.add(i);
			}
			}
				
			if(processos.isEmpty()) {
			tempoAtual++;
			}else {
			execucao = (int) processos.get(0);
			for (int i = 0; i < processos.size(); i++) {
			idProcessoAtual = (int)processos.get(i);
			if ((int)prioridades.get(idProcessoAtual) < (int)prioridades.get(execucao)) {
			execucao = (int)processos.get(i);
								
						
			}
			}
			temposIniciais[execucao] = tempoAtual;
			tempoAtual +=(int) burst.get(execucao);
			temposFinais[execucao] = tempoAtual;
			entrada_1.set(execucao, -1);
			ordemExecucao +="p" + (execucao + 1) + " ";
			qteProcessos--;		
			}
				
	}

}
