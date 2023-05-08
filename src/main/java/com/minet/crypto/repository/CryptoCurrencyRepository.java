package com.minet.crypto.repository;

import com.minet.crypto.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, UUID> {
}
