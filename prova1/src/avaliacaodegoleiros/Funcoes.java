package avaliacaodegoleiros;

import java.util.ArrayList;
import java.util.Random;

public class Funcoes {
	public void verificarResultadoChute(Selecao selecao) {
		Random rand = new Random();
		int[] atuacaoInicialGoleiro = new int[2];
		for (Goleiro goleiro : selecao.getListaGoleiros()) {
			int[] campoAtuacaoGoleiroX = new int[goleiro.getAAG()];
			int[] campoAtuacaoGoleiroY = new int[goleiro.getAAG()];
			
			for (Chute chute : goleiro.getListaChutes()) {
				if(chute.getX() > 1) {
					if(chute.getY() > 1 && chute.getY() < 15) {
						switch (chute.getQuadrante()) {
						case 1:
							atuacaoInicialGoleiro[0] = rand.nextInt(5);
							atuacaoInicialGoleiro[1] = rand.nextInt(9);
							break;
						case 2:
							atuacaoInicialGoleiro[0] = rand.nextInt(5);
							atuacaoInicialGoleiro[1] = rand.nextInt(9) + 8;
							break;
						case 3:
							atuacaoInicialGoleiro[0] = rand.nextInt(3) + 5;
							atuacaoInicialGoleiro[1] = rand.nextInt(8);
							break;
						case 4:
							atuacaoInicialGoleiro[0] = rand.nextInt(3) + 5;
							atuacaoInicialGoleiro[1] = rand.nextInt(9) + 8;
							break;
						default:
							break;
						}
						
						int j = 0;
						for (int i = 0; i < goleiro.getAAG(); i++) {
							campoAtuacaoGoleiroX[i] = atuacaoInicialGoleiro[0] - (i % 3); 
							campoAtuacaoGoleiroY[i] = atuacaoInicialGoleiro[1] + j;
							if(i % 2 == 0) {
								j++;
							}
						}
						
						for (int i = 0; i < campoAtuacaoGoleiroX.length; i++) {
							if(chute.getX() == campoAtuacaoGoleiroX[i] && chute.getY() == campoAtuacaoGoleiroY[i]) {
								if(goleiro.getForca() >= chute.getForca()) {
									goleiro.setDefesasSucedidas();
									chute.setFoiGol(false);
								}
								else {
									goleiro.setDefesasFalhas();
								}
							}
						}
					}
					else {
						chute.setFoiGol(false);
					}
				}
				else {
					chute.setFoiGol(false);
				}
			}
		}
	}
	
	public int[] relatorioChutesPerdidos(ArrayList<Chute> listaChute) {
		int chutesFora = 0;
		int chutesTraveDireita = 0;
		int chutesTraveEsquerda = 0;
		int chutesTraveSuperior = 0;
		int[] relatorio = new int[4];
		
		for (Chute chute : listaChute) {
			if(chute.getX() == 0) {
				chutesFora++;
			}
			if(chute.getY() == 0 && chute.getX() != 0) {
				chutesFora++;
			}
			if(chute.getY() == 16 && chute.getX() != 0) {
				chutesFora++;
			}
			if(chute.getX() == 1) {
				chutesTraveSuperior++;
			}
			if(chute.getY() == 1 && chute.getX() != 1) {
				chutesTraveEsquerda++;
			}
			if(chute.getY() == 15 && chute.getX() != 1) {
				chutesTraveDireita++;
			}
		}
		relatorio[0] = chutesFora;
		relatorio[1] = chutesTraveEsquerda;
		relatorio[2] = chutesTraveDireita;
		relatorio[3] = chutesTraveSuperior;
		
		return relatorio;
	}
	
	public int mediaDefesasSelecao(ArrayList<Goleiro> listaGoleiros) {
		int mediaDefesas = 0;
		
		for (Goleiro goleiro : listaGoleiros) {
			mediaDefesas += goleiro.getDefesasSucedidas();
		}
		mediaDefesas = mediaDefesas / listaGoleiros.size();
		
		return mediaDefesas;
	}
	
