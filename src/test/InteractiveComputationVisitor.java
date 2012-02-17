package test;
import parser.Add;
import parser.Assgn;
import parser.Decl;
import parser.Div;
import parser.Eq;
import parser.ExprStmt;
import parser.ForStmt;
import parser.FuncCall;
import parser.Gt;
import parser.Gte;
import parser.Id;
import parser.IfStmt;
import parser.List;
import parser.Lt;
import parser.Lte;
import parser.Mul;
import parser.Neq;
import parser.Numeral;
import parser.Opt;
import parser.ParserVisitor;
import parser.Procedure;
import parser.SimpleNode;
import parser.Start;
import parser.Sub;
import parser.Type;

class InteractiveComputationVisitor implements ParserVisitor {
    /*
     * SimpleNode is an implementation class generated by JJTree. It serves as a
     * superclass of all the AST classes. This method will never be called in
     * our applications, but since this is an abstract method, we need to
     * implement it nevertheless.
     */
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    /*
     * List and Opt are generic nodes generated by JastAdd2. The describe lists
     * and optionals in a generic way. This method will never be called in our
     * applications, but since this is an abstract method, we need to implement
     * it nevertheless.
     */
    public Object visit(List node, Object data) {
        return null;
    }

    public Object visit(Opt node, Object data) {
        return null;
    }

    public Object visit(Start node, Object data) {
        return node.getExp().jjtAccept(this, data);
    }

    public Object visit(Mul node, Object data) {
        Boolean v1 = (Boolean) node.getLeft().jjtAccept(this, data);
        Boolean v2 = (Boolean) node.getRight().jjtAccept(this, data);
        return new Boolean(v1.booleanValue() || v2.booleanValue());
    }

    public Object visit(Div node, Object data) {
        Boolean v1 = (Boolean) node.getLeft().jjtAccept(this, data);
        Boolean v2 = (Boolean) node.getRight().jjtAccept(this, data);
        return new Boolean(v1.booleanValue() || v2.booleanValue());
    }

    public Object visit(Numeral node, Object data) {
        return Boolean.FALSE;
    }

    public Object visit(Id node, Object data) {
        return Boolean.FALSE;
    }

	@Override
	public Object visit(Procedure node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExprStmt node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfStmt node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ForStmt node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Decl node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Assgn node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Lt node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Gt node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Gte node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Lte node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Eq node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Neq node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Add node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Sub node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncCall node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Type node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
