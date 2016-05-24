package com.bju.cps450;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.node.*;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by carragher on 3/30/16.
 */
public class codeGen extends DepthFirstAdapter {

    private HashMap<Node, String> nodeCode = new HashMap<Node,String>();
    public Class_Dec curClass = null;
    public meth_dec curMeth = null;
    public Token lastToken = null;
    private int whiles = 0;
    private int ifs = 0;
    private int bool_check = 0;



    @Override
    public void outAStart(AStart node) {
        super.outAStart(node);

        //grab code shove into file
        String attempt =




                "#quu..__\n" +
                        "# $$$b  `---.__\n" +
                        "#  \"$$b        `--.                          ___.---uuudP\n" +
                        "#   `$$b           `.__.------.__     __.---'      $$$$\"              .\n" +
                        "#     \"$b          -'            `-.-'            $$$\"              .'|\n" +
                        "#       \".                                       d$\"             _.'  |\n" +
                        "#         `.   /                              ...\"             .'     |\n" +
                        "#           `./                           ..::-'            _.'       |\n" +
                        "#            /                         .:::-'            .-'         .'\n" +
                        "#           :                          ::''\\          _.'            |\n" +
                        "#          .' .-.             .-.           `.      .'               |\n" +
                        "#          : /'$$|           .@\"$\\           `.   .'              _.-'\n" +
                        "#         .'|$u$$|          |$$,$$|           |  <            _.-'\n" +
                        "#         | `:$$:'          :$$$$$:           `.  `.       .-'\n" +
                        "#         :                  `\"--'             |    `-.     \\\n" +
                        "#        :##.       ==             .###.       `.      `.    `\\\n" +
                        "#        |##:                      :###:        |        >     >\n" +
                        "#        |#'     `..'`..'          `###'        x:      /     /\n" +
                        "#         \\                                   xXX|     /    ./\n" +
                        "#          \\                                xXXX'|    /   ./\n" +
                        "#          /`-.                                  `.  /   /\n" +
                        "#         :    `-  ...........,                   | /  .'\n" +
                        "#         |         ``:::::::'       .            |<    `.\n" +
                        "#         |             ```          |           x| \\ `.:``.\n" +
                        "#         |                         .'    /'   xXX|  `:`M`M':.\n" +
                        "#         |    |                    ;    /:' xXXX'|  -'MMMMM:'\n" +
                        "#         `.  .'                   :    /:'       |-'MMMM.-'\n" +
                        "#          |  |                   .'   /'        .'MMM.-'\n" +
                        "#          `'`'                   :  ,'          |MMM<\n" +
                        "#            |                     `'            |tbap\\\n" +
                        "#             \\                                  :MM.-'\n" +
                        "#              \\                 |              .''\n" +
                        "#               \\.               `.            /\n" +
                        "#                /     .:::::::.. :           /\n" +
                        "#               |     .:::::::::::`.         /\n" +
                        "#               |   .:::------------\\       /\n" +
                        "#              /   .''               >::'  /\n" +
                        "#              `',:                 :    .'\n" +
                        "#                                    \n";

        String ShoveMe = attempt + nodeCode.get(node.getClassDef().get(0));
    try {
        PrintWriter writer = new PrintWriter("out.s", "UTF-8");
        writer.print(ShoveMe);
        writer.close();

    } catch (Exception e){

    }



    }

    //todo leave a brotha hangin
    @Override
    public void inAClassDef(AClassDef node) {
        super.inAClassDef(node);
        curClass = symbol_table.checkType(node.getBegin().toString());
    }

    @Override
    public void outAClassDef(AClassDef node) {
        super.outAClassDef(node);
        String code = ""
;        for(PVarDec var : node.getVarDec()){
            code += nodeCode.get(var);
        }
        code += ".global main \n";
        code += "main:\n";
        code += "jmp start\n";
        for(PMethDef meth : node.getMethDef()){
            code += nodeCode.get(meth);
        }



        nodeCode.put(node, code);

    }


    @Override
    public void inAMethDef(AMethDef node) {
        super.inAMethDef(node);
        curMeth = curClass.checkMeth(node.getBegin().toString());
    }

    @Override
    public void outAMethDef(AMethDef node) {
        super.outAMethDef(node);
        //model after class

        String code = ""+curMeth.name + ":\n";
        code += "enter $" + (curMeth.var_decls.size() *4) + ",$0 \n";
        //getting all the variable code
        int index = 1;
        for(Vari_Dec var : curMeth.var_decls){
        //    code += nodeCode.get(var);
            code += "movl $0, -" + (index*4) + "(%ebp)\n";
            index++;
        }

        //getting all the stmt code
        for(PStatement stmt : node.getStatement()) {
            code += nodeCode.get(stmt);
        }
        if(curMeth.returntype != null){
            code += "movl -4(%ebp), %eax \n";
           // code += "popl (%ebp)\n";
        }//todo baby come back

        code+= "leave\n";
        code+= "ret\n";


        code += "#MethDef \n";



        nodeCode.put(node, code);

    }




