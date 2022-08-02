
- Install yarn
   
      curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
      echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
      sudo apt update 
      sudo apt install -y yarn
      export PATH=$PATH:~/.config/yarn/global/node_modules/.bin 

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

       vue add electron-builder
       
    to run the desktop app

       yarn electron:serve 

    to build the desktop app for deployment   
       
       yarn electron:build




