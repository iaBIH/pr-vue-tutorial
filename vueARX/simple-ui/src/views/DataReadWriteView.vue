<template>
  <div class="datareadwrite">
    <h1>Import data</h1>
    <h1>Export data</h1>
    <!-- <h1>{{msg}}</h1> -->
      
          <ArxTable />  
  
  </div>
</template>

<script>
import ArxTable from '@/components/ArxTable.vue'

export default {
    name: "AboutView",
    data(){
      // msg : EmpTable.msg
    },
     components: { 
       ArxTable 
       }
 }
</script>