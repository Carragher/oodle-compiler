package com.bju.cps450;

import com.bju.cps450.lexer.*;
import com.bju.cps450.node.*;
import java.io.*;

/**
 * Created by carragher on 1/18/16.
 */

//this class extends the default sablecc lexer
public class ExtLexer extends Lexer  {

    public static String curFile = "";


    public ExtLexer(@SuppressWarnings("hiding") PushbackReader in) {
        super(in);
    }

    //gets correct line and file that your token is in
    public String getCorrectLine() {
      String linenum = "";
        Integer fakeLine = this.token.getLine();
        for(int x = 0; x < FileManager.iList.size(); x++) {
            //Integer fakeLine = this.token.getLine();
            if((FileManager.iList.get(x) - fakeLine) >= 0 && x ==0){
                curFile = FileManager.sList.get(x);
                return fakeLine.toString();


            }

            if ((FileManager.iList.get(x) -fakeLine) < 0){
                fakeLine -= FileManager.iList.get(x);

            } else {
                curFile = FileManager.sList.get(x);
                return fakeLine.toString();
            }



        }





        return "DEBUG ME O SWEET SUMMER CHILD";
    }


    //checks for tokens for the lexer
    // if found will then prints
    //one of the many prints for tokens
    public void printToken() {
        String lineNum = getCorrectLine();
        String messageFile = curFile;


        String Message = messageFile + ":" + lineNum + "," + this.token.getPos() + ":" + "'" + this.token.getText() + "'";
        System.out.println(Message);
    }
    //prints operators
    public void printOP() {
        String lineNum = getCorrectLine();
        String messageFile = curFile;


        String Message = messageFile + ":" + lineNum + "," + this.token.getPos() + ":"+ "operator" + "'" + this.token.getText() + "'";
        System.out.println(Message);
    }

    //prints tokens
    public void printToken(String rep) {
        String lineNum = getCorrectLine();
        String messageFile = curFile;
        String repMe = rep + ":";
        if (rep == ""){
            repMe = "";
        }

        String Message = messageFile + ":" + lineNum + "," + this.token.getPos() + ":" + repMe + this.token.getText().trim();
        System.out.println(Message);
    }

    //prints the CR line correctly
    public void printCR() {
        String lineNum = getCorrectLine();
        String messageFile = curFile;


        String Message = messageFile + ":" + lineNum + "," + this.token.getPos() + ":" + "cr";
        System.out.println(Message);
    }

    //checks the token to see if it is an operator
    public boolean checkOperation(){

        boolean checked = false;

        if (    this.token instanceof TConcat ||
                this.token instanceof TPlus ||
                this.token instanceof TMinus ||
                this.token instanceof TStar ||
                this.token instanceof TDiv ||
                this.token instanceof TAnd ||
                this.token instanceof TOr ||
                this.token instanceof TNot ||
                this.token instanceof TEqual ||
                this.token instanceof TGthan ||
                this.token instanceof TGthanEq ||
                this.token instanceof TLthan ||
                this.token instanceof TLthanEq
                ) {

            checked = true;

        }

        if(checked){




        }

    return checked;

    }

    //checks token to see if it is a keyworkd
    public boolean checkKeyword() {
        boolean checked =false;

        if (    this.token instanceof TBool ||
                this.token instanceof TBegin ||
                this.token instanceof TClasskey ||
                this.token instanceof TElse ||
                this.token instanceof TEnd ||
                this.token instanceof TFalse ||
                this.token instanceof TFrom ||
                this.token instanceof TIf ||
                this.token instanceof TInherits ||
                this.token instanceof TInt ||
                this.token instanceof TIs ||
                this.token instanceof TLoop ||
                this.token instanceof TMe ||
                this.token instanceof TNew ||
                this.token instanceof TNull ||
                this.token instanceof TString ||
                this.token instanceof TThen ||
                this.token instanceof TTrue ||
                this.token instanceof TWhile){

            checked = true;
        }

        if(checked){

        }

        return checked;
    }
    //checks to see if token is misc
    public boolean checkMisc(){
        boolean checked = false;

        if (    this.token instanceof TAssignOp ||
                this.token instanceof TLParen ||
                this.token instanceof TRParen ||
                this.token instanceof TLBracket ||
                this.token instanceof TRBracket ||
                this.token instanceof TComma ||
                this.token instanceof TSemiColon ||
                this.token instanceof TColon ||
                this.token instanceof TDot){
            checked = true;
        }

        if (checked){

        }
        return checked;
    }

    //overiden filter method that does the printing for tokens incluiding bad ones.
    @Override
    protected void filter() throws LexerException, IOException {
        super.filter();
        boolean cont = false;
        cont = checkOperation();



        if (cont && Globals.dsTest){
            printOP();
        }

        cont = checkKeyword();

        if (cont && Globals.dsTest){
            printToken("keyword");
        }

        cont = checkMisc();

        if (cont && Globals.dsTest){
            printToken();
        }

        if (this.token instanceof  TLinefilter && Globals.dsTest){
            printCR();
        }

        if (this.token instanceof TId && Globals.dsTest){
            printToken("identifier");
        }

        if (this.token instanceof TStrLit && Globals.dsTest){
            printToken("string lit");
        }

        if (this.token instanceof TIllegalStrLit){
            printToken("illegal string");
            this.next();
        }

        if (this.token instanceof TUntermStr){
            printToken("unterminated string");
            this.next();
        }

        if (this.token instanceof TUnknownChar){
            printToken("unrecognized char");
            this.next();
        }

        if(this.token instanceof TSpctab){
            this.token = null;
        }


    }
}
