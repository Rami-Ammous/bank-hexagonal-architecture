package com.example.bank.infrastructure.database.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Rami Ammous
 */
@Entity
@Table(name = "compte")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solde")
    private Double solde;

    @ManyToOne
    @JoinColumn(name = "customer" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_COMPTE_CLIENT"))
    private CustomerEntity customer;


}
