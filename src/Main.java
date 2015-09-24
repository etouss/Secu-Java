
public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Cesar cesar = new Cesar(3);
        String chiffre = cesar.chiffrer("salut je suis ");
        System.out.println(chiffre);
        System.out.println(cesar.dechiffrer(chiffre));

        Permutation perm = new Permutation("azertyuiopqsdfghjklmwxcvbn");
        String chiffre2 = perm.chiffrer("salut je suis ");
        System.out.println(chiffre2);
        System.out.println(perm.dechiffrer(chiffre2));
        */
        /*
        Vigenere vign = new Vigenere("bal");
        String chiffre3 = vign.chiffrer("salut je suis ");
        System.out.println(chiffre3);
        vign.razIndice();
        System.out.println(vign.dechiffrer(chiffre3));
        */
        /*
        Cesar cesar = new Cesar(24);
        String chiffre = cesar.chiffrerString("salut comment allez vous moi je vais bien mais bon je suis pas sure que ca compte vraiment");
        DecryptCesar decryptCesar = new DecryptCesar(chiffre);

        try{
            long time = System.currentTimeMillis();
            System.out.println(decryptCesar.decryptBruteForce());
            System.out.println(System.currentTimeMillis()-time);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        */

        try {
            //long time = System.currentTimeMillis();
            Dawg dwg = new Dawg();
            System.out.println(dwg.searchForStringB("abaisserent"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*

        Vigenere vign = new Vigenere("cade");
        String chiffre3 = vign.chiffrerString("ent obvinssent crachasse rembourrera pete endossataire imagent oscillames capuchonnassions pouponnent influenceriez trembloteraient triviale chopera recourbassiez ante debitables mitages croiserais brifferait sirotiez cosmetiquiez rattacheront pelasgique ramenassiez recessif heurs hurlants xylographiques toasteront escamotates maquames enfaitassent afferassions nucleasse murirait cabalistiques rabougrissement denasalisat disetteuse emouchais opinames fienter etreins grisailles houssassiez fertilisable esprits brunisses arrondissons tablars lob diffama refirent depotaient galactique peterons terrasserez delitescence decarrerez antigravitationnels verdoierai succedassions tomat stabilisants rouspetant manouvrieres fileriez sentirions edictaient scindas craner imputasses calomels desengourdimes recrusses microgrenu appairent recollons lutrins inculpat colloquent remonterions vibrerons recalculas commodes bivalences embouteillerions tolerasse depanne federerent moutonnasse ebourgeonnames troubadour receptionniste epaufreraient hauteurs corsetait frimames enverguees bitumeras orthographierait abhorrerons annotera animaliers bases groullerent jaunissiez persiste reniames cancanons ponctuer rendosseraient diluvial deputees barattent enchevauchant soieries claironneront entre deverrouillons chapiteau rat brasseuse reprouvons hegemonie baissent accueilleras caletasses poikilothermes epaulait farigoule versifiait congreates cauchemardes cachetiez deferrisames abstraite opalisent caracals inconvenants raquerent engoula deficelleront mardis considera goupillonnerait enluminent chipas palissent histolyse challengeassent caparaconneront compressiez rengaines transmuant cliquetement analgesia ressemelais engoncait cadreur regreassions deperis steriques epicates pissaladieres saluames causalites surhumanite bombarderai monopolisateurs slaviserais embidonnez depossederons rehaussa gesticuliez deploiements bavoirs manillons ecrivaillais opacifiais boutaient seduise economisaient giletieres contentieux detient privatisat travestissent dessangleras lecherez maquillerent vousoyes residates banjo moralises soufflez onomatopee scellent effarouches deplantaient raplatissions besognions transposa sulfamides zutiste");
        vign.razIndice();
        //String dech = vign.dechiffrerString(chiffre3);
        //System.out.println(dech);
        //vign.razIndice();
        DecryptVigenere decryptVigenere = new DecryptVigenere(chiffre3,4);
        try {
            decryptVigenere.decryptFrequence();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(vign.dechiffrer(chiffre3));

        */
        /*
        Permutation perm = new Permutation("azertyuiopqsdfghjklmwxcvbn");
        String chiffre2 = perm.chiffrerString("lent obvinssent crachasse rembourrera pete endossataire imagent oscillames capuchonnassions pouponnent influenceriez trembloteraient triviale chopera recourbassiez ante debitables mitages croiserais brifferait sirotiez cosmetiquiez rattacheront pelasgique ramenassiez recessif heurs hurlants toasteront escamotates maquames enfaitassent afferassions nucleasse murirait cabalistiques rabougrissement denasalisat disetteuse emouchais opinames fienter etreins grisailles houssassiez fertilisable esprits brunisses arrondissons tablars lob diffama refirent depotaient galactique peterons terrasserez delitescence decarrerez antigravitationnels verdoierai succedassions tomat stabilisants rouspetant manouvrieres fileriez sentirions edictaient scindas craner imputasses calomels desengourdimes recrusses microgrenu appairent recollons lutrins inculpat colloquent remonterions vibrerons recalculas commodes bivalences embouteillerions tolerasse depanne federerent moutonnasse ebourgeonnames troubadour receptionniste epaufreraient hauteurs corsetait frimames enverguees bitumeras orthographierait abhorrerons annotera animaliers bases groullerent jaunissiez persiste reniames cancanons ponctuer rendosseraient diluvial deputees barattent enchevauchant soieries claironneront entre deverrouillons chapiteau rat brasseuse reprouvons hegemonie baissent accueilleras caletasses poikilothermes epaulait farigoule versifiait congreates cauchemardes cachetiez deferrisames abstraite opalisent caracals inconvenants raquerent engoula deficelleront mardis considera goupillonnerait enluminent chipas palissent histolyse challengeassent caparaconneront compressiez rengaines transmuant cliquetement analgesia ressemelais engoncait cadreur regreassions deperis steriques epicates pissaladieres saluames causalites surhumanite bombarderai monopolisateurs slaviserais embidonnez depossederons rehaussa gesticuliez deploiements bavoirs manillons ecrivaillais opacifiais boutaient seduise economisaient giletieres contentieux detient privatisat travestissent dessangleras lecherez maquillerent vousoyes residates banjo moralises soufflez onomatopee scellent effarouches deplantaient raplatissions besognions transposa sulfamides zutiste wagon");
        //System.out.println(chiffre2);
        DecryptPerm dec = new DecryptPerm(chiffre2);
        dec.decrypt();
        */
        //System.out.println(perm.dechiffrer(chiffre2));
    }
}
