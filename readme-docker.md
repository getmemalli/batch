# Batch

## Set up instructions via Docker( for development )


#### Pre-requisites

##### Install brew, docker , gradle, java 8 

First install Brew on your MAC

- Setup Brew: `ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
- `brew update`

##### Install gradle

[Gradle install](https://gradle.org/install/)

#### Download oracle jdk 8

[Download oracle jdk 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

##### Install docker
[Docker installation and Hello World!](https://docs.docker.com/engine/getstarted/step_one/)

##### Mac users
* Please use `Docker for Mac` and do not use `Docker Toolbox for the Mac`
* Set the Docker memory to 4GB and number of cpus to 3

##### Linux users
* sudo apt-get install docker
* pip install docker-compose
* sudo usermod -aG docker $(whoami) # Adds yourself to docker group

Now Log out and log back in once after last step.

##### Install docker-compose
[Install Docker Compose](https://docs.docker.com/compose/install/)

##### Login to Dockerhub
Ensure that you have a dockerhub user that is added to the Razorpay Organization.
 - Admin Contact: `nemo@razorpay.com`

###### Mac Users
Run Docker for Mac while signed-in as this user.

###### Linux Users
use the `docker login` command to sign-in with the aforementioned dockerhub user.

## Run docker-compose
[Create a github PAT](https://help.github.com/articles/creating-an-access-token-for-command-line-use/), if you do not have one.

```
GIT_TOKEN=<PAT>
export GIT_TOKEN
```
or,
add it to your `.bashrc`/`.bash_profile`

##### Optional configurations
Note: By default batch service will run on port 8081 and mysql on 3306. In case you wish to change these params or other ports like for elasticsearch, please modify `docker-compose.dev.yml`

For Mac Users, PATH_TO_CONTAINERS is by default ~/Library/

Now, build the containers:

```
$ make build
```

The above will take care of building a `Containerized batch app` from your
local file-system, spin up `mysql:8.0.12` container and establish connection
to run the app locally.

You should be able to access the app at:
`http://localhost:8081/`

#### Shutting down/Pausing the container

```
$ make down
```

#### Bringing the container back after it has been shut down/paused

```
$ make up
```

#### Cleaning up all container images

```
$ make clean
```


## Set up Remote debugging and Hot swap
* Install IntelliJ IDEA
* Navigate to RUN -> Edit Configurations ->  Add New Configuration -> Remote and add following properties
* Host :  Remote host ( localhost if debugging docker)
* Port : JDWP port (refer to value of address parameter in JVM arguments) 