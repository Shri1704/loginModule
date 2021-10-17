Register

curl --location --request POST 'http://localhost:8080/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "admin2",
    "age": 20,
    "email": "admin@admin.com",
    "address": {
        "address": "abc",
        "street": "bbb",
        "city": "vvv",
        "state": "state",
        "country": "country",
        "postalCode": "12345"
    },
    "phoneNumber": 1234567890,
    "userName": "admin",
    "password": "admin"
}'
----------------------------------------------------------------------------------
Activate

curl --location --request PUT 'http://localhost:8080/activate-account' \
--form 'otp="487741"' \
--form 'userName="admin"'
----------------------------------------------------------------------------------
Login

curl --location --request GET 'http://localhost:8080/login' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='
---------------------------------------------------------------------------------
Forget password

curl --location --request POST 'http://localhost:8080/forget-password?userName=admin'
------------------------------------------------------------------------------------
Reset password

curl --location --request POST 'http://localhost:8080/reset-password?userName=admin&otp=605301&password=admin'
---------------------------------------------------------------------------------------
User Details update
curl --location --request PUT 'http://localhost:8080/userDetails' \
--header 'X-CSRF-Token: 4bfd1575-3ad1-4d21-96c7-4ef2d9f86721' \
--header 'Authorization: Basic YWRtaW46YWRtaW4=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "admin2",
    "age": 20,
    "email": "admin@admin.com",
    "address": {
        "address": "abc",
        "street": "bbb",
        "city": "vvv",
        "state": "state",
        "country": "country1",
        "postalCode": "123456"
    },
    "phoneNumber": 1234567890,
    "userName": "admin",
    "password": "admin"
}'
----------------------------------------------------------------------------------------------------------------