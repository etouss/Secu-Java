java securiteL3/chiffre c 15 $1> $1.cesar
java securiteL3/dechiffre c  15 $1.cesar >$1.cesar.clair
if diff -q $1 $1.cesar.clair >&2
then echo Cesar réussi\n
else echo Cesar raté\n
fi




java securiteL3/chiffre p "nbvcxwmlkjhgfdsqpoiuytreza" $1> $1.perm
java securiteL3/dechiffre p "nbvcxwmlkjhgfdsqpoiuytreza" $1.perm > $1.perm.clair
if diff -q $1 $1.perm.clair >&2
then echo chiffre  permutation  réussi\n
else echo chiffre permutation  raté\n
fi

java securiteL3/chiffre v  "programme" $1> $1.vige
java securiteL3/dechiffre v "programme" $1.vige > $1.vige.clair
if diff -q $1 $1.vige.clair  >&2
then echo chiffre Vigenère  réussi\n
else echo chiffre Vigenère   raté\n
fi


echo decrypt cesar
java securiteL3/decrypt c  $1.cesar   1  ponctuation >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt cesar mode 1 réussi\n
else echo decrypt cesar mode 1 raté\n
fi



java securiteL3/decrypt c  $1.cesar  2  >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt cesar mode 2 réussi\n
else echo decrypt cesar mode 2 raté\n
fi



java securiteL3/decrypt c  $1.cesar  3 >$1.clair
if diff -q $1 $1.clair   >&2
then echo decrypt cesar mode 3 réussi\n
else echo decrypt cesar mode 3 raté\n
fi


echo decrypt Vigenère
java securiteL3/decrypt v $1.vige 9 >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Vigenère réussi\n
else echo decrypt Vigenère raté\n
fi

echo decrypt Vigenère sans taille de clef
java securiteL3/decrypt v $1.vige 0 >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Vigenère réussi\n
else echo decrypt Vigenère raté
fi

echo decrypt permutation
java securiteL3/decrypt p $1.perm  >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Permutation réussi\n
else echo decrypt Permutation raté
fi

echo decrypt full perm
java securiteL3/decrypt f $1.perm  >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Full réussi\n
else echo decrypt Full raté\n
fi

echo decrypt full cesar
java securiteL3/decrypt f $1.cesar  >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Full réussi\n
else echo decrypt Full raté\n
fi

echo decrypt full vigener
java securiteL3/decrypt f $1.vige  >$1.clair
if diff -q $1 $1.clair  >&2
then echo decrypt Full réussi\n
else echo decrypt Full raté\n
fi
