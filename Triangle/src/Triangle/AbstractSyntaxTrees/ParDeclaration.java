/*
 * @(#)ParDeclaration.java                        17/10/2017
 *
 * Copyright (C) 1999, 2017 Edwin Torrez Barrera
 * Dept. of Computing Ing, ITCR, Cartago, Costa Rica.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ParDeclaration extends Declaration {

  public Declaration D1, D2;

  public ParDeclaration (Declaration d1AST, Declaration d2AST, SourcePosition thePosition) {
    super (thePosition);

    D1 = d1AST;
    D2 = d2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitParDeclaration(this, o);
  }

}
