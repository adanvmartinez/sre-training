FROM ubuntu 

LABEL Author="Adan Martinez"

#installs nginx
RUN apt-get -y update && apt-get -y install nginx

#copies configuration in current directory to the directory in the container
COPY default /etc/nginx/sites-available/default

#don't need to specify tcp, but might as well (Port number should be enough)
EXPOSE 80/tcp

#This command starts nginx on boot (only one CMD line per file)
CMD [ "/usr/sbin/nginx", "-g", "daemon off;"]

