package com.minet.crypto.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user_wallet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserWallet {

    @Id
    @GeneratedValue(generator = "uuidv4")
    @GenericGenerator(name = "uuidv4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
