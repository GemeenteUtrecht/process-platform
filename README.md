# Process platform

- Goal
    - Spring boot with Camunda as Process engine
        - https://github.com/camunda/camunda-bpm-spring-boot-starter
        - https://docs.camunda.org/manual/develop/user-guide/spring-boot-integration/
    - NLX service layer to connect with API's
    - Hosts Bing process with generic components
    - Custom generic process component's to be used within the Camunda modeler
        - Component for Zaak creation of any type
        - Component for set Status of any type
        - Component for set Result of any type
        - Component for set Notification of any type
        - Component for link Document of any type

# Status aanpassen via een task

Kopier de volgende regel: ```${statusExecutionListenerImpl.setStatus(execution, 1)} ```
Pas het volgnummer aan van 1 naar het gewenste nummer.

![Alt text](documentation/images/tutorial-set-status.png?raw=true "Title")

## BInG application

The `docker-compose.yml` services definition contains everything to start
the BInG application. This application can be used to actually go through the
flow to submit a project, which starts the Camunda process.

### Requirements

You need to have an NLX outway running to be able to access the APIs hosted in
the Utrecht network - see the [NLX documentation](https://docs.nlx.io/get-started/).

In particular, it's expected that you are running the outway on port 12018 on
your localhost machine. If you choose different ports/machines, make sure to
update the configuration in `bing-demo.json`.

### Running the BIng application

Start up the application:

```bash
docker-compose up
```

**Fixtures**

The fixtures contains start-up data for the environment. They are loaded
automatically when starting the application via docker-compose.

* It assumes the docker host is available on `172.17.0.1` - if this is another
  IP address, please replace all occurrences of `172.17.0.1` with the appropriate
  IP address in `bing-demo.json`. You can determine this by running `ip addr`
  and looking for the `docker0` interface.

* The default superuser account is `demo` with password `demo`. You can login
  on http://localhost:8000/admin/

**Application layout**

* A database (PostgreSQL) that stores the data in a volume
* A web app, available on http://localhost:8000
* An asynchronous worker, processing the tasks scheduled by the web app
* Web app and worker communicate via Redis.

All of these parts are linked together in the docker-compose.

**Different version**

The current definition starts BInG version 0.11.2. You can override this by
creating a `.env` file with the following contents:

```
BING_VERSION=0.11.3
```

If the port 8000 is already taken, you can change the BInG port via the `.env`
file as well:

```
PORT=9000
```

## Docker image

There is a docker hub repository available that contains a pre-built image ready to run:

https://cloud.docker.com/u/scrumteamzgw/repository/docker/scrumteamzgw/process-platform/general

To launch the docker image you need to specify the following environment variables:

Server port:
> SERVER_PORT with your server port. Default 8080.

MySQL database:      
> SPRING_DATASOURCE_URL with value: jdbc:mysql://{hostname}:3306/{schema_name}

> SPRING_DATASOURCE_USERNAME with your MySQL username

> SPRING_DATASOURCE_PASSWORD with your MySQL password

Admin login:
> CAMUNDA_BPM_ADMINUSER_ID with your admin username (default AdminAccountGemeenteUtrecht)

> CAMUNDA_BPM_ADMINUSER_PASSWORD with your admin password

NLX API's:
> NLX_TOKEN with your JWT token

> NLX_ZAAK with the REST endpoint for zaken API

> NLX_CATALOGUSZAAKTYPE with the REST endpoint for the catalogi API

> NLX_STATUS with the REST endpoint for the statussen API

> NLX_DOCUMENT with the REST endpoint for the object informatie objecten API

> NLX_RESULTAAT with the REST endpoint for the resultaten API

> NLX_NOTIFICATIE with the REST endpoint for the notificaties API
