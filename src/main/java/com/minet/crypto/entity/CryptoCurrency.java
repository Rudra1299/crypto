package com.minet.crypto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "cryto_currency")
public class CryptoCurrency implements Serializable {

    @Id
    @GeneratedValue(generator = "uuidv4")
    @GenericGenerator(name = "uuidv4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @NotBlank
    @Column(name = "crypto_name")
    private String cryptoName;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "100.00")
    @Column(name = "value_change")
    private BigDecimal valueChange;

    @NotNull
    @DecimalMin(value = "0.00")
    @Column(name = "market_cap")
    private BigDecimal marketCap;

    @NotNull
    @DecimalMin(value = "0.00")
    @Column(name = "volume_per_day")
    private BigDecimal volumePerDay;


    @NotNull
    @DecimalMin(value = "0.00")
    @Column(name = "circulating_supply")
    private BigDecimal circulatingSupply;

    @NotNull
    @Column(name = "watch_status")
    private boolean watchStatus;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
