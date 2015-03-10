### Nodcloud Dashbord

Nodcloud web application

## Folder

-- nodcloud-dashbord (root project)

 -- nodcloud-sdk (sdk module private cloud api)

 -- nodcloud-module (project common util and other from springside)

 -- nodcloud-persistent (database entity and repository)

 -- nodcloud-service (business logic and service)

 -- nodcloud-web (nodcloud web application)

## For Developer

### How To Setup develope enviroments

1, Install Vgarant

```
vagrant box add base https://cloud-images.ubuntu.com/vagrant/precise/current/precise-server-cloudimg-i386-vagrant-disk1.box
```

2, Godo Project Root

```
Vagrant up
```
>This step will automate install mysql, the username and password is development/development database is development. You can use 127.0.0.1:3306 to access the mysql-server

3, Add VM options

```
-Djdbc.driver=com.mysql.jdbc.Driver
-Djdbc.url=jdbc:mysql://127.0.0.1:3306/development
-Djdbc.username=development
-Djdbc.password=development
-Dqingcloud.endpoint=https://api.qingcloud.com/iaas/
-Dqingcloud.accessKeyId=MUFQEIVRZNIUIVOHURVF
-Dqingcloud.secretKey=JvDGFZqGpzVP6rPOPFlUTnJ7GIIhFJvSOR11loVP
-Dgithub.clientId=f1a49f548bf966ac6e85
-Dgithub.clientSecret=d425876030b7c8c98f49b6539d765eaeb760a092
-Dgithub.accessTokenUrl=https://github.com/login/oauth/access_token
-Dgithub.userInfoUrl=https://api.github.com/user
-Dgithub.redirectUrl=http://localhost:8080/nodcloud/oauth2-login
```

4, Start local server

### How To Run

__Checkout Code__

```
git clone git@git.xt1728.com:yangfei/nodcloud.git nodcloud-dashbord
```

__Run In Local__

```
cd <ProjectRoot>/nodcloud-web
```

```
mvn jetty:run
```

> Default user admin/admin123