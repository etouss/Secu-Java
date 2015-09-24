
import psycopg2 as dbapi2
import sys
import unicodedata
import string

def remove_accents(data):
    return ''.join(x for x in unicodedata.normalize('NFKD', data) if x in string.ascii_letters).upper()


lex = open("lexique.txt","r")
lex2 = open("lexique2.txt","w")
for word in lex.readlines():
    if(len(word)>2):
        word = remove_accents(word)
        lex2.write(word+"\n")

lex.close()
lex2.close()

