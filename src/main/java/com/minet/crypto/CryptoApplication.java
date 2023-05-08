package com.minet.crypto;

import com.minet.crypto.entity.CryptoCurrency;
import com.minet.crypto.entity.CryptoWallet;
import com.minet.crypto.entity.User;
import com.minet.crypto.repository.CryptoCurrencyRepository;
import com.minet.crypto.repository.CryptoWalletRepository;
import com.minet.crypto.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CryptoWalletRepository cryptoWalletRepository,
											   UserRepository userRepository, CryptoCurrencyRepository cryptoCurrencyRepository) {
		return args -> {
			testCryptoWallet(cryptoWalletRepository, userRepository, cryptoCurrencyRepository);
		};
	}

	private void testCryptoWallet(CryptoWalletRepository cryptoWalletRepository,
								  UserRepository userRepository, CryptoCurrencyRepository cryptoCurrencyRepository) {
		User user = new User();
		user.setUserName("John");
		user.setUserEmail("john@example.com");
		user.setPassword("password");
		user.setStatus("active");

		userRepository.save(user);

		CryptoCurrency cryptoCurrency = new CryptoCurrency();
		cryptoCurrency.setCryptoName("Bitcoin");
		cryptoCurrency.setPrice(new BigDecimal("57000.50"));
		cryptoCurrency.setValueChange(new BigDecimal("1.23"));
		cryptoCurrency.setMarketCap(new BigDecimal("1.07E+12"));
		cryptoCurrency.setVolumePerDay(new BigDecimal("4.53E+10"));
		cryptoCurrency.setCirculatingSupply(new BigDecimal("1.87E+7"));
		cryptoCurrency.setWatchStatus(true);
		cryptoCurrencyRepository.save(cryptoCurrency);

		CryptoWallet cryptoWallet = new CryptoWallet();
		cryptoWallet.setTotalValue(BigDecimal.valueOf(1000.0));
		cryptoWallet.setUser(user);
		cryptoWallet.setCryptoCurrency(cryptoCurrency);
		cryptoWalletRepository.save(cryptoWallet);
		User cryptoUser = cryptoWallet.getUser();
		System.out.println("CyrptoUser: " + cryptoUser.toString());
		CryptoCurrency walletCryptoCurrency = cryptoWallet.getCryptoCurrency();
		System.out.println("Wallet Crypto Currency: " + walletCryptoCurrency.toString());
	}

}
