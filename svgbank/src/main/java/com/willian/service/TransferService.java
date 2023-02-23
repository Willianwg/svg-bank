package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.dto.TransferDto;
import com.willian.model.Transaction;
import com.willian.model.enums.TransactionTypes;
import com.willian.model.User;
import com.willian.repository.ITransactionRepository;
import com.willian.repository.IUserRepository;
import com.willian.utils.IPasswordEncoder;


@Service
public class TransferService {
    private IUserRepository userRepository;
    private ITransactionRepository transactionRepository;
    private IPasswordEncoder passwordEncoder;

    public TransferService(IUserRepository userRepository, ITransactionRepository transactionRepository, IPasswordEncoder passwordEncoder){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String execute(TransferDto transferData) {

        User from = this.userRepository.findById(transferData.getFrom());
        User to = this.userRepository.findById(transferData.getTo());

        String encodedPassword = from.getPassword();
        boolean match = this.passwordEncoder.compare(transferData.getPassword(), encodedPassword);

        if (!match) {
            return "Fail to resolve transaction, wrong credentials";
        }

        double amount = transferData.getAmount();

        boolean success = from.debit(amount);

        if (!success) {
            return "Fail to resolve transaction, insufficient balance";
        }

        to.credit(amount);

        Transaction sentTransaction = new Transaction();
        sentTransaction.setType(TransactionTypes.SENT);
        sentTransaction.setAmount(amount);
        sentTransaction.setSent_by(from.getEmail());
        sentTransaction.setReceived_by(to.getEmail());

        Transaction receivedTransaction = new Transaction();
        receivedTransaction.setType(TransactionTypes.RECEIVED);
        receivedTransaction.setAmount(amount);
        receivedTransaction.setSent_by(from.getEmail());
        receivedTransaction.setReceived_by(to.getEmail());

        this.transactionRepository.save(sentTransaction);
        this.transactionRepository.save(receivedTransaction);

        from.addTransaction(sentTransaction);
        to.addTransaction(receivedTransaction);
                
        this.userRepository.save(from);
        this.userRepository.save(to);

        return "Transaction succeeded";

    }
}