    @Override
    public void outAVarDec(AVarDec node) {
        super.outAVarDec(node);
        String code = ".comm _" + node.getId() + ", 4, 4 \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAIfStatement(AIfStatement node) {
        super.outAIfStatement(node);
        String code = "ifCond" + (++ifs) + ":\n" +
                nodeCode.get(node.getCondition()) +
                "popl %eax \n" +
                "cmpl $1, %eax \n" +
                "jne elseif" + ifs + "\n" +

                "beginif" + ifs + ":\n";

        for(PStatement stmt : node.getTrue()) {
            code += nodeCode.get(stmt);
        }
        code += "jmp endif" + ifs + "\n";

        code += "elseif" + ifs + ":\n";


        for(PStatement stmt : node.getFalse()) {
            code += nodeCode.get(stmt);
        }

        code += "endif" + ifs + ":\n #if \n" ;



        nodeCode.put(node, code);
    }

    @Override
    public void outAWhileStatement(AWhileStatement node) {
        super.outAWhileStatement(node);
        String code = "whileCond" + (++whiles) + ":\n" +
                nodeCode.get(node.getCondition()) +
                "popl %eax \n" +
                "cmpl $1, %eax \n" +
                "jne endWhile" + whiles + "\n" +

                "beginWhile" + whiles + ":\n";

        for(PStatement stmt : node.getStatement()) {
            code += nodeCode.get(stmt);
        }
                code += "jmp whileCond" + whiles + "\n";
                code += "endWhile" + whiles + ":\n #while \n" ;



        nodeCode.put(node, code);

    }

    @Override
    public void outAAssignOpStatement(AAssignOpStatement node) {
        super.outAAssignOpStatement(node);

        String code = nodeCode.get(node.getExpression()) +


                "popl %eax\n";



        int indexoffset = 0;



        if(curMeth.checkType(node.getId().toString()) != null){
            //do stuff
            if(curMeth.checknonargindex(node.getId().toString() + " ") != -1){
                indexoffset = curMeth.checknonargindex(node.getId().toString()+ " ")+1;

                code += "movl %eax, " + indexoffset*-4 +"(%ebp)" + "\n";


            }else{
                indexoffset = curMeth.checkArgindex(node.getId().toString()+ " ") + 2;

                code += "movl %eax, " + indexoffset*4 +"(%ebp)" + "\n";
            }

        }else if(curClass.checkType(node.getId().toString()) != null){
            //indexoffset = curClass.checkindex(node.getId().toString());
            code += "movl %eax, _" + node.getId().toString() + "\n";

        }
        code += "#assign\n";
        nodeCode.put(node, code);
    }

    @Override
    public void outAMethodCallStatement(AMethodCallStatement node) {
        super.outAMethodCallStatement(node);
        String code = "";



        for( int i = node.getParams().size()-1; i >= 0; --i) {
            code += nodeCode.get(node.getParams().get(i));
        }

        code+= "call " + node.getId().toString()+"\n" +
                "addl $" + node.getParams().size() * 4 + ", %esp\n";

        //code += "pushl %eax \n";
        code += "#call good luck \n";


        nodeCode.put(node, code);

    }

    @Override
    public void outAOrExpression(AOrExpression node) {
        super.outAOrExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "orl %ebx, %eax \n" +
                "pushl %eax\n" +
                "#OR \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAAndExpression(AAndExpression node) {
        super.outAAndExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "andl %ebx, %eax \n" +
                "pushl %eax\n" +
                "#and \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAGreaterThanExpression(AGreaterThanExpression node) {
        super.outAGreaterThanExpression(node);

        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cmpl %ebx, %eax \n" +
                "jl bool_check" + (++bool_check) + "\n" +

                "pushl $1\n" +
                "jmp bool_true" + bool_check + "\n" +
                "bool_check" + bool_check + ":\n" +
                "pushl $0\n" +
                "bool_true" + bool_check + ":\n"+

                "#greaterthan \n";


        nodeCode.put(node, code);

    }

