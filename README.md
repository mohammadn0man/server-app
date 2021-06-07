# Project

### POST add user
http://localhost:8082/api/user/signup

Bodyraw (json)

#### JSON

{
"userName": "Gamma",
"password": "0000",
"fullName": "hrma ara s"
}

### POST
authenticate

http://localhost:8082/api/user/authenticate

Bodyraw (json)

#### JSON
{
"username": "theta",
"password": "0000"
}

### POST
ask_question

http://localhost:8082/api/question/solution

Request Headers

Authorization
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjk0MTc5OSwiaWF0IjoxNjIyOTA1Nzk5fQ.vDlIleQAbq7mTjSbu0c9o0Yhmj6oxDrMWEmM08zBHyU

Bodyraw (json)
#### JSON
{
"questionId": 1,
"replyId": 17
}
### POST
add_reply

http://localhost:8082/api/reply/add

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjc0MzUxMiwiaWF0IjoxNjIyNzA3NTEyfQ.p7_xoDPu8QjRGUJkS1p4hv6FwAXviXFQHCs7R5ZPWOA

Bodyraw (json)

#### JSON

{
"userId": "10002",
"questionId": "1",
"text": " a positivity rate of less than 5 per cent for a week, 70 per cent vaccination rate for vulnerable population and community-ownership of Covid-appropriate behaviour.In terms of preventing the third wave, it is very simple that districts with less than 5 per cent positivity should open up a little bit they should open very gradually. They should ensure that the vulnerable population should achieve at least 70 per cent vaccination if that has not been achieved, they should vaccinate them and then open up, he said."
}

### GET
logout

http://localhost:8082/api/user/logout

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZWxsc2RmYSIsImV4cCI6MTYyMjQ5NTU4MSwiaWF0IjoxNjIyNDU5NTgxfQ.lnx0kPRsgqo1L3-D0z1VYc6Im5BZMbK0Se7i8XTGtWo

### GET

reply/<id>

http://localhost:8082/api/reply/16

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjMwOTcwMiwiaWF0IjoxNjIyMjczNzAyfQ.fioCBmrzKxWGOSgeX33WDa3XVl7v75OP02dxrFXWjUM

### GET

question_reply/<questionID>

http://localhost:8082/api/reply/question/1

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjIyODU4NywiaWF0IjoxNjIyMTkyNTg3fQ.lt7YvlC_G-BzinM9bLye0pJAPfIwLidFWMBnmKWcOTQ

### GET

question_by_product/<productID>

http://localhost:8082/api/question/get/product/1

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjIyODU4NywiaWF0IjoxNjIyMTkyNTg3fQ.lt7YvlC_G-BzinM9bLye0pJAPfIwLidFWMBnmKWcOTQ

### GET

question_by_user/<userID>

http://localhost:8082/api/question/get/user/10003

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjIyODU4NywiaWF0IjoxNjIyMTkyNTg3fQ.lt7YvlC_G-BzinM9bLye0pJAPfIwLidFWMBnmKWcOTQ

### GET

all products

http://localhost:8082/api/product/get

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZWxsc2RmYSIsImV4cCI6MTYyMjQ5NTU4MSwiaWF0IjoxNjIyNDU5NTgxfQ.lnx0kPRsgqo1L3-D0z1VYc6Im5BZMbK0Se7i8XTGtWo

### POST

like_reply

http://localhost:8082/api/reply/like

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjc0MzUxMiwiaWF0IjoxNjIyNzA3NTEyfQ.p7_xoDPu8QjRGUJkS1p4hv6FwAXviXFQHCs7R5ZPWOA

Bodyraw (JSON)

#### JSON

{
"userId": "1002",
"replyId": "18"
}

### GET

get_like/<replyId>

http://localhost:8082/api/reply/get/like/18

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjg0MjEyOSwiaWF0IjoxNjIyODA2MTI5fQ.4xJd_DwYlrmxiOKvmhLcwlPr5F8XUUPJcYjamm5XnsY

### GET

search?query=<>&sort=

http://localhost:8082/api/question/get?sort=&query=

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjIyODU4NywiaWF0IjoxNjIyMTkyNTg3fQ.lt7YvlC_G-BzinM9bLye0pJAPfIwLidFWMBnmKWcOTQ

Request Params

sort
query
before
after

### GET

stats api

http://localhost:8082/api/stats/get

### POST

solution

http://localhost:8082/api/question/solution

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjk0MTc5OSwiaWF0IjoxNjIyOTA1Nzk5fQ.vDlIleQAbq7mTjSbu0c9o0Yhmj6oxDrMWEmM08zBHyU

Bodyraw (json)

#### JSON

{
"questionId": 1,
"replyId": 17
}

### POST

ask_question

http://localhost:8082/api/question/ask

Request Headers

Authorization

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGV0YSIsImV4cCI6MTYyMjk0MTc5OSwiaWF0IjoxNjIyOTA1Nzk5fQ.vDlIleQAbq7mTjSbu0c9o0Yhmj6oxDrMWEmM08zBHyU

Bodyraw (json)

#### JSON
{
"userId": "10003",
"productId": "1",
"title": "new asdf asdfuas da casd fasidf cas ;dif",
"subject": "sfasd",
"text": "asdfas"
}