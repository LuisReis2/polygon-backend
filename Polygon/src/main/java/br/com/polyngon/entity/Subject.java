package br.com.polyngon.entity;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "PLG_Subjects")
public class Subject {

    @Id // Informe que sera o identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) // informa que deve gerar um id automaticamente
    @Column(name = "id")
    private long id;

    //coluna     Nome             NOTNULL   UNIQUE
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "icon",nullable = false)
    private String icon;

    @Column(name = "qtd_articles", nullable = false)
    private int qtd_articles;

    //CARDINALIDADE
//    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
//    private List<Article> articles;


    public Subject(){

    }

    //CONSTRUCTOR
    public Subject(String name, String icon, int qtd_articles/*, List<Article> articles*/) {
        this.name = name;
        this.icon = icon;
        this.qtd_articles = qtd_articles;
        //this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getQtd_articles() {
        return qtd_articles;
    }

    public void setQtd_articles(int qtd_articles) {
        this.qtd_articles = qtd_articles;
    }
}
