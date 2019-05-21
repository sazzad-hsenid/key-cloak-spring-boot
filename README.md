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

### CURL command to get token

```
curl -X POST \
  http://localhost:8081/auth/realms/sample-application-1/protocol/openid-connect/token \
  -H 'Accept: */*' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'username=user1&password=123456&client_id=client-1&grant_type=password'

```

### CURL command to get protected resource with token

```
curl -X GET \
  http://localhost:8082/customer \
  -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpaHdJeE9zS25VRTJYbGVleG5ydWJwTlhEY1RvaDBlSG5TNnpSUldsMWFFIn0.eyJqdGkiOiIyNmZhYjk1OC1hMGJiLTRlNzMtOTY3Yy03M2Q5MmZlM2NhMzMiLCJleHAiOjE1NTgzNDM3NjYsIm5iZiI6MCwiaWF0IjoxNTU4MzQzNDY2LCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODEvYXV0aC9yZWFsbXMvc2FtcGxlLWFwcGxpY2F0aW9uLTEiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiOTI2MGI3ZTgtM2I4Zi00OWJmLThiYTMtYjlkMDJkOTFmZDBlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiY2xpZW50LTEiLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiJiODBhMGIwOS1kYzNlLTQxMjQtOWViZC1jNWZmMGRiMWU1M2YiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJ1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyMSJ9.UfsU6Z4pdBRLBuD4yjl716Mh9YTmfHpzFewgoDjHFmPw3RVU7EkKpoyCmn1PXUBaU_8bOgbv0HNz3L6v1RXxtUsBO2sRjraiL0Elc514HQTh9ioX0vnVql5YpB5G8SgfD-zAAofskZclp1x1UOLUdwXUDQIgKd0CgGqVHQJbc2Bh8No8Q-mwauGu_khhnPLIuBw4bjTW940YQwxzj-Yn65UAaq--iPpZos6laFQqzA5uAzhBDmYH9YgcZfNce5krymm5A7-vkJ1lQ2-_XY0HUCI4d2NvF63cglYiAb3VqYKaofPvfqgvljrUEZB8My9bLB_w6i-YcU3YYd66EYKSgQ' \

```

### KeyCloak server setup with docker
`sudo docker run -p 8081:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak`
