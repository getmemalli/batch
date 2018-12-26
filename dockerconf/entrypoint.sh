#!/bin/sh

java $JAVA_OPTS -Dspring.profiles.active=$APP_MODE -jar app.jar