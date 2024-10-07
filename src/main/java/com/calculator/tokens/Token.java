

package com.calculator.tokens;

import com.calculator.tokens.TokenType;

public class Token{
  
  private TokenType tokenType;
  private String tokenValue;
  
  public Token(TokenType tokenType, String tokenValue){
    this.tokenType = tokenType;
    this.tokenValue = tokenValue;
    
  }
  
  public TokenType getTokenType(){
    return this.tokenType;
  }
  
  public String getTokenValue(){
    return this.tokenValue;
  }
  
} 