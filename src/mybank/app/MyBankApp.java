package mybank.app;

import java.math.BigDecimal;

import mybank.models.Account;
import mybank.models.AccountManager;
import mybank.models.AccountType;
import mybank.models.Client;
import mybank.models.ClientManager;
import mybank.models.ClientType;
import mybank.models.TransactionManager;

public class MyBankApp {
    private static ClientManager clientManager = new ClientManager();
    private static AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {
        try {

            // Testando a funcionalidade de inscrever clientes
            clientManager.subscribeClient(ClientType.NATURAL_PERSON,
             "Lucas Duarte", "ldp@gmail.com", "123456");

             clientManager.subscribeClient(ClientType.JURIDICAL_PERSON,
             "Pudim S/A", "pudins@psa.com", "654321");

            // Testando a obtencao das instancias cliente criadas
            Client clienteLucas = clientManager.getSingleClient(0);
            Client clientePudimSA = clientManager.getSingleClient(1);

            // Testando a funcionalidade de criar contas
            accountManager.createAccount(AccountType.CHECKING_ACCOUNT, clienteLucas);
            accountManager.createAccount(AccountType.INVESTIMENT_ACCOUNT, clientePudimSA);
            accountManager.createAccount(AccountType.SAVINGS_ACCOUNT, clienteLucas);

            // Testando a obtencao das instancias de contas por cliente
            Account contaCorrente = clientManager.getAccountById(clienteLucas, 0);
            Account contaInvestimento = clientManager.getAccountById(clientePudimSA, 0);
            Account contaPoupanca = clientManager.getAccountById(clienteLucas, 1);

            // Testando a funcionalidade de ativar contas
            accountManager.setActive(contaCorrente);
            accountManager.setActive(contaInvestimento);
            accountManager.setActive(contaPoupanca);

            // Testando a funcionalidade de autenticar sessão
            clientManager.logIn(clienteLucas, "ldp@gmail.com", "123456");

            // Testando a inicializacao de um gerente de transação
            TransactionManager lucastransactionManager = new TransactionManager(clienteLucas);

            // Testando a funcionalidade de depositar
            BigDecimal amountOfMoney = new BigDecimal(1000);
            lucastransactionManager.deposit(contaCorrente, amountOfMoney);

            BigDecimal saldo =  accountManager.getBalance(contaCorrente);

            System.out.printf("Depósito de %.2f reais: Saldo atual na conta-corrente: %.2f\n", amountOfMoney, saldo);

            // Testando a funcionalidade de sacar

            amountOfMoney = new BigDecimal(500);
            lucastransactionManager.withdraw(contaCorrente, amountOfMoney);

            saldo =  accountManager.getBalance(contaCorrente);

            System.out.printf("Saque de %.2f reais: Saldo atual na conta-corrente: %.2f\n", amountOfMoney, saldo);

            // Testando a funcionalidade de transferir

            amountOfMoney = new BigDecimal(250);
            lucastransactionManager.transfer(contaCorrente, contaPoupanca, amountOfMoney);

            BigDecimal saldoContaCorrente =  accountManager.getBalance(contaCorrente);
            BigDecimal saldoContaPoupanca =  accountManager.getBalance(contaPoupanca);

            System.out.printf("Transferencia de %.2f reais: (cc -> cp) Saldo Conta Corrente: %.2f, Saldo Conta Poupança: %.2f\n",
            amountOfMoney, saldoContaCorrente, saldoContaPoupanca);

            // Testando a funcionalidade de saque e transferência de conta de pessoa jurídica
            clientManager.logIn(clientePudimSA, "pudins@psa.com", "654321");
            TransactionManager pudimTransactionManager = new TransactionManager(clientePudimSA);

            amountOfMoney = new BigDecimal(1000);
            pudimTransactionManager.deposit(contaInvestimento, amountOfMoney);
            BigDecimal saldoContaInvestimento =  accountManager.getBalance(contaInvestimento);
            System.out.printf("Depósito de %.2f reais: Saldo atual na Conta Investimento: %.2f\n", amountOfMoney, saldoContaInvestimento);

            amountOfMoney = new BigDecimal(500);
            pudimTransactionManager.withdraw(contaInvestimento, amountOfMoney);
            saldoContaInvestimento =  accountManager.getBalance(contaInvestimento);
            System.out.printf("Saque de %.2f reais: Saldo atual na Conta Investimento: %.2f\n",amountOfMoney, saldoContaInvestimento);

            amountOfMoney = new BigDecimal(100);
            pudimTransactionManager.transfer(contaInvestimento, contaCorrente, amountOfMoney);
            saldoContaInvestimento =  accountManager.getBalance(contaInvestimento);
            saldoContaCorrente =  accountManager.getBalance(contaCorrente);

            System.out.printf("Transferência de %.2f reais: (ci -> cc) Saldo Conta Corrente: %.2f, Saldo Conta Investimento: %.2f\n",
            amountOfMoney, saldoContaCorrente, saldoContaInvestimento);

            // Testando a funcionalidade de desconectar

            clientManager.logOut(clienteLucas);

            // Testando a funcionalidade de operacao desconectada

            lucastransactionManager.deposit(contaCorrente, amountOfMoney);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void showOptions() {
        System.out.printf("Lista de Opções:");
    }
}
