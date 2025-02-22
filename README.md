# Assentuando
Gerencie seus assentos com facilidade.
![ezgif-1fbc037500fa86](https://github.com/user-attachments/assets/11d02767-e390-41d3-9789-976b6546d28a)

Aplicação web para gerenciamento de poltronas em uma sala. Foram utilizadas as tecnologias **Spring Boot**, **Angular** e **PostgreSQL**, orquestrados por **Docker Compose**.

----------

##  Como Executar via Docker Compose
clone o repositório baixando diretamente do seu navegador, ou via CLI.

    git clone https://github.com/erbert-gadelha/assentuando
    cd assentuando
execute o comando docker na pasta raiz da aplicação

    sudo docker-compose up --build

## Acessando a aplicação
apois subir os containers a aplicação deve ficar dispoível localmente nos seguintes endereços    
   -   **Frontend (Angular):**  [http://localhost:4200](http://localhost:4200)
        
-   **Backend (Spring Boot):**  http://localhost:8080
        
----------

## **Documentação**
o backend da aplicação é documentado via Swagger. Para vizualizar as rotas disponíveis acesseo endereço `localhost:8080`/docs
