package com.bju.cps450;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.node.*;

import java.util.HashMap;

/**
 * Created by carragher on 3/12/16.
 */
public class SemanticChecker extends DepthFirstAdapter   {
    private HashMap<Node, Type> attributeGrammerMap = new HashMap<Node,Type>();
    public Class_Dec curClass = null;
    public meth_dec curMeth = null;
    public Token lastToken = null;

    private void reportError(Exception e){

       System.out.println( lastToken.getLine() + ":" + lastToken.getPos() + " " + e.getMessage() );
    }

    @Override
    public void outAStart(AStart node) {
        super.outAStart(node);
        Globals.attributeGrammerMap = attributeGrammerMap;
    }

    @Override
    public void inAStart(AStart node) {
        super.inAStart(node);

        Class_Dec reader = new Class_Dec();
        reader.name = "reader";
        meth_dec readInt = new meth_dec();
        readInt.name = "readint";
        readInt.returntype = Type.integer;

        reader.meth_decls.add(readInt);

        symbol_table.class_decls.add(reader);

        Class_Dec writer = new Class_Dec();
        writer.name = "writer";
        meth_dec writeInt = new meth_dec();
        writeInt.name = "writeint";
        writeInt.returntype = Type.integer;
        Argument arg =new Argument();
        arg.id= "what I WRITE :D :D :D :D";
        arg.tip =  Type.integer;
        writeInt.args.add(arg);

        writer.meth_decls.add(writeInt);

        symbol_table.class_decls.add(writer);

        //todo remever spacing

        Vari_Dec in = new Vari_Dec();
        in.Id = "in";
        in.tip = new Type("reader");

        Vari_Dec out = new Vari_Dec();
        out.Id = "out";
        out.tip = new Type("writer");

        symbol_table.globalVars.add(in);
        symbol_table.globalVars.add(out);



//todo add in/out


    }


//


