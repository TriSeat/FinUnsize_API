# FinUnsize API


![FinUnsize](https://i.imgur.com/XlAENqn.png)


> This is project of FinUnsize API:

Deployed link: https://finunsize.onrender.com

Endpoints Testados:

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
