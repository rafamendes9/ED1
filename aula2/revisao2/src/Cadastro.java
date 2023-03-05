import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cadastro {
    private int contador;
    private Funcionario [] vetFunc;

    public Cadastro(int tamanho){
        vetFunc = new Funcionario[tamanho];
    }

    public void contratar (String matricula){
        Scanner entrada = new Scanner(System.in);
        String nome;
        String cargo;
        double salario;
        int ano;
        int busca = this.buscarFuncionario(matricula);
        Calendar calendario = GregorianCalendar.getInstance();
        ano = calendario.get(Calendar.YEAR);

        if(this.contador==this.vetFunc.length){
            System.out.println("Sistema lotado, entre em contato conosco para aumentarmos sua capacidade");
        } else {
            if(busca != -1){
                System.out.println("Já existe funcionario com essa matricula");
            }
            else {
                Funcionario f = new Funcionario(matricula);
                System.out.println("Insira o nome completo do funcionario: ");
                nome = entrada.nextLine();
                f.setNome(nome);
                System.out.println("Insira o cargo do funcionario: ");
                cargo = entrada.nextLine();
                f.setCargo(cargo);
                System.out.println("insira o salario do funcionario: ");
                salario = entrada.nextDouble();
                f.setSalario(salario);
                f.setAnoContrato(ano);


                int resultado;
                this.vetFunc[this.contador]=f;
                System.out.println(this.contador);
                for (int i = 0; i < this.contador; i++){//inserção ordenada de menor pro maior
                    resultado = this.vetFunc[i].compareTo(f);
                    if (resultado > 0){
                        Funcionario aux = this.vetFunc[this.contador];
                        this.vetFunc[this.contador]=this.vetFunc[i];
                        this.vetFunc[i]=aux;
                    }
                }
                this.contador++;
                System.out.println("Novo funcionário cadastrado");


            }
        }
    }


    public void imprimeDadosTodosFuncionario (){
        System.out.println("Essa é a lista de funcionarios: ");
        if (this.contador == 0){
            System.out.println("Voce nao tem nenhum funcionario cadastrado");
        } else{
            for (int i=0; i < this.contador; i++){
                System.out.println("Funcionário " + (i + 1));
                System.out.println(this.vetFunc[i]);
            }
        }

    }


    public int buscarFuncionario(String matricula){
        Funcionario novo = new Funcionario(matricula);
        int i=0;
        while (i<this.contador && novo.compareTo(this.vetFunc[i])>=0){
            if(this.vetFunc[i].getMatricula().compareTo(novo.getMatricula())==0){
                return i;
            }
            i++;
        }

        return -1;
    }

    public void aplicarAumento (String matricula, double percentual){
        int resultadoBusca=buscarFuncionario(matricula);
        if (resultadoBusca>=0){
            vetFunc[resultadoBusca].aplicarAumento(percentual);
        } else if(resultadoBusca<0){
            System.out.println("Matricula inexistente");
        }

    }

    public void printFuncionario (String matricula){
        int resultadoBusca = buscarFuncionario(matricula);

        if(resultadoBusca == -1){
            System.out.println("Matricula inexistente");
        }
        else{
           System.out.println(this.vetFunc[resultadoBusca].toString());
        }

    }


    public void demitirFuncionario (String matricula){
        int resultadoBusca=buscarFuncionario(matricula);
        int i;
        if (resultadoBusca==-1){
            System.out.println("Essa matricula nao existe");
        } else{
            for (i=resultadoBusca; i<this.contador; i++){
                this.vetFunc[i] = this.vetFunc[i+1];
            }
            vetFunc[this.contador]=null;
            contador--;
            System.out.println("Funcionario demitido com sucesso");
        }

    }
}