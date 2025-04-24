package devx.arjun.evaluation.services;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service("azureKeyVault")
public class AzureKeyVault implements IKeyVault {

    TreeMap<String, String> tree = new TreeMap<>();

    @Override
    public void saveSecret(String secretName, String secretValue) {
        tree.put(secretName, secretValue);
    }

    @Override
    public String retrieveSecret(String secretName) {
        String value = tree.get(secretName);
        return value;
    }
}
