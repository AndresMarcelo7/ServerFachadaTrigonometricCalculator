# Servidor Spark Fachada y Cliente :D

Andres Felipe Marcelo
Segunda parte parcial 1 AREP

## Available Servers:
- Servidor Fachada (This Repo): 
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://parcialarepcalcfachada.herokuapp.com/)
[![CircleCI](https://circleci.com/gh/AndresMarcelo7/ServerFachadaTrigonometricCalculator.svg?style=svg)](https://circleci.com/gh/AndresMarcelo7/ServerFachadaTrigonometricCalculator)

- Servidor Logico (![ Link to GitHub Repo](https://github.com/AndresMarcelo7/TrigonometricCalculatorServer)):
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://parcialarepcalc.herokuapp.com/)
[![CircleCI](https://circleci.com/gh/AndresMarcelo7/TrigonometricCalculatorServer.svg?style=svg)](https://circleci.com/gh/AndresMarcelo7/TrigonometricCalculatorServer)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
### Prerequisites

The things you need in order to run this proyect on your computer are:
- Maven
- Git  
- Java
- Heroku CLI (If you want to deploy this app by yourself)

Make sure you have this installed with the commands
```
mvn --version
```
```
git --version
```
```
java -showversion
```
and 
```
heroku -v
```

IMPORTANT : This project was developed with Java V1.8

### Installing
Please clone this repository on your computer with the command:

```
git clone https://github.com/AndresMarcelo7/ServerFachadaTrigonometricCalculator
```
Once finished, you must navigate into the project and execute the command 'mvn package' like this:
```
cd /ServerFachadaTrigonometricCalculator
```
And finally please run the command 
```
mvn package
```
Here, mvn package Builds the project and packages the resulting JAR file into the target directory.

## Run

If you want to locally run the app use the following command:
```
java -cp target/classes edu.eci.arep.parcialArepFachada.client.Client
```
Then the client will make 2 requests:  
- 1 to the "Server Fachada"
- 1 to the "Server Calc"  
Both Hosted in heroku.