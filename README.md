# ObligatorioWhile

El obligatorio tiene como objetivo agregar funcionalidades al lenguaje While dictado en el curso. 

Integrantes: Juan Lemos, Mauricio Coniglio, Cynthia Duhalde, Fernando Torterolo

[NIELSON1999] (http://www.daimi.au.dk/~bra8130/Wiley_book/wiley.html)
H.R. Nielson & F. Nielson: "Semantic with Applications: A formal introduction". John Wiley & Sons, revised edition ISBN 0-471-92980-8.


## Reglas

| Numero | Descripción Regla                                                                                                                                     | Desarollo | Test |
|--------|-------------------------------------------------------------------------------------------------------------------------------------------------------|-----------|------|
| 1      | Que no exista más de un salto de línea entre dos líneas de código consecutivas.                                                                       |           |      |
| 2      | Que haya solo un statement por línea                                                                                                                  |           |      |
| 3      | Detectar funciones declaradas sin llamar                                                                                                              |           |      |
| 4      | Detectar variables declaradas sin usar                                                                                                                |           |      |
| 5      | Detectar código que no se va a ejecutar. ej:                                                                                                          |           |      |
| 6      | Detectar código muerto, Ejemplo: '' if (15>10) { /**/ } else { /* esto no se ejecuta nunca */ }''                                                     |           |      |
| 7      | Los nombres de la variables deben comenzar con minúsculas y sin guiones bajos                                                                         |           |      |
| 8      | Los nombres de los métodos deben comenzar con minúsculas                                                                                              |           |      |
| 9      | Uso de variables no definidas                                                                                                                         |           |      |
| 10     | Chequear llamado a funciones que en el caso que se quiera asignar su retorno retornen algo y el tipo coincida.                                        |           |      |
| 11     | Chequear que la cantidad de variables que se le pasa a una función sea igual a la definición así como los tipos.                                      |           |      |
| 12     | Detectar parámetros de funciones que no son utilizados.                                                                                               |           |      |
| 13     | Chequear que las funciones que deben devolver algo lo hagan y lo hagan en el tipo definido en la firma así como las que no devuelven nada no lo hagan |           |      |
| 14     | No se puede redefinir funciones                                                                                                                       |           |      |
| 15     | No se puede redefinir variables                                                                                                                       |           |      |
| 16     | Comprobar que el tipo de la variable y la expresión coincidan al momento de asignar                                                                   |           |      |
| 17     | No se puede tener paréntesis superfluos                                                                                                               |           |      |
| 18     | No se puede tener llaves superfluas                                                                                                                   |           |      |
| 19     | no escribir nombres de variables o métodos iguales pero que se diferencien en solamente en mayúsculas y minúsculas Ej no permitido                    |           |      |
| 20     | numeric a=23; numeric A=23 Solamente uno de los debería existir pero no los dos                                                                       |           |      |
| 21     | No permitir redefinición de variables con el mismo nombre dentro de las funciones como variables locales                                              |           |      |
| 22     | Warning expresiones con más de 7 operadores.                                                                                                          |           |      |
| 23     | Warning sentencias con más de 5 anidaciones.                                                                                                          |           |      |
