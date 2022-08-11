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

   <button class="btnSave" v-on:click="saveArxResult()">Save as CSV file</button>
   <br>
   <!-- {{arxDataArray}} -->
   <!-- <h2>Patients Data</h2>

       <PatTable />   -->
  
  </div>
</template>

<script>
//TODOs:
//   use input file name for saving
//   save as csv file 
//   parse and use the input data in java 


import axios from 'axios';
import ArxTable from '@/components/ArxTable.vue'
// import PatTable from '@/components/PatTable.vue'
import TextReader from '@/components/TextReader.vue'
import ArxService from '@/services/ArxService.js'


export default {
    name: "AboutView",
    data: () => ({ 
      text : "",
      arxDataArray : [],
      arxDataText : ""
    }),
    components: { 
       ArxTable,
      //  PatTable,
       TextReader 
    },
    methods: {
        processInputData (){
          axios.post(`http://localhost:8081/api/arx`, {
          body: this.text
          })  
          // this.textData = this.calcoperation
        },
        saveArxResult(){
           ArxService.getArxData().then( 
                    (response) =>{
                       this.arxDataArray = response.data;
           });
           this.arxDataText=JSON.stringify(this.arxDataArray)
           
           // call save file 
           const data = JSON.stringify(this.arxDataArray)
           const blob = new Blob([data], {type: 'text/plain'})
           const e = document.createEvent('MouseEvents'),
           a = document.createElement('a');
           a.download = "arx_result.json";
           a.href = window.URL.createObjectURL(blob);
           a.dataset.downloadurl = ['text/json', a.download, a.href].join(':');
           e.initEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
           a.dispatchEvent(e);
        },
        created(){
          this.processInputData()
        }
    },
  }
 
</script>