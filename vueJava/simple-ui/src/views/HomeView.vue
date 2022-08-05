<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <HomePage msg="Welcome to Simple UI App 2022"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HomePage from '@/components/HomePage.vue'

export default {
  name: 'HomeView',
  components: {
    HomePage
  }
}
</script>
