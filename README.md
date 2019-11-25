# CSN
Proyecto para consultar eventos sismicos en distintos Paises

# Pasos para instalación del Proyecto!

- clonar proyecto desde git@github.com:agonzalezcastillo/eval.git

- debes poseer una instancia de mongoDB instalada en tu ordenador y corriendo 

- crear una nueva coleccion que se llame "events" en tu base de datos "local"
 
- ir a la carpeta raiz del proyecto e iniciar la aplicacion con el siguiente comando
```sh
./gradlew bootRun
```

- Realizar llamado al siguiente endpoint para poblar la coleccion "events" en la base local
```sh
[PUT] localhost:8080/event/1/save 
```

# Endpoints Disponibles para consulta
- consulta entre rango de fechas NOTA(startTime no puede ser menor que endTime, el sistema arrojara una excepcion controlada)
```sh
[GET] localhost:8080/event/1/date?startTime=2019-10-01&endTime=2019-10-20
```
- consulta entre rango de magnitudes NOTA(minMagnitude no puede ser menor que maxMagnitude, el sistema arrojará una excepcion controlada)
 ```sh
[GET] localhost:8080/event/1/magnitude?minMagnitude=5.3&maxMagnitude=7.5
```
- consulta entre 2 rangos de fecha NOTA(aplica misma logica de fechas anterior, sistema arrojará excepcion controlada)
```sh
[GET] localhost:8080/event/1/dateE?startTimeA=2019-10-01&endTimeA=2019-10-03&startTimeB=2019-10-06&endTimeB=2019-10-14
```
- consulta por pais
```sh
[GET] localhost:8080/event/1/country?country=chile
[GET] localhost:8080/event/1/country?country=USA
```
- consulta para contar cantidad de eventos por 2 paises y rango de fechas NOTA(paises no pueden ser iguales y aplica misma regla anterior de fechas, sistema arrojará excepcion controlada)
```sh
[GET] localhost:8080/event/1/countryE?countryA=usa&countryB=chile&startTime=2019-10-13&endTime=2019-10-20
```


