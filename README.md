# TC2019BDDWorkshop
This is what we've done during TestCamp 2019 BDD Workshop "Integruj ogorkiem" workshop. Full description in Polish below:

Repozytorium powstało w czasie warsztatów "Integruj ogórkiem" w czasie TestCamp 2019. 
API z którego korzystamy to API Trello - na specjalnie na warsztat założonym koncie Trello (jrosinski@thinkingdriventesting.com / TestCamp2019) 
Najpierw pokazaliśmy przykłady pracy z RestAssured (po prostu w testach) i różnice pomiędzy Response i ValidatableResponse. 
Następnie dopięliśmy do powyższego Cucumbera i w klasie StepsDef opisaliśmy kroki (zakomentowane aktualnie) 
Na koniec dodana została warstwa abstrakcji, czyli klasa obsługująca Boardy Trello i dopiero na jej metodach następowały działania w StepsDef (stan aktualny)
