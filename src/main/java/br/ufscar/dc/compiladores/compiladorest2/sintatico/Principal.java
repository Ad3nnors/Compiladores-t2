package br.ufscar.dc.compiladores.compiladorest2.sintatico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        LALexer lexer = new LALexer(cs);
        
//        // Descomentar para depurar o Léxico
//        Token t = null;
            Token t = null;
            
            FileWriter arq = new FileWriter(args[1]);
            PrintWriter gravarArq = new PrintWriter(arq);
            int i = 1; // variável auxiliar para definir casos de parada 
            while ((t = lexer.nextToken()).getType() != Token.EOF && i == 1) { 
            // t recebe proxima token até encontrar o final do arquivo ou até encontrar algum caso de parada (i != 1) 
                
                //System.out.println("<" + LALexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
                //System.out.print(t.getText() + "  ");
                /*
                if (AlgumaLexer.VOCABULARY.getDisplayName(t.getType()).equals("PALAVRA_CHAVE"))
                    gravarArq.printf("<'%s','%s'>\n", t.getText(), t.getText());
                else 
                */
                if (LALexer.VOCABULARY.getDisplayName(t.getType()).equals("COMENTARIO_ERRADO")){
                    gravarArq.printf("Linha %d : comentario nao fechado\n", t.getLine());
                    i = 0;
                }
                else if (LALexer.VOCABULARY.getDisplayName(t.getType()).equals("CADEIA_ERRADA")){
                    gravarArq.printf("Linha %d : cadeia literal nao fechada\n", t.getLine());
                    i = 0;
                }
                else if (LALexer.VOCABULARY.getDisplayName(t.getType()).equals("ERROR")){
                    gravarArq.printf("Linha %d: %s - simbolo nao identificado\n", t.getLine(), t.getText());
                    i = 0;
                }
                //else gravarArq.printf("<'%s',%s>\n", t.getText(), AlgumaLexer.VOCABULARY.getDisplayName(t.getType()));
            }
            
            arq.close();


//        while( (t = lexer.nextToken()).getType() != Token.EOF) {
//            System.out.println("<" + LALexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
//        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LAParser parser = new LAParser(tokens);
        parser.programa();
        //parser.
        
        List<Token> tokenlist = tokens.getTokens();
        
                
    }
}
