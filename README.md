### Mal och Curl

1.

Mal: Skapa grupper av användare<br>
Curl:<br>
<code>
curl --location --request POST 'http://localhost:15001/api/v1/group?name=taxi_group&type=bus'
</code>

2.

Mal: Registrera nya användare i en grupp<br>
Curl:<br>
<code>
curl --location --request POST 'http://localhost:15001/api/v1/group/add/user?groupId=103&userId=10'
</code>

3.

Mal: Lägga till fordon till gruppen<br>
Curl:<br>
<code>
curl --location --request POST 'http://localhost:15001/api/v1/group/add/vehicle?groupId=2&vehicleId=2'
</code>

4.

Mal: Ta bort fordon från gruppen<br>
Curl:<br>
<code>
curl --location --request DELETE 'http://localhost:15001/api/v1/group/delete/vehicle?groupId=1&vehicleId=1'
</code>

5.

Mal: Hämta en lista över fordon som finns i gruppen<br>
Här ska det även framgå vart fordonet är placerat och ifall den är tillgänglig eller redan används av en annan
gruppmedlem.
<br>
Curl:<br>
<code>
curl --location 'http://localhost:15001/api/v1/vehicle/group/52'
</code>

6.

Mal: Sätta ett visst fordon i gruppen som är upptagen. Det ska även gå att sätta hur länge fordonet förväntas vara
upptagen
<br>Tiden ska utgå från en rutt hämtad från api:et som hanterar enskild transport.
<br>
Curl:<br>
<code>
curl
--location 'http://localhost:15001/api/v1/group/route/find?groupId=2&from=GARDEN_MALL&to=LIBRARY&transportMethod=driving'
</code>

7.

Mal: Registrera grupp-promenader<br>
Curl:<br>
<code>
curl --location --request POST 'http://localhost:15001/api/v1/group?name=taxi_group&type=walking'
</code>

8.

Mal: Avregistrera promenader<br>
Curl:<br>
<code>
curl --location --request DELETE 'http://localhost:15001/api/v1/group/delete/user?groupId=102&userId=8'
</code>

9.

Mal: Hämta grupp-promenader<br>
Promenadens rutt hämtas från tjänsten som hanterar enskild transport (se kategori 1).
<br>
Curl:<br>
<code>
curl
--location 'http://localhost:15001/api/v1/group/route/find?groupId=2&from=GARDEN_MALL&to=LIBRARY&transportMethod=walking_and_cycling'
</code>