FROM mhart/alpine-node:latest

MAINTAINER Your Name <you@example.com>

# Create app directory
RUN mkdir -p /fw-r-cljs-v3
WORKDIR /fw-r-cljs-v3

# Install app dependencies
COPY package.json /fw-r-cljs-v3
RUN npm install pm2 -g
RUN npm install

# Bundle app source
COPY target/release/fw-r-cljs-v3.js /fw-r-cljs-v3/fw-r-cljs-v3.js
COPY public /fw-r-cljs-v3/public

ENV HOST 0.0.0.0

EXPOSE 3000
CMD [ "pm2-docker", "/fw-r-cljs-v3/fw-r-cljs-v3.js" ]
