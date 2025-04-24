package devx.arjun.evaluation.controllers;

import devx.arjun.evaluation.dtos.SecretDto;
import devx.arjun.evaluation.services.IKeyVault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eval/api/azure/secrets")
public class AzureController {

    @Qualifier("azureKeyVault")
    @Autowired
    private IKeyVault keyVault;

    @PostMapping
    public void saveSecret(@RequestBody SecretDto secretInput) {
        keyVault.saveSecret(secretInput.getName(), secretInput.getValue());
    }

    @GetMapping("/{name}")
    public String getSecret(@PathVariable String name) {
        String value = keyVault.retrieveSecret(name);
        return value;
    }
}