package com.substring.foodie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foodie_users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private int age;



    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String address;

    private String phoneNumber;

    private boolean isAvailable = true; // applicable for delivery boy

    // feel free to add more fields ad required

    private LocalDate createdDate;

    private  boolean enabled=true;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleEntities = new ArrayList<>();

    @PrePersist
    public void preSave() {
        this.createdDate = LocalDate.now();
    }

    @PostPersist
    public void postSave() {
        System.out.println("entity saved : " + this.getId());
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("entity updated : " + this.getId());
    }
}
