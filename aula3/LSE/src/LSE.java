
public class LSE {
    private LSENode primeiro;
    
    public void inserir (Funcionario f) {
        // Inserir um novo funcionário no início da lista de funcionários
        // Inserção não ordenada
        // Permite repetidos
        LSENode novo;
        novo = new LSENode ();    // criar um novo nó
        novo.setInfo(f);          // "guardar" o funcionário no novo nó
        
        // Inserir o novo nó na lista de nós
        if (this.primeiro == null) {    // se a lista estiver vazia
             this.primeiro = novo;
        }
        else {
            novo.setProx(this.primeiro);
            this.primeiro = novo;
        }
    }
    public void exibir() {
        LSENode atual = this.primeiro; // começa no primeiro nó
        while (atual != null) { // enquanto não chegar ao fim da lista
            System.out.println(atual.getInfo().toString()); // imprime dados do funcionário
            atual = atual.getProx(); // avança para o próximo nó
        }
    }
    
}

