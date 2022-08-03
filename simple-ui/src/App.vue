<template>

  <img alt="Vue logo" src="./assets/bih-logo.svg" width="150" height="150" class="center"> 
  <!-- <div>  toolbar </div> -->
  
  <AccessibilityToolbar>
 
  </AccessibilityToolbar>

  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <nav>
    <router-link to="/datareadwrite">Data</router-link> |
    <router-link to="/configtransform">Configure transformation</router-link> |
    <router-link to="/exploreresults">Explore results</router-link> |
    <router-link to="/analyzeutility">Analyze utility</router-link> |
    <router-link to="/analyzerisk">Analyze risk</router-link> 
  </nav>
  <router-view/>
</template>
<script>

 import { AccessibilityToolbar } from 'vue-accessibility-toolbar'
 export default {
    components: {
      AccessibilityToolbar
   }
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
