docker network create kanban-network<br>
docker run --name kanbandb --network kanban-network -e MYSQL_USER=freedom -e MYSQL_PASSWORD=123 -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=kanbandb -e TZ=Asia/Bangkok -p 3306:3306 -d --restart=always mysql:8.0<br><br>

add<br>
compileOnly 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.3'<br>
cmd C:\Users\%user%\.gradle\caches\modules-2\files-2.1\org.jasypt\jasypt\1.9.2\91eee489a389faba9fc57bfee75c87c615c19cd7<br>
java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="123" password=secretkey algorithm=PBEWithMD5AndDES
Environment variables: jasypt.encryptor.password=secretkey<br>
