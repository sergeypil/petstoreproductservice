package io.swagger.configuration;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class KeyVaultService {
    
    public String getSecretValue(String secretUrl) {
        String[] urlParts = secretUrl.split("/");
        String keyVaultName = urlParts[2].split("\\.")[0];
        String secretName = urlParts[urlParts.length - 2];
        String secretVersion = urlParts[urlParts.length - 1];
        
        String keyVaultUrl = "https://" + keyVaultName + ".vault.azure.net";
        
        SecretClient secretClient = new SecretClientBuilder()
            .vaultUrl(keyVaultUrl)
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();
        
        return secretClient.getSecret(secretName, secretVersion).getValue();
    }
}