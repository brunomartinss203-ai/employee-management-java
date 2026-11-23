package app;

import entities.Employee;
import service.EmployeeService;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int opc;
        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=".repeat(20));
            System.out.println("SISTEMA RH");
            System.out.println("=".repeat(20));
            System.out.println("1- Cadastrar funcionário");
            System.out.println("2- Listar  funcionários");
            System.out.println("3- Buscar funcionário pr ID");
            System.out.println("4- Aumentar salário");
            System.out.println("5- Remover funcionário");
            System.out.println("6- Calcular folha salarial");
            System.out.println("0- Sair");
            System.out.println("=".repeat(20));
            System.out.print("Escolha uma opção :");
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
            }else {
                System.out.println("ENTRADA INVALIDA DIGITE APENAS INT");
                sc.nextLine();
                continue;
            }
            if (opc == 1) {
                double baseSalary = 0;
                sc.nextLine();
                System.out.println("=== CADASTRAR FUNCIONÁRIO===");
                System.out.println();
                System.out.print("Nome:");
                String name = sc.nextLine();
                System.out.print("Cargo:");
                String role = sc.nextLine();
                System.out.print("Salário-base:");
                if (sc.hasNextDouble()) {
                    baseSalary = sc.nextDouble();
                }else {
                    System.out.println("ENTRADA INVALIDA DIGITE APENAS DOUBLE");
                    sc.nextLine();
                    continue;
                }
                Employee employee = new Employee(name, role, baseSalary);
                boolean cadastro = service.addEmployee(employee);
                if (cadastro){
                 System.out.println("Cadastro Realizado com sucesso");
                }
                else {
                    System.out.println("Falha no cadastro Dados invalidos");
                }
            } else if (opc == 2) {
                System.out.println("===FUNCIONÁRIOS CADASTRADOS===");
                int totfunc = service.getEmployees().size();
                for (Employee employee : service.getEmployees()) {
                    System.out.println("-".repeat(25));
                    System.out.println(employee);
                }
                System.out.println("Total de funcionários:" + totfunc);
            } else if (opc == 3) {
                int id;
                System.out.println("===BUSCAR FUNCIONÁRIO===");
                System.out.print("Digite o ID:");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                }else {
                    System.out.println("ENTRADA INVALIDA DIGITE APENAS INT");
                    sc.nextLine();
                    continue;
                }
                Employee func = service.findById(id);
                if (func != null){
                    System.out.println("[ENCONTRADO]");
                   System.out.println(func);
                }
                 else {
                System.out.println("ERRO Funcionário não encontrado !!!");
            }

            } else if (opc == 4) {
                int id = 0;
                double percent;
                System.out.println("===Aumentar Salário===");
                System.out.println();
                System.out.println("Digite o ID:");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                }else {
                    System.out.println("ENTRADA INVALIDA DIGITE APENAS INT");
                    sc.nextLine();
                    continue;
                }
                System.out.println("Percentual de aumento:");
                if (sc.hasNextDouble()) {
                    percent = sc.nextDouble();
                }else {
                    System.out.println("ENTRADA INVALIDA DIGITE APENAS DOUBLE");
                    sc.nextLine();
                    continue;
                }
                System.out.println();
                if(service.increaseEmployeeSalary(id,percent)){
                    System.out.println("[SUCESSO]");
                }else {
                    System.out.println("ERRO Desconhecido");
                }

            } else if (opc == 5) {
                int id = 0;
                System.out.println("===REMOVER FUNCIONÁRIO");
                System.out.println("Digite o ID:");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                }else {
                    System.out.println("ENTRADA INVALIDA DIGITE APENAS INT");
                    sc.nextLine();
                    continue;
                }
                Employee func = service.findById(id);
                if(func != null){
                    System.out.println("Funcionário encontrado: "+func.getName());
                    System.out.print("Deseja Remover esse funcionario (Digite s ou sim ) ?");
                    String yon = sc.next();
                    if(yon.toLowerCase(Locale.ROOT).equals( "sim") ||yon.toLowerCase(Locale.ROOT).equals("s")){
                        service.removeEmployee(id);
                        int totfunc = service.getEmployees().size();
                        System.out.println("[SUCESSO] Funcionário removido!");
                        System.out.println("Funcionários Restantes:"+totfunc);
                    }else {
                        System.out.println("Voltando....");
                        continue;
                    }
                }else {
                    System.out.println("Funcionário não encontrado !");
                    continue;
                }

            } else if (opc == 6) {
                System.out.println("==FOLHA SALARIAL===");
                for (Employee employee : service.getEmployees()) {
                    System.out.println(employee.getName()+":     "+ employee.getBaseSalary());
                }
                System.out.println("-".repeat(25));
                System.out.println("TOTAL: "+service.calculatePayroll());

            } else if (opc == 0) {
                break;

            } else {
                System.out.println("OPÇÃO DESCONHECIDA TENTE NOVAMENTE");
            }
        }
    }
}