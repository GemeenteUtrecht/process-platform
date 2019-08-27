# process-platform

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

## BInG application

The `docker-compose.yml` services definition contains everything to start
the BInG application. This application can be used to actually go through the
flow to submit a project, which starts the Camunda process.

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
