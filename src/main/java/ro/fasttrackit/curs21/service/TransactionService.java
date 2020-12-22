package ro.fasttrackit.curs21.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.TransactionRepository;
import ro.fasttrackit.curs21.model.Transaction;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }
}
