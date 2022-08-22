from curses import window
import os, sys
import random
from PySide6 import QtCore, QtWidgets, QtGui
from PySide6.QtUiTools import QUiLoader
from PySide6.QtCore import QFile
from PySide6 import QtGui, QtCore, QtUiTools


from pyarxaas import ARXaaS, Dataset
from pyarxaas.privacy_models import KAnonymity, LDiversityDistinct
from pyarxaas import AttributeType
import pandas as pd
import logging

class MainWindow(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        print("-------------------------------------")
        print("          ARX Main Window           ")
        print("-------------------------------------")

        self.hello = ["Hallo Welt", "Hei maailma", "Hola Mundo", "Привет мир"]

        # self.button = QtWidgets.QPushButton("Click me!")
        # self.text = QtWidgets.QLabel("Hello World",
        #                              alignment=QtCore.Qt.AlignCenter)
        # self.layout = QtWidgets.QVBoxLayout(self)
        # self.layout.addWidget(self.text)
        # self.layout.addWidget(self.button)
        # self.button.clicked.connect(self.magic)

        self.loader = QUiLoader()

        self.appPath = os.path.dirname(os.path.abspath(__file__))

        self.uiFnm = os.path.join(self.appPath,"MainWindow.ui")
 
        self.window = self.loader.load(self.uiFnm , None)
        print( "self.window.children: ", self.window.findChildren(QtWidgets.QPushButton,'btnRun') )
        self.window .resize(800, 600)
        self.window .show()

        self.btnRun     = self.window.findChild(QtWidgets.QPushButton,'btnRun')
        self.btnRun.clicked.connect(self.btnRunClick)

        self.btnOpen     = self.window.findChild(QtWidgets.QPushButton,'btnOpen')
        #pushButton.clicked.connect(btnOpenClick)
       
        #self.lblInput   = self.window.findChild(QtWidgets.QLabel,'lblInput')
        self.txtInput   = self.window.findChild(QtWidgets.QTextBrowser,'txtInput')
        self.txtOutput  = self.window.findChild(QtWidgets.QTextBrowser,'txtOutput')

  
    #@QtCore.Slot()
    #def btnOpenClick(self):
    #    self.lblInput.setText(QFileDialog.getOpenFileName())
       

 

    @QtCore.Slot()
    def btnRunClick(self):

        # #  kill process uses 8080
        # os.system("sudo kill -9 $(sudo lsof -t -i:8080)")
        # # run arxas server
        # os.system("java -jar  arxaas-2022-RELEASE.jar")
        


        self.txtInput.setText("text input")
        self.txtOutput.setText("text output")
        # TODO:
        # use arx demo

        # set logging level to INFO to show pyARXaas logging
        logging.basicConfig(level=logging.INFO)

        arxaas = ARXaaS('http://localhost:8080/') # connecting to online service

        """#### fetch sensitive data"""
        dataFnm = os.path.join(self.appPath,"data2.csv")
        data_df = pd.read_csv(dataFnm, sep=";")
        self.txtInput.setText(data_df.to_string())

        zipHFnm = os.path.join(self.appPath,"data2_zipcode_hierarchy.csv")
        ageHFnm = os.path.join(self.appPath,"data2_age_hierarchy.csv")
        diseaseHFnm = os.path.join(self.appPath,"data2_disease_hierarchy.csv")

        zipcode_hierarchy = pd.read_csv(zipHFnm, sep=";", header=None)
        age_hierarchy = pd.read_csv(ageHFnm, sep=";", header=None)
        disease_hierarchy = pd.read_csv(diseaseHFnm, sep=";", header=None)


        """### Create Dataset"""

        dataset = Dataset.from_pandas(data_df)
        dataset.describe()

        """### Set the AttributeType for the dataset fields"""

        dataset.set_attribute_type(AttributeType.IDENTIFYING, 'salary')

        """### Set Generalization Hierarchies
        Note that if the hierarchy does not have a header row in the csv file, please set header=None in read_csv() or the first row will be interpreted as a header and ARXaaS will throw an exception for the missing hierarchy data.
        """

        dataset.set_hierarchy("age", age_hierarchy)
        dataset.set_hierarchy("zipcode", zipcode_hierarchy)
        dataset.set_hierarchy("disease", disease_hierarchy)

        """### Create Privacy Models"""

        kanon = KAnonymity(2)

        """### Create Risk Profile"""

        risk_profile = arxaas.risk_profile(dataset)

        risk_profile.re_identification_risk

        risk_profile.distribution_of_risk_dataframe().head()

        """## Anonymize"""

        anon_result = arxaas.anonymize(dataset, [kanon])

        anon_result.dataset.to_dataframe()

        """#### Anonymization Status"""

        print(anon_result.anonymization_status)

        """#### RiskProfile for the anonymized dataset"""

        anon_rp = anon_result.risk_profile
        

        print(anon_rp.re_identification_risk)

        result = anon_rp.distribution_of_risk_dataframe().head(10)
        print(result)
        self.txtOutput.setText(str(result))

if __name__ == "__main__":
    print("=====================================")
    print("          ARX Qt           ")
    print("=====================================")

    app = QtWidgets.QApplication(sys.argv)

    mainWindow = MainWindow()
 

    sys.exit(app.exec_())        
