/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForCommand extends Command {

  public ForCommand (Identifier iAST, Expression eAST,Expression eAST2, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    E = eAST;
    E2 = eAST2;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    //return v.visitForCommand(this, o);
    return null;
  }

  public Identifier I;
  public Expression E;
  public Expression E2;
  public Command C;
}