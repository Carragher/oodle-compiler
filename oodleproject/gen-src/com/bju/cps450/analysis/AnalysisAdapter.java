/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.analysis;

import java.util.*;
import com.bju.cps450.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStart(AStart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClassDef(AClassDef node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExtendsProd(AExtendsProd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDec(AVarDec node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethDef(AMethDef node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethType(AMethType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringType(AStringType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayType(AArrayType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACustomType(ACustomType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArgument(AArgument node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignOpStatement(AAssignOpStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethodCallStatement(AMethodCallStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrExpression(AOrExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndExpression(AAndExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterThanExpression(AGreaterThanExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualExpression(AEqualExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterExpression(AGreaterExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessThanExpression(ALessThanExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALesserExpression(ALesserExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddExpression(AAddExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusExpression(AMinusExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultExpression(AMultExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivExpression(ADivExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConcatExpression(AConcatExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotExpression(ANotExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegExpression(ANegExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPosExpression(APosExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANewExpression(ANewExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntExpression(AIntExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringExpression(AStringExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATrueExpression(ATrueExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdExpression(AIdExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMeExpression(AMeExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANullExpression(ANullExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrexpExpression(AArrexpExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethExprExpression(AMethExprExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTContinuation(TContinuation node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBool(TBool node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBegin(TBegin node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTClasskey(TClasskey node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnd(TEnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFrom(TFrom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInherits(TInherits node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIs(TIs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLoop(TLoop node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMe(TMe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNew(TNew node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNull(TNull node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTab(TTab node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAssignOp(TAssignOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLParen(TLParen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRParen(TRParen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLBracket(TLBracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRBracket(TRBracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLCurly(TLCurly node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRCurly(TRCurly node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemiColon(TSemiColon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConcat(TConcat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStar(TStar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGthan(TGthan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLthan(TLthan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGthanEq(TGthanEq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLthanEq(TLthanEq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSpctab(TSpctab node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntLiteral(TIntLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStrLit(TStrLit node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIllegalStrLit(TIllegalStrLit node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLinefilter(TLinefilter node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTUntermStr(TUntermStr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTUnknownChar(TUnknownChar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
