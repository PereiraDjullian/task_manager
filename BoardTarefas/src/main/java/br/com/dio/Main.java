package br.com.dio;

import br.com.dio.dao.TaskDAO;
import br.com.dio.model.Task;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskDAO taskDao = new TaskDAO();

        while (true) {
            System.out.println("\n========== MENU DE TAREFAS ===========");
            System.out.println("1. Adicionar nova tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Atualizar status da tarefa");
            System.out.println("4. Excluir tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();
                    taskDao.adicionarTarefa(title, description);
                    break;

                case 2:
                    List<Task> tasks = taskDao.listAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada.");
                    } else {
                        System.out.println("\n===== LISTA DE TAREFAS =====");
                        for (Task task : tasks) {
                            System.out.println("ID: " + task.getId());
                            System.out.println("Título: " + task.getTitle());
                            System.out.println("Descrição: " + task.getDescription());
                            System.out.println("Status: " + task.getStatus());
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID da tarefa para atualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo status: ");
                    String newStatus = scanner.nextLine();
                    taskDao.updateStatus(idUpdate, newStatus);
                    break;

                case 4:
                    System.out.print("ID da tarefa para excluir: ");
                    int idDelete = scanner.nextInt();
                    taskDao.deleteTask(idDelete);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }


    }
}