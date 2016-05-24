package com.bju.cps450;

import java.util.Vector;

/**
 * Created by carragher on 3/12/16.
 */
public class symbol_table {

    public static Vector<Class_Dec> class_decls = new Vector<Class_Dec>();
    public static Vector<Vari_Dec> globalVars = new Vector<>();

    public static Vari_Dec checkTable(String checkme){
        checkme = checkme.trim();

        for(int x= 0; x < globalVars.size(); x++ ){
            if ( checkme.equals( globalVars.elementAt(x).Id)){
                return globalVars.elementAt(x);
            }
        }

        return null;

    }


    public static Class_Dec checkType(String checkme){
        checkme = checkme.trim();

        for(int x= 0; x < class_decls.size(); x++ ){
            if ( checkme.equals( class_decls.elementAt(x).name)){
                return class_decls.elementAt(x);
            }
        }

        return null;


    }

}
