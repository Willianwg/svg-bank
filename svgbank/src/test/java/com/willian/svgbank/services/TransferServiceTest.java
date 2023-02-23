package com.willian.svgbank.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.willian.dto.TransferDto;
import com.willian.model.User;
import com.willian.repository.ITransactionRepository;
import com.willian.repository.IUserRepository;
import com.willian.service.TransferService;
import com.willian.svgbank.repositories.InMemoryTransactionRepository;
import com.willian.svgbank.repositories.inMemoryUserRepository;
import com.willian.svgbank.services.util.PasswordEncoderTest;
import com.willian.utils.IPasswordEncoder;

public class TransferServiceTest {
    
    @Test
    public void should_be_able_to_complete_transaction(){
        IUserRepository userRepository = new inMemoryUserRepository();
        ITransactionRepository transactionRepository = new InMemoryTransactionRepository();
        IPasswordEncoder passwordEncoder = new PasswordEncoderTest();
        TransferService transferService = new TransferService(userRepository, transactionRepository, passwordEncoder);

        User userFrom = new User();
        userFrom.setEmail("willian@willain.com");
        userFrom.setName("willian");
        userFrom.setPassword("123456");

        User userTo = new User();
        userTo.setEmail("test@willain.com");
        userTo.setName("test");
        userTo.setPassword("123456");

        userRepository.save(userFrom);
        userRepository.save(userTo);

        TransferDto transferData = new TransferDto();
        transferData.setFrom(userFrom.getId());
        transferData.setPassword(userFrom.getPassword());
        transferData.setTo(userTo.getId());
        transferData.setAmount(10);

        String response = transferService.execute(transferData);

        assertEquals("Transaction succeeded", response);
        assertEquals(90, userRepository.findById(userFrom.getId()).getBalance());
    }
}
