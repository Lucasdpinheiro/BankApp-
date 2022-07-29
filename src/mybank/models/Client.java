package mybank.models;

import java.util.ArrayList;

public abstract class Client {
    private String clientName;
    private String password;
    private String email;
    private boolean loggedIn = false;
    private int managerIndex;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    protected Client(String name, String email, String password) {
        this.clientName = name;
        this.password = password;
        this.email = email;
    }

    protected String getClientName() {
        return this.clientName;
    }

    protected void setClientName(String clientName) {
        this.clientName = clientName;
    }

    protected String getPassword() {
        return this.password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected String getEmail() {
        return this.email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected boolean isLoggedIn() {
        return this.loggedIn;
    }

    protected void logIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getManagerIndex() {
        return managerIndex;
    }

    public void setManagerIndex(int managerIndex) {
        this.managerIndex = managerIndex;
    }

    protected ArrayList<Account> getAccounts() {
        return accounts;
    }

    protected void addAccount(Account account) {
        this.accounts.add(account);
    }

    protected Account getAccountById(int id) {
        return this.accounts.get(id);
    }
    
}
