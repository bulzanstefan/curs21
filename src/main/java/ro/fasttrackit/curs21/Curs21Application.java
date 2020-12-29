package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.model.Account;
import ro.fasttrackit.curs21.model.Category;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.model.Type;
import ro.fasttrackit.curs21.repository.AccountRepository;
import ro.fasttrackit.curs21.repository.CategoryRepository;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;

@SpringBootApplication
public class Curs21Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs21Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(
            TransactionRepository repo,
            AccountRepository accountRepository,
            CategoryRepository categoryRepository) {
        return args -> {
            Category electronicsCategory = categoryRepository.save(new Category("electronics"));
            Category foodCategory = categoryRepository.save(new Category("food"));
            Category transportationCategory = categoryRepository.save(new Category("transportation"));
            Category dailyCategory = categoryRepository.save(new Category("daily"));
            Category etcCategory = categoryRepository.save(new Category("etc"));

            Account dailyAccount = accountRepository.save(new Account("Daily Spending"));
            Account electronics = accountRepository.save(new Account("Electronics"));
            repo.saveAll(List.of(
                    new Transaction("bread", Type.BUY, 10, dailyAccount, List.of(foodCategory, dailyCategory)),
                    new Transaction("car", Type.SELL, 12000, dailyAccount, List.of(transportationCategory, etcCategory)),
                    new Transaction("laptop", Type.SELL, 1200, electronics, List.of(electronicsCategory, dailyCategory)),
                    new Transaction("phone", Type.BUY, 300, electronics, List.of(electronicsCategory, dailyCategory, etcCategory))
            ));
        };
    }
}
