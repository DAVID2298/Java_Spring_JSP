package it.contrader.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_anagrafico")
public class UserRegistry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String name;

    private String surname;

    private String address;

    private String birthdate;


    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = true)
    private User user;

}