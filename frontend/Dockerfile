FROM node:alpine

WORKDIR /usr/src/app
COPY package-lock.json /usr/src/app
COPY package.json /usr/src/app
RUN npm install -g @angular/cli
RUN npm install
COPY . /usr/src/app

EXPOSE 4200

CMD ["ng", "serve"]
