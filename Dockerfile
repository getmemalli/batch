FROM java:8

COPY ./build/libs/* /src/app/app.jar
COPY ./dockerconf/entrypoint.sh /src/app/dockerconf/entrypoint.sh

WORKDIR /src/app

RUN chmod +x dockerconf/entrypoint.sh

EXPOSE 8080

ENTRYPOINT  ["dockerconf/entrypoint.sh"]

