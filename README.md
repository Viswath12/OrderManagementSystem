# OrderManagementSystem
A order management system application consists of the below sub-modules

	1. ServiceRegistry - Spring boot Eureka registry for services discovery
	2. OrderItemService - Spring boot microservice for managing orderitems
	3. OrderService - Spring boot microservice for managing orders. Uses Feign Client to call OrderItemService and save orderitems.
	
Both OrderItemService and OrderService uses H2 In-memory database for data storage/retrieval and Zalando Problem dependecy to handle REST Exceptions.

Further Improvements that can be added to improve stability of the entire system

	1.  Can user Circuit Breaker pattern using Hystrix when calling other services using Feign Client - So that when called service fails, the caller can be fail-fast and fail-safe.
	
