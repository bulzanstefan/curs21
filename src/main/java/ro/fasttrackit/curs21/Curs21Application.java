package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.model.Type;

import java.util.List;

@SpringBootApplication
public class Curs21Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs21Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repo) {
        return args -> repo.saveAll(List.of(
                new Transaction("bread", Type.BUY, 10),
                new Transaction("car", Type.SELL, 12000),
                new Transaction("laptop", Type.SELL, 1200),
                new Transaction("phone", Type.BUY, 300)
        ));
    }
}
