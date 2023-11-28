# lab05

Departamento de Computação – DComp - IFMA
Laboratório de Banco de Dados – 5o Período
Entrega e Apresentação: 23-11-2023

Atividade 05 - Etapa 03
Escopo do Projeto

Deseja-se fazer uma camada de acesso a dados para armazenar as informações de uma
locadora de jogos digitais. Hipoteticamente para compor o back-end de uma aplicação
web).
Cada jogo pode rodar em mais de uma plataforma (Xbox, PS3, PS4, PC, etc.). Cada jogo
possui seu preço diário de locação, sendo que um mesmo jogo pode ter preços de
locação diferentes para cada plataforma. Quando um cliente (nome, email, telefone,
senha) deseja fazer uma locação, ele informa quais jogos ele quer locar, informando
inclusive de qual plataforma é cada jogo contido na locação a ser realizada. Quando a
locação é realizada, a data atual deve ser registrada para esta locação. Para cada jogo
locado, o cliente informa quantos dias ele deseja ficar com cada um (note que ele pode
alugar, por exemplo, um jogo X da plataforma Xbox por 2 dias e um jogo Y da
plataforma PC por 5 dias, tudo para a mesma locação). A locadora também possui
alguns consoles de videogame, os quais podem ser usados no local pelos clientes por
um certo intervalo de tempo. Cada console possui um preço por cada hora (ou fração)
utilizada, e contém um conjunto de acessórios (headphone, controle, Kinect, etc.).

Etapa 01: Implementar das entidades com os respectivos mapeamentos para
um sistema de jogos digitais. (5.0 pontos)

Segue o fragmento do diagrama de classes do modelo de domínio da aplicação.

Etapa 02: Funcionalidades a serem implementadas na camada de repositório
(4 pontos)
I. Cadastro de clientes:
● Permitir o cadastro de clientes com informações como nome, e-mail,
telefone e senha.
II. Cadastro de jogos:
● Permitir o cadastro de jogos com informações como título, plataforma
(Xbox, PS3, PS4, PC, etc.) e preço de locação diário para cada
plataforma.
III. Locação de jogos:
● Permitir que os clientes realizem locações, selecionando os jogos
desejados e a plataforma específica de cada jogo. Deve-se registrar a
data atual para cada locação realizada.
● Permitir que o cliente especifique a quantidade de dias que deseja ficar
com cada jogo locado.
● Cálculo do preço da locação (é importante lembrar que um mesmo jogo
pode ter preços de locação diferentes para cada plataforma)

IV. Locação de consoles: (Desafio: 0.5 ponto extra)
● Permitir que os clientes realizem a locação de consoles de videogame.
● Registrar a data atual para cada locação de console realizada.

● Calcular o valor da locação com base no tempo de uso (horas ou
frações) e no preço por hora do console.
● Permitir o uso de acessórios associados a cada console (headphone,
controle, Kinect, etc.).

V. Consulta de disponibilidade: (Desafio: 0.5 ponto extra)
● Verificar a disponibilidade dos jogos e consoles para locação em
determinada data.
● Garantir que um jogo ou console já locado não fique disponível para
outra locação no mesmo período.

Etapa 03: Implementação dos testes (1 pt)
A partir da camada de acesso a dados desenvolvida na etapa anterior.
● Desenvolva classes de teste para cada funcionalidade implementada.
