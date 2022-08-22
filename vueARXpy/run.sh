# TODO use user specific ports that are not used in the system
#sudo kill -9 $(sudo lsof -t -i:8081)
cd  sbBE
./mvnw spring-boot:run  &
 cd ../simple-ui/dist_electron && ./simple-ui-0.1.0.AppImage
