package Salao_java;

import java.util.ArrayList;
import java.util.Calendar;

public class Atendimento {
	private Cliente cliente;
	private Calendar data;
	private ArrayList<Servico> listaServico;
	private Cabeleireiro cabeleireiro;
	
	public Atendimento(Cliente cliente, Cabeleireiro cabeleireiro) {
		this.cliente = cliente;
		this.data = Calendar.getInstance();
		this.cabeleireiro = cabeleireiro;
		setListaServico(new ArrayList<Servico>());
	}

	public ArrayList<Servico> getListaServico() {
		return listaServico;
	}

	public void setListaServico(ArrayList<Servico> listaServico) {
		this.listaServico = listaServico;
	}
	
	public void addServico(Servico servi) {
		listaServico.add(servi);
	}
	
	public String imprimir() {
		String output = "Cliente: ";
		
		output += "\n\t Id: " + this.cliente.getId();
		output += "\n\t Nome: " + this.cliente.getNome();
		output += "\n\t CPF: " + this.cliente.getCpf();
		
		output += "\n\nCabeleleiro: ";
		
		output += "\n\t Id: " + this.cabeleireiro.getId();
		output += "\n\t Nome: " + this.cabeleireiro.getNome();
		output += "\n\t CPF: " + this.cabeleireiro.getCpf();
		
		output += "\n\nServicos: ";
		
		for (Servico servico : listaServico) {
			output += "\n\t Id: " + servico.getId();
			output += "\n\t Nome: " + servico.getNome();
			output += "\n\t Descricao: " + servico.getDescricao();
			output += "\n\t Valor: " + servico.getValor();
		}
		output += "\n\n";
		
		return output;
		}
		
	}
