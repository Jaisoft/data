pyspark

JSON

vim people.json

and add

{"name":"Michael"}
{"name":"Andy", "age":30}
{"name":"Justin", "age":19}


df = spark.read.json("people.json")


df.show()


df.printSchema()


df.select("name").show()

df.select(df['name'], df['age'] + 1).show()

df.filter(df['age'] > 21).show()

df.groupBy("age").count().show()


SQL QUERIES

df.createOrReplaceTempView("people")

sqlDF = spark.sql("SELECT * FROM people")

sqlDF.show()
