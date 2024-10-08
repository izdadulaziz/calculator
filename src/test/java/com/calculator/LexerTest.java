

package com.calculator;

import org.junit.jupiter.api.Test;
import com.calculator.Lexer;
import com.calculator.tokens.Token;
import java.util.ArrayList;


public class LexerTest{
  
  @Test
  public void testLexer()  {
    
    String code = "1 + 1 * 2 + (100 * 20)";
    
    Lexer lexer = new Lexer(code);
    
    ArrayList<Token> tokens = lexer.tokenize();

    System.out.println("code : " + code);
    for(Token token : tokens){
      System.out.println("TOKEN ( " + token.getTokenType() + " ) -> " + token.getTokenValue());
    }
    
    
  }
  
}


