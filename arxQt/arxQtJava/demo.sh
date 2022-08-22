
## kill any process using spring-boot port
#sudo kill -9 $(sudo lsof -t -i:8080)

java -jar  arxaas-2022-RELEASE.jar &

javac -cp qtjambi-6.3.3.jar MainWindow.java

java -cp qtjambi-6.3.3.jar;qtjambi-native-linux-x64-6.3.2.jar;. -Djava.library.path=/home/ibr/Qt/6.3.1/gcc_64/lib MainWindow


#modules https://github.com/OmixVisualization/qtjambi/blob/v6.3.2/www/Modules.md

# doc: https://github.com/OmixVisualization/qtjambi/blob/master/www/How-to-develop-Qt-in-Java.md