	public int mediaGolsSofridosSelecao(ArrayList<Goleiro> listaGoleiros) {
		int mediaGolsSofridos = 0;
		
		  for (Goleiro goleiro : listaGoleiros) {
			mediaGolsSofridos += goleiro.getGolsSofridos();
		}
		mediaGolsSofridos = mediaGolsSofridos / listaGoleiros.size();
		
		return mediaGolsSofridos;
	}
	
	public String verificarGoleiroTitular(ArrayList<Goleiro> listaGoleiro) {
		int aux = 0;
		String titular = "";
		
		for (Goleiro goleiro : listaGoleiro) {
			if(aux < goleiro.getDefesasSucedidas()) {
				aux = goleiro.getDefesasSucedidas();
				titular = goleiro.getNome();
			}
		}
		
		return titular;
	}
	
	public String[] melhoresGoleiros(ArrayList<Selecao> listaSelecao) {
		String[] selecaoMelhorGoleiro = new String[3];
		int aux1 = 0, aux2 = 0, aux3 = 0;
		
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				if(goleiro.getDefesasSucedidas() > aux1) {
					aux3 = aux2;
					selecaoMelhorGoleiro[2] = selecaoMelhorGoleiro[1];
					aux2 = aux1;
					selecaoMelhorGoleiro[1] = selecaoMelhorGoleiro[0];
					aux1 =  goleiro.getDefesasSucedidas();
					selecaoMelhorGoleiro[0] = selecao.getNome() + " com o goleiro " + goleiro.getNome();
				}
				else if (goleiro.getDefesasSucedidas() > aux2) {
					aux3 = aux2;
					selecaoMelhorGoleiro[2] = selecaoMelhorGoleiro[1];
					aux2 = goleiro.getDefesasSucedidas();
					selecaoMelhorGoleiro[1] = selecao.getNome() + " com o goleiro " + goleiro.getNome();
				}
				else if (goleiro.getDefesasSucedidas() > aux3) {
					aux3 = goleiro.getDefesasSucedidas();
					selecaoMelhorGoleiro[2] = selecao.getNome() + " com o goleiro " + goleiro.getNome();
				}
			}
		}
		return selecaoMelhorGoleiro;
	}
	
	public void relatorioGoleiro(ArrayList<Selecao> listaSelecao, int id) {
		
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				if(goleiro.getId() == id) {
					System.out.println("Relatório do goleiro informado: ");
					System.out.println("Nome: " + goleiro.getNome());
					System.out.println("Seleção: " + selecao.getNome());
					System.out.println("Gols defendidos: " + goleiro.getDefesasSucedidas());
					System.out.println("Gols sofridos: " + goleiro.getGolsSofridos());
					System.out.println("AAG: " + goleiro.getAAG());
				}
			}
		}
	}
	
public void quadranteComMaisGols(ArrayList<Selecao> listaSelecao, int id) {
		int[] golsPorQuadrante = new int[4];
		int quadranteComMaisGols = 0;
		String nomeGoleiro = "";
		for (Selecao selecao : listaSelecao) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				if(goleiro.getId() == id) {
					nomeGoleiro = goleiro.getNome();
					for (Chute chute : goleiro.getListaChutes()) {
						if(chute.isFoiGol() == true) {
							switch (chute.getQuadrante()) {
							case 1:
								golsPorQuadrante[0]++;
								break;
							case 2:
								golsPorQuadrante[1]++;
								break;
							case 3:
								golsPorQuadrante[2]++;
								break;
							case 4:
								golsPorQuadrante[3]++;
								break;
							default:
								break;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < golsPorQuadrante.length; i++) {
			if(golsPorQuadrante[i] > quadranteComMaisGols) {
				quadranteComMaisGols = i + 1;
			}
		}
		System.out.println("O goleiro " + nomeGoleiro + " tomou mais gols no quadrante: " + quadranteComMaisGols);
	}
}
