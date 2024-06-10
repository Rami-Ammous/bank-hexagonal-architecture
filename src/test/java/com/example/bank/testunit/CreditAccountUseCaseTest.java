package com.example.bank.testunit;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.core.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.CreditAccountPort;
import com.example.bank.domain.use_case.CreditAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

/**
 * @author Rami Ammous
 */
@SpringBootTest
public class CreditAccountUseCaseTest {

    @Autowired
    private CreditAccountUseCase creditAccountUseCase;

    @MockBean
    private CreditAccountPort creditAccountPort;

    @MockBean
    private AccountPort accountPort;


    @Test
    public void creditCompteTestFound(){

        Double montant = 65.0;

        Customer customer = new Customer(1L , "Rami");
        Account account = new Account(1L ,100.0,customer);

        //when
        Mockito.when(accountPort.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        //Arrange
        doNothing().when(creditAccountPort).save(Mockito.any());

        Account accountUpdate = new Account(account.getId(), account.getSolde() + montant, account.getCustomer());
        Mockito.when(accountPort.update(Mockito.any())).thenReturn(accountUpdate);


        Mockito.when(accountPort.update(Mockito.any())).thenReturn(accountUpdate);

        Account accountResult = creditAccountUseCase.creditAccount(new RequestTransaction(1L, montant));

        // Assert
        verify(creditAccountPort).save(Mockito.any());

        Assertions.assertEquals(true,accountResult!=null);
        Assertions.assertEquals(accountResult.getId(),1L);
        Assertions.assertEquals(accountResult.getCustomer().getId(),customer.getId());
        Assertions.assertEquals(accountResult.getSolde(),accountUpdate.getSolde() );
    }


    @Test
    public void creditCompteTestCompteNotFound() {

        Long idCompte = 100L;

        RecordNotFoundException thrown = Assertions.assertThrows(RecordNotFoundException.class, () -> {
            creditAccountUseCase.creditAccount(new RequestTransaction(idCompte, 10.0));
        });
//        Assertions.assertEquals("le account banquaire "+idCompte+" est introuvable" , thrown.getMessage());
    }

    @Test
    public void creditCompteTestBadRequest() {


        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            creditAccountUseCase.creditAccount(null);
        });
    }


}
