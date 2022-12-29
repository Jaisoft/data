import pyspark 

from pyspark.sql import SparkSession

import mysql.connector

import pandas as pd


#spark = SparkSession.builder.config("spark.jars", "/Users/jaisoft/Documents/data/spark/pspark-sql/pyspark-sql-script/mysql-connector-java-8.0.20.jar").master("local").appName("pyspark_mysql").getOrCreate()

#spark = SparkSession.builder.config("spark.jars", "/Users/jaisoft/Documents/data/spark/pspark-sql/pyspark-sql-script/mysql-connector-java-8.0.20.jar").appName('pyspark_mysql').getOrCreate()

#df = spark.read.format("jdbc").options(url="jdbc:mysql://localhost:3306/university",driver = "com.mysql.jdbc.Driver",dbtable = "university",user="root",password="example").load()

spark = SparkSession.builder.master("local").appName("pyspark_mysql").getOrCreate()



conn = mysql.connector.connect(user='root', database='university',
                               password='example',
                               host="localhost",
                               port=3306)

cursor = conn.cursor()

query = "SELECT id, name FROM teacher"


pdf = pd.read_sql(query, con=conn)

conn.close()


print(pdf)



# Convert Pandas dataframe to spark DataFrame

#df = spark.createDataFrame(pdf)

#df.printSchema()

#df.show()
