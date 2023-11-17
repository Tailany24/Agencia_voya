package model;

import java.util.Date;

public class Destino {
private int id_destino;
private String formas_de_pagamento;
private String destino_da_viagem;
private Date data_de_ida;
private Date data_de_volta;


public Destino() {
}


public Destino(String formas_de_pagamento, String destino_da_viagem, Date data_de_ida, Date data_de_volta) {
	this.formas_de_pagamento = formas_de_pagamento;
	this.destino_da_viagem = destino_da_viagem;
	this.data_de_ida = data_de_ida;
	this.data_de_volta = data_de_volta;
}


public Destino(int id_destino, String formas_de_pagamento, String destino_da_viagem, Date data_de_ida,
		Date data_de_volta) {
	this.id_destino = id_destino;
	this.formas_de_pagamento = formas_de_pagamento;
	this.destino_da_viagem = destino_da_viagem;
	this.data_de_ida = data_de_ida;
	this.data_de_volta = data_de_volta;
}
public int getId_destino() {
	return id_destino;
}
public void setId_destino(int id_destino) {
	this.id_destino = id_destino;
}
public String getFormas_de_pagamento() {
	return formas_de_pagamento;
}
public void setFormas_de_pagamento(String formas_de_pagamento) {
	this.formas_de_pagamento = formas_de_pagamento;
}
public String getDestino_da_viagem() {
	return destino_da_viagem;
}
public void setDestino_da_viagem(String destino_da_viagem) {
	this.destino_da_viagem = destino_da_viagem;
}
public Date getData_de_ida() {
	return data_de_ida;
}
public void setData_de_ida(Date data_de_ida) {
	this.data_de_ida = data_de_ida;
}
public Date getData_de_volta() {
	return data_de_volta;
}
public void setData_de_volta(Date data_de_volta) {
	this.data_de_volta = data_de_volta;
}

public void mostrar() {
	System.out.println("==============================================");
	System.out.println("ID: "+this.id_destino);
	System.out.println("Destino: "+this.destino_da_viagem);
	System.out.println("Forma de pagamento: "+this.formas_de_pagamento);
	System.out.println("Data de Ida: "+this.data_de_ida);
	System.out.println("Data de Volta: "+this.data_de_volta);
	System.out.println("==============================================");
}

}
