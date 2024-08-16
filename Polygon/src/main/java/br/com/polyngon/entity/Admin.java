package br.com.polyngon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "PLG_Admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private long id_admin;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "image_profile")
    private String image_profile;


    public Admin(String name, String email, String password, String image_profile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.image_profile = image_profile;
    }
}
