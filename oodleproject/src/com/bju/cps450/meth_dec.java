package com.bju.cps450;

import java.util.Vector;

/**
 * Created by carragher on 3/12/16.
 */
public class meth_dec {

    String name;
    Vector<Argument> args = new Vector<Argument>();
    Vector<Vari_Dec> var_decls = new Vector<Vari_Dec>();
    String endId;
    Type returntype = Type.error;




    public boolean checkTable(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < var_decls.size(); x++ ){
            if ( checkme.trim().equals( var_decls.elementAt(x).Id.trim())){
                return true;
            }
        }

        for(int x= 0; x < args.size(); x++ ){
            if ( checkme.equals( args.elementAt(x).id)){
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
        for(int x= 0; x < args.size(); x++ ){
            if ( checkme.equals( args.elementAt(x).id)){
                return args.elementAt(x).tip;
            }
        }

        return null;


    }
    public int checkArgindex(String checkme){
        checkme = checkme.trim();

        for(int x= 0; x < args.size(); x++ ){
            if ( checkme.equals( args.elementAt(x).id)){
                return x;
            }
        }

        return -1;


    }

    public int checknonargindex(String checkme){
        checkme = checkme.trim();
        for(int x= 0; x < var_decls.size(); x++ ){
            if ( checkme.equals( var_decls.elementAt(x).Id)){
                return x;
            }
        }


        return -1;


    }
}
