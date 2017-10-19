/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */


/**
 * Imports.
 */
package Triangle.SyntacticAnalyzer;


/**
 * Define Token class.
 */
final class Token extends Object {


  /**
   * Define the attributes.
   */
  protected int kind;
  protected String spelling;
  protected SourcePosition position;


  /**
   * Define the constructor.
   * 
   * @param kind
   * @param spelling
   * @param position 
   */
  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else {
      this.kind = kind;
    }

    this.spelling = spelling;
    this.position = position;
  }

  /**
   * Define function spell.
   * 
   * @param kind
   * @return 
   */
  public static String spell (int kind) {
    return tokenTable[kind];
  }

  /**
   * Define function toString.
   * @return 
   */
  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling + ", position=" + position;
  }

  /**
   * Token classes...
   * Literals, identifiers, operators...
   */
  public static final int

    // Literals.
    INTLITERAL          = 0,
    CHARLITERAL         = 1,
    IDENTIFIER          = 2,
    OPERATOR            = 3,

    // Reserved words - must be in alphabetical order...
    AND			= 4,           // EDWTORBA: Add AND token.
    ARRAY		= 5,
    //BEGIN		= 6,           // EDWTORBA: DELETE BEGIN token.
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FOR			= 10,           // EDWTORBA: Add FOR token.
    FUNC		= 11,
    IF			= 12,
    IN			= 13,
    LET			= 14,
    LOCAL		= 15,           // EDWTORBA: Add LOCAL token.
    OF			= 16,
    PAR			= 17,           // EDWTORBA: Add PAR token.
    PROC		= 18,
    RECORD		= 19,
    RECURSIVE           = 20,           // EDWTORBA: Add RECURSIVE token.
    REPEAT		= 21,           // EDWTORBA: Add REPEAT token.
    SKIP		= 22,           // EDWTORBA: Add SKIP token.
    THEN		= 23,
    TO			= 24,           // EDWTORBA: Add TO token.
    TYPE		= 25,
    UNTIL		= 26,           // EDWTORBA: Add UNITL token.
    VAR			= 27,
    WHILE		= 28,

    // Punctuation ...
    DOT			= 29,
    COLON		= 30,
    SEMICOLON           = 31,
    COMMA		= 32,
    BECOMES		= 33,
    IS			= 34,

    // Brackets ...
    LPAREN		= 35,
    RPAREN		= 36,
    LBRACKET            = 37,
    RBRACKET            = 38,
    LCURLY		= 39,
    RCURLY		= 40,

    // Special tokens ...
    EOT			= 41,
    ERROR		= 42;

  /**
   * Define token table.
   */
  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "and",                      // EDWTORBA: Add AND token.
    "array",
    //"begin",                  // EDWTORBA: DELETE BEGIN token.
    "const",
    "do",
    "else",
    "end",
    "for",                      // EDWTORBA: Add FOR token.
    "func",
    "if",
    "in",
    "let",
    "local",                     // EDWTORBA: Add LOCAL token.
    "of",
    "par",                       // EDWTORBA: Add PAR token.
    "proc",
    "record",
    "recursive",                  // EDWTORBA: Add RECURSIVE token.
    "repeat",                     // EDWTORBA: Add REPEAT token.
    "skip",                       // EDWTORBA: Add SKIP token.
    "then",
    "to",                         // EDWTORBA: Add TO token.
    "type",
    "until",                      // EDWTORBA: Add UNTIL token.
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>",
  };

  private final static int	firstReservedWord = Token.AND,
  				lastReservedWord  = Token.WHILE;

}
