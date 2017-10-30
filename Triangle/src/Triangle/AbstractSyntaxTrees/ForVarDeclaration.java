/*
 * @(#)ForVarDeclaration.java                        17/10/2017
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

public class ForVarDeclaration extends Declaration {

  public Identifier I;
  public Vname V;
  public Expression E;

  public ForVarDeclaration (Identifier iAST, Vname vAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);

    I = iAST;
    V = vAST;
    E = eAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForVarDeclaration(this, o);
  }

}
