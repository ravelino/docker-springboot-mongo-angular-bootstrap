# docker-springboot-mongo-angular-bootstrap

# Como subir o projeto

# Com o docker rodando execute o comando no terminal

# Baixar um container com MongoDB e
## docker run -it -p 27017:27017 --name mongodb mongo:3.4 /usr/bin/mongod --smallfiles && cd app-domain/ && mvn clean install && cd .. && docker stop $(docker ps -qa) && docker rm mongodb && docker build -f restClientDockerfile -t rogerioavelino/app-rest-client-docker . && cd app-rest-service-docker/ && mvn clean package docker:build && cd .. && docker-compose up -d
## espere até baixar o container e a mensagem "waiting for connections on port 27017" do mongo aparecer, então aperte ctrl + p + q para sair do console do mongo e iniciar 
## o build do projeto app-domain

## ele ira baixar um container com o mongoDB e subir na porta 27017


# va ate a pasta raiz do projeto(onde se encontra o arquivo restClientDockerfile) e execute o comando:
# docker build -f restClientDockerfile -t rogerioavelino/app-rest-client-docker .

# cd app-rest-service-docker/ && mvn clean package docker:build && cd ..
