import string
import random

lex = open("lexique.txtclear","r")
lex2 = open("text.txt",'w')
for word in lex.readlines():
    r = random.randint(1,20)
    lex2.write(word+" ")
    if r == 11:
        lex2.write("\n")

lex.close()
lex2.close()

