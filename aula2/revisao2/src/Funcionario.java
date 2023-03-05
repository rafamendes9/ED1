public class Funcionario implements Comparable<Funcionario> {
    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int anoContrato;
    int compare;

    public Funcionario(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public int getAnoContrato() {
        return anoContrato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setAnoContrato(int anoContrat) {
        this.anoContrato = anoContrat;
    }

    @Override
    public String toString() {
        return "Informações do Funcionario{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", anoContrat=" + anoContrato +
                '}';
    }

    public int compareTo (Funcionario procurado){
        Funcionario f = new Funcionario(this.matricula);
        int compara;
        compara = f.getMatricula().compareTo(procurado.getMatricula());
        return compara;
    }

    public void aplicarAumento (double percentual){
        this.setSalario(this.salario+this.salario*(percentual/100));
    }
}