/**
 * Created by ByTeK on 14/03/15.
 */
public class Occurence {

    char c;
    int freq = 0;
    int ecartPrec;
    int ecartSuiv;
    int proba;

    public Occurence(char c){
        this.c = c;
    }

    public void incremente(){
        freq ++;
    }

    public void finish(int total){
        freq = (freq*1000)/total;
    }

    public void setFreq(int f){
        freq = f;
    }
    public void setEcartPrec(int ep){
        ecartPrec = ep;
    }
    public void setEcartSuiv(int es){
        ecartSuiv = es;
    }
}
