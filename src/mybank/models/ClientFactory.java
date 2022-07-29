package mybank.models;

import mybank.exceptions.NoSuchClientTypeException;

public class ClientFactory {
    public static Client subscribeClient(ClientType clientType, String name, String email, String password) throws Exception {
        if (clientType == ClientType.NATURAL_PERSON) {
            return new NaturalPersonClient(name, email, password);
        } else if (clientType == ClientType.JURIDICAL_PERSON) {
            return new JuridicalPersonClient(name, email, password);
        } else {
            throw new NoSuchClientTypeException();
        }
    }
}
