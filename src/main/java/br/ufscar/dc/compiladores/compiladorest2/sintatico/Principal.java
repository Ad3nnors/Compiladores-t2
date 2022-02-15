package br.ufscar.dc.compiladores.compiladorest2.sintatico;

import br.ufscar.dc.compiladores.compiladorest2.MyCustomErrorListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {

    public static void main(String args[]) throws IOException {
        // args[0] é o arquivo de entrada (algoritmo)
        // args[1] é o arquivo de saída
        try ( PrintWriter pw = new PrintWriter(new File(args[1]))) {
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lexer = new LALexer(cs);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LAParser parser = new LAParser(tokens);

            // Registrar o error lister personalizado aqui
            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.addErrorListener(mcel);

            try {
                parser.programa();
            } catch (RuntimeException re) {
                if (re.getMessage().equals("Parar")) {
                    // não faz nada, apenas para
                } else {
                    throw re; // não era a nossa exception! re-lança para que o erro apareça
                }
            }
            pw.println("Fim da compilacao");
        }

    }
}
