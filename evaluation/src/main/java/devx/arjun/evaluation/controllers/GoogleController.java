package devx.arjun.evaluation.controllers;

import devx.arjun.evaluation.dtos.SecretDto;
import devx.arjun.evaluation.services.IKeyVault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoogleController {

    @Qualifier("googleKeyVault")
    @Autowired
    private IKeyVault keyVault;

    @PostMapping("/eval/api/google/secrets")
    public void SaveSecrete(@RequestBody SecretDto secretInput) {
        keyVault.saveSecret(secretInput.getName(), secretInput.getValue());
    }

    @GetMapping("/eval/api/google/secrets/{name}")
    public String getSecret(@PathVariable String name) {
        String value = keyVault.retrieveSecret(name);
        return value;
    }
}
