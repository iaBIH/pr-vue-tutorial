<template>
  <div class="datareadwrite">
    <h3>Import data</h3>
    <h3>Export data</h3>

<!-- <h1>{{msg}}</h1> -->
   <label class="text-reader">
       <input type="file" @change="loadTextFromFile">
  </label>
    <textarea id="inputArxText" name="inputArxText"
              rows="3" cols="80">
              Data will be loaded here from the selected file!
      </textarea>
    <input type="text" v-model="calcoperation" id="textArea"  >

<!-- <button id="process" onclick="onProcessClick()"> Process</button> -->
   <button class="process" v-on:click="processInputData()">Process</button>

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

export default {
    name: "AboutView",
    data(){
      // msg : EmpTable.msg
    },
    components: { 
       ArxTable,
       PatTable 
    },
    methods: {
        loadTextFromFile(ev) {
          const file = ev.target.files[0];
          const reader = new FileReader();

          reader.onload = e => this.$emit("load", e.target.result);
          reader.readAsText(file);
        },
        processInputData (){
          axios.post(`http://localhost:8081/api/arx`, {
          body: this.calcoperation
          })  
        },
        created(){
          this.processInputData()
        }
    },
  }
 

// function onProcessClick(){
//     console.log("clicked")
//     //  document.getElementById("process").innerHTML = "CLICKED!";
// }

 //Listner
//  document.getElementById("process").addEventListener("click", onProcessClick)


</script>