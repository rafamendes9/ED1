import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro cadastro = new Cadastro(5);
        int escolha = 0;

        System.out.println("Bem vindo ao sistema, por favor escolha uma das opções ");
        while (escolha < 6) {
            System.out.println("1 - Admitir novo funcionario");
            System.out.println("2 - Exibir todos os funcionarios");
            System.out.println("3 - Aplicar aumento de salario a um funcionario");
            System.out.println("4 - Exibir dados de um funcionario");
            System.out.println("5 - Demitir funcionario");
            System.out.println("6 - Encerrar programa");
            
            System.out.println("digite a opção desejada");
            
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite numero de matricula do funcionario a ser criado");
                    String matricula = in.next();
                    in.nextLine();
                    cadastro.contratar(matricula);
                    break;

                case 2:
                    in.nextLine();
                    cadastro.imprimeDadosTodosFuncionario();
                    break;


                case 3:
                    System.out.println("Digite a matricula do funcionario");
                    matricula = in.next();
                    in.nextLine();
                    System.out.println("Agora digite o percentual do aumento a ser dado");
                    double percentual = in.nextDouble();
                    in.nextLine();
                    cadastro.aplicarAumento(matricula, percentual);
                    break;

                case 4:
                    System.out.println("Digite a matricula do funcionario cujos dados voce quer ver");
                    matricula = in.next();
                    in.nextLine();
                    cadastro.printFuncionario(matricula);
                    break;

                case 5:
                    System.out.println("Digite a matricula do funcionario que voce quer demitir");
                    matricula = in.next();
                    in.nextLine();
                    cadastro.demitirFuncionario(matricula);
                    break;

                case 6:
                    System.out.println("Deslogando do sistema");
            }

        }

    }
}