# Developer Guide: 

- Download and install recent JAVA JDK e.g.
  
      wget https://download.oracle.com/java/18/latest/jdk-18_linux-x64_bin.deb     
      echo "export PATH=$PATH:/usr/lib/jvm/jdk-18/bin" >> ~/.bashrc
      echo "export JAVA_HOME=/usr/lib/jvm/jdk-18" >> ~/.bashrc
      source ~/.bashrc

- Download and install recent node tool e.g. 
      
      sudo apt install curl
      curl -fsSL https://deb.nodesource.com/setup_16.x | sudo -E bash -
      sudo apt-get install -y nodejs
      node -v

        
- Download and install recent yarn tool e.g.

      curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
      echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
      sudo apt update 
      sudo apt install -y yarn
      echo "export PATH=$PATH:~/.config/yarn/global/node_modules/.bin" >> ~/.bashrc

- Install Vue 

      yarn global add @vue/cli
      vue --version


# Compile the project:

  - open a windows terminal CMD and change to the vue project folder e.g.:

        cd vueARX/simple-ui

     
  - first install dependencies 
  
         yarn install   
  
  - to run the desktop app

         yarn electron:serve

  - to build the executable app

         yarn electron:build
         # to build for windows
         yarn electron:build --win nsis  
           
    the executable setup file can be found in dist_electron folder 
    
# Create a new vue project with java backend for ARX   

## Create a vue app 

- Create a folder tree for the project e.g. vueARX  
- inside vueARX folder, create a new vue project from a template by running 

      cd vueARX
      vue create simple-ui       

- Run the created website in a local webserver       
     
       cd simple-ui
       yarn serve
 
   this will run the web site at http://localhost:8080/    

- Build the website for deployment

       yarn build

    this creates a dist folder that can be deployed to another computer    
 
### Create a desktop app from a website using electron

  - to build a desktop app:
   
        vue add electron-builder -mwl
       
- to run the desktop app:
  
         yarn electron:serve 

- to build the desktop app for deployment   
       
       yarn electron:build

- to build for different system : you need to compile e.g.

  first install dependencies 
  
       yarn install   
  
  then build the executable app

         yarn electron:build
         # to build for windows
         yarn electron:build --win nsis  

By default build for current platform and current arch. Use CLI flags --mac, --win, --linux to specify platforms. And --ia32, --x64 to specify arch.

## Create a springboot project:

First create a Spring Boot Project 
 
    - https://start.spring.io/
    - run spring project:
       - install maven:
        
          sudo apt install maven

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
    -  yarn add axios
    -  add java service as described here: https://www.youtube.com/watch?v=hDC_kNlzz6c 

Resources:

- [Create vue js app in 5 minutes](https://www.blog.duomly.com/vue-js-tutorial-how-to-create-vue-js-app-in-5-minutes)
- [Electron with Vue.js](https://www.youtube.com/watch?v=Fl7---SEORQ)
- [Vue CLI plugin electron builder](https://github.com/nklayman/vue-cli-plugin-electron-builder)
