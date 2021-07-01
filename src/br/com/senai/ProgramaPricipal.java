package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import br.com.alunos.Aluno;
import br.com.alunos.AlunoController;
import br.com.cursos.Curso;
import br.com.cursos.CursoController;

public class ProgramaPricipal {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();

		CursoController cursoController = new CursoController();
		AlunoController alunoController = new AlunoController();

		boolean sair = false;

		do {
			System.out.println("------MENU------");
			System.out.println("--- 1 - PESSOAS ---");
			System.out.println("--- 2 - CURSOS ---");
			System.out.println("--- 3 - SAIR ---");

			int opcao = alunoController.leOpcao();

			switch (opcao) {
			case 1:
				alunoController.menu(alunos);
				break;

			case 2:
				cursoController.menu(cursos);
				break;

			case 3:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida !");
				break;
			}
		} while (!sair);
	}
}
