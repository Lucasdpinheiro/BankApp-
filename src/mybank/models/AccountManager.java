package mybank.models;

import java.math.BigDecimal;
import java.util.ArrayList;

import mybank.exceptions.AccountCreationNotAllowedException;
import mybank.exceptions.RedundantOperationException;

public class AccountManager {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private int accountIndex = -1;

    public ArrayList<Account> getAllAccounts() {
        return this.accounts;
    }

    public Account getSingleAccount(int index) {
        return this.accounts.get(index);
    }

    private void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void createAccount(AccountType accountType, Client client) throws Exception {
        if (client instanceof JuridicalPersonClient && accountType == AccountType.SAVINGS_ACCOUNT) {
            throw new AccountCreationNotAllowedException();
        }
        Account newAccount = AccountFactory.createAccount(accountType);
        this.accountIndex += 1;

        newAccount.setManagerIndex(accountIndex);
        this.addAccount(newAccount);
        client.addAccount(newAccount);
    }

    public boolean accountIsActive(Account account) {
        return account.isActive();
    }

    public void setActive(Account account) throws Exception {
        if (account.isActive()) {
            throw new RedundantOperationException();
        }
        account.setActive(true);
    }

    public int getManagerIndex(Account account) {
        return account.getManagerIndex();
    }

    public BigDecimal getBalance(Account account) {
        return account.getBalance();
    }

}
