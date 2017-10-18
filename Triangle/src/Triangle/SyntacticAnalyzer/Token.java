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
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // Reserved words - must be in alphabetical order...
    AND			= 4,           // EDWTORBA: Add AND token.
    ARRAY		= 5,
    BEGIN		= 6,           // EDWTORBA: DELETE BEGIN token.
    CONST		= 7,
    DO			= 8,
    ELSE		= 9,
    END			= 10,
    FOR			= 11,           // EDWTORBA: Add FOR token.
    FUNC		= 12,
    IF			= 13,
    IN			= 14,
    LET			= 15,
    LOCAL		= 16,           // EDWTORBA: Add LOCAL token.
    OF			= 17,
    PAR			= 18,           // EDWTORBA: Add PAR token.
    PROC		= 19,
    RECORD		= 20,
    RECURSIVE           = 21,           // EDWTORBA: Add RECURSIVE token.
    REPEAT		= 22,           // EDWTORBA: Add REPEAT token.
    SKIP		= 23,           // EDWTORBA: Add SKIP token.
    THEN		= 24,
    TYPE		= 25,
    TO			= 26,           // EDWTORBA: Add TO token.
    UNTIL		= 27,           // EDWTORBA: Add UNITL token.
    VAR			= 28,
    WHILE		= 29,

    // punctuation...
    DOT			= 30,
    COLON		= 31,
    SEMICOLON   = 32,
    COMMA		= 33,
    BECOMES		= 34,
    IS			= 35,

    // brackets...
    LPAREN		= 36,
    RPAREN		= 37,
    LBRACKET    = 38,
    RBRACKET    = 39,
    LCURLY		= 40,
    RCURLY		= 41,

    // special tokens...
    EOT			= 42,
    ERROR		= 43;

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
    "begin",                    // EDWTORBA: DELETE BEGIN token.
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
    "type",
    "to",                         // EDWTORBA: Add TO token.
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
