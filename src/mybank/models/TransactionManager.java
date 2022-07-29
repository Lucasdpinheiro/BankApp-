package mybank.models;

import java.math.BigDecimal;

import mybank.exceptions.InactiveAccountException;
import mybank.exceptions.InvalidAmounException;
import mybank.exceptions.LoggedOutException;
import mybank.exceptions.NotEnoughMoneyException;

public class TransactionManager {
    private Client client;

    public TransactionManager(Client client) throws Exception {
        if (!client.isLoggedIn()) {
            throw new LoggedOutException();
        }
        this.client = client;
    }

    public void deposit(Account account, BigDecimal amountOfMoney) throws Exception {
        if (!this.client.isLoggedIn()) {
            throw new  LoggedOutException();
        }
        if (amountOfMoney.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmounException();
        }

        BigDecimal yield = new BigDecimal(1.02f);
        if (this.client instanceof JuridicalPersonClient && account instanceof InvestimentAccount) {
            BigDecimal correctAmountOfMoney = amountOfMoney.multiply(yield);
            account.deposit(correctAmountOfMoney);
            return;
        }
        account.deposit(amountOfMoney);
    }

    public void withdraw(Account account, BigDecimal amountOfMoney) throws Exception {
        if (!this.client.isLoggedIn()) {
            throw new  LoggedOutException();
        }
        if (amountOfMoney.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmounException();
        } 

        BigDecimal interest = new BigDecimal(1.005f);
        BigDecimal correctAmountOfMoney = amountOfMoney.multiply(interest);
        if (this.client instanceof JuridicalPersonClient) {
            if (correctAmountOfMoney.compareTo(account.getBalance()) > 0) {
                throw new NotEnoughMoneyException();
            }
            account.withdraw(correctAmountOfMoney);
            return;
        }
        if (amountOfMoney.compareTo(account.getBalance()) > 0) {
            throw new NotEnoughMoneyException();
        }
        account.withdraw(amountOfMoney);
    }

    public void transfer(Account accountToWithdraw, Account accountToDeposit, BigDecimal amountOfMoney) throws Exception{
        if (!this.client.isLoggedIn()) {
            throw new  LoggedOutException();
        }
        if (amountOfMoney.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmounException();
        } 
        if (amountOfMoney.compareTo(accountToWithdraw.getBalance()) > 0) {
            throw new NotEnoughMoneyException();
        }

        if (!accountToDeposit.isActive()) {
            throw new InactiveAccountException("destino");
        }

        BigDecimal interest = new BigDecimal(1.005f);
        if (this.client instanceof JuridicalPersonClient) {
            BigDecimal correctAmountOfMoney = amountOfMoney.multiply(interest);
            accountToWithdraw.withdraw(correctAmountOfMoney);
            accountToDeposit.deposit(amountOfMoney);
            return;
        }
        accountToWithdraw.withdraw(amountOfMoney);
        accountToDeposit.deposit(amountOfMoney);

    }
}
