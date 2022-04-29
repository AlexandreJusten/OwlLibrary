package Conection.DTO;

public class ClientesDTO {

    private String nomedelogin;
    private String nomeCompleto;
    private int id;
    private int telefone;
    private String endereco;

    private String senha;

    public String getNomedelogin() {
        return nomedelogin;
    }

    public void setNomedelogin(String nomedelogin) {
        this.nomedelogin = nomedelogin;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
