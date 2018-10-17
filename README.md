## Creating sample producer and consumer using Spring boot

* This repo has sample consumer and producer services.
* Account service acts as consumer. User service acts as producer.
* Both of them are exposed at same port with different base URI (/account for account and /user for user) (6060)
* Account service uses /user end point to create an account.
* Clone this repo.
* Do a maven build.

    ```mvn clean install```

* To start the application run:

    ``` java -jar target/demo-0.0.1-SNAPSHOT.jar ```

* Import below curls in postman to interact with the application.

### To create an account

```
  curl -X POST \
  http://localhost:6060/account/create \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: cdc94bd1-177a-4028-8f29-dcb4e40fa721' \
  -H 'cache-control: no-cache' \
  -d '{
	"fullName": "santosh",
	"phone":"1234566",
	"email" : "xyz@xyx.com",
	"desc": " Testing 1"
}'

```

### To get all accounts created

```
curl -X GET \
  http://localhost:6060/account/ \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: b25db8ed-99f6-4d44-877e-b7a095a01a49' \
  -H 'cache-control: no-cache'
  
```

### To get a paticular account details [ replace { account_id } with actual value - {} also not needed ]

```
curl -X GET \
  http://localhost:6060/account/{account_id} \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 0dd5fcc1-d15b-4980-a456-c887df21487d' \
  -H 'cache-control: no-cache'
  
```
