<template>
  <div class="datareadwrite">
    <h1>Import data</h1>
    <h1>Export data</h1>
    <!-- <h1>{{msg}}</h1> -->
      
          <EmpTable />  
  
  </div>
</template>

<script>
import EmpTable from '@/components/EmpTable.vue'

export default {
    name: "AboutView",
    data(){
      // msg : EmpTable.msg
    },
     components: { 
       EmpTable 
       }
 }
</script>