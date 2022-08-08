<template>
  <div class="arx">
    <h1>{{ msg }}</h1>

     <table class="table table-striped">
      <thead>
         <th> ID</th>   
         <th> Data</th>   

      </thead>
      <tbody>
         <tr v-for ="row in arxData" v-bind:key = "row.id">
           <td> {{row.id}}</td>
           <td> {{row.rowData}}</td>
         </tr>
      </tbody>
     </table>
  </div>
</template>

<script>
import ArxService from '@/services/ArxService'

export default {
  name: 'ArxTable',
  data(){
     return  { 
      msg : "Welcome to Arx World!",
      arxData : []
     }
  },
  methods:{
     getArxData(){
      ArxService.getArxData().then( 
        (response) =>{
             this.arxData = response.data;
      });
     }              
  },
  created(){
   this.getArxData()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 
</style>
