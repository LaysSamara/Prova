package br.com.alunos;

import br.com.enderecos.Endereco;

public class Aluno extends Endereco {
	
	 public String nomeAluno;
	 public int idadeAluno; 
	 public String curso;
	 
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public int getIdadeAluno() {
		return idadeAluno;
	}
	public void setIdadeAluno(int idadeAluno) {
		this.idadeAluno = idadeAluno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}	 

}
