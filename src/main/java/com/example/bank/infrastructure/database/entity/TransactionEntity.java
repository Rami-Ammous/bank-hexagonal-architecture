package com.example.bank.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rami Ammous
 */
@Entity
@Table(name = "mouvement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeMouvement")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EntityListeners({AuditingEntityListener.class})
public abstract class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double montant;

    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMvt;

    @ManyToOne
    @JoinColumn(name = "account" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_MVT_COMPTE"))
    private AccountEntity account;


}
