package com.bju.cps450;

import java.util.Vector;

/**
 * Created by carragher on 3/12/16.
 */
public class Class_Dec {
    String name;
    Vector<Vari_Dec> var_decls = new Vector<Vari_Dec>();
    Vector<meth_dec> meth_decls = new Vector<meth_dec>();


    //returns true if found false otherwise
    public boolean checkTable(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < var_decls.size(); x++ ){
            if ( checkme.equals( var_decls.elementAt(x).Id)){
                return true;
            }
        }

        return false;

    }

    public Type checkType(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < var_decls.size(); x++ ){
            if ( checkme.equals( var_decls.elementAt(x).Id)){
                return var_decls.elementAt(x).tip;
            }
        }

        return null;


    }
    public int checkindex(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < var_decls.size(); x++ ){
            if ( checkme.equals( var_decls.elementAt(x).Id)){
                return x;
            }
        }

        return -1;


    }

    public meth_dec checkMeth(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < meth_decls.size(); x++ ){
            if ( checkme.equals( meth_decls.elementAt(x).name)){
                return meth_decls.elementAt(x);
            }
        }

        return null;


    }

}
