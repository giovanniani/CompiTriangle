/*
 * @(#)ForDoCommand.java                        17/10/2017
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

public class ForDoCommand extends Command {
  public VarDeclarationInitialization V1;
  public Expression E1;
  public Command C;

  public ForDoCommand (VarDeclarationInitialization vAST, Expression e2AST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    V1 = vAST;
    E1 = e2AST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForDoCommand(this, o);
  }

}
