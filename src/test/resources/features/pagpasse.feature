#language: pt

Funcionalidade: Autenticação de Usuário
Como usuário da API
Quero autenticar minhas credenciais
Para acessar recursos protegidos do sistema

  Cenário: Login bem-sucedido com credenciais válidas
    Dado que estou na página de login e possuo as seguintes credenciais válidas:


      |campo        | valor    |
      |nomeUsuario	| Usuário  |
      |senha	    | Senha    |
    Quando eu enviar a requisição de autenticação
    Então devo ser redirecionado para o painel de controle e devo visualizar uma mensagem de boas-vindas


  Cenário: Login mal-sucedido com credenciais inválidas
    Dado que estou na página de login e possuo as seguintes credenciais inválidas:


      |campo	    | valor              |
      |nomeUsuario	| Usuário Inválido   |
      |senha	    | Senha Inválida     |
    Quando eu enviar a requisição de autenticação
    Então devo visualizar a mensagem de erro "Credenciais inválidas"


  Cenário: Tentativa de acesso a recurso privado sem autenticação
    Dado que não estou autenticado no sistema
    Quando eu tentar acessar o endpoint "/api/private/hello"
    Então devo receber a resposta com status code 401 Não Autorizado

Funcionalidade: Cadastro de Cartão de Transporte
  Como usuário da API
  Quero cadastrar um novo cartão de transporte
  Para utilizar o sistema de mobilidade urbana

  Cenário: Cadastro de cartão de transporte com dados válidos
    Dado que estou autenticado na API
    E possuo os seguintes dados válidos para o cartão de transporte:
      | campo          | valor              |
      | numeroCartao   | 1234567890          |
      | tipoCartao     | Comum               |
      | saldoCartao    | 50.00               |
      | dataEmissao    | 2024-04-01           |
    Quando eu enviar uma requisição POST para "/api/cartao-transporte/adicionar"
    Então devo receber uma resposta com status code 200
    E o corpo da resposta deve conter o número do cartão "1234567890"

Funcionalidade: Consulta de Linha
  Como usuário da API
  Quero consultar uma linha de transporte cadastrada
  Para visualizar informações de rota e horários

  Cenário: Buscar linha existente pelo ID
    Dado que existe uma linha cadastrada com ID 1
    Quando eu enviar uma requisição GET para "/api/linha/1"
    Então devo receber uma resposta com status code 200
    E o corpo da resposta deve conter o nome da linha e rota

Funcionalidade: Recarga de Saldo
  Como usuário da API
  Quero recarregar meu saldo
  Para continuar usando o transporte público

  Cenário: Tentativa de recarga com valor negativo
    Dado que estou autenticado na API
    E tento recarregar o saldo com um valor negativo "-10.00"
    Quando eu enviar uma requisição POST para "/api/recarga/adicionar"
    Então devo receber uma resposta com status code 400
    E uma mensagem de erro informando "O valor da recarga deve ser positivo"

