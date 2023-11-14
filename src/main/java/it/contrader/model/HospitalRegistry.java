package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HospitalRegistry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(unique = false)

    private String name;

    private String address;

    private String nation;

    private String province;

    private String city;

    private String description;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    User user;



}
