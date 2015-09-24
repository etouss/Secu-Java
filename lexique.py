import psycopg2 as dbapi2
import sys
import unicodedata
import string

def remove_accents(data):
    return ''.join(x for x in unicodedata.normalize('NFKD', data) if x in string.ascii_letters).lower()

db = dbapi2.connect (database=sys.argv[2], user=sys.argv[1])
curs = db.cursor()
curs.execute("CREATE TABLE lexique (id_mot serial PRIMARY KEY, mot varchar);")

lex = open("lexique.txt","r")
for word in lex.readlines():
    word = remove_accents(word)
    curs.execute("INSERT INTO lexique (mot) VALUES ('"+word+"')")

db.commit()
curs.close()
db.close()

