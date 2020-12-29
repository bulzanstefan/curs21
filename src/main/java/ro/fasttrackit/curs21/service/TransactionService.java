package ro.fasttrackit.curs21.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.TransactionRepository;

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

    public Transaction getTransaction(Integer transactionId) {
        return repository.findById(transactionId).orElseThrow(() -> new RuntimeException("Could not find..."));
    }

    public Transaction add(Transaction transaction) {
        return repository.save(transaction);
    }
}
