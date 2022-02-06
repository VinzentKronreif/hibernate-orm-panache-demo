# Hibernate ORM with Panache demo project
Vinzent Kronreif

## Description
This demo-project is all about fruits. You can add fruits, show all fruits or search for seasons of the fruits.

## How to start the program
Start Database:
```bash
docker run --ulimit memlock=-1:-1 -it --rm --memory-swappiness=0 \
           --name postgres-db -e POSTGRES_USER=app \
           -e POSTGRES_PASSWORD=app -e POSTGRES_DB=db \
           -p 5432:5432 postgres:12.4
```
Start Prgram:
```bash
./mvnw clean compile quarkus:dev
```