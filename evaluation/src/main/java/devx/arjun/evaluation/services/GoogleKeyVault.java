package devx.arjun.evaluation.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.TreeMap;

@Service("googleKeyVault")
public class GoogleKeyVault implements IKeyVault {

    HashMap<String, String> hm = new HashMap<>();

    @Override
    public void saveSecret(String secretName, String secretValue) {
        hm.put(secretName, secretValue);
    }

    @Override
    public String retrieveSecret(String secretName) {
        String value = hm.get(secretName);
        return value;
    }
}
