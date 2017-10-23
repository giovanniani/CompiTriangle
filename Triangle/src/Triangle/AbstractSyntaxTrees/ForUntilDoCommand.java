/*
 * @(#)ForUntilDoCommand.java                        17/10/2017
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

public class ForUntilDoCommand extends Command {

  public Expression E1, E2, E3;
  public Command C;

  public ForUntilDoCommand (Expression e1AST, Expression e2AST, Expression e3AST, Command cAST, SourcePosition thePosition) {
    super (thePosition);

    E1 = e1AST;
    E2 = e2AST;
    E3 = e3AST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForUntilDoCommand(this, o);
  }

}
