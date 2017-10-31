/*
 * @(#)RecursiveDeclaration.java                        17/10/2017
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

public class RecursiveDeclaration extends Declaration {

  public Declaration D;

  public RecursiveDeclaration (Declaration d1AST, SourcePosition thePosition) {
    super (thePosition);

    D = d1AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRecursiveDeclaration(this, o);
  }

}