    @Override
    public void outAArrexpExpression(AArrexpExpression node) {
        super.outAArrexpExpression(node);

            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT array edition:((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}


    }

    @Override
    public void inAMethDef(AMethDef node)  {
        super.inAMethDef(node);
        lastToken = node.getBegin();
        curMeth = new meth_dec();
        curMeth.name = node.getBegin().toString().trim();



        if(curClass.checkTable(node.getBegin().toString())){
            try{throw new Exception(curMeth.name + " already exists");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }

        if(!node.getBegin().toString().equals(node.getEnd().toString())){
            try{throw new Exception(node.getBegin().toString() + "does not match the meth end");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }

        curClass.meth_decls.add(curMeth);


    }

    @Override
    public void outAMethDef(AMethDef node) {
        super.outAMethDef(node);

        curMeth = null;

    }

    @Override
    public void outAMethType(AMethType node) {
        super.outAMethType(node);

        curMeth.returntype = attributeGrammerMap.get(node.getType());

        if (curMeth.returntype != null){
            Vari_Dec newvar = new Vari_Dec();
            newvar.Id = curMeth.name.trim();
            newvar.tip = curMeth.returntype;
            curMeth.var_decls.add(newvar);
        }
    }

    //class in out
    @Override
    public void inAClassDef(AClassDef node)  {
        super.inAClassDef(node);




        lastToken = node.getBegin();

        curClass = new Class_Dec();
        curClass.name = node.getBegin().toString().trim();
        if (symbol_table.class_decls.size() > 2){
            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT more than one class edition :((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }

        if (symbol_table.checkType(node.getBegin().toString()) != null){
            try{throw new Exception(node.getBegin().toString() + " already exists");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }

        if(!node.getBegin().toString().equals(node.getEnd().toString())){
            try{throw new Exception(node.getBegin().toString() + "does not match the class.end");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }

        symbol_table.class_decls.add(curClass);



    }



    @Override
    public void outAClassDef(AClassDef node) {
        super.outAClassDef(node);

        curClass = null;






    }



    @Override
    public void outAExtendsProd(AExtendsProd node)  {
        super.outAExtendsProd(node);
        lastToken = node.getId();
        try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
    }

    @Override
    public void outAArgument(AArgument node)  {
        super.outAArgument(node);
        lastToken = node.getId();

        Argument iarg = new Argument();

        iarg.id = node.getId().toString().trim();
        iarg.tip = attributeGrammerMap.get(node.getType());
        if(curMeth.checkTable(iarg.id)){
            try{throw new Exception("Argument type error :(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        } else {
            curMeth.args.add(iarg);

        }





    }

//statements

        @Override
        public void outAIfStatement(AIfStatement node)  {
            super.outAIfStatement(node);




            if (Type.bool != attributeGrammerMap.get(node.getCondition())){
                try{throw new Exception("if stmt comparison has errored D:");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }



        }

        @Override
        public void outAWhileStatement(AWhileStatement node)  {
            super.outAWhileStatement(node);


            if (Type.bool != attributeGrammerMap.get(node.getCondition())){
                try{throw new Exception("while stmt comparison has errored D:");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }





        }

        @Override
        public void outAAssignOpStatement(AAssignOpStatement node)  {
            super.outAAssignOpStatement(node);
            lastToken = node.getId();


            Type blah = null;



            if(curMeth.checkTable(node.getId().toString())){
                attributeGrammerMap.put(node,  curMeth.checkType(node.getId().toString()));
                blah = curMeth.checkType(node.getId().toString());
            } else if (curClass.checkTable(node.getId().toString())) {

                attributeGrammerMap.put(node,  curClass.checkType(node.getId().toString()));
                blah = curClass.checkType(node.getId().toString());
            }else{

                try{throw new Exception("Bad no Id found D:");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }


            if (blah.name.equals( attributeGrammerMap.get(node.getExpression()).name)){
                attributeGrammerMap.put(node, Type.integer);
            } else {
                try{throw new Exception("you done goofed and are assigned wrong types together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }



        }

    @Override
    public void outAMethExprExpression(AMethExprExpression node) {
        super.outAMethExprExpression(node);

        lastToken = node.getId();
        meth_dec iMeth ;

        Type tip = attributeGrammerMap.get(node.getLhs())!=null ? attributeGrammerMap.get(node.getLhs()) : new Type(curClass.name);
        String class_name = tip.name;
        Class_Dec iClass = symbol_table.checkType(class_name);
        if(iClass == null){
            try{throw new Exception(class_name +" had no method "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }
        iMeth = iClass.checkMeth(node.getId().toString());

        if(iMeth == null){
            try{throw new Exception(class_name +" had no method "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }



        attributeGrammerMap.put(node,iMeth.returntype);


        if(node.getRhs().size() != iMeth.args.size()){
            try{throw new Exception( " has the wrong num of params for "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }
        int i =0;
        for(PExpression expr : node.getRhs()){
            if(!attributeGrammerMap.get(expr).name.equals(iMeth.args.get(i).tip.name)){
                try{throw new Exception(class_name +" has the wrong type of param for "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }
            i++;
        }



    }


    //TODO dont forget me





        @Override
        public void outAMethodCallStatement(AMethodCallStatement node)  {
            super.outAMethodCallStatement(node);
            lastToken = node.getId();

            meth_dec iMeth ;

            Type tip = attributeGrammerMap.get(node.getDot())!=null ? attributeGrammerMap.get(node.getDot()) : new Type(curClass.name);
            String class_name = tip.name;
            Class_Dec iClass = symbol_table.checkType(class_name);
            if(iClass == null){
                try{throw new Exception(class_name +" had no method "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }
            iMeth = iClass.checkMeth(node.getId().toString());

            if(iMeth == null){
                try{throw new Exception(class_name +" had no method "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }

            //TODO: set this node's attributegrammar thing to be its own return type from method




           if(node.getParams().size() != iMeth.args.size()){
               try{throw new Exception(class_name +" has the wrong num of params for "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
           }
            int i =0;
            for(PExpression expr : node.getParams()){
                if(!attributeGrammerMap.get(expr).name.equals(iMeth.args.get(i).tip.name)){
                    try{throw new Exception(class_name +" has the wrong type of param for "+ node.getId().toString() );}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
                }
                i++;
            }




        }


//type

        @Override
        public void outACustomType(ACustomType node) {
            super.outACustomType(node);
            lastToken = node.getId();
            attributeGrammerMap.put(node, new Type(node.getId().toString()));


        }

        @Override
        public void outAArrayType(AArrayType node)  {
            super.outAArrayType(node);


            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT the array section");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }

        @Override
        public void outAStringType(AStringType node)  {
            lastToken = node.getString();
            super.outAStringType(node);
            attributeGrammerMap.put(node, Type.string);
            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }

        @Override
        public void outABooleanType(ABooleanType node) {
            super.outABooleanType(node);
            lastToken = node.getBool();
            attributeGrammerMap.put(node, Type.bool);
        }

        @Override
        public void outAIntType(AIntType node) {
            super.outAIntType(node);
            lastToken = node.getInt();
            attributeGrammerMap.put(node, Type.integer);




        }


    //vars out


    @Override
    public void outAVarDec(AVarDec node)  {
        super.outAVarDec(node);
        lastToken = node.getId();
        Vari_Dec iVar = new Vari_Dec();

        iVar.Id = node.getId().toString().trim();
        iVar.tip = attributeGrammerMap.get(node.getType());
        if(node.getExpression() != null){
            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT the type assignment of var expression section stuff yea :D");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }
        if(iVar.tip == null){
            try{throw new Exception("no type :(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
        }



       if (curMeth == null){
           //class
           //check if var exists in class else add to class;

           if(curClass.checkTable(iVar.Id)){
               try{throw new Exception("Bad don't declare things already declared in classes");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
           } else {
               curClass.var_decls.add(iVar);

           }

       } else {
           // method


           if(curMeth.checkTable(iVar.Id)){
               try{throw new Exception("Bad don't declare things already declared in methods");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
           } else {
               curMeth.var_decls.add(iVar);

           }



       }


    }

    //block of low level expressions
        @Override
        public void outAMeExpression(AMeExpression node) {
            super.outAMeExpression(node);

            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT me edition :((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}




           // attributeGrammerMap.put(node,new Type(curClass.name));

        }

        @Override
        public void outAIdExpression(AIdExpression node)  {
            super.outAIdExpression(node);
            lastToken = node.getId();

            if(curMeth.checkTable(node.getId().toString())){
                attributeGrammerMap.put(node,  curMeth.checkType(node.getId().toString()));
            } else if (curClass.checkTable(node.getId().toString())) {

                attributeGrammerMap.put(node,  curClass.checkType(node.getId().toString()));
            } else if (symbol_table.checkTable(node.getId().toString()) != null) {
                attributeGrammerMap.put(node, symbol_table.checkTable(node.getId().toString()).tip);
            }else{

                try{throw new Exception("Bad no Id found D:");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
            }



        }


    @Override
    public void outANullExpression(ANullExpression node) {
        super.outANullExpression(node);
        try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT null :((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

    }

    @Override
        public void outAFalseExpression(AFalseExpression node) {
            super.outAFalseExpression(node);

            attributeGrammerMap.put(node, Type.bool);

        }

        @Override
        public void outATrueExpression(ATrueExpression node) {
            super.outATrueExpression(node);
            attributeGrammerMap.put(node, Type.bool);
        }

        @Override
        public void outAStringExpression(AStringExpression node) {
            super.outAStringExpression(node);
            lastToken = node.getStrLit();
            attributeGrammerMap.put(node, Type.string);
        }

        @Override
        public void outAIntExpression(AIntExpression node) {
            super.outAIntExpression(node);
            lastToken = node.getIntLiteral();
            attributeGrammerMap.put(node, Type.integer);
        }

        @Override
        public void outANewExpression(ANewExpression node) {
            super.outANewExpression(node);
            try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT new edition :((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

           // lastToken = node.getId();
           // attributeGrammerMap.put(node, new Type(node.getId().toString()));
        }

    // level 7 unaries
        @Override
        public void outAPosExpression(APosExpression node)  {
            super.outAPosExpression(node);

            if (attributeGrammerMap.get(node.getExpression()) == Type.integer){
                attributeGrammerMap.put(node, Type.integer);
            } else {
                try{throw new Exception("math unaries can only be used on ints :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }

        }

        @Override
        public void outANegExpression(ANegExpression node)  {
            super.outANegExpression(node);

            if (attributeGrammerMap.get(node.getExpression()) == Type.integer){
                attributeGrammerMap.put(node, Type.integer);
            } else {
                try{throw new Exception("math unaries can only be used on ints :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        }

        @Override
        public void outANotExpression(ANotExpression node)  {
            super.outANotExpression(node);
            if (attributeGrammerMap.get(node.getExpression()) == Type.bool){
                attributeGrammerMap.put(node, Type.bool);
            } else {
                try{throw new Exception("bool unaries can only be used on bools :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        }



    // div mult add sub



    @Override
    public void outADivExpression(ADivExpression node)  {
        super.outADivExpression(node);


        if (attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer){
            attributeGrammerMap.put(node, Type.integer);
        } else {
            try{throw new Exception("you done goofed and are adding non ints together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }

    }

    @Override
    public void outAMultExpression(AMultExpression node)  {
        super.outAMultExpression(node);

        if (attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer){
            attributeGrammerMap.put(node, Type.integer);
        } else {
            try{throw new Exception("you done goofed and are adding non ints together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }
    }

    @Override
    public void outAMinusExpression(AMinusExpression node)  {
        super.outAMinusExpression(node);
        if (attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer){
            attributeGrammerMap.put(node, Type.integer);
        } else {
            try{throw new Exception("you done goofed and are adding non ints together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }
    }

    @Override
    public void outAAddExpression(AAddExpression node)  {
        super.outAAddExpression(node);
        if (attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer){
            attributeGrammerMap.put(node, Type.integer);
        } else {
            try{throw new Exception("you done goofed and are adding non ints together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }
    }


    // concat


    @Override
        public void outAConcatExpression(AConcatExpression node)  {
            super.outAConcatExpression(node);
            if (attributeGrammerMap.get(node.getLhs()) == Type.string && attributeGrammerMap.get(node.getRhs()) == Type.string){
                attributeGrammerMap.put(node, Type.string);
            } else {
                try{throw new Exception("you done goofed and are adding non strings together :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        try{throw new Exception("YOU DONE USED A NON USABLE FEATURE ..... THAT MEANS DON'T USE IT string concat edition :((");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.string);return;}

        }


    // equivelence sterf


        @Override
        public void outAEqualExpression(AEqualExpression node)  {
            super.outAEqualExpression(node);
            if ((attributeGrammerMap.get(node.getLhs()) == attributeGrammerMap.get(node.getRhs()))){

                if( (attributeGrammerMap.get(node.getLhs()) == Type.integer ) || (attributeGrammerMap.get(node.getLhs())) == Type.string || (attributeGrammerMap.get(node.getLhs())) == Type.bool) {
                    attributeGrammerMap.put(node, Type.bool);
                } else {
                    try{throw new Exception("you done goofed and are equaling things are not equaled :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}
                }

            } else {
                try{throw new Exception("you done goofed and are equaling two non equal types :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        }

        @Override
        public void outAGreaterExpression(AGreaterExpression node)  {
            super.outAGreaterExpression(node);
            if ((attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer)
                    || (attributeGrammerMap.get(node.getLhs()) == Type.string && attributeGrammerMap.get(node.getRhs()) == Type.string)){

                attributeGrammerMap.put(node, Type.bool);
            } else {
                try{throw new Exception("greater require ints  :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }

        }

        @Override
        public void outALessThanExpression(ALessThanExpression node)  {
            super.outALessThanExpression(node);
            if ((attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer)
                    || (attributeGrammerMap.get(node.getLhs()) == Type.string && attributeGrammerMap.get(node.getRhs()) == Type.string)) {

                attributeGrammerMap.put(node, Type.bool);
            } else {
                try{throw new Exception("lessthan require ints  :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        }

        @Override
        public void outALesserExpression(ALesserExpression node)  {
            super.outALesserExpression(node);

            if ((attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer)
                    || (attributeGrammerMap.get(node.getLhs()) == Type.string && attributeGrammerMap.get(node.getRhs()) == Type.string)) {
                attributeGrammerMap.put(node, Type.bool);
            } else {
                try{throw new Exception("less require ints  :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }

        }

        @Override
        public void outAGreaterThanExpression(AGreaterThanExpression node)  {
            super.outAGreaterThanExpression(node);
            if ((attributeGrammerMap.get(node.getLhs()) == Type.integer && attributeGrammerMap.get(node.getRhs()) == Type.integer)
                    || (attributeGrammerMap.get(node.getLhs()) == Type.string && attributeGrammerMap.get(node.getRhs()) == Type.string)) {
                attributeGrammerMap.put(node, Type.bool);
            } else {
                try{throw new Exception("greaterthan require ints  :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

            }
        }


    //and or boolean stuffs


    @Override
    public void outAOrExpression(AOrExpression node)  {
        super.outAOrExpression(node);
        if (attributeGrammerMap.get(node.getLhs()) == Type.bool && attributeGrammerMap.get(node.getRhs()) == Type.bool){
            attributeGrammerMap.put(node, Type.bool);
        } else {
            try{throw new Exception("you done goofed and are adding non bools togethor :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }
    }

    @Override
    public void outAAndExpression(AAndExpression node)  {
        super.outAAndExpression(node);
        if (attributeGrammerMap.get(node.getLhs()) == Type.bool && attributeGrammerMap.get(node.getRhs()) == Type.bool){
            attributeGrammerMap.put(node, Type.bool);
        } else {
            try{throw new Exception("you done goofed and are adding non bools togethor :'(");}catch(Exception e){reportError(e);attributeGrammerMap.put(node,Type.error);return;}

        }
    }
}
