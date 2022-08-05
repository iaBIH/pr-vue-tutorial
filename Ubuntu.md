
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
        ./mvnw spring-boot:run
    -  add java class as described here: https://www.youtube.com/watch?v=hDC_kNlzz6c 
    -  Create vue project
    -  yarn add bootstrap     
    -  yarn add popperjs
    - yarn add axios
    -  add java service as described here: https://www.youtube.com/watch?v=hDC_kNlzz6c 

Resources:

- [Create vue js app in 5 minutes](https://www.blog.duomly.com/vue-js-tutorial-how-to-create-vue-js-app-in-5-minutes)
- [Electron with Vue.js](https://www.youtube.com/watch?v=Fl7---SEORQ)
- [Vue CLI plugin electron builder](https://github.com/nklayman/vue-cli-plugin-electron-builder)
