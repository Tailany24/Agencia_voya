package model;

public class Usuario {
	private int id_usuario;
	private String nome_completo;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private String senha;

	public Usuario() {

	}

	public Usuario(String nome_completo, String cpf, String endereco, String email, String telefone, String senha) {

		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Usuario(int id_usuario, String nome_completo, String cpf, String endereco, String email, String telefone,
			String senha) {

		this.id_usuario = id_usuario;
		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void mostrar() {
		System.out.println("==============================================");
		System.out.println("ID: "+this.id_usuario);
		System.out.println("Nome: "+this.nome_completo);
		System.out.println("CPF: "+this.cpf);
		System.out.println("Endereço: "+this.endereco);
		System.out.println("Telefone: "+this.telefone);
		System.out.println("Email: " +this.email);
		System.out.println("Senha: "+this.senha);
		System.out.println("==============================================");
	}

	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
