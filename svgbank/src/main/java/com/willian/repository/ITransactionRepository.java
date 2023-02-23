package com.willian.repository;

import com.willian.model.Transaction;

public interface ITransactionRepository {
    public Transaction save(Transaction transaction);
}
