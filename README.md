
# Spring Boot Currency Exchange Project
This is a currency exchange Rest Api application which is developed using Spring Boot Framework.


## How to Run 
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

	* Clone this repository
	* Make sure you are using JDK 1.8 and Maven 3.x
	* You can build the project and run the tests by running mvn clean package

## About the Services:
There are four Rest Api service in this applicaiton. These are :

**1. Retrieve Currency Exchange Rate Api**  : This Api retrieve rate about two currency exchange.
  This api accepts source currency and target currency as input. Each input is required.
	
	* Local Host Exhange Rate Api End Point for Postman : localhost:8080/api/v1/retrieveExchangeRate
	* Example inputs are below:
	
				sourceCurrency : "USD"
				targetCurrency : "TRY"
	
	
**2. Convert Currency API**: This api convert source currency amount to target currency amount.**
  This api accepts source currency, target currency and source amount as input.
  Each input is required.
 
  * Local Host Convert Currency Api End Point for Postman : localhost:8080/api/v1/convertCurrency
 
  * Example inputs are below: 
				
				{
				  "sourceCurrency": "USD",
				  "sourceCurrencyAmount": 300,
				  "targetCurrency": "TRY"
				}

**3. Search Currency Conversion List (Conversion List API)** :
 This api return currency conversion list using paging mthod. This api accepts  are page, size,, transactionDate and TransactionId parameters.
 Page, size inputs and also at least one of transactionDate and transactionId parameters are required
 
  * Local Host Convert Currency Api End Point for Postman : localhost:8080/api/v1/findCurrencyConversionList
  
   * Example inputs are below: 
			   
			   page : 0
			   size : 3
			   transactionDate : 2022-01-19
			   transactionId : 1
  
	 

## About Swagger :	 
 * Also All these Api services can be accessed from the Swagger address below.
	http://localhost:8080/swagger-ui/index.html	 

## About the Heroku:
  * Also All these Api services can be accessed from the Heroku end-points below.

  *  Retrieve Currency Exchange Rate Api : https://exchangecurrency-api-deploy.herokuapp.com/api/v1/retrieveExchangeRate
  *  Convert Currency API :   https://exchangecurrency-api-deploy.herokuapp.com/api/v1/convertCurrency
  *  Search Currency Conversion List :  https://exchangecurrency-api-deploy.herokuapp.com/api/v1/findCurrencyConversionList




	 
	 
	 
	 
	 
