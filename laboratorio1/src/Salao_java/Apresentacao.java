package Salao_java;

import java.util.ArrayList;
import java.util.Scanner;

public class Apresentacao {
	public Cliente addCliente(Scanner input) {
		System.out.println("informe os dados do cliente: ");
		
		System.out.println("CPF: ");
		Cliente clt = new Cliente(input.next());
		
		System.out.println("Id: ");
		clt.setId(input.nextInt());
		
		System.out.println("Nome: ");
		clt.setNome(input.next());
		
		System.out.println("\n");
		
		return clt;
	}
	
	public ArrayList<Servico> addServico(Scanner input){
		ArrayList<Servico> aux = new ArrayList<Servico>();
		System.out.println("Informe os dados do(s) servico(s): ");
		String opc = "";
		do {
			Servico serv = new Servico();
			
			System.out.println("Nome: ");
			serv.setNome(input.next());
			
			System.out.println("Descricao: ");
			serv.setDescricao(input.next());
			
			System.out.println("Valor: ");
			serv.setValor(input.nextFloat());
			
			aux.add(serv);
			System.out.print("Digite sair para finalizar ");
			System.out.println("ou aperte qualquer tecla para adicionar um novo servico:");
			opc = input.next();
		}while (!(opc.equals("sair")));
		
		return aux;
	}
	
	public Atendimento dadosCarregadosDoTecladoAtendimento() {
		Scanner input = new Scanner(System.in);
		Cliente cliente = addCliente(input);
		Cabeleireiro cabeleireiro = addCabeleireiro(input);
		Atendimento attendance = new Atendimento(cliente, cabeleireiro);
		attendance.setListaServico(addServico(input));
		
		return attendance;
	}

	private Cabeleireiro addCabeleireiro(Scanner entrada) {

		System.out.println("Informe os dados do cabeleireiro: ");
		System.out.print("Nome: ");
		String nome = entrada.next();
		
		System.out.print("CPF: ");
		String cpf = entrada.next();
		Cabeleireiro cbl = new Cabeleireiro(nome, cpf);

		System.out.print("Id: ");
		cbl.setId(entrada.nextInt());

		return cbl;
	}

	public static void main(String[] args) {

		Apresentacao presentation = new Apresentacao();
		
		Scanner input = new Scanner(System.in);
		ArrayList<Atendimento> listaAtendimento = new ArrayList<Atendimento>();
		String opc = "";
		do {
			Atendimento attendence = presentation.dadosCarregadosDoTecladoAtendimento();
			
			listaAtendimento.add(attendence);
			System.out.print("Digite sair para finalizar ");
			System.out.println("ou aperte qualquer tecla para adicionar um novo atendimento:");
			opc = input.next();
		}while (!(opc.equals("sair")));
		
		for (Atendimento atendimento : listaAtendimento) {
			System.out.println(atendimento.imprimir());
		}

	}
}
