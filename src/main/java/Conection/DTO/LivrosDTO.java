package Conection.DTO;

public class LivrosDTO {

    private int id;
    private String titulo;
    private String assunto;
    private String autor;
    private int estoque;
    private int editoraId;
    private int categoriaId;

    public LivrosDTO(int id, String titulo, String assunto, String autor, int estoque, int editoraId, int categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.assunto = assunto;
        this.autor = autor;
        this.estoque = estoque;
        this.editoraId = editoraId;
        this.categoriaId = categoriaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(int editoraId) {
        this.editoraId = editoraId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "LivrosDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", assunto='" + assunto + '\'' +
                ", autor='" + autor + '\'' +
                ", estoque=" + estoque +
                ", editoraId=" + editoraId +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
