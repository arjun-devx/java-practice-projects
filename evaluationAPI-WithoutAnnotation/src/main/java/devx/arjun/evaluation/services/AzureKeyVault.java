package devx.arjun.evaluation.services;

import java.util.TreeMap;

public class AzureKeyVault implements IKeyVault {
    private TreeMap<String, String> tree = new TreeMap<>();

    public void saveSecret(String name, String value) {
        tree.put(name, value);
    }

    public String retrieveSecret(String name) {
        return tree.get(name);
    }
}
