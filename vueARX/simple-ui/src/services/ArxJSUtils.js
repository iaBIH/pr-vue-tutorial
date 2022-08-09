/**
 * Javascript Utilities
 * taken from hakathon repository
 */


 // Global variables 
 var tableData         = [];  // Output CSV table
 
 class ArxJSUtils {
  /**
  * Author: Ibraheem Al-Dhamari
  * Save text data to a txt file. The file will be saved in the download folder 
  * dataObject should be a java object in any format, table is recommended e.g.
  *  var data = [ 
  *               [ "label1", "label2",  "label3"],
  *               [ value11,   valu12,   value13],
  *               [ value21,   valu122,   value23],
  *               [ value31,   valu32,   value33],
  *             ];
  */
   SaveData2TextFile(dataObject, dataFileName){
      
    console.log(" Writing data to a text file: " + dataFileName);   
    
    // Create a formated text from the data object:
    // TODO: add qutes for string values
    var dataTxt = "";
    var numCols = dataObject.reduce((x, y) => Math.max(x, y.length), 0)
    // Loop over rows
    for (let i = 0; i < dataObject.length; i++) {
      // loop over columns 
      var dataRowObject = dataObject[i]
      var dataRow = dataRowObject[0]
      for(let j = 1; j < numCols; j++) {
          dataRow += " ; " + dataRowObject[j]  
      }
      dataTxt += dataRow + "\n"
    }

    // Write data to a file 
    var file = new Blob([dataTxt], {type: ""});
    if (window.navigator.msSaveOrOpenBlob) // IE10+
        window.navigator.msSaveOrOpenBlob(file, dataFileName);
    else { 
      // Create a download link to save the file 
      var a = document.createElement("a"),
              url = URL.createObjectURL(file);
      a.href = url;
      a.download = dataFileName;
      document.body.appendChild(a);
      a.click();
      
      // Remove the download link after downloading
      setTimeout(function() {
          document.body.removeChild(a);
          window.URL.revokeObjectURL(url);  
      }, 0); 
    }
    console.log(" The file " + dataFileName + " is saved in the Downloads folder!" );
   }

    /**
    * Author: Ibraheem Al-Dhamari
    * Read data from a file located in the working directory 
    * The data could be converted to a java object e.g.
    *               var jsonData= JSON.parse(dataText)
    *               console.log(JSON.stringify(jsonData))
    * then danfo dataframe can be created e.g.
    *  
    *             <script src="https://cdn.jsdelivr.net/npm/danfojs@1.1.1/lib/bundle.min.js"></script>
    *             
    *             var  df = new dfd.DataFrame(jsonData) 
    *                  df.print()
    */
    loadDataFromTextFile(dataFileName){
        console.log(" Reading data from a file " + dataFileName + "    ");
        var dataText = "no data"
        var rawFile = new XMLHttpRequest();
        rawFile.open("GET", dataFileName, false);
        rawFile.onreadystatechange = function () {
        if(rawFile.readyState === 4) {
            if(rawFile.status === 200 || rawFile.status == 0) {
                dataText = rawFile.responseText;
            }
        }
        }
        rawFile.send(null);
        return dataText;
    }

    /**
    * Author: Ibraheem Al-Dhamari
    * List all filenames selected by a user as a list
    * inputFolder is a file input tag e.g. 
    *    <button style="display:block;width:120px; height:30px;"  onclick="document.getElementById('inputFolder').click()">Select data files</button>
    *    <input type='file' id="inputFolder" style="display:none"  onchange="listSelectedDataFiles()" multiple >
    */     
    listSelectedDataFiles(){
        console.log(" Get All selected files ..........")
        var selectedFilenames = [];
        var selectedFiles = document.getElementById("inputFolder");
        for (var i = 0; i < selectedFiles.files.length; i++) {
            selectedFilenames.push(selectedFiles.files[i].name);
        }
        return selectedFiles;
    }

    //========================== Filtering Functions ============================  
    /**
    *   Get unique values of an array    
    */
    iaUniqueList(dataArray) {    
        function getUnique(value, index, self){
            return self.indexOf(value) === index;
        }
        var dataSet = dataArray.filter(getUnique);
        dataSet = dataSet.sort();
        return dataSet; 
    } 

    /**
     * Author: Ibraheem Al-Dhamari
     * Get part of a table by slicing 
     *   r1,r2: first and last rows
     *   c1,c2: first and last columns 
     */
    getSubData (data, r1, r2, c1, c2, hasLabels) {      
        var subData = []
        if (hasLabels) subData.push(data[0])

        for (var i = r1; i < r2 + 1; i++){
            var col = []
            for (var j = c1; j < c2 + 1; j++){
                col.push(data[i][j])
            }
            subData.push(col)
        }
        return subData
    }

    /**
     * Author: Ibraheem Al-Dhamari
     * Get column from a table by index or label 
     * with an option to return only unique sorted values 
     */
    getDataColumn (data, index, label, AsUnique)  {
                const arrayColumn = (arr, n) => arr.map(x => x[n]); 
                if (label != "")   index =  tableData[0].findIndex(element => element==label)                 
                var datColumn = arrayColumn(data, index) 
                if (AsUnique){
                    datColumn = this.iaUniqueList(datColumn)
                }  
                return datColumn
    }
 
}

export default new ArxJSUtils()