## Spring boot application with KeyCloak

### Prerequisite 
* run KeyCloak server
* create realm `sample-application-1`
* create client `client-1`
* set redirect url `http://localhost:8082/*`
* create user and role according to your need

### Run app and go to following url to test

* http://localhost:8082/ `[OPEN]`
* http://localhost:8082/customer `[need auth]`