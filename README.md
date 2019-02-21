# Hammerhead Interview Development Asssignment

Start by forking this repo and solving the problem with completed instructions for building/running.

Open a PR against the original hammerheadnav/interview repo when you're finished.

## Instructions

Write a simple program in a language of your choice that has implementations for three "services" (Strava, RWGPS, and Komoot).

Results should be printed to standard output after following the build instructions.

### Services

Each service has the ability to get routes. Services can retreive all routes or retrieve routes for a specific user.

#### Strava

* Has fixed routes  `["SRT", "CVT", "Perkiomen"]`
* For user routes, Strave prepends the user id onto the route.

#### RWGPS

* Has fixed routes  `["CVT", "Perkiomen", "Welsh Mountain"]`
* For user routes, RWGPS appends the user id onto the route.

#### Komoot

* Has fixed routes  `["SRT", "Welsh Mountain", "Oaks to Philly"]`
* For user routes, Komoot prepends *and* appends the user id onto the route.

### Results

The code should have the following functionality:

#### All Routes

Return the list of the routes across all services.

#### Unique Routes

Return a *unique* list of the routes across all services.

#### All User Routes

Given a user id and return a list of all the routes the user has across all services.

#### Users Routes by Service

Given a user id and a subset of the list of services (e.g. `["Strava", "Komoot"]`)
return the user's routes for only the services listed.


## Building/Running

These instructions are assuming you are on a *NIX system.

##### Configuring Postgresql.

A Running postgresql server is required in order for this project to function correctly.

NOTE: if the database connection information needs to be updated with different values, changes can be made
in the src/main/resoureces/application.properties file.

##### Running Postgresql in docker.

While docker is not required for this project, it makes setup easy. 
the shell script postgres-docker.sh is included to help manage docker containers.
commands are create,start,stop,destroy'

Assuming docker and the docker daemon has already been installed run 
```$bash
docker pull postgres
to pull the latest postgresql docker image
then run 

```$bash
./postgres-docker.sh create
```

followed by 

```$bash
./postgres-docker.sh start
```

The default username and password for this postgres image is simply 
user: postgres
password: password

##### Migrating with flyway

The database structure and data is managed using flyway migrations. The flyway binary has been included in this project
for convenience.

from the flyway-5.1.3 directory, run the command 

```$bash
./flyway -schemas=<schemas> -locations=filesystem:../sql/flyway/migration/ -url=<jdbcUrl> -user=<jdbcUser> migrate
```

##### Building

from the root of the project directory, use the included gradlew file to assemble the source. 

```$bash
./gradlew clean assemble
```

to run the web service, from the root of the project run

```$bash
java -jar build/libs/hammerhead-1.0-SNAPSHOT.jar
```

NOTE:  port 8080 must be open in order to run.

##### Testing

Integration tests require that the postgresql database connection be up, running and migrated. 

the tests can be run using.

```$bash
./gradlew test
```
##### Rest endpoints 

- All Routes

```$bash
curl 'http://localhost:8080/service/route
["SRT","CVT","Perkiomen","CVT","Welsh Mountain","Perkiomen","SRT","Welsh Mountain","Oaks to Philly"]
```

- Unique Routes

```$bash
curl 'http://localhost:8080/route
["SRT","CVT","Perkiomen","Welsh Mountain","Oaks to Philly"]
```

- All User Routes

```$bash
curl 'http://localhost:8080/user/42/route'
["42SRT","42CVT","42Perkiomen","42CVT","42Perkiomen","42Welsh Mountain","42SRT","42Welsh Mountain","42Oaks to Philly"]
```

- All User Routes by Service
```$bash
curl 'http://localhost:8080/user/42/route?service=Komoot,Strava'
["42SRT","42CVT","42Perkiomen","42SRT","42Welsh Mountain","42Oaks to Philly"]
```

