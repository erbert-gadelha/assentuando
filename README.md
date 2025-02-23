
# Assentuando
Gerencie seus assentos com facilidade.
![ezgif-1fbc037500fa86](https://github.com/user-attachments/assets/11d02767-e390-41d3-9789-976b6546d28a)

Aplicação web para gerenciamento de poltronas em uma sala. Foram utilizadas as tecnologias **Spring Boot**, **Angular** e **PostgreSQL**, orquestrados por **Docker Compose**.

----------

## Deploy na Railway
Há um deploy da aplicação executando em plano gratuito na [railway](https://railway.com/), portanto é normal passar por instabilidades. O deploy da aplicação foi dividido em [backend](https://assentuando-backend-production.up.railway.app/) e [frontend](https://assentuando-frontend-production.up.railway.app/), e podem ser acessados nos links anexos.
##  Como Executar via Docker Compose
clone o repositório baixando diretamente do seu navegador, ou via CLI.

    git clone https://github.com/erbert-gadelha/assentuando
    cd assentuando
execute o comando docker na pasta raiz da aplicação

    sudo docker-compose up --build

### Acessando a aplicação
apois subir os containers a aplicação deve ficar dispoível localmente nos seguintes endereços    
   -   **Frontend (Angular):**  [http://localhost:4200](http://localhost:4200)
        
-   **Backend (Spring Boot):**  http://localhost:8080
        
----------

## **Documentação**
o backend da aplicação é documentado via Swagger. Para vizualizar as rotas disponíveis acesseo endereço `localhost:8080`/docs.

O mockup da aplicação foi realizado no [figma](https://www.figma.com/design/GyV6SM5YRd4IfodEJwUqT7/Gest%C3%A3o-de-Poltronas?node-id=0-1&t=LDQtJJ8f4j2ckv6F-1) e pode ser acessado no link anexo.
