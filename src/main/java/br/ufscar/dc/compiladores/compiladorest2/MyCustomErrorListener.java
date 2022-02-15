/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.compiladorest2;

import br.ufscar.dc.compiladores.compiladorest2.sintatico.LALexer;
import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author ander
 */
public class MyCustomErrorListener implements ANTLRErrorListener {

    PrintWriter pw;

    public MyCustomErrorListener(PrintWriter pw) {
        this.pw = pw;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        // tratamento de erro customizado
        Token t = (Token) o;
        switch (LALexer.VOCABULARY.getDisplayName(t.getType())) {
            case "COMENTARIO_ERRADO":
                pw.printf("Linha " + t.getLine() + ": comentario nao fechado\n");
                break;
            case "CADEIA_ERRADA":
                pw.printf("Linha " + t.getLine() + ": cadeia literal nao fechada\n");
                break;
            case "ERROR":
                pw.printf("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n");
                break;
            default:
                pw.println("Linha " + i + ": erro sintatico proximo a " + (("<EOF>".equals(t.getText())) ? "EOF" : t.getText()));
                break;
        }
        // parada para não identificar mais de um erro
        throw new RuntimeException("Parar");
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
        // Não será necessário para o T2
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
        // Não será necessário para o T2
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
        // Não será necessário para o T2
    }

}
