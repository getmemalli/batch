# Batchmate

#### Pre-requisites

##### Install brew, docker , gradle, java 8 

First install Brew on your MAC

- Setup Brew: `ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
- `brew update`

##### Install java 8

- brew tap caskroom/versions
- brew cask install java8

##### Install gradle

[Gradle install](https://gradle.org/install/)

#### Download oracle jdk 8

[Download oracle jdk 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


## Set up instructions ( for development )

### (Docker)

* [Refer Docker](readme-docker.md)


### (IntelliJ IDEA)

* Install IntelliJ IDEA
* Navigate to RUN -> Edit Configurations ->  Add New Configuration -> Application and add following properties
* Main class : com.razorpay.batch.BatchApplication
* VM options : -Dspring.profiles.active=dev
* Working directory : Source code folder
* JRE : 1.8

