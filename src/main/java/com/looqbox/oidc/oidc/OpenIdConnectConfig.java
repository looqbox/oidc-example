package com.looqbox.oidc.oidc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@Configuration
@EnableOAuth2Client
public class OpenIdConnectConfig {
    @Value("${openid.clientId}")
    private String clientId;

    @Value("${openid.clientSecret}")
    private String clientSecret;

    @Value("${openid.accessTokenUri}")
    private String accessTokenUri;

    @Value("${openid.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${openid.redirectUri}")
    private String redirectUri;


    public OAuth2ProtectedResourceDetails openId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        /*
         * these scopes are setup in the identity provider.
         * the information contained in the token will depend on them.
         */
        details.setScope(Arrays.asList("openid", "email", "profile", "aws.cognito.signin.user.admin"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate googleOpenIdTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(openId(), clientContext);
    }
}
