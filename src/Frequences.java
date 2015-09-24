import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ByTeK on 01/03/15.
 */
public abstract class Frequences {
    private Occurence[] tab = new Occurence[26];
    private int nb = 0;
    //private static final HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
    //private static final ArrayList<Integer> array = new ArrayList<Integer>();

    public Frequences(){
        //char c = 97;
        for(char c = 0; c<26;c++){
            tab[c] = new Occurence((char)(c+97));
        }
    }

    public void incremente(char c){
        nb ++;
        tab[c-97].incremente();
    }

    public void sortByFreq(){
        
    }

    public void finalise(){
        for(char c = 0; c<26;c++){
            tab[c].finish(nb);
        }
    }

    /*private static void initFreqFr(){
        freq.put('e',171);
        array.add(171);

        freq.put('a',81);
        array.add(81);

        freq.put('s',80);
        array.add(80);

        freq.put('i',75);
        array.add(75);

        freq.put('t',72);
        array.add(72);

        freq.put('r',66);
        array.add(66);

        freq.put('u',63);
        array.add(63);

        freq.put('l',55);
        array.add(55);

        freq.put('o',54);
        array.add(54);

        freq.put('d',37);
        array.add(37);

        freq.put('c',34);
        array.add(34);

        freq.put('p',30);
        array.add(30);

        freq.put('m',30);
        array.add(30);

        freq.put('c',33);
        array.add(33);

        freq.put('v',16);
        array.add(16);

        freq.put('q',14);
        array.add(14);

        freq.put('f',10);
        array.add(10);

        freq.put('b',9);
        array.add(9);

        freq.put('g',9);
        array.add(9);

        freq.put('h',7);
        array.add(7);

        freq.put('j',5);
        array.add(5);

        freq.put('x',4);
        array.add(4);

        freq.put('y',3);
        array.add(3);

        freq.put('z',1);
        array.add(1);

        freq.put('w',1);
        array.add(1);
    }

    public void trierAndMaj(){

    }
*/
}
