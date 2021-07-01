package br.com.alunos;

import java.util.List;
import java.util.Scanner;

public class AlunoController {
	
	private Scanner tec;

	public AlunoController(){
		tec = new Scanner(System.in);
	}

	public int leOpcao(){
		System.out.print("> ");
		return tec.nextInt();
	}
	public Aluno cadastrarAluno(){
		Aluno pessoa = new Aluno();

		System.out.println("--- CADASTRAR PESSOA ---");
		System.out.print("Informe o nome: ");
		tec.nextLine();
		pessoa.setNomeAluno(tec.nextLine());

		System.out.print("Informe a idade: ");
		pessoa.setIdadeAluno(tec.nextInt());

		System.out.print("Informe o curso: ");
		pessoa.setCurso(tec.nextLine());
	
		return pessoa;
	}
	
	public List<Aluno> listarAluno(List<Aluno> alunos) {
			
		if(alunos.isEmpty()) {
			System.out.println("Năo possui aluno cadastrado");
			return null;
		}
			
		System.out.printf("| %10s | %3fs | %15s |\n", 
				"Aluno","Idade");
			
		for(int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %10s | %3f | %15s |\n",
					alunos.get(i).getNomeAluno(),
					alunos.get(i).getIdadeAluno(),
					alunos.get(i).getCurso());
		}		
		return alunos;
	}
	
	public List<Aluno> editarAluno(List<Aluno> alunos) {
		Aluno aluno = new Aluno();
		listarAluno(alunos);
		
		if(alunos.isEmpty()) {
			return null;
		}
		
		System.out.print("Informe o Id do aluno para editar: ");
		System.out.println("                                   ");
		int idAluno = tec.nextInt() - 1;
		
		System.out.println("--- 1) Editar nome ---");
		System.out.println("--- 2) Editar idade ---");
		System.out.println("--- 3) Editar curso ---");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("Informe o novo nome do aluno: ");
			aluno.setNomeAluno(tec.next());
			
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			alunos.set(idAluno, aluno);
			break;
			
		case 2:
			System.out.print("Informe a nova idade do aluno: ");
			aluno.setIdadeAluno(tec.nextInt());
			
			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			alunos.set(idAluno, aluno);
			break;
			
		case 3:
			System.out.print("Informe o novo curso do aluno: ");
			aluno.setCurso(tec.next());
			
			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			alunos.set(idAluno,aluno);
			break;
		
		default:
			System.out.println("Opçăo inválida!");
			break;
		}
		return alunos;
		
		
	}
	
	public void excluirAluno(List<Aluno> alunos) {
		
		listarAluno(alunos);
		
		if(alunos.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR ALUNO ---");
		
		System.out.print("Informe o ID do aluno para excluir: ");
		int idAluno = tec.nextInt() - 1;
		
		if(alunos.size() <= idAluno) {
			System.out.println("Aluno năo cadastrado.");
		if(!alunos.isEmpty())
			System.out.println("Não é possível apagar o aluno, pois ainda tem cadastro.");
			return;
		}
		
		alunos.remove(idAluno);
	}
	
	public void menu(List<Aluno> alunos) {
		boolean sair = false;
		do {
		System.out.println("--- 1 - Cadastrar ---");
		System.out.println("--- 2 - Listar ---");
		System.out.println("--- 3 - Editar ---");
		System.out.println("--- 4 - Excluir ---");
		System.out.println("--- 5 - Voltar ao menu ---");
		
		int opcao = leOpcao();
		switch(opcao) {
		
		case 1:
			alunos.add(cadastrarAluno());
			break;
			
		case 2:
			listarAluno(alunos);
			break;
			
		case 3:
			editarAluno(alunos);
			break;
		
		case 4:
			excluirAluno(alunos);
			break;
			
		case 5:
			sair = true;
			break;
			
		default:
			System.out.println("Opção inválida !");
			break;
		
		}
	}while(!sair);

	}
		
}




