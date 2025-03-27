# **Projeto Conversor de moeda**

### **Propósito:**
Ser capaz de converter um valor entre duas moedas distintas.

### **Entrada de dados esperada:**

    "user_Id": 4, 
    "currencyOrigin": "BRL",
    "amountOrigin": 50 ,
    "currencyDestination": "PLN"

**user_id** -> Indicar ID do usuário (Qualquer numero Long)

**currencyOrigin** -> Moeda de origem

**amountOrigin** -> Valor a ser convertido

**currencyDestination** -> Moeda de destino

### **Funcionamento:**
Ao consultar a API, fornecendo os dados no Bodyrequest, a aplicação faz a leitura das moedas, consome a API exchangerates e obtem as taxas de conversão.
Na versão free, a API retorna a taxa de conversão das moedas para o Euro.
Dentro de casa, a aplicação faz o calculo para chegar na taxa de conversão direta.
Os dados obtidos da API Exchangerates, os dados fornecidos no BodyRequest e a conversão são persistidos no banco de dados em Memória.

### **Tecnologia utilizada:**
Java 21  
SpringBoot 3.4.4
Spring Framework
Spring cloud Openfeign
H2 Database
IntelliJ IDEA Community Edition
Maven
Postman

### **Aplicação separada por camadas:**

Model
- Entity
- Repository

Service
- Impl

Controller

Handler

Test


### **Como rodar:**
1. Clonar o projeto para ambiente local.
2. Importar projeto para Intellij
3. Caso não possua JDK 21, o Intellij questionará qual JDK utilizar, sugiro realizar download através do Intellij, Não testado em outras JDKs 
4. Aguardar Maven concluir download das dependências
5. Rodar aplicação no IntelliJ
6. No Postman, Enviar uma requisição Post para a URL: localhost:8080/api/converter com o Body:
7. {
   "user_Id": ,
   "currencyOrigin": "",
   "amountOrigin":  ,
   "currencyDestination": ""
   }
8. Preencher o body com base nas instruções "Entrada de dados esperada", as moedas podem ser obtidas abaixo.
9. É possível consultar as transações por usuário, basta enviar uma requisição Get para a URL localhost:8080/api/findAllByUser=4, passando o ID do usuário na URL

### **Oportunidade de melhorias:**
- Implementar demais testes
- Ampliar lista de exceptions customizadas
- Implementar a conversão de várias moedas numa unica solicitação.
- Implementar cadastro de usuário

### **Moedas suportadas:**

"AED": "United Arab Emirates Dirham"

"AFN": "Afghan Afghani"

"ALL": "Albanian Lek"

"AMD": "Armenian Dram"

"ANG": "Netherlands Antillean Guilder"

"AOA": "Angolan Kwanza"

"ARS": "Argentine Peso"

"AUD": "Australian Dollar"

"AWG": "Aruban Florin"

"AZN": "Azerbaijani Manat"

"BAM": "Bosnia-Herzegovina Convertible Mark"

"BBD": "Barbadian Dollar"

"BDT": "Bangladeshi Taka"

"BGN": "Bulgarian Lev"

"BHD": "Bahraini Dinar"

"BIF": "Burundian Franc"

"BMD": "Bermudan Dollar"

"BND": "Brunei Dollar"

"BOB": "Bolivian Boliviano"

"BRL": "Brazilian Real"

"BSD": "Bahamian Dollar"

"BTC": "Bitcoin"

"BTN": "Bhutanese Ngultrum"

"BWP": "Botswanan Pula"

"BYN": "New Belarusian Ruble"

"BYR": "Belarusian Ruble"

"BZD": "Belize Dollar"

"CAD": "Canadian Dollar"

"CDF": "Congolese Franc"

"CHF": "Swiss Franc"

"CLF": "Chilean Unit of Account (UF)"

"CLP": "Chilean Peso"

"CNY": "Chinese Yuan"

"CNH": "Chinese Yuan Offshore"

"COP": "Colombian Peso"

"CRC": "Costa Rican Colón"

"CUC": "Cuban Convertible Peso"

"CUP": "Cuban Peso"

"CVE": "Cape Verdean Escudo"

"CZK": "Czech Republic Koruna"

"DJF": "Djiboutian Franc"

"DKK": "Danish Krone"

"DOP": "Dominican Peso"

"DZD": "Algerian Dinar"

"EGP": "Egyptian Pound"

"ERN": "Eritrean Nakfa"

"ETB": "Ethiopian Birr"

"EUR": "Euro"

"FJD": "Fijian Dollar"

"FKP": "Falkland Islands Pound"

"GBP": "British Pound Sterling"

"GEL": "Georgian Lari"

"GGP": "Guernsey Pound"

"GHS": "Ghanaian Cedi"

"GIP": "Gibraltar Pound"

"GMD": "Gambian Dalasi"

"GNF": "Guinean Franc"

