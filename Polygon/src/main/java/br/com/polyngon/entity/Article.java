package br.com.polyngon.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "PLG_Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private long id;


    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;




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

// CONSTRUCTOR
    public Article(Subject subject, String title, String text, String author, Date createDate, Date updateDate) {
        this.subject = subject;
        this.title = title;
        this.text = text;
        this.author = author;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
