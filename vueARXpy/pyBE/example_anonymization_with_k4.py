# -*- coding: utf-8 -*-
"""example-anonymization-with-k4.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1Pk_D9aFWcBrcX8ow9DbGSJkF9Zt8oKIW

## Example analyzation and anonymization of sensitive dataset
"""

# First run docker pull navikt/arxaas
# docker run -p 8080:8080 navikt/arxaas

# import os
# os.system("docker pull navikt/arxaas")
# os.system("docker run -d  -p 8080:8080 navikt/arxaas")

# Commented out IPython magic to ensure Python compatibility.
# %pip install pyarxaas

from pyarxaas import ARXaaS, Dataset
from pyarxaas.privacy_models import KAnonymity, LDiversityDistinct
from pyarxaas import AttributeType
import pandas as pd

"""#### Create ARXaaS connection"""

# set logging level to INFO to show pyARXaas logging
import logging
logging.basicConfig(level=logging.INFO)

arxaas = ARXaaS('http://localhost:8080/') # connecting to online service

"""#### fetch sensitive data"""

data_df = pd.read_csv("samples/data/data2.csv", sep=";")

data_df = data_df[:6]
data_df

"""### Create Dataset"""

dataset = Dataset.from_pandas(data_df)
dataset.describe()

"""### Set the AttributeType for the dataset fields"""

dataset.set_attribute_type(AttributeType.IDENTIFYING, 'salary')

"""### Set Generalization Hierarchies
Note that if the hierarchy does not have a header row in the csv file, please set header=None in read_csv() or the first row will be interpreted as a header and ARXaaS will throw an exception for the missing hierarchy data.
"""

zipcode_hierarchy = pd.read_csv("samples/data/data2_zipcode_hierarchy.csv", sep=";", header=None)
age_hierarchy = pd.read_csv("samples/data/data2_age_hierarchy.csv", sep=";", header=None)
disease_hierarchy = pd.read_csv("samples/data/data2_disease_hierarchy.csv", sep=";", header=None)

age_hierarchy

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

anon_rp.distribution_of_risk_dataframe().head(10)
print(anon_rp.distribution_of_risk_dataframe().head(10))
