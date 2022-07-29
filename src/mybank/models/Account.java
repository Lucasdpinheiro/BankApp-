package mybank.models;

import java.math.BigDecimal;

public abstract class Account {
    private int managerIndex;
    private boolean active = false;
    private BigDecimal balance = new BigDecimal(0);
    
    protected int getManagerIndex() {
        return this.managerIndex;
    }

    protected void setManagerIndex(int index) {
        this.managerIndex = index;
    }

    protected boolean isActive() {
        return this.active;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }

    protected BigDecimal getBalance() {
        return this.balance;
    }

    protected void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    protected void withdraw(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    @Override
    public String toString() {
        return String.format("Account{index=%s, active=%s}\n", this.getManagerIndex(), this.isActive());
    } 
}
