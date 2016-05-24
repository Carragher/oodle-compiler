package com.bju.cps450.test;

import java.io.*;

import com.bju.cps450.ExtLexer;
import com.bju.cps450.node.*;
import junit.framework.TestCase;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.lexer.LexerException;

public class LexerTest extends TestCase {
	Lexer lex;

	//currently tests all tokens
	public void testSuccessfulScan() throws IOException, LexerException {
		ExtLexer lexer = new ExtLexer(new PushbackReader(new BufferedReader(new FileReader("lexertest.ood"))));
		assertNextToken(lexer, TString.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer, TThen.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer, TWhile.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer, TBool.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer, TBegin.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TClasskey.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TElse.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TEnd.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TFrom.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TIf.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TInherits.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TInt.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TIs.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TLoop.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TMe.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TNew.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TNull.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TTrue.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TFalse.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TAnd.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TOr.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TNot.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TTab.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TDot.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TAssignOp.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TLParen.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TRParen.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TLBracket.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TRBracket.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TComma.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TSemiColon.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TColon.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TConcat.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TPlus.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TMinus.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TStar.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TDiv.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TGthan.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TLthan.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TGthanEq.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TLthanEq.class);
		assertNextToken(lexer,TSpctab.class);
		assertNextToken(lexer,TEqual.class);
		assertNextToken(lexer, TLinefilter.class);
		assertNextToken(lexer,TUnknownChar.class);
		assertNextToken(lexer, TLinefilter.class);
		assertNextToken(lexer, TUntermStr.class);

		assertNextToken(lexer, TIllegalStrLit.class);



		assertNextToken(lexer, TLinefilter.class);
		assertNextToken(lexer, EOF.class);
	}

	public void assertNextToken(ExtLexer lexer, Class tokenExpected) throws IOException, LexerException {
		Token t = lexer.next();
		System.err.println(t);
		if(t.getClass().equals(tokenExpected)) {
			return;
		} else {
			fail();
		}
	}
}
