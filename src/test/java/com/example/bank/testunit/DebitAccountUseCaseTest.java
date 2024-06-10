package com.example.bank.testunit;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.core.exception.OperationFailedException;
import com.example.bank.core.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.entities.DebitAccount;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.DebitAccountPort;
import com.example.bank.domain.use_case.DebitAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

/**
 * @author Rami Ammous
 */
@SpringBootTest
public class DebitAccountUseCaseTest {

    @Mock
    private DebitAccountPort debitAccountPort;

    @Mock
    private AccountPort accountPort;

    @InjectMocks
    private DebitAccountUseCase debitAccountUseCase;

    @Test
    public void debitCompteTestFound() {

        Double montant = 40.0;

        Customer customer = new Customer(1L, "Rami");
        Account account = new Account(1L, 500.0, customer);
//        DebitAccount debitAccount = new DebitAccount(1L,montant,new Date() ,account);

        //when
        Mockito.when(accountPort.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        //Arrange
        doNothing().when(debitAccountPort).save(Mockito.any());

        Account accountUpdate = new Account(account.getId(), account.getSolde() - montant, account.getCustomer());
        Mockito.when(accountPort.update(Mockito.any())).thenReturn(accountUpdate);

        Account accountResult = debitAccountUseCase.debitAccount(new RequestTransaction(1L, montant));

        // Assert
        verify(debitAccountPort).save(Mockito.any());

        Assertions.assertEquals(true, accountResult != null);
        Assertions.assertEquals(accountResult.getId(), 1L);
        Assertions.assertEquals(accountResult.getCustomer().getId(), customer.getId());
        Assertions.assertEquals(accountResult.getSolde(), accountUpdate.getSolde());
    }


    @Test
    public void debitCompteTestCompteNotFound() {

        Long idCompte = 100L;
        //when
        Mockito.when(accountPort.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        RecordNotFoundException thrown = Assertions.assertThrows(RecordNotFoundException.class, () -> {
            debitAccountUseCase.debitAccount(new RequestTransaction(idCompte, 10.0));
        });
//        Assertions.assertEquals("le account banquaire "+idCompte+" est introuvable" , thrown.getMessage());
    }

    @Test
    public void debitCompteTestBadRequest() {

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            debitAccountUseCase.debitAccount(null);
        });
    }


    @Test
    public void debitCompteTestInsufficientBankBalance() {

        Double montant = 500.0;

        Customer customer = new Customer(1L, "Rami");
        Account account = new Account(1L, 100.0, customer);

        DebitAccount debitAccount = new DebitAccount(1L, montant, new Date(), account);

        //when
        Mockito.when(accountPort.findById(Mockito.anyLong())).thenReturn(Optional.of(account));


        OperationFailedException thrown = Assertions.assertThrows(OperationFailedException.class, () -> {
            debitAccountUseCase.debitAccount(new RequestTransaction(1L, montant));
        });

    }
}
