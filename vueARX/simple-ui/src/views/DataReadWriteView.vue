<template>
  <div class="datareadwrite">
    <h3>Import data</h3>
    <h3>Export data</h3>


    <br>
    <text-reader @load="text = $event"></text-reader>
    <br>
    <textarea rows="10" v-model="text"></textarea>

    <br>
    <!-- <input type="text" v-model="calcoperation" id="textArea"  > -->


    <!--    Process Data     -->

   <button class="btnProcess" v-on:click="processInputData()">Process</button>

   <br>
   <h2>ARX Data</h2>

          <ArxTable />  

   <h2>Patients Data</h2>

       <PatTable />  
  
  </div>
</template>

<script>
import axios from 'axios';
import ArxTable from '@/components/ArxTable.vue'
import PatTable from '@/components/PatTable.vue'
import TextReader from '@/components/TextReader.vue'

export default {
    name: "AboutView",
    data: () => ({ text: "" }),
    components: { 
       ArxTable,
       PatTable,
       TextReader 
    },
    methods: {
        processInputData (){
          axios.post(`http://localhost:8081/api/arx`, {
          body: this.text
          })  
          // this.textData = this.calcoperation
        },
        created(){
          this.processInputData()
        }
    },
  }
 
</script>