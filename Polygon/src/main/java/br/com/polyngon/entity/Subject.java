package br.com.polyngon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    private long icon;

    @Column(name = "qtd_articles", nullable = false)
    private int qtd_articles;

    //CARDINALIDADE
    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
    private List<Article> articles;

    //CONSTRUCTOR
    public Subject(String name, long icon, int qtd_articles, List<Article> articles) {
        this.name = name;
        this.icon = icon;
        this.qtd_articles = qtd_articles;
        this.articles = articles;
    }
}
