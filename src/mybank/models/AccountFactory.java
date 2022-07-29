package mybank.models;

import mybank.exceptions.NoSuchAccountTypeException;

public class AccountFactory {
    public static Account createAccount(AccountType accountType) throws Exception {
        if (accountType == AccountType.CHECKING_ACCOUNT) {
            return new CheckingAccount();
        } else if (accountType == AccountType.SAVINGS_ACCOUNT) {
            return new SavingsAccount();
        } else if (accountType == AccountType.INVESTIMENT_ACCOUNT) {
            return new InvestimentAccount();
        } else {
            throw new NoSuchAccountTypeException();
        }


    }
}
