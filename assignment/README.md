This Assignment contains the following APIs

POST

http://localhost:8080/api/insert

GET - To fetch all recordsw

http://localhost:8080/api/fetchAllRecords

GET - To fetch all records with a specific error code

http://localhost:8080/api/fetchAllRecords/code/{code}

GET - To fetch all records with a specific ID

http://localhost:8080/api/fetchAllRecords/id/{id}



Note:

-> While working with this project, i first tried using H2 In-Memory Database
But there, i faced issue while handling ARRAYS data type.

-> Then i made a switch to POSTGRES and realised that JPA by default doesn't support ARRAYS

-> Then i looked upon various approaches and figured out the way to handle arrays.

-> But i wasn't able to handle a LIST<LIST<>> 
