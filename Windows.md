
- Install yarn
   
      curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
      echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
      sudo apt update 
      sudo apt install -y yarn
      echo "export PATH=$PATH:~/.config/yarn/global/node_modules/.bin" >> ~/.bashrc

- Install node

      curl -fsSL https://deb.nodesource.com/setup_16.x | sudo -E bash -
      sudo apt-get install -y nodejs
      node -v
          
- Install Vue

      yarn global add @vue/cli
      vue --version

- Create a website
   
      vue create myFirstWebApp

- Run the website in a local webserver
       
       cd myFirstWebApp
       yarn serve

    this will run the web site at http://localhost:8080/    

- Build the website for deployment

       yarn build

    this creates a dist folder that can be deployed to another computer    
 
- Create a desktop app from a website using electron

       vue add electron-builder -mwl
       
    to run the desktop app

       yarn electron:serve 

    to build the desktop app for deployment   
       
       yarn electron:build

    to build for different system : you need to compile at different systems:

       // first install dependencies 
       yarn install   
       // build the executable app
       yarn build


# To connect with java:

First create a Spring Boot Project 
 
    - https://start.spring.io/
    - run spring project:
       - TODO: fix run spring boot from vs code!!!
       - install maven:
         - download the binary e.g. https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz
         - extract to the java folder e.g. C:\Program Files\Java\apache-maven-3.8.6 
         - add C:\Program Files\Java\apache-maven-3.8.6\bin to the system  path 
         - add JAVA_HOME to your system variables (not to the user variables)
           e.g. C:\Program Files\Java\jdk-18.0.2
      - open a new terminal, go to the spring boot folder and run
        mvnw spring-boot:run
        you should see the output of the main java application!
    -  add java class as described here: https://www.youtube.com/watch?v=hDC_kNlzz6c 
    -  Create vue project
      - if the project is already created run in the vue project folder:
        yarn install 
        then either run using:
          yarn electron:serve
        or build exe using (the setup file can be found inside folder dist_electron):  
          yarn electron:build
    -  yarn add bootstrap     
    -  yarn add popperjs
    - yarn add axios
    -  add java service as described here: https://www.youtube.com/watch?v=hDC_kNlzz6c 

Resources:

- [Create vue js app in 5 minutes](https://www.blog.duomly.com/vue-js-tutorial-how-to-create-vue-js-app-in-5-minutes)
- [Electron with Vue.js](https://www.youtube.com/watch?v=Fl7---SEORQ)
- [Vue CLI plugin electron builder](https://github.com/nklayman/vue-cli-plugin-electron-builder)
