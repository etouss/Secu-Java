

import psycopg2 as dbapi2
import sys
import unicodedata
import string

def remove_accents(data):
    return ''.join(x for x in unicodedata.normalize('NFKD', data) if x in string.ascii_letters).lower()


lex = open(sys.argv[1],"r")
lex2 = open(sys.argv[1]+"clear","w")
for word in lex.readlines():
    for c in word :
        if(c == ' '):
            lex2.write(c)
            continue
        c = remove_accents(c)
        lex2.write(c)

lex.close()
lex2.close()

