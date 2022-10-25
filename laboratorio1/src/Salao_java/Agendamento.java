package Salao_java;

import java.util.Calendar;

public class Agendamento {
	private int id;
	private Calendar data;
	private Cliente cliente;
	private Cabeleireiro cabeleireiro;
	
	public Agendamento(Cliente cliente, Cabeleireiro cabeleireiro) {
		this.cliente = cliente;
		this.cabeleireiro = cabeleireiro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Cabeleireiro getCabeleireiro() {
		return cabeleireiro;
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
		
		output += "\n\t Data do Agendamento: " + this.data.get(Calendar.DATE);
		output += "/" + this.data.get(Calendar.MONTH);
		output += "/" + this.data.get(Calendar.YEAR);
		output += " --- " + this.data.get(Calendar.HOUR);
		output += ":" + this.data.get(Calendar.MINUTE) + "\n\n";
		
		
		return output;
		
	}
}
