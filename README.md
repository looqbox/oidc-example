# oidc-example
simple OIDC example

### Atenção
Esse exemplo precisa ser rodado em ambiente HTTPS!

### Fluxo da aplicação
Qualquer endpoint acessado irá redirecionar o usuário para o Cognito.

    Caso já exista um sessão válida no Cognito, o usuário é redirecionado para a aplicação.
    
    Caso não exista um sessão válida, o usurio faz login e é redirecionado para a aplicação.
    
Em ambos os casos acima, o Cognito retorna um ID Token do JWT gerado para a aplicação no endpoint definido no arquivo de properties

### Scopes e Flows
Na tela de admin do cognito, ir em App Integration > App client settings:
    Allowed OAuth Flows: Ativar a opção Authorization code grant
    Allowed OAuth Scopes: email, openid, aws.cognito.signin.user.admin, profile
    
Para mais informações sobre scopes e flows: http://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-pools-app-idp-settings.html

Para mais informações sobre os endpoints do Cognito usados pela aplicação (arquivo de properties: http://docs.aws.amazon.com/cognito/latest/developerguide/cognito-userpools-server-contract-reference.html
