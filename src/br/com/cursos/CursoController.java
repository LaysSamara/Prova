package br.com.cursos;

import java.util.List;
import java.util.Scanner;

public class CursoController {
	
	private Scanner tec;
	
	public CursoController() {
		this.tec = new Scanner(System.in);
	}

	public int leOpcao(){
		System.out.print("> ");
		return tec.nextInt();
	}
	
	public Curso cadastrarCurso() {
		
		Curso curso = new Curso();
	
		System.out.print("Informe o nome do curso: ");
		curso.setNomeCurso(tec.next());
		
		return curso;
	}
	
	public List<Curso> listarCursos(List<Curso> cursos) {
		
		if(cursos.isEmpty()) {
			System.out.println("Năo possui cursos cadastrados");
			return null;
		}
		
		System.out.printf("| %2f | %10s |\n", 
				"ID","Curso");
		
		for(int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %2f | %10s |\n",
					cursos.get(i).getNomeCurso());
		}		
		return cursos;
	}
	
	public List<Curso> editarCurso(List<Curso> cursos) {
		
		listarCursos(cursos);
		
		Curso curso = new Curso();
		
		if(cursos.isEmpty()) {
			return null;
		}
		
		System.out.print("Informe o Id do curso para editar: ");
		System.out.println("                                   ");
		int idCurso = tec.nextInt() - 1;
		
		System.out.println("--- Editar nome ---");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("Informe o novo nome do curso: ");
			curso.setNomeCurso(tec.next());
			
			cursos.set(idCurso, curso);
			break;
			
		default:
			System.out.println("Opçăo inválida!");
			break;
		}
		
		
		return cursos;
	}
	
	public void excluirCurso(List<Curso> cursos) {
		
			listarCursos(cursos);
			if(cursos.isEmpty()) {
				return;
			}
			
			System.out.println("--- EXCLUIR CURSO ---");
			
			System.out.print("Informe o ID do produto para excluir: ");
			int idCurso = tec.nextInt() - 1;
			
			if(cursos.size() <= idCurso) {
				System.out.println("Curso năo cadastrado.");
			if(!cursos.isEmpty())
				System.out.println("Não é possível apagar o curso, pois ainda há estudantes.");
				return;
			}
			
			cursos.remove(idCurso);
	}
	
	public void menu(List<Curso> cursos) {	
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
			cursos.add(cadastrarCurso());
			break;
			
		case 2:
			listarCursos(cursos);		
			break;
					
		case 3:
			editarCurso(cursos);
			break;
			
		case 4:
			excluirCurso(cursos);
			break;
			
		case 5:
			sair = true;
			break;
		
		default:
			System.out.println("Opção inválida !");
			break;
			
		}
	}while (!sair);
	}	
}

