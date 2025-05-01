package devx.arjun.evaluation.services;

import java.util.HashMap;

public class GoogleKeyVault implements IKeyVault {
    private HashMap<String, String> map = new HashMap<>();

    public void saveSecret(String name, String value) {
        map.put(name, value);
    }

    public String retrieveSecret(String name) {
        return map.get(name);
    }
}
