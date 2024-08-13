package br.com.polyngon.entity;

import javax.persistence.*;

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

    @Column(name = "Articles", nullable = false)
    private int articles;

    public Subject(String name, long icon, int articles) {
        this.name = name;
        this.icon = icon;
        this.articles = articles;
    }

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIcon() {
        return icon;
    }

    public void setIcon(long icon) {
        this.icon = icon;
    }
}
