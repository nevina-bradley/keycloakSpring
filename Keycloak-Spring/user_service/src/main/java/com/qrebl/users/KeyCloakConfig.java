package com.qrebl.users;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeyCloakConfig {

    static Keycloak keycloak = null;
    final static String serverUrl = "http://localhost:8081";
    public final static String realm = "Spring";
    final static String clientId = "spring-api";
    final static String clientSecret = "OBwshcyH5GQJeT5lep3Pl0dSF13llW2B";
    final static String userName = "admin";
    final static String password = "admin";


    public KeyCloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                                   )
                    .build();
        }
        return keycloak;
    }
}
