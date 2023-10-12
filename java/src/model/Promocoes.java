package model;

public class Promocoes {
	private int id_promocoes;
	private String descricao;
	private float preco;

	private Destino destino;
	private Usuario usuario;

	public Promocoes() {

	}

	public Promocoes(int id_promocoes, String descricao, float preco, Destino destino, Usuario usuario) {

		this.id_promocoes = id_promocoes;
		this.descricao = descricao;
		this.preco = preco;
		this.destino = destino;
		this.usuario = usuario;
	}

	public Promocoes(String descricao, float preco, Destino destino, Usuario usuario) {

		this.descricao = descricao;
		this.preco = preco;
		this.destino = destino;
		this.usuario = usuario;
	}

	public int getId_promocoes() {
		return id_promocoes;
	}

	public void setId_promocoes(int id_promocoes) {
		this.id_promocoes = id_promocoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void mostrar() {
		System.out.println("==============================================");
		System.out.println("ID: "+this.id_promocoes);
		System.out.println("Usuario: "+this.usuario.getNome_completo());
		System.out.println("Destino: "+this.destino.getDestino_da_viagem());
		System.out.println("Descrição: "+this.descricao);
		System.out.println("Valor: "+this.preco);
		System.out.println("==============================================");
	}
}
