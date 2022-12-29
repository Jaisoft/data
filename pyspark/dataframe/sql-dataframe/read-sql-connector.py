import mysql.connector
import pandas as pd
from pyspark.sql import SparkSession

appName = "PySpark MySQL Example - via mysql.connector"
master = "local"

spark = SparkSession.builder.master(master).appName(appName).getOrCreate()

# Establish a connection
conn = mysql.connector.connect(user='hive', database='test_db',
                               password='hive',
                               host="localhost",
                               port=10101)
cursor = conn.cursor()
query = "SELECT id, value FROM test_table"
# Create a pandas dataframe
pdf = pd.read_sql(query, con=conn)
conn.close()

# Convert Pandas dataframe to spark DataFrame
df = spark.createDataFrame(pdf)

df.show()
