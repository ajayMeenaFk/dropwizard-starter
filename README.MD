**Pointers**
* Curl test resource
    `curl -X GET http://localhost:8080/test`
* curl health check to see app is healthy or not
    `curl -X GET http://localhost:8081/healthcheck`
* dropwizard offers managed object that is usefull when we want to start certain service or want to cache some data before serving requests in web server  
* Need to check auth before processing request in server
    * Check in each resource method for auth
    * Use dropwizard's dynamic feature to set auth
    * Can be added jersey filters for this purpose
* dropwizard bundle
     * <a href ="https://stackoverflow.com/questions/34825213/how-to-create-my-own-custom-dropwizard-bundle"> read about bundles </a>
     * <a href ="http://www.dropwizard.io/0.7.1/docs/manual/migrations.html"> db migration </a>