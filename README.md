## Shopping Engine

[![Architecture](https://i.imgur.com/mF1dbXI.png "Architecture")](https://i.imgur.com/mF1dbXI.png "Architecture")`

#### Jhipster Registry
-  Service Discovery based from Spring cloud, and eureka.
- This where our microservices gets registered(oauth2 server, salamat-shopee , api gateway)


#### Gateway
-  Gateway is the API Gateway where we expose the rest apis of salamat shopee app, and oauth2 resource
- at the moment this also contains the frontend code


#### Salamat Shopee/Shopping-API
-  Contains the  business logic for cart and orders 

#### UAA
- is the oAuth2 component of the app responsible for the Authentication and authorization. API Gateway uses Feign client to communicate with the oauth2 server

Given the nature of the design and limitations of my machine I needed to combine the Cart Service, Product Service in Shopping-api

###Set up
1. Create 2 Schemas in MySQL namely uaa, and shopee
2. Change the connection String on application.dev.yml for both uaa, and shopee

### How to run

1.) run the jhipster-registry first by executing ```mvnw.cmd```
2.) run the uaa/oauth2 server by executing ```mvn spring-boot:run```
3.) run the Gateway by execute ```mvnw.cmd```
4.) run the the shopeepee/shopping cart api by executing ```mvn spring-boot:run```
