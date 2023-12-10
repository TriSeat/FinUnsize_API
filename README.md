# FinUnsize API


![FinUnsize](https://i.imgur.com/XlAENqn.png)


> This is project of FinUnsize API:

Deployed link: https://finunsize.onrender.com


Certifique-se de que você possui os seguintes pré-requisitos instalados antes de executar:

- Java 17 SDK: [Instalação do Java 17](https://www.oracle.com/java/technologies/downloads/)
- Spring Boot 3.2.0: Adicionado automaticamente pelo gerenciador de dependências do projeto.
- Maven: [Instação do Maven](https://maven.apache.org/download.cgi)
- Docker: [Instalação do Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Instalação do Docker Compose](https://docs.docker.com/compose/install/)



## Passo 1: Configuração do Projeto

```BASH
git clone https://github.com/TriSeat/FinUnsize_API.git
cd FinUnsize_API
```

## Passo 2: Instalação de Dependências

### Para Windows:

1. Java 17 SDK:
- Baixe e instale o Java 17 a partir do [site oficial da Oracle](https://www.oracle.com/java/technologies/downloads/#java17).

2. Spring Boot 3.2.0:
- Adicionado automaticamente pelo gerenciador de dependências do projeto.

### Para Linux 

1. Java 17 SDK:
- Instale o Java 17 utilizando o gerenciador de pacotes da sua distribuição.

Exemplo para Ubuntu:

```SHELL
sudo apt-get install openjdk-17-jdk
```

## Passo 2.1: Instalação do Maven

> O Maven, é um gerenciador de dependências para java. Para a execução de um projeto Spring Boot, o mesmo não é necessário, mas caso queira realizar testes,
e resolver problemas de dependências, siga as instruções abaixo para instalá-lo.

### Para Windows:

1. Instalação:
- Baixe e instale o Apache Maven a partir do [site oficial do Apache Maven](https://maven.apache.org/download.cgi).

2. Configurando as Variáveis de Ambiente:
- Adicione o diretório bin do Maven ao seu PATH. Por exemplo, se o Maven foi instalado em C:\Program Files\Apache\maven, adicione C:\Program Files\Apache\maven\bin ao PATH do sistema.

### Para Linux:

1. Instalação:
- Baixe apartir do repositório oficial de sua distro (caso tenha, senão vá até o site oficial)

```BASH
sudo apt update
sudo apt install maven
```

2. Configurando as Variáveis de Ambiente (Linux):

- Abra o arquivo ~/.bashrc ou ~/.zshrc (dependendo do seu shell) em um editor de texto.
- Adicione a seguinte linha ao final do arquivo:

```BASH
export PATH=/caminho/para/maven/bin:$PATH
```

- Execute o comando abaixo para aplicar as alterações:

```BASH
source ~/.bashrc
```

3. Verificando a instalação:

```BASH
mvn -version
```

**Com isso agora poderá ir na raiz do projeto e executar comandos do maven:**

- Dependências

```BASH
mvn dependency:resolve
```

- Instalar

```BASH
mvn clean install
```

- Executar testes

```BASH
mvn test
```

## Passo 3: instalação do Docker e Docker Compose (Opcional)

> As instalações do Docker e Docker Compose são opcionais. Mas facilitam na execução do projeto, principalmente a utilização do Docker Compose, para container do MySQL.

Antes de realizar qualquer conexão ao banco de dados, é de extrema importância que altere o perfil em ```FinUnsize_API/src/main/resources/application.properties``` alterando a seguinte linha:

```properties
spring.profiles.active=host
```

**para:**

```properties
spring.profiles.active=local
```

**Obs:** O docker-compose foi utilizado para um container do MySQL, caso tenha o banco de dados
instalado em sua máquina, esta etapa não é necessária. Sendo assim, apenas altere as credenciais no **application-local.properties**. 
Localizado em ```FinUnsize_API/src/main/resources/application-local.properties ```

### Instalação

### Para Windows:

1. Docker:
Siga as instruções fornecidas em [Instalação do Docker no Windows](https://docs.docker.com/desktop/install/windows-install/).

2. Docker Compose:
Siga as instruções fornecidas em [Instalação do Docker Compose no Windows](https://docs.docker.com/desktop/install/windows-install/#install-compose).

### Para Linux:

1. Docker:
Siga as instruções fornecidas em [Instalação do Docker no Linux](https://docs.docker.com/desktop/install/linux-install/).

2. Docker Compose:
Siga as instruções fornecidas em [Instalação do Docker Compose no Linux](https://docs.docker.com/desktop/install/linux-install/#install-compose).

> Para mais informações de sua utilização no spring boot, [vide o site oficial](https://spring.io/blog/2023/06/21/docker-compose-support-in-spring-boot-3-1)

## Passo 4: Execução do Docker Compose (Opcional)

Pós a instalação do Docker Compose, é necessário subir o container do MySQL, para tal, primeiro vá até ``` FinUnsize_API/src/main/resources ```
e rode o seguinte comando:

```BASH 
docker-compose up -d
```

Caso queira mudar algo no container do MySQL, modifique o arquivo ```docker-compose.yaml```, no mesmo diretório.


## Passo 5: Execução do Docker (opcional)

> Abra um terminal na raiz do seu projeto onde o Dockerfile está localizado

### Docker junto ao docker compose

- Para essa etapa, é necessário ter concluido a anterior (Etapa 4).

1. Construa a imagem Docker

```BASH
docker build -t nome-da-imagem .
```

2. Execute o contêiner da aplicação Spring Boot:

```BASH
docker run -p 8080:8080 --link nome-do-banco:db -e SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/nome-do-banco nome-da-imagem
```

**O Dockerfile já está configurado na raiz do projeto, altere-o de acordo com as suas necessidades**

### Apenas o Docker

1. Construa a imagem Docker

```BASH
docker build -t nome-da-imagem .
```

2. Executando o Contêiner a partir da Imagem:

```BASH
docker run -p 8080:8080 nome-da-imagem
```

- Para mais informações viste a [documentação oficial do docker](https://docs.docker.com/build/guide/intro/)


## Passo 6: Execução do projeto

> Para a execução, poderá utilizar IDE ou a linha de comando

### 1. Executando com IntelliJ IDEA (IDE)

### Pré-requisitos:
- Certifique-se de ter o IntelliJ IDEA instalado no seu sistema.

1. Escolha a opção Run ou Debug para executar o aplicativo.

Para mais informações, viste a [documentação oficial do Intellij IDEA](https://www.jetbrains.com/help/idea/spring-boot.html#spring-boot-endpoints).

### 2. Executando com Maven (RECOMENDADO)

### Pré-requisitos:
- Certifique-se de ter o Maven instalado no seu sistema (vide o passo 2.1).

1. Abra um terminal na raiz do seu projeto.
2. Execute o seguinte comando para compilar e executar o projeto:

```BASH
mvn spring-boot:run
```

### 3. Executando com o Visual Studio Code

Para tal, vide o tutorial: [Executando uma API REST Spring Boot no Visual Studio Code](https://pt.linkedin.com/pulse/executando-uma-api-rest-spring-boot-visual-studio-bruno#:~:text=Para%20executar%20uma%20API%20Spring,execução%20para%20o%20seu%20projeto.)

### 5. Outra forma de executar

### Pré-requisitos:
- Certifique-se de ter o Java 17 SDK instalado no seu sistema (vide o passo 2). 

1. Abra um terminal na raiz do seu projeto.
2. Compile o projeto com o seguinte comando:

```BASH
mvn clean install
```

3. Navegue até o diretório target:

```BASH
cd target
```

4. Execute o arquivo JAR gerado:

```BASH
java -jar nome-do-arquivo.jar
```

5. Alterar porta de funcionamento (OPCIONAL)

Se você precisar configurar uma porta diferente, você pode fazer isso passando a opção -Dserver.port ao executar o JAR da aplicação:
```BASH
java -jar -Dserver.port=PORTA_DESEJADA seu-projeto.jar
```

- A aplicação por padrão irá iniciar na porta 8080
http://localhost:8080

# Documentação dos EndPoints

> Endpoints testados

## Company

Endpoint: https://finunsize.onrender.com/company/

- create;
- credentials;
- update;

### Payload

**Create**

```JSON
{
	"cnpj": "",
	"nome": "",
	"slogan": "",
	"segmento": "",
	"cep": ,
	"renda_media": ,
	"balanco_atual": ,
	"despesa_media": ,
	"razao": "",
	"url_image": ""
}
```

**Update**

```JSON
{
	"nome": "",
	"slogan": "",
	"segmento": "",
	"cep": ,
	"renda_media": ,
	"balanco_atual": ,
	"despesa_media": ,
	"razao_social": "",
	"url_image": ""
}
```

## User

Endpoint: https://finunsize.onrender.com/user/

- signup
- login
- credentials
- list
- update/{id}
- delete/{id}

### Payload:

**Singnup**

```json
{
	"nome": "",
	"login": "",
	"password": "",
	"email": "",
	"telefone": ,
	"cep": ,
	"plano_padrao": ,
	"role": "",
	"cnpj": "",
	"url_image": ""
}
```

**Login**

```JSON
{
	"login": "",
	"password": ""
}
```

## Employee

Endpoint: https://finunsize.onrender.com/employee/

- create;
- find/{id};
- list;
- update/{cpf};
- delete/{cpf};

### Payload

**Create**

```JSON
{
	"cpf": "",
	"nome": "",
	"cargo": "",
	"turno": "",
	"telefone": ,
	"admissao": "",
	"endereco": {
	  "cep": "",
      "rua": "",
      "numero": "",
      "complemento": "",
      "referencia": "",
      "cidade": ""
	},
	"salario": ,
	"observacao": "",
	"url_image": ""
}
```

**Update**

```JSON
{
	"nome": "",
	"cargo": "",
	"turno": "",
	"telefone": ,
	"admissao": "",
	"endereco": {
	  "cep": "",
    " rua": "",
      "numero": "",
      "complemento": "",
      "referencia": "",
      "cidade": ""
	},
	"salario": ,
	"observacao": "",
	"url_image": ""
}
```

## Supplier

Endpoint: https://finunsize.onrender.com/supplier/

- create;
- find/{id};
- search/{name}
- list;
- update/{id};
- delete/{id};

**Create**

```JSON

{
	"nome": "",
	"endereco": {
      "cep": "",
      "rua": "",
      "numero": "",
      "complemento": "",
      "referencia": "",
      "cidade": ""
	},
	"descricao": "",
	"url_image": ""
}

```

**Update**

```JSON

{
  "nome": "",
  "endereco": {
    "cep": ,
    "rua": "",
    "numero": "",
    "complemento": "",
    "referencia": "",
    "cidade": ""
  },
  "descricao": "",
  "url_image": ""
}
```

## Product

Endpoint: https://finunsize.onrender.com/product/

- create;
- find/{barras};
- search/{name}
- list;
- update/{barras};
- delete/{barras};

**Create**

```JSON

{
	"cod_barras": "",
	"nome": "",
	"quantidade": ,
	"informacoes": {
		"marca": "",
		"categoria": "",
		"tipo": ""
	},
	"fornecedor": "",
	"validade": "",
	"descricao": "",
	"varejo": ,
	"atacado": ,
	"url_image" : ""
}
```

**Update**

```JSON
{
	"cod_barras": "",
	"nome": "",
	"quantidade": ,
	"informacoes": {
		"marca": "",
		"categoria": "",
		"tipo": ""
	},
	"fornecedor": "",
	"validade": "",
	"descricao": "",
	"varejo": ,
	"atacado": ,
	"url_image" : ""
}
```
