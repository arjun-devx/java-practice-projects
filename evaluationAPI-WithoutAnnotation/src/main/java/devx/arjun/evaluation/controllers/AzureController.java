package devx.arjun.evaluation.controllers;

import devx.arjun.evaluation.dtos.SecretDto;
import devx.arjun.evaluation.services.IKeyVault;

public class AzureController {
    private IKeyVault keyVault;

    public AzureController(IKeyVault keyVault) {
        this.keyVault = keyVault;
    }

    public void saveSecret(SecretDto input) {
        keyVault.saveSecret(input.getName(), input.getValue());
    }

    public String getSecret(String name) {
        return keyVault.retrieveSecret(name);
    }
}
