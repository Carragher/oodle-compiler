/* Oodle.java
 * Author: Ethan McGee
 * Date: 2014-01-23
 * 
 * Purpose: Main class for Oodle compiler project
 */

package com.bju.cps450;
import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.node.EOF;
import com.bju.cps450.node.Start;
import com.bju.cps450.parser.ParserException;
import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.IllegalOptionValueException;
import jargs.gnu.CmdLineParser.UnknownOptionException;

import java.io.*;


import com.bju.cps450.lexer.LexerException;

public class Oodle
{
	/* printHelp
	 * Arguments:
	 * 
	 * Purpose: Writes a help statement to standard out
	 */
	public static void printHelp() {
		System.out.println("Oodle Compiler");
		System.out.println("v 0.1");
		System.out.println("Author: <Carragher>");
		System.out.println("");
		System.out.println("Usage:");
		System.out.println(" java -jar oodle.jar [options] [files]");
	}

	//sets the ds flag
	public static void setDs() {
		Globals.dsTest = true;
	}

	public static void setS() {
		Globals.STest = true;
	}
	
	/* main
	 * Arguments:
	 *  @args - the list of command line arguments
	 * Purpose: main execution function for compiler
	 */
    public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {

		CmdLineParser parser = new CmdLineParser();
    	//command line options
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		CmdLineParser.Option token = parser.addBooleanOption('d',"ds");
		CmdLineParser.Option token1 = parser.addBooleanOption('s',"ds");
		CmdLineParser.Option tokenS = parser.addBooleanOption('S', "S");
		//parse command line arguments
		parser.parse(args);
		
		//set applicable values from options class
		if ((Boolean)parser.getOptionValue(help, false)) {
			printHelp();
			return;
		}

		if ((Boolean)parser.getOptionValue(tokenS, false)) {

		setS();
		}

		//cmd line parsing
		if ((boolean)parser.getOptionValue(token, false) && (boolean)parser.getOptionValue((token1),false)) {
			setDs();

		}
		//checks for files
		int argLen = parser.getRemainingArgs().length ;

		if (argLen <= 0 ){
			throw new IOException("no files to lex");
		}

		//initializing the lexer via temp file
		String[] file = parser.getRemainingArgs();
		FileManager.initArray = file;
		FileManager.generateTemp();
		PushbackReader reader = new PushbackReader(new InputStreamReader(new FileInputStream(FileManager.file)),1000);
		ExtLexer lexer = new ExtLexer(reader);
	//loop over the tokens until you hit EOF
		ExtParser phase2 = new ExtParser(lexer);
		Start node = null;
		try {
			 node =phase2.parse();
		} catch (ParserException e) {
			while(!(lexer.peek() instanceof EOF)){
				lexer.next();
			}

			e.printStackTrace();
		}
		SemanticChecker phase3 = new SemanticChecker();
		codeGen phase4 = new codeGen();
		assert node != null;
		node.apply(phase3);
		node.apply(phase4);
		if (Globals.STest == false) { // dont compile if -S
			ProcessBuilder pb = new ProcessBuilder("gcc", "-m32", "-o", file[file.length-1].toString().replace(".ood",""), "out" + ".s", "stdlib.o");
			Process p = pb.start();
			int ret = -1;

			try {
				ret = p.waitFor();
				System.out.println("AM I ACTUALLY WORKING?!?!?!?!");
			} catch (InterruptedException e) {
				System.out.println("compile process failed");
			}

			if (ret != 0) {
				System.out.println("Compile failure" + ret);
			}
		}

		if (Globals.STest != true){
			File files = new File("out.s");
			files.delete();
		}


	}
}

