package avaliacaodegoleiros;

import java.util.ArrayList;
import java.util.Scanner;

public class Apresentacao {
	public void organizar() {
		System.out.println();
		System.out.println();
		System.out.println("======================================================================");
		System.out.println("======================================================================");
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		Apresentacao presentation = new Apresentacao();
		Funcoes function = new Funcoes();
		Scanner input = new Scanner(System.in);
		ArrayList<Selecao> listaSelecao = new ArrayList<Selecao>();
		String[] melhoresGoleiros = new String[3];
		String opc = "";
		int[] chutesPerdidos = new int[4];
		int quantChutesPerdidos = 0;
		int golsAngulo = 0;
		
		Goleiro goleiro1 = new Goleiro(1, "Pratik Skaggs");
		goleiro1.setStats(5, 7, 8, 9, 6, 6);
		Goleiro goleiro2 = new Goleiro(2, "Uehudah Hack");
		goleiro2.setStats(9, 6, 8, 8, 7, 10);
		Goleiro goleiro3 = new Goleiro(3, "Edison Drye");
		goleiro3.setStats(5, 8, 5, 8, 10, 7);
		Goleiro goleiro4 = new Goleiro(4, "Ajani Harding");
		goleiro4.setStats(6, 6, 5, 8, 7, 6);
		Goleiro goleiro5 = new Goleiro(5, "Orazio Hart");
		goleiro5.setStats(5, 8, 7, 9, 9, 10);
		
		Selecao selecao1 = new Selecao(1, "Primeira");
		selecao1.addGoleiro(goleiro1);
		selecao1.addGoleiro(goleiro2);
		selecao1.addGoleiro(goleiro3);
		selecao1.addGoleiro(goleiro4);
		selecao1.addGoleiro(goleiro5);
		
		Goleiro goleiro6 = new Goleiro(6, "Tristan Karns");
		goleiro6.setStats(9, 7, 10, 7, 7, 6);
		Goleiro goleiro7 = new Goleiro(7, "Niven Glaser");
		goleiro7.setStats(10, 9, 7, 6, 5, 8);
		Goleiro goleiro8 = new Goleiro(8, "Derwyn Devers");
		goleiro8.setStats(10, 7, 9, 5, 9, 5);
		Goleiro goleiro9 = new Goleiro(9, "Tod Phan");
		goleiro9.setStats(10, 7, 7, 5, 5, 6);
		Goleiro goleiro10 = new Goleiro(10, "Eddie Hulse");
		goleiro10.setStats(7, 6, 5, 9, 7, 5);
		
		Selecao selecao2 = new Selecao(1, "Segunda");
		selecao2.addGoleiro(goleiro6);
		selecao2.addGoleiro(goleiro7);
		selecao2.addGoleiro(goleiro8);
		selecao2.addGoleiro(goleiro9);
		selecao2.addGoleiro(goleiro10);
		
		Goleiro goleiro11 = new Goleiro(11, "Welford Yepez");
		goleiro11.setStats(5, 8, 8, 7, 7, 8);
		Goleiro goleiro12 = new Goleiro(12, "Rishley Snyder");
		goleiro12.setStats(6, 5, 6, 5, 7, 6);
		Goleiro goleiro13 = new Goleiro(13, "Milo Mccurdy");
		goleiro13.setStats(10, 9, 8, 6, 10, 9);
		Goleiro goleiro14 = new Goleiro(14, "Carden Justus");
		goleiro14.setStats(8, 5, 8, 5, 10, 7);
		Goleiro goleiro15 = new Goleiro(15, "Carlyon Gorby");
		goleiro15.setStats(8, 5, 8, 8, 8, 6);
		
		Selecao selecao3 = new Selecao(3, "Terceira");
		selecao3.addGoleiro(goleiro11);
		selecao3.addGoleiro(goleiro12);
		selecao3.addGoleiro(goleiro13);
		selecao3.addGoleiro(goleiro14);
		selecao3.addGoleiro(goleiro15);
		
		Goleiro goleiro16 = new Goleiro(16, "Mungo Spangler");
		goleiro16.setStats(8, 10, 9, 8, 9, 5);
		Goleiro goleiro17 = new Goleiro(17, "Whitmore Squires");
		goleiro17.setStats(9, 10, 7, 9, 9, 10);
		Goleiro goleiro18 = new Goleiro(18, "Pedrog Mccurdy");
		goleiro18.setStats(8, 5, 10, 5, 7, 7);
		Goleiro goleiro19 = new Goleiro(19, "Ridgley Leo");
		goleiro19.setStats(8, 8, 8, 9, 9, 9);
		Goleiro goleiro20 = new Goleiro(20, "Bolton Tarin");
		goleiro20.setStats(9, 8, 7, 6, 9, 10);
		
		Selecao selecao4 = new Selecao(4, "Quarta");
		selecao4.addGoleiro(goleiro16);
		selecao4.addGoleiro(goleiro17);
		selecao4.addGoleiro(goleiro18);
		selecao4.addGoleiro(goleiro19);
		selecao4.addGoleiro(goleiro20);
		
		Goleiro goleiro21 = new Goleiro(21, "Edison Loy");
		goleiro21.setStats(7, 7, 5, 10, 10, 7);
		Goleiro goleiro22 = new Goleiro(22, "Delling Herndon");
		goleiro22.setStats(7, 5, 5, 8, 9, 9);
		Goleiro goleiro23 = new Goleiro(23, "Senichi Iorio");
		goleiro23.setStats(7, 7, 5, 8, 10, 5);
		Goleiro goleiro24 = new Goleiro(24, "Albin Kerner");
		goleiro24.setStats(6, 7, 8, 8, 9, 9);
		Goleiro goleiro25 = new Goleiro(25, "Jivin Justus");
		goleiro25.setStats(9, 10, 8, 7, 7, 5);
		
		Selecao selecao5 = new Selecao(5, "Quinta");
		selecao5.addGoleiro(goleiro21);
		selecao5.addGoleiro(goleiro22);
		selecao5.addGoleiro(goleiro23);
		selecao5.addGoleiro(goleiro24);
		selecao5.addGoleiro(goleiro25);
		
		listaSelecao.add(selecao1);
		listaSelecao.add(selecao2);
		listaSelecao.add(selecao3);
		listaSelecao.add(selecao4);
		listaSelecao.add(selecao5);
		
		Chute chute1 = new Chute(1);
		chute1.setInfoChute(2, 1, 4, 7);
		Chute chute2 = new Chute(2);
		chute2.setInfoChute(6, 1, 3, 6);
		Chute chute3 = new Chute(3);
		chute3.setInfoChute(9, 2, 4, 15);
		Chute chute4 = new Chute(4);
		chute4.setInfoChute(5, 4, 6, 11);
		Chute chute5 = new Chute(5);
		chute5.setInfoChute(3, 4, 8, 13);
		Chute chute6 = new Chute(6);
		chute6.setInfoChute(3, 3, 6, 4);
		Chute chute7 = new Chute(7);
		chute7.setInfoChute(4, 4, 5, 8);
		Chute chute8 = new Chute(8);
		chute8.setInfoChute(7, 4, 7, 14);
		Chute chute9 = new Chute(9);
		chute9.setInfoChute(8, 4, 7, 14);
		Chute chute10 = new Chute(10);
		chute10.setInfoChute(4, 4, 6, 12);
		Chute chute11 = new Chute(11);
		chute11.setInfoChute(2, 4, 5, 15);
		Chute chute12 = new Chute(12);
		chute12.setInfoChute(7, 3, 6, 4);
		Chute chute13 = new Chute(13);
		chute13.setInfoChute(3, 3, 8, 2);
		Chute chute14 = new Chute(14);
		chute14.setInfoChute(9, 4, 7, 10);
		Chute chute15 = new Chute(15);
		chute15.setInfoChute(10, 4, 7, 12);
		Chute chute16 = new Chute(16);
		chute16.setInfoChute(5, 1, 4, 2);
		Chute chute17 = new Chute(17);
		chute17.setInfoChute(3, 4, 5, 13);
		Chute chute18 = new Chute(18);
		chute18.setInfoChute(10, 2, 4, 16);
		Chute chute19 = new Chute(19);
		chute19.setInfoChute(10, 4, 5, 16);
		Chute chute20 = new Chute(20);
		chute20.setInfoChute(10, 2, 3, 14);
		Chute chute21 = new Chute(21);
		chute21.setInfoChute(9, 2, 1, 8);
		Chute chute22 = new Chute(22);
		chute22.setInfoChute(4, 4, 8, 16);
		Chute chute23 = new Chute(23);
		chute23.setInfoChute(8, 4, 6, 14);
		Chute chute24 = new Chute(24);
		chute24.setInfoChute(7, 4, 7, 11);
		Chute chute25 = new Chute(25);
		chute25.setInfoChute(6, 1, 0, 3);
		Chute chute26 = new Chute(26);
		chute26.setInfoChute(5, 3, 6, 7);
		Chute chute27 = new Chute(27);
		chute27.setInfoChute(3, 3, 8, 4);
		Chute chute28 = new Chute(28);
		chute28.setInfoChute(4, 3, 6, 7);
		Chute chute29 = new Chute(29);
		chute29.setInfoChute(10, 2, 2, 13);
		Chute chute30 = new Chute(30);
		chute30.setInfoChute(7, 3, 5, 3);
		
		ArrayList<Chute> listaChutes = new ArrayList<Chute>();
		listaChutes.add(chute1);
		listaChutes.add(chute2);
		listaChutes.add(chute3);
		listaChutes.add(chute4);
		listaChutes.add(chute5);
		listaChutes.add(chute6);
		listaChutes.add(chute7);
		listaChutes.add(chute8);
		listaChutes.add(chute9);
		listaChutes.add(chute10);
		listaChutes.add(chute11);
		listaChutes.add(chute12);
		listaChutes.add(chute13);
		listaChutes.add(chute14);
		listaChutes.add(chute15);
		listaChutes.add(chute16);
		listaChutes.add(chute17);
		listaChutes.add(chute18);
		listaChutes.add(chute19);
		listaChutes.add(chute20);
		listaChutes.add(chute21);
		listaChutes.add(chute22);
		listaChutes.add(chute23);
		listaChutes.add(chute24);
		listaChutes.add(chute25);
		listaChutes.add(chute26);
		listaChutes.add(chute27);
		listaChutes.add(chute28);
		listaChutes.add(chute29);
		listaChutes.add(chute30);
		
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				goleiro.setListaChutes(listaChutes);
			}
		}
		
		chutesPerdidos = function.relatorioChutesPerdidos(listaChutes);
		for (int i = 0; i < chutesPerdidos.length; i++) {
			quantChutesPerdidos += chutesPerdidos[i];
		}
		
		for (Selecao selecao : listaSelecao) {
			function.verificarResultadoChute(selecao);
		}

		System.out.println("================== SISTEMA DE AVALIAÇÃO DE GOLEIROS ==================");
		System.out.println("======================== Relatório Completo ==========================");
		System.out.println();
		System.out.println();
		
		//Questão 1
		for (Selecao selecao : listaSelecao) {
			int mediaDefesas = 0;
			mediaDefesas = function.mediaDefesasSelecao(selecao.getListaGoleiros());
			System.out.print("Média de defesas da seleção " + selecao.getNome() + ": ");
			System.out.println(mediaDefesas);
		}
		
		presentation.organizar();
		
		//Questão 2
		for (Selecao selecao : listaSelecao) {
			String goleiroTitular = "";
			goleiroTitular = function.verificarGoleiroTitular(selecao.getListaGoleiros());
			System.out.print("Melhor opção para goleiro titular da seleção " + selecao.getNome() + ": ");
			System.out.println(goleiroTitular);
		}
		
		presentation.organizar();
		
		//Questão 3
		for (Selecao selecao : listaSelecao) {
			int mediaGolsSofridos = 0;
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				goleiro.setGolsSofridos(goleiro.getListaChutes().size() - (goleiro.getDefesasSucedidas() + quantChutesPerdidos));
				
			}
			mediaGolsSofridos = function.mediaGolsSofridosSelecao(selecao.getListaGoleiros());
			System.out.print("Média de gols sofridos da seleção " + selecao.getNome() + ": ");
			System.out.println(mediaGolsSofridos);
		}
		
		presentation.organizar();
		
		//Questão 4
		for (int i = 0; i < chutesPerdidos.length; i++) {
			switch (i) {
			case 0:
				System.out.print("Quantidadede chutes fora: ");
				System.out.println(chutesPerdidos[i]);
				break;
			case 1:
				System.out.print("Quantidadede chutes na trave esquerda: ");
				System.out.println(chutesPerdidos[i]);
				break;
			case 2:
				System.out.print("Quantidadede chutes na trave direita: ");
				System.out.println(chutesPerdidos[i]);
				break;
			case 3:
				System.out.print("Quantidadede chutes na trave superior: ");
				System.out.println(chutesPerdidos[i]);
				break;
			default:
				break;
			}
		}
		
		presentation.organizar();
		
		//Questão 5
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				for (Chute chute : goleiro.getListaChutes()) {
					if(chute.isFoiGol() == true) {
						if(chute.getX() == 2 && chute.getY() == 2) {
							golsAngulo++;
						}
						if(chute.getX() == 2 && chute.getY() == 15) {
							golsAngulo++;
						}
					}
				}
				System.out.print("Gols no ângulo feitos no goleiro " + goleiro.getNome() + ": ");
				System.out.println(golsAngulo);
			}
		}
		
		presentation.organizar();
		
		//Questão 6
		melhoresGoleiros = function.melhoresGoleiros(listaSelecao);
		System.out.println("Seleções com os três melhores goleiros: ");
		for (String string : melhoresGoleiros) {
			System.out.println(string);
		}
		
		presentation.organizar();
		
		//Questão 7
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				System.out.println("Defesas falhas do goleiro " + goleiro.getNome() + " " + goleiro.getDefesasFalhas());
			}
		}
		
		presentation.organizar();
		
		//Questão 8
		do {
			System.out.println("Informe o id do goleiro no qual você deseja ver o relatório: ");
			int id = input.nextInt();
			function.relatorioGoleiro(listaSelecao, id);
			System.out.println("Digite sair para finalizar ou aperte qualquer tecla para visualizar outro relatório:");
			opc = input.next();
		} while (!(opc.equals("sair")));
		
		presentation.organizar();
		
		//Questão 9
		do {
			System.out.println("Informe o id do goleiro no qual você deseja ver a informação: ");
			int id = input.nextInt();
			function.quadranteComMaisGols(listaSelecao, id);
			System.out.println("Digite sair para finalizar ou aperte qualquer tecla para visualizar a informação de outro goleiro:");
			opc = input.next();
		} while (!(opc.equals("sair")));
	}

}