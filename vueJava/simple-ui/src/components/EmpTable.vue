<template>
  <div class="emps">
    <h1>{{ msg }}</h1>

     <table class="table table-striped">
      <thead>
         <th> ID</th>   
         <th> Name</th>   
         <th> Age</th>   
      </thead>
      <tbody>
         <tr v-for ="emp in emps" v-bind:key = "emp.id">
           <td> {{emp.id}}</td>
           <td> {{emp.name}}</td>
           <td> {{emp.age}}</td>
         </tr>
      </tbody>
     </table>
  </div>
</template>

<script>
import EmpsService from '@/services/EmpsService'

export default {
  name: 'EmpTable',
  data(){
     return  { 
      msg : "Welcome to Java World!",
      emps : []
     }
  },
  methods:{
     getEmps(){
      EmpsService.getEmps().then( 
        (response) =>{
             this.emps = response.data;
      });
     }              
  },
  created(){
   this.getEmps()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 
</style>
