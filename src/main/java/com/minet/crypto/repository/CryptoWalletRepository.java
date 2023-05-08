package com.minet.crypto.repository;

import com.minet.crypto.entity.CryptoWallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CryptoWalletRepository extends JpaRepository<CryptoWallet, UUID> {
}