    @Override
    public void outAEqualExpression(AEqualExpression node) {
        super.outAEqualExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cmpl %ebx, %eax \n" +
                "jne bool_check" + (++bool_check) + "\n" +

                "pushl $1\n" +
                "jmp bool_true" + bool_check + "\n" +
                "bool_check" + bool_check + ":\n" +
                "pushl $0\n" +
                "bool_true" + bool_check + ":\n"+

                "#equals \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAGreaterExpression(AGreaterExpression node) {
        super.outAGreaterExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cmpl %ebx, %eax \n" +
                "jle bool_check" + (++bool_check) + "\n" +

                "pushl $1\n" +
                "jmp bool_true" + bool_check + "\n" +
                "bool_check" + bool_check + ":\n" +
                "pushl $0\n" +
                "bool_true" + bool_check + ":\n"+

                "#greater \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outALessThanExpression(ALessThanExpression node) {
        super.outALessThanExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cmpl %ebx, %eax \n" +
                "jg bool_check" + (++bool_check) + "\n" +

                "pushl $1\n" +
                "jmp bool_true" + bool_check + "\n" +
                "bool_check" + bool_check + ":\n" +
                "pushl $0\n" +
                "bool_true" + bool_check + ":\n"+

                "#lessthan \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outALesserExpression(ALesserExpression node) {
        super.outALesserExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cmpl %ebx, %eax \n" +
                "jge bool_check" + (++bool_check) + "\n" +

                "pushl $1\n" +
                "jmp bool_true" + bool_check + "\n" +
                "bool_check" + bool_check + ":\n" +
                "pushl $0\n" +
                "bool_true" + bool_check + ":\n"+

                "#lesser \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAAddExpression(AAddExpression node) {
        super.outAAddExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "addl %ebx, %eax \n" +
                "pushl %eax\n" +
                "#ADD \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAMinusExpression(AMinusExpression node) {
        super.outAMinusExpression(node);

        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "subl %ebx, %eax \n" +
                "pushl %eax\n" +
                "#Minus \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAMultExpression(AMultExpression node) {
        super.outAMultExpression(node);

        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "imull %ebx \n" +
                "pushl %eax\n" +
                "#MULT \n";


        nodeCode.put(node, code);
    }

    @Override
    public void outADivExpression(ADivExpression node) {
        super.outADivExpression(node);
        String code = nodeCode.get(node.getLhs()) +
                nodeCode.get(node.getRhs()) +
                "popl %ebx\n" +
                "popl %eax\n" +
                "cdq\n" +
                "idivl %ebx \n" +
                "pushl %eax\n" +
                "#idiv \n";


        nodeCode.put(node, code);

    }

    @Override
    public void outANotExpression(ANotExpression node) {
        super.outANotExpression(node);

        String code = nodeCode.get(node.getExpression()) +
                "popl %eax\n" +
                "xorl $1, %eax\n" +
                "pushl %eax\n"
                + "#not\n";




        nodeCode.put(node, code);
    }

    @Override
    public void outANegExpression(ANegExpression node) {
        super.outANegExpression(node);

        String code = nodeCode.get(node.getExpression()) +
                "popl %eax\n" +
                "negl %eax \n" +
                "pushl %eax\n" +
                "#neg\n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAPosExpression(APosExpression node) {
        super.outAPosExpression(node);

        String code = nodeCode.get(node.getExpression()) +
                "popl %eax\n" +
                "pushl %eax\n";


        nodeCode.put(node, code);
    }

    //todo ignore me bois
    @Override
    public void outANewExpression(ANewExpression node) {
        super.outANewExpression(node);
    }

    @Override
    public void outAIntExpression(AIntExpression node) {
        super.outAIntExpression(node);
        String code = "pushl $" + node.getIntLiteral().toString() +"\n";


        nodeCode.put(node, code);
    }


    //todo pahse 5 maybe
    @Override
    public void outAStringExpression(AStringExpression node) {
        super.outAStringExpression(node);
    }

    @Override
    public void outATrueExpression(ATrueExpression node) {
        super.outATrueExpression(node);
        String code = "pushl $1\n";


        nodeCode.put(node, code);
    }

    @Override
    public void outAFalseExpression(AFalseExpression node) {
        super.outAFalseExpression(node);
        String code = "pushl $0\n";


        nodeCode.put(node, code);
    }


    @Override
    public void outAIdExpression(AIdExpression node) {
        super.outAIdExpression(node);

        int indexoffset = 0;
        String code = "";


        if(curMeth.checkType(node.getId().toString()) != null){
            //do stuff
            if(curMeth.checknonargindex(node.getId().toString()) != -1){
                 indexoffset = curMeth.checknonargindex(node.getId().toString()) + 1;

                code += "pushl " + indexoffset*(-4) +"(%ebp)" + "\n";


            }else{
                 indexoffset = curMeth.checkArgindex(node.getId().toString()) + 2;

                code += "pushl " + indexoffset*4 +"(%ebp)" + "\n";
            }

        }else if(curClass.checkType(node.getId().toString()) != null){
             //indexoffset = curClass.checkindex(node.getId().toString());
            code += "pushl _" + node.getId().toString() + "\n";

        }



        code += "#ID \n";





        nodeCode.put(node, code);
    }
    //todo COME BACK LATER
    @Override
    public void outAMethExprExpression(AMethExprExpression node) {
        super.outAMethExprExpression(node);
        String code = "";



        for( int i = node.getRhs().size()-1; i >= 0; --i) {
            code += nodeCode.get(node.getRhs().get(i));
        }

        code+= "call " + node.getId().toString()+"\n" +
                "addl $" + node.getRhs().size() * 4 + ", %esp\n";

        code += "pushl %eax \n";
        code += "#methexpr good luck \n";


        nodeCode.put(node, code);


    }
}
