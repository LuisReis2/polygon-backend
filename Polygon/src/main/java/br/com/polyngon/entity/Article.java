package br.com.polyngon.entity;

import javax.persistence.*;

@Entity
@Table(name = "PLG_Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

   @Column(name = "author", nullable = false)
    private String author;

   @Column(name = "createDate", nullable = false)
   @Temporal(TemporalType.DATE)
    private java.util.Date createDate;

   @Column(name = "updateDate", nullable = false)
   @Temporal(TemporalType.DATE)
    private java.util.Date updateDate;

}
