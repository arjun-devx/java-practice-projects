package devx.arjun.evaluation;

import devx.arjun.evaluation.controllers.AzureController;
import devx.arjun.evaluation.controllers.GoogleController;
import devx.arjun.evaluation.dtos.SecretDto;
import devx.arjun.evaluation.services.AzureKeyVault;
import devx.arjun.evaluation.services.GoogleKeyVault;

public class EvaluationsApplication {
	public static void main(String[] args) {
		AzureKeyVault azureKeyVault = new AzureKeyVault();
		GoogleKeyVault googleKeyVault = new GoogleKeyVault();

		AzureController azureController = new AzureController(azureKeyVault);
		GoogleController googleController = new GoogleController(googleKeyVault);

		SecretDto secret = new SecretDto("username", "arjun123");

		azureController.saveSecret(secret);
		System.out.println("Azure Vault Returned: " + azureController.getSecret("username"));

		googleController.saveSecret(secret);
		System.out.println("Google Vault Returned: " + googleController.getSecret("username"));
	}
}