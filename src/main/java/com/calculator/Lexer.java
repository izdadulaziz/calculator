

package com.caculator;

import java.util.ArrayList;
import com.caculator.Token;
import com.caculator.TokenType;

public class Lexer{
  
  private String sourceCode;
  private int position;
  
  public Lexer(String sourceCode){
    this.sourceCode = sourceCode;
    this.position = 0;
  }
  
  public ArrayList<Token> tokenize(){
    
    ArrayList<Token> tokens = new ArrayList<>();
    
    
    while(position < sourceCode.length()){
      
      if(Character.isWhitespace(sourceCode.charAt(position)));{
        
        skip();
        
      }else if(isNumber()){
        
        tokens.add(getNumber());
        
      }else if(isOperator()){
        
        tokens.add(getOperator());
        
      }else if(isParenthesis()){
        
        tokens.add(getParenthesis());
        
      }else{
        
        tokens.add(new Token(TokenType.ERROR, "INVALID TOKEN"));
        
      }
     
    }
    
    return tokens;
    
  }
  
  public void skip(){
    position++;
  }
  
  public boolean isNumber(){
    return Character.isDigit(sourceCode.charAt(position));
  }
  
  public Token getNumber(){
    int value = 0; 
    
    while(position < sourceCode.length() && Character.isDigit(sourceCode.charAt(position))){
      value = value * 10 + (code.charAt(position++) - '0');
    }
    
    skip();
    return new Token(TokenType.NUMBER, String.valueOf(value));
    
  }
  
  public boolean isOperator(){
    return sourceCode.charAt(position) == '+' || sourceCode.charAt(position) == '-' || sourceCode.charAt(position) == '*' || sourceCode.charAt(position) == '/';
  }
  
  public Token getOperator(){
    
    switch (sourceCode.charAt(position)) {
      case '+':
        skip();
        return new Token(TokenType.PLUS, "+");
      case '-':
        skip();
        return new Token(TokenType.MINUS, "-");
      case '*':
        skip();
        return new Token(TokenType.TIMES, "*")
      case '/':
        skip();
        return new Token(TokenType.DIVIDE, "/");
      default:
        skip();
        return new Token(TokenType.ERROR, "INVALID TOKEN");
      
    }
    
  }
  
  public boolean isParenthesis(){
    return sourceCode.charAt(position) =='(' || sourceCode.charAt(position) == ')';
  }
  
  public Token getParenthesis(){
    
    switch(sourceCode.charAt(position)){
      case '(':
        skip();
        return new Token(TokenType.LPAREN, "(");
      case ')':
        skip();
        return new Token(TokenType.RPAREN, ")");
      default:
        skip();
        return new Token(TokenType.ERROR, "INVALID TOKEN");
    }
  }
  
  
} 