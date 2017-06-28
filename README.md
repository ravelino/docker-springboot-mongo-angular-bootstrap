## docker-springboot-mongo-angular-bootstrap

Projeto para aprendizagem utilizando as seguintes tecnologias:
* Docker
* Springboot
* Restful
* MongoDB
* AngularJs
* Bootstrap


### Como subir o projeto, requisitos:
* JDK 1.8
* Maven 3
* Docker e Docker-compose

> Obs: O projeto foi buildado com GNU/Linux Fedora 25, então todos os passos descritos a seguir são referentes ao mesmo!

#### Execute o comando no terminal para iniciar o docker:

```sh 
$ systemctl start docker
```

#### Logo depois de iniciar o docker, execute o comando no terminal para subir a aplicação

```sh
$ docker run -it -p 27017:27017 --name mongodb mongo:3.4 /usr/bin/mongod --smallfiles && cd app-domain/ && mvn clean install && cd .. && docker stop $(docker ps -qa) && docker rm mongodb && docker build -f restClientDockerfile -t rogerioavelino/app-rest-client-docker . && cd app-rest-service-docker/ && mvn clean package docker:build && cd .. && docker-compose up -d
```

Espere baixar e subir container do mongoDB até a mensagem "waiting for connections on port 27017" do mongo aparecer, então aperte:
``` ctrl + p + q ```
para sair do console do mongo e continuar a subir a aplicação.

##### Logo quando terminar, acesse a aplicação pelo link -> [http://localhost:8383/index.html]