"GTQ": "Guatemalan Quetzal"

"GYD": "Guyanaese Dollar"

"HKD": "Hong Kong Dollar"

"HNL": "Honduran Lempira"

"HRK": "Croatian Kuna"

"HTG": "Haitian Gourde"

"HUF": "Hungarian Forint"

"IDR": "Indonesian Rupiah"

"ILS": "Israeli New Sheqel"

"IMP": "Manx pound"

"INR": "Indian Rupee"

"IQD": "Iraqi Dinar"

"IRR": "Iranian Rial"

"ISK": "Icelandic Króna"

"JEP": "Jersey Pound"

"JMD": "Jamaican Dollar"

"JOD": "Jordanian Dinar"

"JPY": "Japanese Yen"

"KES": "Kenyan Shilling"

"KGS": "Kyrgystani Som"

"KHR": "Cambodian Riel"

"KMF": "Comorian Franc"

"KPW": "North Korean Won"

"KRW": "South Korean Won"

"KWD": "Kuwaiti Dinar"

"KYD": "Cayman Islands Dollar"

"KZT": "Kazakhstani Tenge"

"LAK": "Laotian Kip"

"LBP": "Lebanese Pound"

"LKR": "Sri Lankan Rupee"

"LRD": "Liberian Dollar"

"LSL": "Lesotho Loti"

"LTL": "Lithuanian Litas"

"LVL": "Latvian Lats"

"LYD": "Libyan Dinar"

"MAD": "Moroccan Dirham"

"MDL": "Moldovan Leu"

"MGA": "Malagasy Ariary"

"MKD": "Macedonian Denar"

"MMK": "Myanma Kyat"

"MNT": "Mongolian Tugrik"

"MOP": "Macanese Pataca"

"MRU": "Mauritanian Ouguiya"

"MUR": "Mauritian Rupee"

"MVR": "Maldivian Rufiyaa"

"MWK": "Malawian Kwacha"

"MXN": "Mexican Peso"

"MYR": "Malaysian Ringgit"

"MZN": "Mozambican Metical"

"NAD": "Namibian Dollar"

"NGN": "Nigerian Naira"

"NIO": "Nicaraguan Córdoba"

"NOK": "Norwegian Krone"

"NPR": "Nepalese Rupee"

"NZD": "New Zealand Dollar"

"OMR": "Omani Rial"

"PAB": "Panamanian Balboa"

"PEN": "Peruvian Nuevo Sol"

"PGK": "Papua New Guinean Kina"

"PHP": "Philippine Peso"

"PKR": "Pakistani Rupee"

"PLN": "Polish Zloty"

"PYG": "Paraguayan Guarani"

"QAR": "Qatari Rial"

"RON": "Romanian Leu"

"RSD": "Serbian Dinar"

"RUB": "Russian Ruble"

"RWF": "Rwandan Franc"

"SAR": "Saudi Riyal"

"SBD": "Solomon Islands Dollar"

"SCR": "Seychellois Rupee"

"SDG": "South Sudanese Pound"

"SEK": "Swedish Krona"

"SGD": "Singapore Dollar"

"SHP": "Saint Helena Pound"

"SLE": "Sierra Leonean Leone"

"SLL": "Sierra Leonean Leone"

"SOS": "Somali Shilling"

"SRD": "Surinamese Dollar"

"STD": "São Tomé and Príncipe Dobra"

"SVC": "Salvadoran Colón"

"SYP": "Syrian Pound"

"SZL": "Swazi Lilangeni"

"THB": "Thai Baht"

"TJS": "Tajikistani Somoni"

"TMT": "Turkmenistani Manat"

"TND": "Tunisian Dinar"

"TOP": "Tongan Paʻanga"

"TRY": "Turkish Lira"

"TTD": "Trinidad and Tobago Dollar"

"TWD": "New Taiwan Dollar"

"TZS": "Tanzanian Shilling"

"UAH": "Ukrainian Hryvnia"

"UGX": "Ugandan Shilling"

"USD": "United States Dollar"

"UYU": "Uruguayan Peso"

"UZS": "Uzbekistan Som"

"VEF": "Venezuelan Bolívar Fuerte"

"VES": "Sovereign Bolivar"

"VND": "Vietnamese Dong"

"VUV": "Vanuatu Vatu"

"WST": "Samoan Tala"

"XAF": "CFA Franc BEAC"

"XAG": "Silver (troy ounce)"

"XAU": "Gold (troy ounce)"

"XCD": "East Caribbean Dollar"

"XDR": "Special Drawing Rights"

"XOF": "CFA Franc BCEAO"

"XPF": "CFP Franc"

"YER": "Yemeni Rial"

"ZAR": "South African Rand"

"ZMK": "Zambian Kwacha (pre-2013)"

"ZMW": "Zambian Kwacha"

"ZWL": "Zimbabwean Dollar"

