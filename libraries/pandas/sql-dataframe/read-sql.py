import pandas as pd
from sqlalchemy import create_engine
import pymysql

# Credentials to database connection
hostname="localhost"
dbname="university"
uname="root"
pwd="example"


# Create dataframe
df = pd.DataFrame(data=[[111,'Thomas','35','United Kingdom'],
		[222,'Ben',42,'Australia'],
		[333,'Harry',28,'India']],
columns=['id','name','age','country']
)

# Create SQLAlchemy engine to connect to MySQL Database
engine = create_engine("mysql+pymysql://{user}:{pw}@{host}/{db}".format(host=hostname, db=dbname, user=uname, pw=pwd))

# Convert dataframe to sql table                                   
df.to_sql('users', engine, index=False)