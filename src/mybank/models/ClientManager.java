package mybank.models;

import java.util.ArrayList;

import mybank.exceptions.AuthenticationFailedException;
import mybank.exceptions.NoAccountForIndexException;
import mybank.exceptions.RedundantOperationException;
import mybank.exceptions.SameEmailException;
import mybank.exceptions.SameNameException;
import mybank.exceptions.SamePassWordException;

public class ClientManager {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private int clientIndex = -1;

    public ArrayList<Client> getAllClients() {
        return this.clients;
    }

    public Client getSingleClient(int index) {
        return this.clients.get(index);
    }

    private void addClient(Client client) {
        this.clients.add(client);
    }

    public void subscribeClient(ClientType clientType, String name, String email, String password) throws Exception {
        Client newClient = ClientFactory.subscribeClient(clientType, name, email, password);
        this.clientIndex += 1;

        newClient.setManagerIndex(clientIndex);
        this.addClient(newClient);
    }

    public void logIn(Client client, String email, String password) throws Exception{
        if (client.isLoggedIn()) {
            throw new RedundantOperationException();
        } else if (email != client.getEmail() || password != client.getPassword()) {
            throw new AuthenticationFailedException();
        } 
        client.logIn(true);
    }

    public void logOut(Client client) throws Exception {
        if (!client.isLoggedIn()) {
            throw new RedundantOperationException();
        }
        client.logIn(false);
    }

    public String getClientName(Client client) {
        return client.getClientName();
    }

    public void changeClientName(Client client, String clientName) throws Exception {
        if (clientName == client.getClientName()) {
            throw new SameNameException();
        }
        client.setClientName(clientName);
    }

    public void changePassword(Client client, String password) throws Exception {
        if (password == client.getPassword()) {
            throw new SamePassWordException();
        }
        client.setPassword(password);
    }

    public void changeEmail(Client client, String email) throws Exception {
        if (email == client.getEmail()) {
            throw new SameEmailException();
        }
        client.setEmail(email);
    }

    public Account getAccountById(Client client, int AccountId) throws Exception {
        try {
            return client.getAccountById(AccountId);
        } catch (IndexOutOfBoundsException e){
            throw new NoAccountForIndexException();
        }
    }
}
