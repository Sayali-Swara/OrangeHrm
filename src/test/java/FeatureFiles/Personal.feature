@Personals
Feature: Test Personal all End points using different http request

  Background: 
    * user set base uri

  @GetSinglePersonalEmployee
  
  Scenario: Retrieve Personal Employee Entity
  
    Given user set "personals" base path
    And user get the request specification object
    And user add personal employee id "2" as path parameter
    When user select http get request to retrieve employee single entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs

     @CreateSingleEntityPersonalEmployee
  
  Scenario: Create(POST) Personal Employee Entity
  
   	Given user set "personals" base path
		And user get request specification interface object
		And user create request payload for post request 
		And user add personal customer request payload to http requests
		When user select http post request
		Then user get Validatable response interface object
		And user validate status code 201
		And user validate status line "201 Created"
		And user validate response time below 5000 ms
		And user validate response "Content-Type" and "application/json" header
		And user validate response "Date" and "Jan 2025" header 
		And user generate response logs
		
		
  @GetSinglePersonalEmployee
  
  Scenario: Retrieve Personal Employee Entity
  
    Given user set "personals" base path
    And user get the request specification object
    And user add personal employee firstname "Sayali" as path parameter
    When user select http get request to retrieve employee single entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs
    
    @GetAllPersonalEmployeeAsPerCondition
  
  Scenario: Retrieve All Personal Employee Entity
  
    Given user set "personals" base path
    And user get the request specification object
    And user add employee query parameter "city" and "Pune"
    When user select http get request to retrieve all personal employee entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs
    
    @DeleteSinglePersonalEmployee
  
  Scenario: Delete Personal Employee Entity
  
    Given user set "personals" base path
    And user get the request specification object
    And user add personal employee id "a0b2" as path parameter
    When user select http delete request to delete personal employee single entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs
    
    @GetAllPersonalEmployee
  
  Scenario: Retrieve All Personal Employee Entity
  
    Given user set "personals" base path
    And user get the request specification object
    When user select http get request to retrieve all personal employee entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs
    