<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
         This app demonstrates some user interface elements using Vue<br>
    </p>
   
   <h3> Using different components (properties and events) e.g.: </h3>
    <ul>
      <li>Buttons, textbox, droplist, progressbar, tabs, ...etc </li><br>
      <li>Charts, images, graphics, ...etc </li><br>
      <li>Menus, popup menus,...etc </li>
      <!-- <li><a href="https://" target="_blank" rel="noopener">eslint</a></li> -->
    </ul>
   <h3> Read, write: </h3>
    <ul>
      <li>Files </li><br>
      <li>Databases </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
