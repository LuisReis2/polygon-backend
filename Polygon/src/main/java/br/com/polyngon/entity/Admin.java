package br.com.polyngon.entity;

import javax.persistence.*;

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


}
