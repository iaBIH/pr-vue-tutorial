<template>
  <div class="pats">
    <h3>{{ msg }}</h3>

     <table class="table table-striped">
      <thead>
         <th> ID</th>   
         <th> Name</th>   
         <th> Age</th>   
      </thead>
      <tbody>
         <tr v-for ="pat in pats" v-bind:key = "pat.id">
           <td> {{pat.id}}</td>
           <td> {{pat.name}}</td>
           <td> {{pat.age}}</td>
         </tr>
      </tbody>
     </table>
  </div>
</template>

<script>
import PatsService from '@/services/PatsService'

export default {
  name: 'PatTable',
  data(){
     return  { 
      msg : "Welcome to Java World!",
      pats : []
     }
  },
  methods:{
     getPats(){
      PatsService.getPats().then( 
        (response) =>{
             this.pats = response.data;
      });
     }              
  },
  created(){
   this.getPats()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 
</style>
